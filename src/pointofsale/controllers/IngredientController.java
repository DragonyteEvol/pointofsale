/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JPanel;
import pointofsale.controllers.components.CardIngredientController;
import pointofsale.controllers.modal.NewIngredientController;
import pointofsale.models.IngredientModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.IngredientView;

/**
 *
 * @author dragonyte
 */
public class IngredientController extends Controller implements ActionListener {

    private IngredientView view;

    public IngredientController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.view = new IngredientView();
        
        setIngredients();
        
        this.addView(this.view, panel);
        this.initEvents();
    }
    
    private void setIngredients(){
        IngredientModel ingredientModel = new IngredientModel();
        List<Ingredient> ingredients = ingredientModel.selectAll();
        for(Ingredient ingredient: ingredients){
            CardIngredientController cardIngredientController = new CardIngredientController(ingredient, this.view.pnIngredients);
        }
    }
    
    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewIngredientController newIngredient = new NewIngredientController();
            this.initComponents(this.view);
        }
    }
    
}
