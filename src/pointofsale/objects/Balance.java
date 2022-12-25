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
	private Long id;
	private String reason;
	private Long value;
	private Long user_id;
	private String created_at;

        public Balance(Long id, String reason, Long value, Long user_id, String created_at) {
        this.id = id;
        this.reason = reason;
        this.value = value;
        this.user_id = user_id;
        this.created_at = created_at;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
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
        return "Balance{" + "id=" + id + ", reason=" + reason + ", value=" + value + ", user_id=" + user_id + ", created_at=" + created_at + '}';
    }

    
        
        
}
