/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public interface BillTableTmpDao extends Dao<BillTableTmp, Long>{
    BillTableTmp selectByTableId(Integer id);
    List<Product> selectProducts(Integer id);
}
