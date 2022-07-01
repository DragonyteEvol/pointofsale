/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dragonyteevol
 */
public class DataBaseConnection {
	String base= "pointofsale.db";
	Connection connect;
	public DataBaseConnection(){
		this.connect();
	}

	public Connection connect(){
		try{
			this.connect = DriverManager.getConnection("jdbc:sqlite:"+this.base);
			if(this.connect!=null){
				System.out.println("OK");
			}
		}catch(SQLException e){
			System.out.println("connect error " + e.getMessage());
		}
		return this.connect;
	}

	// Close connection method
	public void closeConnection(Connection connection){
		try{
			connection.close();
		}catch(SQLException e ){
			System.out.println("close connect error" + e.getMessage());
		}
	}
}
