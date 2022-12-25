/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.MovementInventory;

/**
 *
 * @author dragonyte
 */
public interface MovementInventoryDao extends Dao<MovementInventory, Long>{
    void deleteWhere(String where);
    List<MovementInventory> getByIngredient(Long id);
}
