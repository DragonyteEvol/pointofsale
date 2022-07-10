/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.views.HomeView;

/**
 *
 * @author dragonyte
 */
public class HomeController extends Controller implements ActionListener{

    HomeView view;

    public HomeController() {
        this.view = new HomeView();
        this.view.setResizable(false);
        this.view.setVisible(true);
        
        this.view.btnInventory.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.view.btnInventory){
            new InventoryController(this.view.pnDinamic);
        }
    }
    
}
