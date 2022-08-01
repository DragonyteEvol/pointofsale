/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

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
    private JPanel panelWindow;

    public AccountingMenuController(JPanel panelMenu, JPanel panelWindow) {
        this.view = new AcountingMenu();
        this.panelWindow = panelWindow;
        this.addMenu(this.view, panelMenu);

        view.btnAnnulments.addActionListener(this);
        view.btnBills.addActionListener(this);
        view.btnExpens.addActionListener(this);
        view.btnReports.addActionListener(this);
        view.btnSell.addActionListener(this);
        view.btnPaymentMethod.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnAnnulments) {
            AnnulmentController annulment = new AnnulmentController(panelWindow);
        }
        if (source == this.view.btnBills) {
            BillController bill = new BillController(panelWindow);
        }
        if (source == this.view.btnExpens) {
            ExpenseController expense = new ExpenseController(panelWindow);
        }
        if (source == this.view.btnReports) {
            ReportController report = new ReportController(panelWindow);
        }
        if (source == this.view.btnSell) {
            SellController sell = new SellController(panelWindow);
        }
        if (source == this.view.btnPaymentMethod) {
            PaymentMethodController payment = new PaymentMethodController(panelWindow);
        }
    }
}
