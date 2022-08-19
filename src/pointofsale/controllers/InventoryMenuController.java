/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.menu.InventoryMenu;

/**
 *
 * @author dragonyte
 */
public class InventoryMenuController implements ActionListener{
    
    public InventoryMenu view;
    private JPanel panel;

    public InventoryMenuController(JPanel panel) {
        this.view = new InventoryMenu();
        this.panel = panel;
        
        
        this.view.btnInventory.addActionListener(this);
        this.view.btnUnit.addActionListener(this);
        this.view.btnCategorie.addActionListener(this);
        this.view.btnIngredient.addActionListener(this);
        this.view.btnProduct.addActionListener(this);
        this.view.btnReception.addActionListener(this);
        
        addMenu();
    }
    
      public final void addMenu(){
        panel.removeAll();
        panel.add(view, BorderLayout.WEST);
        revalidate();
    }
    
    public void revalidate(){
        panel.repaint();
        panel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnInventory){
            addMenu();
            InventoryController inventoryController = new InventoryController(panel);
        }
        if(source==this.view.btnUnit){
            addMenu();
            UnitController unitController= new UnitController(panel);
        }
	if(source==this.view.btnCategorie){
            addMenu();
            CategorieController categorieController = new CategorieController(panel);
	}
        if(source==this.view.btnIngredient){
            addMenu();
            IngredientController ingredientController = new IngredientController(panel);
        }
        if(source==this.view.btnProduct){
            addMenu();
            ProductController productController = new ProductController(panel);
        }
        if(source==this.view.btnReception){
            addMenu();
            ReceptionController receptionController = new ReceptionController(panel);
        }
    }   
}
