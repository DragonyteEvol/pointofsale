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
import java.util.List;
import pointofsale.dao.ReportDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Report;

/**
 *
 * @author dragonyte
 */
public class ReportDaoImpl extends SqlConstructor implements ReportDao {

    private Connection connection;

    public ReportDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Report> select(String SQL) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Report> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(SQL);
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

    @Override
    public Report selectReport(String SQL) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Report a = null;
        try {
            statement = this.connection.prepareStatement(SQL);
            set = statement.executeQuery();
            while (set.next()) {
                a = (convert(set));
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
    public Report convert(ResultSet set) throws SQLException {
        Integer id = set.getInt("id");
        String name = set.getString("name");
        Integer quantity = set.getInt("quantity");
        Integer subvalue = set.getInt("subvalue");
        String created_at = set.getString("updated_at");
        Report report = new Report();
        report.setId(id);
        report.setCreated_at(created_at);
        report.setName(name);
        report.setQuantity(quantity);
        report.setSubvalue(subvalue);
        return report;
    }
}
