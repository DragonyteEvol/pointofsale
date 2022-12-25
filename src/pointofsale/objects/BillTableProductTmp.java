/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillTableProductTmp {
	private Long id;    
	private Long bill_tmp_id;
	private Long product_id;
	private Long quantity;
	private Long subvalue;
	private String created_at;

    public BillTableProductTmp(Long id, Long bill_tmp_id, Long product_id, Long quantity, Long subvalue, String created_at) {
        this.id = id;
        this.bill_tmp_id = bill_tmp_id;
        this.product_id = product_id;
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

    public Long getBill_tmp_id() {
        return bill_tmp_id;
    }

    public void setBill_tmp_id(Long bill_tmp_id) {
        this.bill_tmp_id = bill_tmp_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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
        return "BillTableProductTmp{" + "id=" + id + ", bill_tmp_id=" + bill_tmp_id + ", product_id=" + product_id + ", quantity=" + quantity + ", subvalue=" + subvalue + ", created_at=" + created_at + '}';
    }
        
        
}
