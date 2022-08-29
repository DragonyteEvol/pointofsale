/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.controllers.components.CardIngredientController;
import pointofsale.controllers.modal.NewIngredientController;
import pointofsale.models.IngredientModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.IngredientView;

/**
 *
 * @author dragonyte
 */
public class IngredientController extends Controller implements ActionListener, FocusListener {

    private IngredientView view;

    public IngredientController(JPanel panel) {
        this.view = new IngredientView();

        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        panel.add(view);
        setIngredients();
        this.initEvents();
    }

    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
        this.view.txtSearch.addFocusListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search();
            }

            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    private void setIngredients() {
        view.pnIngredients.removeAll();
        SetResource sr = new SetResource();
        sr.start();
    }

    private void search() {
        SearchThread st = new SearchThread();
        st.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewIngredientController newIngredient = new NewIngredientController();
            setIngredients();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object source = fe.getSource();
        if (source == view.txtSearch) {
            view.txtSearch.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    class SearchThread extends Thread {

        private void search(JPanel searchPanel) {
            String search = view.txtSearch.getText();

            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.search(search);

            searchPanel.removeAll();

            if (ingredients.isEmpty()) {
                searchPanel.repaint();
                searchPanel.revalidate();
            } else {

                for (Ingredient ingredient : ingredients) {
                    CardIngredientController card = new CardIngredientController(ingredient, searchPanel);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            }
        }

        public void run() {
            search(view.pnIngredients);
        }
    }

    class SetResource extends Thread {

        private void setIngredients() {
            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.selectAll();
            for (Ingredient ingredient : ingredients) {
                CardIngredientController cardIngredientController = new CardIngredientController(ingredient, view.pnIngredients);
                view.pnIngredients.repaint();
                view.pnIngredients.revalidate();
            }
        }

        @Override
        public void run() {
            setIngredients();
        }
    }
}
