/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.NewUnitController;
import pointofsale.views.inventory.InventoryView;
import pointofsale.views.modal.NewUnitView;

/**
 *
 * @author dragonyte
 */
public class InventoryController extends Controller implements ActionListener{
    
    private InventoryView view;

    public InventoryController(JPanel panel) {
        this.view = new InventoryView();
        
        InventoryMenuController a = new InventoryMenuController(panel);
        this.addViewWhitoutRefresh(this.view, panel);
        
        this.view.btnPrint.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.view.btnPrint){
            new NewUnitController();
        }
    }
    
}
