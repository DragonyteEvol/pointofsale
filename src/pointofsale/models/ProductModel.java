/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.IngredientUnit;
import pointofsale.objects.Product;
import pointofsale.objects.ProductIngredient;

/**
 *
 * @author dragonyte
 */
public class ProductModel extends Model{
    public void insert(Product product,List<IngredientUnit> listIngredients){
        Integer id = this.dao.getProductDao().insert(product);
        for(IngredientUnit ingredientUnit: listIngredients){
            ProductIngredient productIngredient = new ProductIngredient(null, id, ingredientUnit.getId(), ingredientUnit.getQuantity(), null);
            this.dao.getProductIngredientDao().insert(productIngredient);
        }
        this.saveChanges();
    }
    
    public List<Product> selectAll(){
        List<Product> products = this.dao.getProductDao().selectAll();
        this.closeConnection();
        return products;
    }
    
    public List<Product> selectWhere(String where){
        List<Product> products = this.dao.getProductDao().selectWhere(where);
        this.closeConnection();
        return products;
    }
}
