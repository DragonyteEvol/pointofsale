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
    final List<String> COLUMS = Arrays.asList("description", "client_type", "client_id", "waiter_id","user_id", "people", "discount", "tip", "courtesy", "internal", "payment_method_id", "housing", "printed", "total", "total_real", "event_id");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE + " order by created_at desc limit 50";
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETBYEVENT = "select * from " + TABLE + " where event_id=?";
    final String GETCOLLECTEVENT = "select id,description,client_type,client_id,waiter_id,user_id,people,discount,tip,courtesy,internal,payment_method_id,housing,printed,sum(total) as total,sum(total_real) as total_real,event_id, created_at from bills where event_id=?";
    
    private Connection connection;

    public BillDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(Bill a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getDescription());
            statement.setLong(2, a.getClient_type());
            statement.setLong(3, a.getClient_id());
            statement.setLong(4, a.getWaiter_id());
            statement.setLong(5, a.getUser_id());
            statement.setLong(6, a.getPeople());
            statement.setLong(7, a.getDiscount());
            statement.setLong(8, a.getTip());
            statement.setBoolean(9, a.isCourtesy());
            statement.setBoolean(10, a.isInternal());
            statement.setLong(11, a.getPayment_method_id());
            statement.setBoolean(12, a.isHousing());
            statement.setBoolean(13, a.isPrinted());
            statement.setLong(14, a.getTotal());
            statement.setLong(15, a.getTotal_real());
            statement.setLong(16, a.getEvent_id());
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
    public void delete(Bill a) {
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
    public void modify(Bill a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getDescription());
            statement.setLong(2, a.getClient_type());
            statement.setLong(3, a.getClient_id());
            statement.setLong(4, a.getWaiter_id());
            statement.setLong(5, a.getUser_id());
            statement.setLong(6, a.getPeople());
            statement.setLong(7, a.getDiscount());
            statement.setLong(8, a.getTip());
            statement.setBoolean(9, a.isCourtesy());
            statement.setBoolean(10, a.isInternal());
            statement.setLong(11, a.getPayment_method_id());
            statement.setBoolean(12, a.isHousing());
            statement.setBoolean(13, a.isPrinted());
            statement.setLong(14, a.getTotal());
            statement.setLong(15, a.getTotal_real());
            statement.setLong(16, a.getEvent_id());
            statement.setLong(17, a.getId());
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
        Long client_type = set.getLong("client_type");
        Long client_id = set.getLong("client_id");
        Long waiter_id = set.getLong("waiter_id");
        Long user_id = set.getLong("user_id");
        Long people = set.getLong("people");
        Long discount = set.getLong("discount");
        Long tip = set.getLong("tip");
        Boolean courtesy = set.getBoolean("courtesy");
        Boolean internal = set.getBoolean("internal");
        Long payment_method_id = set.getLong("payment_method_id");
        Boolean housing = set.getBoolean("housing");
        Boolean printed = set.getBoolean("printed");
        Long total = set.getLong("total");
        Long total_real = set.getLong("total_real");
        Long event_id = set.getLong("event_id");
        String created_at = set.getString("created_at");
        Bill bill = new Bill(set.getLong("id"), description, client_type, client_id, waiter_id,user_id, people, discount, tip, courtesy, internal, payment_method_id, housing, printed, total, total_real, event_id, created_at);
        return bill;
    }

    @Override
    public List<Bill> selectByEvent(Long event_id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Bill> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETBYEVENT);
            statement.setLong(1, event_id);
            set = statement.executeQuery();
            if (set.next()) {
                a.add(convert(set));
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
    public Bill selectCollectEvent(Long event_id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Bill a = null;
        try {
            statement = this.connection.prepareStatement(GETCOLLECTEVENT);
            statement.setLong(1, event_id);
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
}
