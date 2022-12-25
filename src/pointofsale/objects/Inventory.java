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
	private Long id;    
	private Long ingredient_id;
	private Long quantity;
	private Long minimum;
	private String created_at;

    public Inventory(Long id, Long ingredient_id, Long quantity, Long minimum, String created_at) {
        this.id = id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.minimum = minimum;
        this.created_at = created_at;
    }
    
    public Inventory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getMinimum() {
        return minimum;
    }

    public void setMinimum(Long minimum) {
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
