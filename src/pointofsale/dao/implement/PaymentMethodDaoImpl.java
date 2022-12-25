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
import pointofsale.dao.PaymentMethodDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.PaymentMethod;

/**
 *
 * @author dragonyte
 */
public class PaymentMethodDaoImpl extends SqlConstructor implements PaymentMethodDao {

    // table config
    final String TABLE = "payment_methods";
    final List<String> COLUMS = Arrays.asList("name", "virtual");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String SEARCH = "select * from " + TABLE + " where name like ";

    private Connection connection;

    public PaymentMethodDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(PaymentMethod a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setString(1, a.getName());
            statement.setBoolean(2, a.isVirtual());
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
    public void delete(PaymentMethod a) {
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
    public void modify(PaymentMethod a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setBoolean(2, a.isVirtual());
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
    public List<PaymentMethod> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<PaymentMethod> a = new ArrayList<>();
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
    public PaymentMethod selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        PaymentMethod a = null;
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
    public PaymentMethod convert(ResultSet set) throws SQLException {
        String name = set.getString("name");
        Boolean virtual = set.getBoolean("virtual");
        String created_at = set.getString("created_at");
        PaymentMethod paymentMethod = new PaymentMethod(set.getLong("id"), name, virtual, created_at);
        return paymentMethod;
    }

    @Override
    public List<PaymentMethod> search(String search) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<PaymentMethod> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(SEARCH + "'%" + search +"%'");
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

}
