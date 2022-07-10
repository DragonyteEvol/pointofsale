/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.NewUnitController;
import pointofsale.views.inventory.UnitView;

/**
 *
 * @author dragonyte
 */
public class UnitController extends Controller implements ActionListener{
    
    private UnitView view;

    public UnitController(JPanel panel) {
        this.view = new UnitView();
        InventoryMenuController a = new InventoryMenuController(panel);
        this.addViewWhitoutRefresh(this.view, panel);
        
        this.view.btnCreate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnCreate){
            new NewUnitController();
        }
    }
    
    
    
}
