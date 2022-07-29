/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillRestock {
	private Integer id;    
	private Integer user_id;
	private Integer price;
	private String created_at;

    public BillRestock(Integer id, Integer user_id, Integer price, String created_at) {
        this.id = id;
        this.user_id = user_id;
        this.price = price;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "BillRestock{" + "id=" + id + ", user_id=" + user_id + ", price=" + price + ", created_at=" + created_at + '}';
    }
        
        
}
