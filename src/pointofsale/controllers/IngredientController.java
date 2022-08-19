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
public class IngredientController extends Controller implements ActionListener,FocusListener {

    private IngredientView view;

    public IngredientController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.view = new IngredientView();
        
        setIngredients();
        
        panel.add(view);
        this.initEvents();
    }
    
    private void setIngredients(){
        IngredientModel ingredientModel = new IngredientModel();
        List<Ingredient> ingredients = ingredientModel.selectAll();
        for(Ingredient ingredient: ingredients){
            CardIngredientController cardIngredientController = new CardIngredientController(ingredient, view.pnIngredients);
        }
    }
    
    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
        this.view.txtSearch.addFocusListener(this);
        
        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search(view.pnnn1234);
            }

            public void insertUpdate(DocumentEvent e) {
                search(view.pnnn1234);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewIngredientController newIngredient = new NewIngredientController();
            this.initComponents(this.view);
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
    
}
