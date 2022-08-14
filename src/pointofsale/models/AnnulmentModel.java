/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Annulment;

/**
 *
 * @author dragonyte
 */
public class AnnulmentModel extends Model{
    
    public void insert(Annulment annulment){
        this.dao.getAnnulmentDao().insert(annulment);
        this.saveChanges();
    }
    
    public void delete(Annulment annulment){
        this.dao.getAnnulmentDao().delete(annulment);
        this.saveChanges();
    }
    
    public List<Annulment> selectAll(){
        List<Annulment> annulments= this.dao.getAnnulmentDao().selectAll();
        this.closeConnection();
        return annulments;
    }
    
    public void update(Annulment annulment){
        this.dao.getAnnulmentDao().modify(annulment);
        this.saveChanges();
    }
    
}
