/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class MovementInventory {
	private Long id;    
	private boolean addition;
	private boolean substraction;
	private Long ingredient_id;
	private Long quantity;
	private String created_at;

    public MovementInventory(Long id,Long ingredient_id,Long quantity,boolean addition, boolean substraction, String created_at) {
        this.id = id;
        this.addition = addition;
        this.substraction = substraction;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }
    
    public MovementInventory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAddition() {
        return addition;
    }

    public void setAddition(boolean addition) {
        this.addition = addition;
    }

    public boolean isSubstraction() {
        return substraction;
    }

    public void setSubstraction(boolean substraction) {
        this.substraction = substraction;
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
        return "MovementInventory{" + "id=" + id + ", addition=" + addition + ", substraction=" + substraction + ", ingredient_id=" + ingredient_id + ", quantity=" + quantity + ", created_at=" + created_at + '}';
    }
        
        
}
