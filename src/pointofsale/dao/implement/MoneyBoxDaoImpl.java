/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.dao.MoneyBoxDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.MoneyBox;

/**
 *
 * @author dragonyte
 */
public class MoneyBoxDaoImpl extends SqlConstructor implements MoneyBoxDao{
    
	// table config
	final String TABLE="money_box";
	final List<String> COLUMS= Arrays.asList("entry","out","required","user_id");

	// queries
	String INSERT;
	String UPDATE;
	final String DELETE= "delete from "+TABLE+" where id=?";
	final String GETALL= "select * from "+TABLE;
	final String GETONE= "select * from "+TABLE+" where id=?";

	private Connection connection;

    public MoneyBoxDaoImpl(Connection connection) {
		this.connection=connection;
		this.UPDATE=setUpdate(this.TABLE,this.COLUMS);
		this.INSERT=setInsert(this.TABLE,this.COLUMS);
    }

	// insert row 
	@Override
	public void insert(MoneyBox a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(INSERT);
			statement.setDouble(1, a.getEntry());
			statement.setDouble(2, a.getOut());
			statement.setDouble(3, a.getRequired());
			statement.setInt(4, a.getUser_id());
			if(statement.executeUpdate()==0){
				System.out.println("Execute error");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				statement.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
	}

	// delete row
	@Override
	public void delete(MoneyBox a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(DELETE);
			statement.setInt(1, a.getId());
			if(statement.executeUpdate()==0){
				System.out.println("Execute error");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				statement.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
	}

	// update row
	@Override
	public void modify(MoneyBox a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(UPDATE);
			statement.setDouble(1, a.getEntry());
			statement.setDouble(2, a.getOut());
			statement.setDouble(3, a.getRequired());
			statement.setInt(4, a.getUser_id());
			statement.setInt(5, a.getId());
			if(statement.executeUpdate()==0){
				System.out.println("Execute error");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				statement.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
	}

	// select all rows
	@Override
	public List<MoneyBox> selectAll() {
		PreparedStatement statement= null;
		ResultSet set= null;
		List<MoneyBox> a=new ArrayList<>();
		try{
			statement = this.connection.prepareStatement(GETALL);
			set = statement.executeQuery();
			while(set.next()){
				a.add(convert(set));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			if(set!=null){
				try{
					set.close();
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
			}
		}
		return a;

	}

	// select row for id
	@Override
	public MoneyBox selectById(Long id){
		PreparedStatement statement= null;
		ResultSet set= null;
		MoneyBox a=null;
		try{
			statement = this.connection.prepareStatement(GETONE);
			statement.setLong(1, id);
			set = statement.executeQuery();
			if(set.next()){
				a= convert(set);
			}else{
				System.out.println("empty set");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			if(set!=null){
				try{
					set.close();
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
			}
		}
		return a;
	}

	// convert ResultSet to objects
	public MoneyBox convert(ResultSet set) throws SQLException{
		Double entry= set.getDouble("entry");
		Double out= set.getDouble("out");
		Double required= set.getDouble("required");
		Integer user_id= set.getInt("user_id");
		String created_at= set.getString("created_at");
		MoneyBox moneyBox = new MoneyBox(set.getInt("id"),entry, out,required,user_id,created_at);
		return moneyBox;
	}
    
}
