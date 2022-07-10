/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import pointofsale.dao.DaoManager;
import pointofsale.dao.implement.DaoManagerImpl;
import pointofsale.database.DataBaseConnection;

/**
 *
 * @author dragonyte
 */
public class Model {

    DaoManager dao;
    
    public Model() {
        DataBaseConnection databaseConnection= new DataBaseConnection();
        this.dao = new DaoManagerImpl(databaseConnection.connect());
    }
    
}
