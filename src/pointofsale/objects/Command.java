/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Command {
	private Long id;    
	private Long client_type;
	private Long client_id;
	private boolean printed;
	private String created_at;

    public Command(Long id, Long client_type, Long client_id, boolean printed, String created_at) {
        this.id = id;
        this.client_type = client_type;
        this.client_id = client_id;
        this.printed = printed;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_type() {
        return client_type;
    }

    public void setClient_type(Long client_type) {
        this.client_type = client_type;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Command{" + "id=" + id + ", client_type=" + client_type + ", client_id=" + client_id + ", printed=" + printed + ", created_at=" + created_at + '}';
    }
        
        
}
