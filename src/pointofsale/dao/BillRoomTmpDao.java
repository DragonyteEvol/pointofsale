/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.BillRoomTmp;

/**
 *
 * @author dragonyte
 */
public interface BillRoomTmpDao extends Dao<BillRoomTmp, Long>{
    BillRoomTmp selectByRoomId(Integer id);
}
