/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.crypto.AEADBadTagException;
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
public class ReportController extends Controller implements ActionListener{
    private ExpenseView view;

    public ReportController(JPanel panel) {
        this.view = new ExpenseView();
        
        SetResource setResource = new SetResource();
        setResource.start();

        this.addView(this.view, panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    //THREADS
    
    class SetResource extends Thread{
        
        private void setBill(){
            BillModel billModel = new BillModel();
            List<Bill> bills = billModel.selectAll();
            for(Bill bill : bills){
                CardBillController card = new CardBillController(bill, view.pnBills);
            }
        }
        
        @Override
        public void run(){
        }
    }
}
