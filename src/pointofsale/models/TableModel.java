/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Table;

/**
 *
 * @author dragonyte
 */
public class TableModel extends Model{
    
    public List<Table> selectAll(){
        List<Table> tables = this.dao.getTableDao().selectAll();
        this.closeConnection();
        return tables;
    }
    
    public void insert(Table table){
        this.dao.getTableDao().insert(table);
        this.saveChanges();
    }
    
    public void update(Table table){
        this.dao.getTableDao().modify(table);
        this.saveChanges();
    }
    
    public void remove(Table table){
        this.dao.getTableDao().delete(table);
        this.saveChanges();
    }
    
    public void disableEvent(Integer event_id){
        this.dao.getTableDao().disableEvent(event_id);
        saveChanges();
    }
}
