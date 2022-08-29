/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.AditionalInformation;

/**
 *
 * @author dragonyte
 */
public class ConfigModel extends Model {

    

    public List<AditionalInformation> selectAll() {
        List<AditionalInformation> aditionalInformations = this.dao.getAditionalInformationDao().selectAll();
        this.closeConnection();
        return aditionalInformations;
    }

    public void delete(AditionalInformation aditionalInformation) {
        this.dao.getAditionalInformationDao().delete(aditionalInformation);
        this.saveChanges();
    }

    public void update(AditionalInformation aditionalInformation) {
        this.dao.getAditionalInformationDao().modify(aditionalInformation);
        this.saveChanges();
    }

    public void insert(AditionalInformation aditionalInformation) {
        this.dao.getAditionalInformationDao().insert(aditionalInformation);
        this.saveChanges();
    }

    public AditionalInformation selectDefaultConfig() {
        AditionalInformation aditionalInformation = this.dao.getAditionalInformationDao().selectFirst();
        this.closeConnection();
        return aditionalInformation;
    }

    public void deleteAllTables() {
        this.dao.getDeleteDao().deleteAllTables();
        this.saveChanges();
    }
}
