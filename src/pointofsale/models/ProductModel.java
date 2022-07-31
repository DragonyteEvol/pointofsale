/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Product;
import pointofsale.objects.ProductIngredient;

/**
 *
 * @author dragonyte
 */
public class ProductModel extends Model{
    public void insert(Product product,List<Ingredient> listIngredients){
        Integer id = this.dao.getProductDao().insert(product);
        for(Ingredient ingredient: listIngredients){
            ProductIngredient productIngredient = new ProductIngredient(null, id, ingredient.getId(), ingredient.getQuantity(), null);
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
    
    public Product selectById(Integer id){
        Product product = this.dao.getProductDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return product;
    }
    
    public void delete(Product product){
        this.dao.getProductDao().delete(product);
        this.dao.getProductIngredientDao().deleteWhere("product_id="+String.valueOf(product.getId()));
        this.saveChanges();
    }
    
    public void update(Product product){
        this.dao.getProductDao().modify(product);
        this.saveChanges();
    }
    
    public void update(Product product,List<Ingredient> listIngredients){
        this.dao.getProductDao().modify(product);
        this.dao.getProductIngredientDao().deleteWhere("product_id="+String.valueOf(product.getId()));
        for(Ingredient ingredient: listIngredients){
            ProductIngredient productIngredient = new ProductIngredient(null, product.getId(), ingredient.getId(), ingredient.getQuantity(), null);
            this.dao.getProductIngredientDao().insert(productIngredient);
        }
        this.saveChanges();
    }
    
}
