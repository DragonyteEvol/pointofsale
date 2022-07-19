/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Ingredient;
import pointofsale.objects.IngredientUnit;
import pointofsale.objects.Inventory;
import pointofsale.objects.MovementInventory;

/**
 *
 * @author dragonyte
 */
public class IngredientModel extends Model {

    public void insert(Ingredient ingredient) {
        this.dao.getIngredientDao().insert(ingredient);
        this.saveChanges();
    }

    public List<Ingredient> selectAll() {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectAll();
        this.closeConnection();
        return ingredients;
    }

    public void insert(Ingredient ingredient, boolean extras) {
        Double quantity = ingredient.getQuantity();
        Double minimum = ingredient.getMinimum();

        Integer ingredient_id = this.dao.getIngredientDao().insert(ingredient);

        Inventory inventory = this.createInventory(minimum, quantity, ingredient_id);
        MovementInventory movementInventory = this.createMovement(quantity, ingredient_id);

        this.dao.getInventoryDao().insert(inventory);
        this.dao.getMovementInventoryDao().insert(movementInventory);
        this.saveChanges();
    }

    private Inventory createInventory(Double minimum, Double quantity, Integer ingredient_id) {
        Inventory inventory = new Inventory();
        inventory.setMinimum(minimum);
        inventory.setQuantity(quantity);
        inventory.setIngredient_id(ingredient_id);
        return inventory;
    }

    private MovementInventory createMovement(Double quantity, Integer ingredient_id) {
        MovementInventory movementInventory = new MovementInventory();
        movementInventory.setAddition(true);
        movementInventory.setSubstraction(false);
        movementInventory.setQuantity(quantity);
        movementInventory.setIngredient_id(ingredient_id);
        return movementInventory;
    }
    
    public List<Ingredient> selectWhereCategorie(Integer categorie_id){
        List<Ingredient> ingredients =this.dao.getIngredientDao().selectWhere("categorie_id =" + String.valueOf(categorie_id));
        this.closeConnection();
        return ingredients;
    }
    
    public List<IngredientUnit> selectIngredientUnit(String where){
        List<IngredientUnit> ingredients = this.dao.getIngredientDao().selectWhitUnit(where);
        this.closeConnection();
        return ingredients;
    }
}
