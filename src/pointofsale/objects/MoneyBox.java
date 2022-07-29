/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class MoneyBox {
	private Integer id;    
	private Integer entry;
	private Integer out;
	private Integer required;
	private Integer user_id;
	private String created_at;

    public MoneyBox(Integer id, Integer entry, Integer out, Integer required, Integer user_id, String created_at) {
        this.id = id;
        this.entry = entry;
        this.out = out;
        this.required = required;
        this.user_id = user_id;
        this.created_at = created_at;
    }

    public MoneyBox() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "MoneyBox{" + "id=" + id + ", entry=" + entry + ", out=" + out + ", required=" + required + ", user_id=" + user_id + ", created_at=" + created_at + '}';
    }
        
        
}
