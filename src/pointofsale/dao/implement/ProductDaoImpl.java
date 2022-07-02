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
import pointofsale.dao.ProductDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public class ProductDaoImpl extends SqlConstructor implements ProductDao{
    
	// table config
	final String TABLE="products";
	final List<String> COLUMS= Arrays.asList("name","price","time","route_image","categorie_id");

	// queries
	String INSERT;
	String UPDATE;
	final String DELETE= "delete from "+TABLE+" where id=?";
	final String GETALL= "select * from "+TABLE;
	final String GETONE= "select * from "+TABLE+" where id=?";

	private Connection connection;

    public ProductDaoImpl(Connection connection) {
		this.connection=connection;
		this.UPDATE=setUpdate(this.TABLE,this.COLUMS);
		this.INSERT=setInsert(this.TABLE,this.COLUMS);
    }

	// insert row 
	@Override
	public void insert(Product a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(INSERT);
			statement.setString(1, a.getName());
			statement.setDouble(2, a.getPrice());
			statement.setInt(3, a.getTime());
			statement.setString(4, a.getRoute_image());
			statement.setInt(5, a.getCategorie_id());
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
	public void delete(Product a) {
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
	public void modify(Product a) {
		PreparedStatement statement=null;
		try{
			statement=this.connection.prepareStatement(UPDATE);
			statement.setString(1, a.getName());
			statement.setDouble(2, a.getPrice());
			statement.setInt(3, a.getTime());
			statement.setString(4, a.getRoute_image());
			statement.setInt(5, a.getCategorie_id());
			statement.setInt(6, a.getId());
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
	public List<Product> selectAll() {
		PreparedStatement statement= null;
		ResultSet set= null;
		List<Product> a=new ArrayList<>();
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
	public Product selectById(Long id){
		PreparedStatement statement= null;
		ResultSet set= null;
		Product a=null;
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
	public Product convert(ResultSet set) throws SQLException{
		String name = set.getString("name");
		Double price= set.getDouble("price");
		Integer time= set.getInt("time");
		String route_image= set.getString("route_image");
		Integer categorie_id= set.getInt("categorie_id");
		String created_at= set.getString("created_at");
		Product product = new Product(set.getInt("id"),name, price,time,route_image,categorie_id,created_at);
		return product;
	}
    
}
