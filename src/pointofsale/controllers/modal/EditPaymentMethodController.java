/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.modal.NewPaymentMethodView;

/**
 *
 * @author dragonyte
 */
public class EditPaymentMethodController implements ActionListener{
     private NewPaymentMethodView view;
     private PaymentMethod paymentMethod;

    public EditPaymentMethodController(PaymentMethod paymentMethod) {

        // view config
        this.view = new NewPaymentMethodView(null, true);
        this.paymentMethod = paymentMethod;
        this.view.setResizable(false);
        
        setInfo();

        //events
        this.view.btnSave.addActionListener(this);
        this.view.btnDelete.setVisible(false);

        this.view.setVisible(true);

    }
    
    private void setInfo(){
        view.txtTitle.setText("Editar metodo de pago");
        view.txtName.setText(paymentMethod.getName());
        if(paymentMethod.isVirtual()){
            view.cbVirtual.setSelectedIndex(1);
        }else{
            view.cbVirtual.setSelectedIndex(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = view.txtName.getText();
            Integer virtual = view.cbVirtual.getSelectedIndex();
            paymentMethod.setName(name);
            if(virtual==0){
                paymentMethod.setVirtual(false);
            }else{
                paymentMethod.setVirtual(true);
            }
            
            UpdateThread updateThread = new UpdateThread(paymentMethod);
            updateThread.start();
            view.dispose();
        }
    }

    class UpdateThread extends Thread {

        private PaymentMethod paymentMethod;

        public UpdateThread(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        private void updatePaymentMethod() {
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            paymentMethodModel.update(paymentMethod);
        }

        @Override
        public void run() {
            updatePaymentMethod();
        }
    }
}
