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
import pointofsale.dao.BillDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Bill;

/**
 *
 * @author dragonyte
 */
public class BillDaoImpl extends SqlConstructor implements BillDao {

    // table config
    final String TABLE = "bills";
    final List<String> COLUMS = Arrays.asList("description", "client_type", "client_id", "user_id", "people", "discount", "tip", "courtesy", "internal", "payment_method_id", "housing", "printed", "total", "total_real", "event_id");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public BillDaoImpl(Connection connection) {
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
            statement = this.connection.prepareStatement(INSERT);
            statement.setString(1, a.getDescription());
            statement.setInt(2, a.getClient_type());
            statement.setInt(3, a.getClient_id());
            statement.setInt(4, a.getUser_id());
            statement.setInt(5, a.getPeople());
            statement.setInt(6, a.getDiscount());
            statement.setDouble(7, a.getTip());
            statement.setBoolean(8, a.isCourtesy());
            statement.setBoolean(9, a.isInternal());
            statement.setInt(10, a.getPayment_method_id());
            statement.setBoolean(11, a.isHousing());
            statement.setBoolean(12, a.isPrinted());
            statement.setDouble(13, a.getTotal());
            statement.setDouble(14, a.getTotal_real());
            statement.setInt(15, a.getEvent_id());
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
    public void delete(Bill a) {
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
    public void modify(Bill a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getDescription());
            statement.setInt(2, a.getClient_type());
            statement.setInt(3, a.getClient_id());
            statement.setInt(4, a.getUser_id());
            statement.setInt(5, a.getPeople());
            statement.setInt(6, a.getDiscount());
            statement.setDouble(7, a.getTip());
            statement.setBoolean(8, a.isCourtesy());
            statement.setBoolean(9, a.isInternal());
            statement.setInt(10, a.getPayment_method_id());
            statement.setBoolean(11, a.isHousing());
            statement.setBoolean(12, a.isPrinted());
            statement.setDouble(13, a.getTotal());
            statement.setDouble(14, a.getTotal_real());
            statement.setInt(15, a.getEvent_id());
            statement.setInt(16, a.getId());
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
        Integer client_type = set.getInt("client_type");
        Integer client_id = set.getInt("client_id");
        Integer user_id = set.getInt("user_id");
        Integer people = set.getInt("people");
        Integer discount = set.getInt("discount");
        Double tip = set.getDouble("tip");
        Boolean courtesy = set.getBoolean("courtesy");
        Boolean internal = set.getBoolean("internal");
        Integer payment_method_id = set.getInt("payment_method_id");
        Boolean housing = set.getBoolean("housing");
        Boolean printed = set.getBoolean("printed");
        Double total = set.getDouble("total");
        Double total_real = set.getDouble("total_real");
        Integer event_id = set.getInt("event_id");
        String created_at = set.getString("created_at");
        Bill bill = new Bill(set.getInt("id"), description, client_type, client_id, user_id, people, discount, tip, courtesy, internal, payment_method_id, housing, printed, total, total_real, event_id, created_at);
        return bill;
    }
}
