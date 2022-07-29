/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.inventory.InventoryView;

/**
 *
 * @author dragonyte
 */
public class InventoryController extends Controller implements ActionListener{
    
    private InventoryView view;

    public InventoryController(JPanel panel) {
        this.view = new InventoryView();
        
        this.addView(this.view, panel);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}
