/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.inventory.ReceptionView;

/**
 *
 * @author dragonyte
 */
public class ReceptionController extends Controller implements ActionListener{
    private ReceptionView view;

    public ReceptionController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel){
        this.view = new ReceptionView();
        this.addView(this.view, panel);
        
        this.initEvents();
    }
    
    private void initEvents(){
        this.view.btnCreate.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
