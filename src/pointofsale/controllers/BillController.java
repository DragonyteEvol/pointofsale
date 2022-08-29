/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardBillController;
import pointofsale.models.BillModel;
import pointofsale.objects.Bill;
import pointofsale.views.accounting.DefaultAccountingView;
import pointofsale.views.accounting.ExpenseView;

/**
 *
 * @author dragonyte
 */
public class BillController extends Controller implements ActionListener {

    private ExpenseView view;

    public BillController(JPanel panel) {
        this.view = new ExpenseView();
        panel.add(view);
        SetResource setResource = new SetResource();
        setResource.start();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    //THREADS
    class SetResource extends Thread {

        private void setBill() {
            BillModel billModel = new BillModel();
            List<Bill> bills = billModel.selectAll();
            for (Bill bill : bills) {
                CardBillController card = new CardBillController(bill, view.pnBills);
            }
        }

        @Override
        public void run() {
            setBill();
        }
    }
}
