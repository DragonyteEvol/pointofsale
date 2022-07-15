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
public class UnitModel extends Model{
    public void insert(Unit unit){
		Integer a =this.dao.getUnitDao().insert(unit);
		this.saveChanges();
		System.out.println(a);
	}

	public List<Unit> selectAll(){
		List<Unit> units = this.dao.getUnitDao().selectAll();
		this.closeConnection();
		return units;
	}
}
