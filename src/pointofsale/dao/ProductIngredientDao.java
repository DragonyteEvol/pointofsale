/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.ProductIngredient;

/**
 *
 * @author dragonyte
 */
public interface ProductIngredientDao extends Dao<ProductIngredient, Long>{
    void deleteWhere(String where);
    List<ProductIngredient> selectWhere(String where);
}
