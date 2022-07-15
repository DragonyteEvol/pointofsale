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
import pointofsale.dao.BillTableTmpDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillTableTmp;

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

    private Connection connection;

    public BillTableTmpDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(BillTableTmp a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setInt(1, a.getTable_id());
            statement.setDouble(2, a.getTotal());
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
    public void delete(BillTableTmp a) {
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
    public void modify(BillTableTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getTable_id());
            statement.setDouble(2, a.getTotal());
            statement.setInt(3, a.getId());
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
        Integer table_id = set.getInt("table_id");
        Double total = set.getDouble("total");
        String created_at = set.getString("created_at");
        BillTableTmp billTable = new BillTableTmp(set.getInt("id"), table_id, total, created_at);
        return billTable;
    }

}
