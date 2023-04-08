/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import pointofsale.objects.BillPayment;

/**
 *
 * @author dragonyte
 */
public class BillPaymentModel extends Model{
    
    public BillPayment selectLast(){
        BillPayment billPayment = this.dao.getBillPaymentDao().selectLast();
        return billPayment;
    }
    
    public void insert(BillPayment billPayment){
        Long id = this.selectLast().getId();
        billPayment.setId(id);
        this.dao.getBillPaymentDao().insert(billPayment);
        saveChanges();
    }
}
