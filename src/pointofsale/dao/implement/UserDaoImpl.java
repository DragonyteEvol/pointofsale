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
import pointofsale.dao.UserDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.User;

/**
 *
 * @author dragonyte
 */
public class UserDaoImpl extends SqlConstructor implements UserDao {

    // table config
    final String TABLE = "users";
    final List<String> COLUMS = Arrays.asList("name", "mail", "password", "admin","waiter");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETBYMAIL = "select * from " + TABLE + " where mail=?";
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWAITERS = "SELECT * FROM " + TABLE + " WHERE waiter=TRUE";

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(User a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setString(1, a.getName());
            statement.setString(2, a.getMail());
            statement.setString(3, a.getPassword());
            statement.setBoolean(4, a.isAdmin());
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
    public void delete(User a) {
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
    public void modify(User a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setString(2, a.getMail());
            statement.setString(3, a.getPassword());
            statement.setBoolean(4, a.isAdmin());
            statement.setBoolean(5, a.isWaiter());
            statement.setLong(6, a.getId());
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
    public List<User> selectWaiters() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<User> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETWAITERS);
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
    
    public List<User> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<User> a = new ArrayList<>();
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
    public User selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        User a = null;
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
    public User convert(ResultSet set) throws SQLException {
        String name = set.getString("name");
        String mail = set.getString("mail");
        String password = set.getString("password");
        Boolean admin = set.getBoolean("admin");
        String created_at = set.getString("created_at");
        Boolean waiter = set.getBoolean("waiter");
        User user = new User(set.getLong("id"), name, mail, password, admin, waiter,created_at);
        return user;
    }

    @Override
    public User selectByMail(String mail) {
        PreparedStatement statement = null;
        ResultSet set = null;
        User a = null;
        try {
            statement = this.connection.prepareStatement(GETBYMAIL);
            statement.setString(1, mail);
            set = statement.executeQuery();
            while (set.next()) {
                a = convert(set);
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
