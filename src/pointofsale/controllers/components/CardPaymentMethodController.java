/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.EditPaymentMethodController;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.components.CardPaymentMethodView;

/**
 *
 * @author dragonyte
 */
public class CardPaymentMethodController extends CardController implements ActionListener{

    private PaymentMethod paymentMethod;
    public CardPaymentMethodView view;
    private JPanel panel;

    public CardPaymentMethodController(PaymentMethod paymentMethod, JPanel panel) {
        this.view = new CardPaymentMethodView();
        this.paymentMethod = paymentMethod;
        this.panel = panel;
        setInfo();
        initEvents();

        this.panel.add(view);
    }

    private void setInfo() {
        this.view.txtName.setText(paymentMethod.getName());
        if(paymentMethod.isVirtual()){
            view.txtVirtual.setText("Virtual");
        }else{
            view.txtVirtual.setText("Fisico");
        }
    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        this.panel.repaint();
        this.panel.revalidate();
    }

    private void refreshCategorie() {
        //PaymentMethodModel payment = new PaymentMethodModel();
        //this.paymentMethod = payment.selectById(paymentMethod.getId());
        setInfo();
    }

    private void initEvents() {
        this.view.btnDelete.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
        deleteView.btnYes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnDelete) {
            deleteView.setVisible(true);
        }

        if (source == this.view.btnEdit) {
            EditPaymentMethodController editPaymentMethodController = new EditPaymentMethodController(paymentMethod);
            refreshCategorie();
        }
        
        if(source == deleteView.btnYes){
            DeleteThread deleteThread = new DeleteThread();
            deleteThread.start();
            removeComponent(this.view);
            deleteView.dispose();
        }
    }

    class DeleteThread extends Thread {

        private void deletePayment() {
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            paymentMethodModel.delete(paymentMethod);
        }

        @Override
        public void run() {
            deletePayment();
        }
    }
}
