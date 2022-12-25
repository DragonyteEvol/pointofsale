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
	private Long id;    
	private Long entry;
	private Long out;
	private Long required;
	private Long user_id;
	private String created_at;

    public MoneyBox(Long id, Long entry, Long out, Long required, Long user_id, String created_at) {
        this.id = id;
        this.entry = entry;
        this.out = out;
        this.required = required;
        this.user_id = user_id;
        this.created_at = created_at;
    }

    public MoneyBox() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntry() {
        return entry;
    }

    public void setEntry(Long entry) {
        this.entry = entry;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public Long getRequired() {
        return required;
    }

    public void setRequired(Long required) {
        this.required = required;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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
