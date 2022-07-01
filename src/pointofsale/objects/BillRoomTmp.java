/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillRoomTmp {
	private Integer id;    
	private Integer room_id;
	private Double total;
	private String created_at;

    public BillRoomTmp(Integer id, Integer room_id, Double total, String created_at) {
        this.id = id;
        this.room_id = room_id;
        this.total = total;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "BillRoomTmp{" + "id=" + id + ", room_id=" + room_id + ", total=" + total + ", created_at=" + created_at + '}';
    }
        
        
}
