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
	private Integer id;    
	private boolean addition;
	private boolean substraction;
	private Integer ingredient_id;
	private Integer quantity;
	private String created_at;

    public MovementInventory(Integer id,Integer ingredient_id,Integer quantity,boolean addition, boolean substraction, String created_at) {
        this.id = id;
        this.addition = addition;
        this.substraction = substraction;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }
    
    public MovementInventory(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
