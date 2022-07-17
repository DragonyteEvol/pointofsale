/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.menu.InventoryMenu;

/**
 *
 * @author dragonyte
 */
public class InventoryMenuController extends Controller implements ActionListener{
    
    public InventoryMenu view;
    private JPanel panelWindow;

    public InventoryMenuController(JPanel panelMenu,JPanel panelWindow) {
        this.view = new InventoryMenu();
        this.panelWindow = panelWindow;
        this.addMenu(this.view, panelMenu);
        
        
        
        this.view.btnInventory.addActionListener(this);
        this.view.btnUnit.addActionListener(this);
        this.view.btnCategorie.addActionListener(this);
        this.view.btnIngredient.addActionListener(this);
        this.view.btnProduct.addActionListener(this);
        this.view.btnReception.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnInventory){
            InventoryController inventoryController = new InventoryController(this.panelWindow);
        }
        if(source==this.view.btnUnit){
            UnitController unitController= new UnitController(this.panelWindow);
        }
	if(source==this.view.btnCategorie){
            CategorieController categorieController = new CategorieController(this.panelWindow);
	}
        if(source==this.view.btnIngredient){
            IngredientController ingredientController = new IngredientController(this.panelWindow);
        }
        if(source==this.view.btnProduct){
            ProductController productController = new ProductController(this.panelWindow);
        }
        if(source==this.view.btnReception){
            ReceptionController receptionController = new ReceptionController(this.panelWindow);
        }
    }   
}
