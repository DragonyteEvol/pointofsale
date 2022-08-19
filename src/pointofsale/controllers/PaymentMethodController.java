/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.controllers.components.CardPaymentMethodController;
import pointofsale.controllers.modal.NewPaymentMethodController;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.accounting.PaymentMethodView;

/**
 *
 * @author dragonyte
 */
public class PaymentMethodController extends Controller implements ActionListener,FocusListener {

    private PaymentMethodView view;
    private JTable inventoryTable;

    public PaymentMethodController(JPanel panel) {
        this.view = new PaymentMethodView();

        SetResourceThread setResourceThread = new SetResourceThread();
        setResourceThread.start();

        view.btnCreate.addActionListener(this);
        this.view.txtSearch.addFocusListener(this);
        
        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search(view.pnPayments);
            }

            public void insertUpdate(DocumentEvent e) {
                search(view.pnPayments);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });

        panel.add(view);
    }
    
    private void search(JPanel searchPanel) {
        String search = view.txtSearch.getText();

        PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
        List<PaymentMethod> payments = paymentMethodModel.search(search);

        searchPanel.removeAll();

        if (payments.isEmpty()) {
            searchPanel.repaint();
            searchPanel.revalidate();
        } else {

            for (PaymentMethod paymentMethod : payments) {
                CardPaymentMethodController card = new CardPaymentMethodController(paymentMethod, searchPanel);
                searchPanel.repaint();
                searchPanel.revalidate();
            }
        }
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

    @Override
    public void focusGained(FocusEvent fe) {
        Object source = fe.getSource();
        if (source == view.txtSearch) {
            view.txtSearch.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
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
