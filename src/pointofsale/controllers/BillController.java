/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.accounting.DefaultAccountingView;

/**
 *
 * @author dragonyte
 */
public class BillController extends Controller implements ActionListener{
    private DefaultAccountingView view;

    public BillController(JPanel panel) {
        this.view = new DefaultAccountingView();

        this.addView(this.view, panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
