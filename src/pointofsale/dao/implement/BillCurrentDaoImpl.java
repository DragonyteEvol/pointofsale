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
import pointofsale.dao.BillCurrentDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Bill;

/**
 *
 * @author dragonyte
 */
public class BillCurrentDaoImpl extends SqlConstructor implements BillCurrentDao {

    // table config
    final String TABLE = "bills_current";
    final List<String> COLUMS = Arrays.asList("description", "client_type", "client_id", "waiter_id","user_id", "people", "discount", "tip", "courtesy", "internal", "payment_method_id", "housing", "printed", "total", "total_real", "event_id","id");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE;
    final String GETALL = "select sum(a.total) as total, b.name as description from "+TABLE+" a INNER JOIN payment_methods b on b.id = a.payment_method_id GROUP BY payment_method_id";
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETLOST = "";
    
    private Connection connection;

    public BillCurrentDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(Bill a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getDescription());
            statement.setInt(2, a.getClient_type());
            statement.setInt(3, a.getClient_id());
            statement.setInt(4, a.getWaiter_id());
            statement.setInt(5, a.getUser_id());
            statement.setInt(6, a.getPeople());
            statement.setInt(7, a.getDiscount());
            statement.setInt(8, a.getTip());
            statement.setBoolean(9, a.isCourtesy());
            statement.setBoolean(10, a.isInternal());
            statement.setInt(11, a.getPayment_method_id());
            statement.setBoolean(12, a.isHousing());
            statement.setBoolean(13, a.isPrinted());
            statement.setInt(14, a.getTotal());
            statement.setInt(15, a.getTotal_real());
            statement.setInt(16, a.getEvent_id());
            statement.setInt(17, a.getId());
            rowId = statement.executeUpdate();
            ResultSet idKey = statement.getGeneratedKeys();
            if (idKey.next()) {
                rowId = idKey.getInt(1);
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
    public void delete(Bill a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETE);
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
    public void modify(Bill a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getDescription());
            statement.setInt(2, a.getClient_type());
            statement.setInt(3, a.getClient_id());
            statement.setInt(4, a.getWaiter_id());
            statement.setInt(5, a.getUser_id());
            statement.setInt(6, a.getPeople());
            statement.setInt(7, a.getDiscount());
            statement.setInt(8, a.getTip());
            statement.setBoolean(9, a.isCourtesy());
            statement.setBoolean(10, a.isInternal());
            statement.setInt(11, a.getPayment_method_id());
            statement.setBoolean(12, a.isHousing());
            statement.setBoolean(13, a.isPrinted());
            statement.setInt(14, a.getTotal());
            statement.setInt(15, a.getTotal_real());
            statement.setInt(16, a.getEvent_id());
            statement.setInt(17, a.getId());
            statement.setInt(17, a.getId());
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
    public List<Bill> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Bill> a = new ArrayList<>();
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
    public Bill selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Bill a = null;
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
    public Bill convert(ResultSet set) throws SQLException {
        String description = set.getString("description");
        Integer total = set.getInt("total");
        Bill bill = new Bill();
        bill.setDescription(description);
        bill.setTotal(total);
        return bill;
    }
}
