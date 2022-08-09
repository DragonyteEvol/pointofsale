/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.MissingStock;

/**
 *
 * @author dragonyte
 */
public interface MissingStockDao extends Dao<MissingStock, Long>{
    List<MissingStock> selectNotification();
    MissingStock selectWhereIngredient(Integer ingredient_id);
}
