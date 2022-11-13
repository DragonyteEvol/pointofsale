/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import pointofsale.objects.CashDrawer;

/**
 *
 * @author dragonyte
 */
public class CashDrawerModel extends Model{
    
    public CashDrawer selectPassword(){
        CashDrawer cashDrawer= this.dao.getCashDrawerDao().selectPassword();
        this.closeConnection();
        return cashDrawer;
    }
}
