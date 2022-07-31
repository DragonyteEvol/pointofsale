/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardReceptionController;
import pointofsale.models.IngredientModel;
import pointofsale.models.InventoryModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.ReceptionView;

/**
 *
 * @author dragonyte
 */
public class ReceptionController extends Controller implements ActionListener {

    private List<Ingredient> listIngredients = new ArrayList<>();
    private ReceptionView view;

    public ReceptionController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.view = new ReceptionView();

        SetResourceThread setResourceThread = new SetResourceThread();
        setResourceThread.start();

        this.addView(this.view, panel);

        this.initEvents();
    }

    private void initEvents() {
        this.view.btnSave.addActionListener(this);
    }
    
    private void revalidateView(){
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
            revalidateView();
        }
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
            InventoryModel inventoryModel = new InventoryModel();
            inventoryModel.receiptInventory(listIngredients);
            listIngredients.removeAll(listIngredients);
        }
    }
}
