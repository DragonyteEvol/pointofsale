/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pointofsale.models.BillPaymentModel;
import pointofsale.models.PaymentMethodModel;
import pointofsale.objects.BillPayment;
import pointofsale.objects.PaymentMethod;
import pointofsale.views.modal.MultiAccountView;

/**
 *
 * @author sebastian.yanez
 */
public class MultiAccountController implements ActionListener, ChangeListener {

    private MultiAccountView view;
    private Long price;

    public MultiAccountController(Long price) {
        this.price = price;
        initComponents();
    }

    private void initComponents() {
        this.view = new MultiAccountView(null, true);
        this.view.setLocationRelativeTo(null);
        this.view.txtPrice.setValue(this.price);
        this.view.txtPriceLabel.setText(String.valueOf(this.price));
        SetResourceThreads thread = new SetResourceThreads();
        thread.start();
        initEvents();
        setPrice();
        this.view.setSize(500, 250);
        this.view.setVisible(true);
    }

    private void setPrice() {
        Long price = this.price - (Long.valueOf(String.valueOf(this.view.txtPrice.getValue())));
        System.out.print(price);
        this.view.txtPriceCalculateLabel.setText(String.valueOf(price));
    }

    private void initEvents() {
        this.view.btnSave.addActionListener(this);
        this.view.txtDivide.addChangeListener(this);
        this.view.txtPrice.addChangeListener(this);
    }

    private BillPayment getBillPayment(Long pricePay) {
        PaymentMethod paymentMethod = (PaymentMethod) this.view.cbMethodPayment.getSelectedItem();
        if (!paymentMethod.isVirtual()) {
            ReceipMoneyController receipMoneyController = new ReceipMoneyController(pricePay);
        }
        BillPayment billPayment = new BillPayment();
        billPayment.setPayment_id(paymentMethod.getId());
        billPayment.setPrice(pricePay);
        return billPayment;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            Long pricePay = Long.valueOf(String.valueOf(this.view.txtPrice.getValue()));
            this.price = this.price - pricePay;
            this.view.txtPriceLabel.setText(String.valueOf(this.price));
            this.view.txtPrice.setValue(this.price);
            BillPaymentModel billPaymentModel = new BillPaymentModel();
            billPaymentModel.insert(this.getBillPayment(pricePay));
            if (this.price <= 0) {
                this.view.dispose();
            }
        }
    }

    public void stateChanged(ChangeEvent ce) {
        Object source = ce.getSource();
        if (source == this.view.txtPrice) {
            setPrice();
        }

        if (source == this.view.txtDivide) {
            Long divide = Long.valueOf(String.valueOf(this.view.txtDivide.getValue()));
            Long calculate = this.price / divide;
            this.view.txtPrice.setValue(calculate);
        }
    }

    //THREADS
    class SetResourceThreads extends Thread {

        private void setPaymentMethods() {
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            List<PaymentMethod> paymentMethods = paymentMethodModel.selectAll();
            for (PaymentMethod paymentMethod : paymentMethods) {
                view.cbMethodPayment.addItem(paymentMethod);
            }
        }

        @Override
        public void run() {
            setPaymentMethods();
        }
    }
}
