/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.modal.NewPaymentMethodView;

/**
 *
 * @author dragonyte
 */
public class NewPaymentMethodController implements ActionListener,FocusListener{
    
    private NewPaymentMethodView view;

    public NewPaymentMethodController() {

        // view config
        this.view = new NewPaymentMethodView(null, true);
        this.view.setLocationRelativeTo(null);

        //events
        this.view.btnSave.addActionListener(this);
        //FOCUS
        this.view.txtName.addFocusListener(this);
        
        this.view.btnDelete.setVisible(false);

        this.view.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = view.txtName.getText();
            Long virtual = Long.valueOf(view.cbVirtual.getSelectedIndex());
            InsertThread insertThread = new InsertThread(name, virtual);
            insertThread.start();
            view.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    class InsertThread extends Thread {

        private String name;
        private Long virtual;

        public InsertThread(String name,Long virtual) {
            this.name = name;
            this.virtual = virtual;
        }


        private PaymentMethod createPaymentMehotd(){
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setName(name);
            if(virtual==0){
                paymentMethod.setVirtual(false);
            }else{
                paymentMethod.setVirtual(true);
            }
            paymentMethod.setVirtual(true);
            
            return paymentMethod;
        }
        private void insertPaymentMethod() {
            PaymentMethod paymentMethod = createPaymentMehotd();
            
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            paymentMethodModel.insert(paymentMethod);
        }

        @Override
        public void run() {
            insertPaymentMethod();
        }
    }
}
