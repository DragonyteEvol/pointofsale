/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.CashDrawer;

/**
 *
 * @author dragonyte
 */
public interface CashDrawerDao extends Dao<CashDrawer, Long>{
    CashDrawer selectPassword();
}
