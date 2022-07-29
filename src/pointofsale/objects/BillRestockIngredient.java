/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillRestockIngredient {
	private Integer id;    
	private Integer bill_restock_id;
	private Integer ingredient_id;
	private Integer quantity;
	private Integer subvalue;
	private String created_at;

    public BillRestockIngredient(Integer id, Integer bill_restock_id, Integer ingredient_id, Integer quantity, Integer subvalue, String created_at) {
        this.id = id;
        this.bill_restock_id = bill_restock_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.subvalue = subvalue;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBill_restock_id() {
        return bill_restock_id;
    }

    public void setBill_restock_id(Integer bill_restock_id) {
        this.bill_restock_id = bill_restock_id;
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

    public Integer getSubvalue() {
        return subvalue;
    }

    public void setSubvalue(Integer subvalue) {
        this.subvalue = subvalue;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "BillRestockIngredient{" + "id=" + id + ", bill_restock_id=" + bill_restock_id + ", ingredient_id=" + ingredient_id + ", quantity=" + quantity + ", subvalue=" + subvalue + ", created_at=" + created_at + '}';
    }
        
        
}
