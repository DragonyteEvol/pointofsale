/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import pointofsale.controllers.components.CardPaymentMethodController;
import pointofsale.controllers.modal.NewPaymentMethodController;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.accounting.PaymentMethodView;

/**
 *
 * @author dragonyte
 */
public class PaymentMethodController extends Controller implements ActionListener {

    private PaymentMethodView view;
    private JTable inventoryTable;

    public PaymentMethodController(JPanel panel) {
        this.view = new PaymentMethodView();

        SetResourceThread setResourceThread = new SetResourceThread();
        setResourceThread.start();

        view.btnCreate.addActionListener(this);

        this.addView(this.view, panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnCreate) {
            NewPaymentMethodController paymentMethodController = new NewPaymentMethodController();
            view.pnPayments.removeAll();
            SetResourceThread setResourceThread = new SetResourceThread();
            setResourceThread.start();
        }
    }

    class SetResourceThread extends Thread {

        private void setPayments() {
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            List<PaymentMethod> payments = paymentMethodModel.selectAll();
            for (PaymentMethod paymentMethod : payments) {
                CardPaymentMethodController cardPaymentMethodController = new CardPaymentMethodController(paymentMethod, view.pnPayments);
                view.repaint();
                view.validate();
            }
        }

        @Override
        public void run() {
            setPayments();
        }
    }
}
