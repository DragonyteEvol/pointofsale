/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.database;

import java.util.List;

/**
 *
 * @author dragonyte
 */
public class SqlConstructor {
        
    // create insert sql sentence based on colums
	public String setInsert(String table,List<String> colums){
		// final String INSERT= "insert into "+TABLE+"(name, prefix) values(?,?)";
		String INSERT= "insert into "+table+"(";
		String values=") values(";
		for(String c:colums){
			if(c==colums.get(colums.size()-1)){
				INSERT +=c;
				values += "?";
			}else{
				INSERT += c + ",";
				values += "?,";
			}
		}
		INSERT += values + ")";
		return INSERT;
	}

	// create update sql sentence based on colums
	public String setUpdate(String table,List<String> colums){
	// String UPDATE= "update "+TABLE+" set name=?,prefix=? where id=?";
    String UPDATE= "update "+table+" set ";
		for(String c: colums){
			if(c==colums.get(colums.size()-1)){
				UPDATE += c + "=?";
			}else{
				UPDATE+= c + "=?,";
			}
		}
		UPDATE += " where id=?";
		return UPDATE;
	}
}
