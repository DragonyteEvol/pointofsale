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
import pointofsale.dao.BillRestockDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillRestock;

/**
 *
 * @author dragonyte
 */
public class BillRestockDaoImpl extends SqlConstructor implements BillRestockDao{
    
	// table config
	final String TABLE="bill_restock";
	final List<String> COLUMS= Arrays.asList("user_id","price");

	// queries
	String INSERT;
	String UPDATE;
	final String DELETE= "delete from "+TABLE+" where id=?";
	final String GETALL= "select * from "+TABLE;
	final String GETONE= "select * from "+TABLE+" where id=?";

	private Connection connection;

    public BillRestockDaoImpl(Connection connection) {
		this.connection=connection;
		this.UPDATE=setUpdate(this.TABLE,this.COLUMS);
		this.INSERT=setInsert(this.TABLE,this.COLUMS);
    }

	// insert row 
	@Override
	public void insert(BillRestock a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(INSERT);
			statement.setInt(1, a.getUser_id());
			statement.setDouble(2, a.getPrice());
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
	public void delete(BillRestock a) {
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
	public void modify(BillRestock a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(UPDATE);
			statement.setInt(1, a.getUser_id());
			statement.setDouble(2, a.getPrice());
			statement.setInt(3, a.getId());
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
	public List<BillRestock> selectAll() {
		PreparedStatement statement= null;
		ResultSet set= null;
		List<BillRestock> a=new ArrayList<>();
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
	public BillRestock selectById(Long id){
		PreparedStatement statement= null;
		ResultSet set= null;
		BillRestock a=null;
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
	public BillRestock convert(ResultSet set) throws SQLException{
		Integer user_id= set.getInt("user_id");
		Double price= set.getDouble("price");
		String created_at= set.getString("created_at");
		BillRestock billRestock = new BillRestock(set.getInt("id"),user_id, price,created_at);
		return billRestock;
	}
}
