/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;

import pointofsale.objects.Unit;

/**
 *
 * @author dragonyte
 */
public class UnitModel extends Model {

    public void insert(Unit unit) {
        Long a = this.dao.getUnitDao().insert(unit);
        this.saveChanges();
        System.out.println(a);
    }

    public List<Unit> selectAll() {
        List<Unit> units = this.dao.getUnitDao().selectAll();
        this.closeConnection();
        return units;
    }
    
    public Unit selectById(Long id){
        Unit unit = this.dao.getUnitDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return unit;
    }
    
    public void update(Unit unit){
        this.dao.getUnitDao().modify(unit);
        this.saveChanges();
    }
    
    public void delete(Unit unit){
        this.dao.getUnitDao().delete(unit);
        this.saveChanges();
    }
    
    public List<Unit> search(String search) {
        List<Unit> units = this.dao.getUnitDao().search(search);
        this.closeConnection();
        return units;
    }
}
