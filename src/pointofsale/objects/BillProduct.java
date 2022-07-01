/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillProduct {
	private Integer id;    
	private Integer bill_id;
	private Integer product_id;
	private Integer quantity;
	private Double subvalue;
	private String created_at;

    public BillProduct(Integer id, Integer bill_id, Integer product_id, Integer quantity, Double subvalue, String created_at) {
        this.id = id;
        this.bill_id = bill_id;
        this.product_id = product_id;
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

    public Integer getBill_id() {
        return bill_id;
    }

    public void setBill_id(Integer bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubvalue() {
        return subvalue;
    }

    public void setSubvalue(Double subvalue) {
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
        return "BillProduct{" + "id=" + id + ", bill_id=" + bill_id + ", product_id=" + product_id + ", quantity=" + quantity + ", subvalue=" + subvalue + ", created_at=" + created_at + '}';
    }
        
   
}
