/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Tip;

/**
 *
 * @author dragonyte
 */
public class TipModel extends Model{
    
    public List<Tip> selectAll(){
        List<Tip> tips= this.dao.getTipDao().selectAll();
        this.closeConnection();
        return tips;
    }
    
    public List<Tip> selectTipUser(){
        List<Tip> tips= this.dao.getTipDao().selectTipUser();
        this.closeConnection();
        return tips;
    }
    
}
