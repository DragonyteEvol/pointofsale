/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.Bill;

/**
 *
 * @author dragonyte
 */
public interface BillDao extends Dao<Bill, Long>{
    List<Bill> selectByEvent(Integer event_id);
    Bill selectCollectEvent(Integer event_id);
}
