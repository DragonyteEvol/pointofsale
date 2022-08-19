/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.menu.AcountingMenu;
/**
 *
 * @author dragonyte
 */
public class AccountingMenuController extends Controller implements ActionListener {

    public AcountingMenu view;
    private JPanel panel;

    public AccountingMenuController(JPanel panel) {
        this.view = new AcountingMenu();
        this.panel = panel;
        addMenu();

        view.btnAnnulments.addActionListener(this);
        view.btnBills.addActionListener(this);
        view.btnExpens.addActionListener(this);
        view.btnReports.addActionListener(this);
        view.btnSell.addActionListener(this);
        view.btnPaymentMethod.addActionListener(this);
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
        if (source == this.view.btnAnnulments) {
            addMenu();
            AnnulmentController annulment = new AnnulmentController(panel);
        }
        if (source == this.view.btnBills) {
            addMenu();
            BillController bill = new BillController(panel);
        }
        if (source == this.view.btnExpens) {
            addMenu();
            ExpenseController expense = new ExpenseController(panel);
        }
        if (source == this.view.btnReports) {
            addMenu();
            ReportController report = new ReportController(panel);
        }
        if (source == this.view.btnSell) {
            addMenu();
            SellController sell = new SellController(panel);
        }
        if (source == this.view.btnPaymentMethod) {
            addMenu();
            PaymentMethodController payment = new PaymentMethodController(panel);
        }
    }
}
