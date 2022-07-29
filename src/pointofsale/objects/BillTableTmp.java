/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class BillTableTmp {
	private Integer id;    
	private Integer table_id;
	private Integer total;
	private String created_at;

    public BillTableTmp(Integer id, Integer table_id, Integer total, String created_at) {
        this.id = id;
        this.table_id = table_id;
        this.total = total;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
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
        return "BillTableTmp{" + "id=" + id + ", table_id=" + table_id + ", total=" + total + ", created_at=" + created_at + '}';
    }

   
        
        
}
