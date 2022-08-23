/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.MissingGlobal;
import pointofsale.controllers.components.CardReceptionController;
import pointofsale.models.IngredientModel;
import pointofsale.models.InventoryModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.ReceptionView;

/**
 *
 * @author dragonyte
 */
public class ReceptionController extends Controller implements ActionListener, FocusListener {

    private List<Ingredient> listIngredients = new ArrayList<>();
    private ReceptionView view;

    public ReceptionController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.view = new ReceptionView();

        SetResourceThread setResourceThread = new SetResourceThread();
        setResourceThread.start();

        panel.add(view);

        this.initEvents();
    }

    private void initEvents() {
        this.view.btnSave.addActionListener(this);

        this.view.txtSearch.addFocusListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search(view.pnBase);
            }

            public void insertUpdate(DocumentEvent e) {
                search(view.pnBase);
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
                CardReceptionController card = new CardReceptionController(listIngredients, ingredient, view);
                searchPanel.repaint();
                searchPanel.revalidate();
            }
        }
    }

    private void revalidateView() {
        this.view.repaint();
        this.view.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            ReceptionThread receptionThread = new ReceptionThread();
            receptionThread.start();
            this.view.pnInfo.removeAll();
            this.view.pnBase.removeAll();
            SetResourceThread setResourceThread = new SetResourceThread();
            setResourceThread.start();

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

    class SetResourceThread extends Thread {

        private List<Ingredient> getIngredients() {
            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.selectUnitQuantity();
            return ingredients;
        }

        @Override
        public void run() {
            List<Ingredient> ingredients = getIngredients();
            for (Ingredient ingredient : ingredients) {
                CardReceptionController card = new CardReceptionController(listIngredients, ingredient, view);
            }
        }
    }

    class ReceptionThread extends Thread {

        @Override
        public void run() {
            Integer value = 0;
            for (Ingredient ingredientp : listIngredients) {
                value += ingredientp.getPrice();
            }
            InventoryModel inventoryModel = new InventoryModel();
            inventoryModel.receiptInventory(listIngredients, value);
            System.out.print(value +"");
            listIngredients.removeAll(listIngredients);

            MissingGlobal.showNotifications();

            HomeController.checkNotifications();
            view.txtPrice.setText("");
            revalidateView();
        }
    }
}
