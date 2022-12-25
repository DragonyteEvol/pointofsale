/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public interface BillRoomTmpDao extends Dao<BillRoomTmp, Long>{
    BillRoomTmp selectByRoomId(Long id);
    List<Product> selectProducts(Long id);
}
