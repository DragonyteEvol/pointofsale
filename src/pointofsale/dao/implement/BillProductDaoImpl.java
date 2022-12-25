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
import pointofsale.dao.BillProductDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillProduct;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public class BillProductDaoImpl extends SqlConstructor implements BillProductDao {

    // table config
    final String TABLE = "bills_products";
    final List<String> COLUMS = Arrays.asList("bill_id", "product_id", "quantity", "subvalue");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETPRODUCTS = "select * from " + TABLE + " INNER join products on bills_products.product_id = products.id where bill_id=?"; 

    private Connection connection;

    public BillProductDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(BillProduct a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setLong(1, a.getBill_id());
            statement.setLong(2, a.getProduct_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getSubvalue());
            rowId = Long.valueOf(statement.executeUpdate());
            if (rowId == 0) {
                System.out.println("Execute error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return rowId;
    }

    // delete row
    @Override
    public void delete(BillProduct a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETE);
            statement.setLong(1, a.getId());
            if (statement.executeUpdate() == 0) {
                System.out.println("Execute error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // update row
    @Override
    public void modify(BillProduct a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getBill_id());
            statement.setLong(2, a.getProduct_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getSubvalue());
            statement.setLong(5, a.getId());
            if (statement.executeUpdate() == 0) {
                System.out.println("Execute error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // select all rows
    @Override
    public List<BillProduct> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillProduct> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETALL);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convert(set));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return a;

    }

    // select row for id
    @Override
    public BillProduct selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillProduct a = null;
        try {
            statement = this.connection.prepareStatement(GETONE);
            statement.setLong(1, id);
            set = statement.executeQuery();
            if (set.next()) {
                a = convert(set);
            } else {
                System.out.println("empty set");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return a;
    }

    // convert ResultSet to objects
    public BillProduct convert(ResultSet set) throws SQLException {
        Long bill_id = set.getLong("bill_id");
        Long product_id = set.getLong("product_id");
        Long quantity = set.getLong("quantity");
        Long subvalue = set.getLong("subvalue");
        String created_at = set.getString("created_at");
        BillProduct billProduct = new BillProduct(set.getLong("id"), bill_id, product_id, quantity, subvalue, created_at);
        return billProduct;
    }
    
    // convert ResultSet to objects
    public Product convertProduct(ResultSet set) throws SQLException {
        Long quantity = set.getLong("quantity");
        Long subvalue = set.getLong("subvalue");
        String name = set.getString("name");
        Product product = new Product();
        product.setName(name);
        product.setPrice(subvalue);
        product.setQuantity(quantity);
        return product;
    }

    @Override
    public List<Product> selectProductsByBillId(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Product> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETPRODUCTS);
            statement.setLong(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertProduct(set));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return a;
    }
}
