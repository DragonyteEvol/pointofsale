/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import com.sun.source.util.Plugin;
import java.util.List;
import pointofsale.objects.BillPayment;

/**
 *
 * @author dragonyte
 */
public class BillPaymentModel extends Model {

    public BillPayment selectLast() {
        BillPayment billPayment = this.dao.getBillPaymentDao().selectLast();
        return billPayment;
    }

    public void insert(BillPayment billPayment) {
        Long id = this.selectLast().getId();
        billPayment.setId(id);
        this.dao.getBillPaymentDao().insert(billPayment);
        saveChanges();
    }

    public List<BillPayment> generateY() {
        List<BillPayment> billPayments = this.dao.getBillPaymentDao().generateX();
        this.closeConnection();
        return billPayments;
    }

    public List<BillPayment> generateX() {
        this.dao.getBillPaymentDao().backup();
        List<BillPayment> billPayments = this.dao.getBillPaymentDao().generateX();
        this.dao.getBillPaymentDao().deleteAll();
        this.saveChanges();
        return billPayments;
    }
}
