/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.BillPayment;

/**
 *
 * @author dragonyte
 */
public interface BillPaymentDao extends Dao<BillPayment, Long>{
    BillPayment selectLast();
}
