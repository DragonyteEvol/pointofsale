/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.menu.SellMenu;

/**
 *
 * @author dragonyte
 */
public class SellMenuController extends Controller implements ActionListener{
    public SellMenu view;
    private JPanel panelWindow;

    public SellMenuController(JPanel panelMenu,JPanel panelWindow) {
        this.view = new SellMenu();
        this.panelWindow = panelWindow;
        
        this.view.btnRoom.addActionListener(this);
        this.view.btnTable.addActionListener(this);
        
        this.addMenu(this.view, panelMenu);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnTable){
            TableController tableController = new TableController(panelWindow);
        }
        if(source==this.view.btnRoom){
            RoomController roomController = new RoomController(panelWindow);
        }
    }   
}
