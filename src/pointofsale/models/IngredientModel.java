/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.MovementInventory;
import pointofsale.objects.Product;
import pointofsale.objects.ProductIngredient;

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
    
    public List<Ingredient> selectAmenities(){
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectAmenities();
        this.closeConnection();
        return ingredients;
    }

    public void update(Ingredient ingredient) {
        this.dao.getIngredientDao().modify(ingredient);
        Inventory inventory = this.dao.getInventoryDao().selectWhereIngredient("ingredient_id=" + ingredient.getId());
        inventory.setQuantity(ingredient.getQuantity());
        inventory.setMinimum(ingredient.getMinimum());
        this.dao.getInventoryDao().modify(inventory);
        MovementInventory movementInventory = new MovementInventory(null, ingredient.getId(), ingredient.getQuantity(), false, false, null);
        this.dao.getMovementInventoryDao().insert(movementInventory);
        this.saveChanges();
    }

    public void insert(Ingredient ingredient, boolean extras) {
        Long quantity = ingredient.getQuantity();
        Long minimum = ingredient.getMinimum();

        Long ingredient_id = this.dao.getIngredientDao().insert(ingredient);

        Inventory inventory = this.createInventory(minimum, quantity, ingredient_id);
        MovementInventory movementInventory = this.createMovement(quantity, ingredient_id);

        this.dao.getInventoryDao().insert(inventory);
        this.dao.getMovementInventoryDao().insert(movementInventory);
        this.saveChanges();
    }

    public void insertPolimorphism(Product product, Ingredient ingredient, Long required) {
        Long product_id = this.dao.getProductDao().insert(product);
        Long quantity = ingredient.getQuantity();
        Long minimum = ingredient.getMinimum();

        Long ingredient_id = this.dao.getIngredientDao().insert(ingredient);

        Inventory inventory = this.createInventory(minimum, quantity, ingredient_id);
        MovementInventory movementInventory = this.createMovement(quantity, ingredient_id);
        ProductIngredient productIngredient = new ProductIngredient(null, product_id, ingredient_id, required, null);

        this.dao.getProductIngredientDao().insert(productIngredient);
        this.dao.getInventoryDao().insert(inventory);
        this.dao.getMovementInventoryDao().insert(movementInventory);

        saveChanges();
    }

    private Inventory createInventory(Long minimum, Long quantity, Long ingredient_id) {
        Inventory inventory = new Inventory();
        inventory.setMinimum(minimum);
        inventory.setQuantity(quantity);
        inventory.setIngredient_id(ingredient_id);
        return inventory;
    }

    private MovementInventory createMovement(Long quantity, Long ingredient_id) {
        MovementInventory movementInventory = new MovementInventory();
        movementInventory.setAddition(true);
        movementInventory.setSubstraction(false);
        movementInventory.setQuantity(quantity);
        movementInventory.setIngredient_id(ingredient_id);
        return movementInventory;
    }

    public List<Ingredient> selectWhereCategorie(Long categorie_id) {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectWhere("categorie_id =" + String.valueOf(categorie_id));
        this.closeConnection();
        return ingredients;
    }

    public List<Ingredient> selectIngredientUnit(String where) {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectWhitUnit(where);
        this.closeConnection();
        return ingredients;
    }

    public Ingredient selectById(Long id) {
        Ingredient ingredient = this.dao.getIngredientDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return ingredient;
    }

    public void delete(Ingredient ingredient) {
        this.dao.getIngredientDao().delete(ingredient);
        this.dao.getMovementInventoryDao().deleteWhere("ingredient_id=" + String.valueOf(ingredient.getId()));
        this.dao.getInventoryDao().deleteWhere("ingredient_id=" + String.valueOf(ingredient.getId()));
        this.saveChanges();
    }

    public List<Ingredient> selectRelProduct(Long id) {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectRelProduct(id);
        this.closeConnection();
        return ingredients;
    }

    public List<Ingredient> selectUnitQuantity() {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectUnitQuantity();
        this.closeConnection();
        return ingredients;
    }

    public List<Ingredient> search(String search) {
        List<Ingredient> ingredients = this.dao.getIngredientDao().search(search);
        this.closeConnection();
        return ingredients;
    }

    public List<Ingredient> selectMissing() {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectMissing();
        this.closeConnection();
        return ingredients;
    }
}
