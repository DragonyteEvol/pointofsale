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
	private Long id;    
	private Long product_id;
	private Long ingredient_id;
	private Long quantity;
	private String created_at;

    public ProductIngredient(Long id, Long product_id, Long ingredient_id, Long quantity, String created_at) {
        this.id = id;
        this.product_id = product_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
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
