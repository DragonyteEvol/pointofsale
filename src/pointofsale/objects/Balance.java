/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Balance {
	private Integer id;
	private String reason;
	private Integer value;
	private Integer user_id;
	private String created_at;

        public Balance(Integer id, String reason, Integer value, Integer user_id, String created_at) {
        this.id = id;
        this.reason = reason;
        this.value = value;
        this.user_id = user_id;
        this.created_at = created_at;
    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        return "Balance{" + "id=" + id + ", reason=" + reason + ", value=" + value + ", user_id=" + user_id + ", created_at=" + created_at + '}';
    }

    
        
        
}
