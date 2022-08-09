/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.Inventory;

/**
 *
 * @author dragonyte
 */
public interface InventoryDao extends Dao<Inventory, Long>{
    void deleteWhere(String where);
    Inventory selectWhereIngredient(String where);
    Inventory selectMissingIngredient(Integer ingredient_id);
}
