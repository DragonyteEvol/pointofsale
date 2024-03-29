/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.PaymentMethod;

/**
 *
 * @author dragonyte
 */
public interface PaymentMethodDao extends Dao<PaymentMethod, Long>{
    List<PaymentMethod> search(String search);
}
