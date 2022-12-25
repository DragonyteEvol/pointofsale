/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.database.SqlConstructor;
import pointofsale.dao.AditionalInformationDao;
import pointofsale.objects.AditionalInformation;

/**
 *
 * @author dragonyte
 */
public class AditionalInformationDaoImpl extends SqlConstructor implements AditionalInformationDao {
// table config

    final String TABLE = "aditional_information";
    final List<String> COLUMS = Arrays.asList("nit", "name", "address", "phone", "logo_path", "default_tip");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public AditionalInformationDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(AditionalInformation a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setLong(1, a.getNit());
            statement.setString(2, a.getName());
            statement.setString(3, a.getAddress());
            statement.setLong(4, a.getPhone());
            statement.setString(5, a.getLogo_path());
            statement.setLong(6, a.getDefault_tip());
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
    public void delete(AditionalInformation a) {
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
    public void modify(AditionalInformation a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getNit());
            statement.setString(2, a.getName());
            statement.setString(3, a.getAddress());
            statement.setLong(4, a.getPhone());
            statement.setString(5, a.getLogo_path());
            statement.setLong(6, a.getDefault_tip());
            statement.setLong(7, a.getId());
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
    public List<AditionalInformation> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<AditionalInformation> a = new ArrayList<>();
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
    public AditionalInformation selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        AditionalInformation a = null;
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
    public AditionalInformation convert(ResultSet set) throws SQLException {
        Long nit = set.getLong("nit");
        String name = set.getString("name");
        String logo_path = set.getString("logo_path");
        Long default_tip = set.getLong("default_tip");
        String created_at = set.getString("created_at");
        String address = set.getString("address");
        Long phone = set.getLong("phone");
        AditionalInformation information = new AditionalInformation(set.getLong("id"), nit, name, logo_path, default_tip, created_at);
        information.setAddress(address);
        information.setPhone(phone);
        return information;
    }

    @Override
    public AditionalInformation selectFirst() {
        PreparedStatement statement = null;
        ResultSet set = null;
        AditionalInformation a = null;
        try {
            statement = this.connection.prepareStatement(GETALL);
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

}
