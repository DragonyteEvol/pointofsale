/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillRoomProductTmp {
	private Integer id;    
	private Integer bill_tmp_id;
	private Integer product_id;
	private Integer quantity;
	private Double subvalue;
	private String created_at;

    public BillRoomProductTmp(Integer id, Integer bill_tmp_id, Integer product_id, Integer quantity, Double subvalue, String created_at) {
        this.id = id;
        this.bill_tmp_id = bill_tmp_id;
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

    public Integer getBill_tmp_id() {
        return bill_tmp_id;
    }

    public void setBill_tmp_id(Integer bill_tmp_id) {
        this.bill_tmp_id = bill_tmp_id;
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
        return "BillRoomProductTmp{" + "id=" + id + ", bill_tmp_id=" + bill_tmp_id + ", product_id=" + product_id + ", quantity=" + quantity + ", subvalue=" + subvalue + ", created_at=" + created_at + '}';
    }
        
        
}
