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
    
    public List<PaymentMethod> search(String search) {
        List<PaymentMethod> paymentMethods = this.dao.getPaymentMethodDao().search(search);
        this.closeConnection();
        return paymentMethods;
    }
    
    public PaymentMethod selectById(Integer id){
        PaymentMethod paymentMethod = this.dao.getPaymentMethodDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return paymentMethod;
    }
    
    public void delete(PaymentMethod paymentMethod){
        this.dao.getPaymentMethodDao().delete(paymentMethod);
        this.saveChanges();
    }
    
    public void update(PaymentMethod paymentMethod){
        this.dao.getPaymentMethodDao().modify(paymentMethod);
        this.saveChanges();
    }
    
}
