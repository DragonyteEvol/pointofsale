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
    
    private InventoryMenu view;
    private JPanel panel;

    public InventoryMenuController(JPanel panel) {
        this.view = new InventoryMenu();
        this.panel = panel;
        this.addMenu(this.view, panel);
        
        this.view.btnInventory.addActionListener(this);
        this.view.btnUnit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnInventory){
            new InventoryController(this.panel);
        }
        if(source==this.view.btnUnit){
            new UnitController(this.panel);
        }
    }   
}
