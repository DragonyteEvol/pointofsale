/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.BillTableProductTmp;

/**
 *
 * @author dragonyte
 */
public interface BillTableProductTmpDao extends Dao<BillTableProductTmp, Long>{
    void deleteBill(Integer id);
}
