/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.sql.Connection;
import java.sql.SQLException;

import pointofsale.dao.DaoManager;
import pointofsale.dao.implement.DaoManagerImpl;
import pointofsale.database.DataBaseConnection;

/**
 *
 * @author dragonyte
 */
public class Model {

    DaoManager dao;
	Connection connection;
    
    public Model() {
        DataBaseConnection databaseConnection= new DataBaseConnection();
		connection = databaseConnection.connect();
        this.dao = new DaoManagerImpl(connection);
    }

	public void saveChanges(){
		try{
			this.connection.commit();
			this.closeConnection();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public void closeConnection(){
		try{
			this.connection.close();
			System.out.println("Connection closed");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
