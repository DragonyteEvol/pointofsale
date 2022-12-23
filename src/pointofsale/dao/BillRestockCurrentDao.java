/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.BillRestock;

/**
 *
 * @author dragonyte
 */
public interface BillRestockCurrentDao extends Dao<BillRestock, Long>{
    BillRestock getLostDay();
}
