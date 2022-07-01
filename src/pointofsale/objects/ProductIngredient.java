/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class ProductIngredient {
	private Integer id;    
	private Integer product_id;
	private Integer ingredient_id;
	private Double quantity;
	private String created_at;

    public ProductIngredient(Integer id, Integer product_id, Integer ingredient_id, Double quantity, String created_at) {
        this.id = id;
        this.product_id = product_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ProductIngredient{" + "id=" + id + ", product_id=" + product_id + ", ingredient_id=" + ingredient_id + ", quantity=" + quantity + ", created_at=" + created_at + '}';
    }
        
         
}
