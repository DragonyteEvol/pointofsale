/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.Ingredient;

/**
 *
 * @author dragonyte
 */
public interface IngredientDao extends Dao<Ingredient, Long> {

    List<Ingredient> selectWhere(String where);

    List<Ingredient> selectWhitUnit(String where);

    List<Ingredient> selectRelProduct(Integer id);

    List<Ingredient> selectUnitQuantity();

    List<Ingredient> search(String search);
}
