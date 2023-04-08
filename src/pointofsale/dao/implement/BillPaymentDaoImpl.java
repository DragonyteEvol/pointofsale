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
import pointofsale.dao.BillPaymentDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Bill;
import pointofsale.objects.BillPayment;

/**
 *
 * @author dragonyte
 */
public class BillPaymentDaoImpl extends SqlConstructor implements BillPaymentDao {

    // table config
    final String TABLE = "bill_payment";
    final List<String> COLUMS = Arrays.asList("bill_id","payment_method_id","total","total_real");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE + " order by created_at desc limit 50";
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETLAST = "SELECT * FROM bills ORDER BY 1 DESC LIMIT 1";
    
    private Connection connection;

    public BillPaymentDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(BillPayment a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getId());
            statement.setLong(2, a.getPayment_id());
            statement.setLong(3, a.getPrice());
            statement.setLong(4, a.getPrice());
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
    public void delete(BillPayment a) {
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
    public void modify(BillPayment a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
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
    public List<BillPayment> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillPayment> a = new ArrayList<>();
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
    public BillPayment selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillPayment a = null;
        try {
            statement = this.connection.prepareStatement(GETONE);
            statement.setLong(1, id);
            set = statement.executeQuery();
            if (set.next()) {
                a = new BillPayment();
                a.setId(set.getLong("id"));
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
    public BillPayment convert(ResultSet set) throws SQLException {
        Long payment_id = set.getLong("payment_method_id");
        Long price = set.getLong("total_real");
        BillPayment billPayment = new BillPayment(set.getLong("bill_id"),payment_id,price);
        return billPayment;
    }

    @Override
    public BillPayment selectLast() {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillPayment a = null;
        try {
            statement = this.connection.prepareStatement(GETLAST);
            set = statement.executeQuery();
            if (set.next()) {
                a = new BillPayment();
                a.setId(set.getLong("id"));
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
