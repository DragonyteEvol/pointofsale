/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public interface ProductDao extends Dao<Product, Long>{
    List<Product> selectWhere(String where);
    List<Product> search(String search);
}
