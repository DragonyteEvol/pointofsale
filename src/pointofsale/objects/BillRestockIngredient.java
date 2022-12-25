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
	private Long id;    
	private Long bill_restock_id;
	private Long ingredient_id;
	private Long quantity;
	private Long subvalue;
	private String created_at;

    public BillRestockIngredient(Long id, Long bill_restock_id, Long ingredient_id, Long quantity, Long subvalue, String created_at) {
        this.id = id;
        this.bill_restock_id = bill_restock_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.subvalue = subvalue;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBill_restock_id() {
        return bill_restock_id;
    }

    public void setBill_restock_id(Long bill_restock_id) {
        this.bill_restock_id = bill_restock_id;
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

    public Long getSubvalue() {
        return subvalue;
    }

    public void setSubvalue(Long subvalue) {
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
