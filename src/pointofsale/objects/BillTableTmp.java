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
	private Long id;    
	private Long table_id;
	private Long total;
        private String waiter;
	private String created_at;

    public BillTableTmp(Long id, Long table_id, Long total, String waiter,String created_at) {
        this.id = id;
        this.table_id = table_id;
        this.total = total;
        this.waiter = waiter;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTable_id() {
        return table_id;
    }

    public void setTable_id(Long table_id) {
        this.table_id = table_id;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
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
