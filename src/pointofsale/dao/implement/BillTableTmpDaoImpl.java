/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.dao.BillTableTmpDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public class BillTableTmpDaoImpl extends SqlConstructor implements BillTableTmpDao {

    // table config
    final String TABLE = "bills_table_tmp";
    final List<String> COLUMS = Arrays.asList("table_id", "total");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWHERETABLEID = "select * from " + TABLE + " where table_id=?";
    final String GETPRODUCTS = "SELECT products.id,quantity,name,subvalue,bills_table_products_tmp.created_at as updated_at from bills_table_tmp inner join bills_table_products_tmp on bills_table_products_tmp.bill_tmp_id = bills_table_tmp.id inner join products on products.id = bills_table_products_tmp.product_id where bills_table_tmp.table_id=?";

    private Connection connection;

    public BillTableTmpDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(BillTableTmp a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getTable_id());
            statement.setLong(2, a.getTotal());
            rowId = Long.valueOf(statement.executeUpdate());
            ResultSet idKey = statement.getGeneratedKeys();
            if (idKey.next()) {
                rowId = idKey.getLong(1);
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
    public void delete(BillTableTmp a) {
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
    public void modify(BillTableTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getTable_id());
            statement.setLong(2, a.getTotal());
            statement.setLong(3, a.getId());
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
    public List<BillTableTmp> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillTableTmp> a = new ArrayList<>();
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
    public BillTableTmp selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillTableTmp a = null;
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
    public BillTableTmp convert(ResultSet set) throws SQLException {
        Long table_id = set.getLong("table_id");
        Long total = set.getLong("total");
        String created_at = set.getString("created_at");
        BillTableTmp billTable = new BillTableTmp(set.getLong("id"), table_id, total, created_at);
        return billTable;
    }

    @Override
    public BillTableTmp selectByTableId(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillTableTmp a = null;
        try {
            statement = this.connection.prepareStatement(GETWHERETABLEID);
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
    
    @Override
    public List<Product> selectProducts(Long id) {
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

    // convert ResultSet to objects
    public Product convertProduct(ResultSet set) throws SQLException {
        Long id = set.getLong("id");
        String name = set.getString("name");
        Long quantity = set.getLong("quantity");
        Long subvalue = set.getLong("subvalue");
        String created_at = set.getString("updated_at");
        Product product = new Product();
        product.setId(id);
        product.setCreated_at(created_at);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(subvalue);
        return product;
    }
}
