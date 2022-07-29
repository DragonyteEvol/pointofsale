/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Inventory {
	private Integer id;    
	private Integer ingredient_id;
	private Integer quantity;
	private Integer minimum;
	private String created_at;

    public Inventory(Integer id, Integer ingredient_id, Integer quantity, Integer minimum, String created_at) {
        this.id = id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.minimum = minimum;
        this.created_at = created_at;
    }
    
    public Inventory(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", ingredient_id=" + ingredient_id + ", quantity=" + quantity + ", minimum=" + minimum + ", created_at=" + created_at + '}';
    }
        
        
}
