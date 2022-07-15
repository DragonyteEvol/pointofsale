/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

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
}
