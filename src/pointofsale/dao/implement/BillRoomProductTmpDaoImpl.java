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
import pointofsale.dao.BillRoomProductTmpDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillRoomProductTmp;

/**
 *
 * @author dragonyte
 */
public class BillRoomProductTmpDaoImpl extends SqlConstructor implements BillRoomProductTmpDao {

    // table config
    final String TABLE = "bills_room_products_tmp";
    final List<String> COLUMS = Arrays.asList("bill_tmp_id", "product_id", "quantity", "subvalue");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public BillRoomProductTmpDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(BillRoomProductTmp a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setInt(1, a.getBill_tmp_id());
            statement.setInt(2, a.getProduct_id());
            statement.setInt(3, a.getQuantity());
            statement.setInt(4, a.getSubvalue());
            rowId = statement.executeUpdate();
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
    public void delete(BillRoomProductTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETE);
            statement.setInt(1, a.getId());
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
    public void modify(BillRoomProductTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getBill_tmp_id());
            statement.setInt(2, a.getProduct_id());
            statement.setInt(3, a.getQuantity());
            statement.setInt(4, a.getSubvalue());
            statement.setInt(5, a.getId());
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
    public List<BillRoomProductTmp> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillRoomProductTmp> a = new ArrayList<>();
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
    public BillRoomProductTmp selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillRoomProductTmp a = null;
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
    public BillRoomProductTmp convert(ResultSet set) throws SQLException {
        Integer bill_tmp_id = set.getInt("bill_tmp_id");
        Integer product_id = set.getInt("product_id");
        Integer quantity = set.getInt("quantity");
        Integer subvalue = set.getInt("subvalue");
        String created_at = set.getString("created_at");
        BillRoomProductTmp billRoomProduct = new BillRoomProductTmp(set.getInt("id"), bill_tmp_id, product_id, quantity, subvalue, created_at);
        return billRoomProduct;
    }

}
