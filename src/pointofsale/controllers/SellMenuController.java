/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.menu.SellMenu;

/**
 *
 * @author dragonyte
 */
public class SellMenuController implements ActionListener {

    public SellMenu view;
    private JPanel panel;

    public SellMenuController(JPanel panel) {
        this.view = new SellMenu();
        this.panel = panel;

        panel.removeAll();
        this.view.btnRoom.addActionListener(this);
        this.view.btnTable.addActionListener(this);

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
        if (source == this.view.btnTable) {
            addMenu();
            TableController tableController = new TableController(panel);
        }
        if (source == this.view.btnRoom) {
            addMenu();
            RoomController roomController = new RoomController(panel);
        }
    }
}
