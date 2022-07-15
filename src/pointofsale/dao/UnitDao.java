/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao;
import java.util.List;

import pointofsale.objects.Unit;

/**
 *
 * @author dragonyte
 */
public interface UnitDao extends Dao<Unit, Long>{
	List<Unit> selectWhere(String where);
}
