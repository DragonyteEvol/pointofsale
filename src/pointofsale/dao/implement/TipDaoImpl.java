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
import pointofsale.dao.TipDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Atm;
import pointofsale.objects.Tip;

/**
 *
 * @author dragonyte
 */
public class TipDaoImpl extends SqlConstructor implements TipDao {

    // table config
    final String TABLE = "bills";
    final List<String> COLUMS = Arrays.asList("tip", "user_name");

    // queries
    final String GETALL = "SELECT a.tip as tip,b.name as user_name FROM "+TABLE+" a INNER JOIN users b ON a.waiter_id=b.id";
    final String GETTIPUSER = "SELECT sum(a.tip) as tip,b.name as user_name FROM "+TABLE+" a INNER JOIN users b ON a.waiter_id=b.id GROUP BY waiter_id";

    private Connection connection;

    public TipDaoImpl(Connection connection) {
        this.connection = connection;
    }

    // insert row 
    @Override
    public Integer insert(Tip a) {
        return 1;
    }

    // delete row
    @Override
    public void delete(Tip a) {
    }

    // update row
    @Override
    public void modify(Tip a) {
    }

    // select all rows
    @Override
    public List<Tip> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Tip> a = new ArrayList<>();
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
    public Tip selectById(Long id) {
        Tip tip = null;
        return tip;
    }

    // convert ResultSet to objects
    public Tip convert(ResultSet set) throws SQLException {
        Long tip_value = set.getLong("tip");
        String user_name = set.getString("user_name");
        Tip tip = new Tip(tip_value, user_name);
        return tip;
    }

    @Override
    public List<Tip> selectTipUser() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Tip> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETTIPUSER);
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
