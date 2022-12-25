/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillTableProductTmp;

/**
 *
 * @author dragonyte
 */
public class BillTableProductTmpDaoImpl extends SqlConstructor implements pointofsale.dao.BillTableProductTmpDao {

    // table config
    final String TABLE = "bills_table_products_tmp";
    final List<String> COLUMS = Arrays.asList("bill_tmp_id", "product_id", "quantity", "subvalue");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String DELETEBILL = "delete from " + TABLE + " where bill_tmp_id=?";

    private Connection connection;

    public BillTableProductTmpDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(BillTableProductTmp a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getBill_tmp_id());
            statement.setLong(2, a.getProduct_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getSubvalue());
            Long.valueOf(statement.executeUpdate());
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
    public void delete(BillTableProductTmp a) {
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
    public void modify(BillTableProductTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getBill_tmp_id());
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
    public List<BillTableProductTmp> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillTableProductTmp> a = new ArrayList<>();
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
    public BillTableProductTmp selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillTableProductTmp a = null;
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
    
    
    @Override
    public void deleteBill(Long id) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETEBILL);
            statement.setLong(1, id);
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

    // convert ResultSet to objects
    public BillTableProductTmp convert(ResultSet set) throws SQLException {
        Long bill_tmp_id = set.getLong("bill_tmp_id");
        Long product_id = set.getLong("product_id");
        Long quantity = set.getLong("quantity");
        Long subvalue = set.getLong("subvalue");
        String created_at = set.getString("created_at");
        BillTableProductTmp billTableProduct = new BillTableProductTmp(set.getLong("id"), bill_tmp_id, product_id, quantity, subvalue, created_at);
        return billTableProduct;
    }

}
