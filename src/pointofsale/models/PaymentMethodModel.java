/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.PaymentMethod;

/**
 *
 * @author dragonyte
 */
public class PaymentMethodModel extends Model {

    public void insert(PaymentMethod paymentMethod) {
        this.dao.getPaymentMethodDao().insert(paymentMethod);
        this.saveChanges();
    }

    public List<PaymentMethod> selectAll() {
        List<PaymentMethod> paymentMethods = this.dao.getPaymentMethodDao().selectAll();
        this.closeConnection();
        return paymentMethods;
    }
}
