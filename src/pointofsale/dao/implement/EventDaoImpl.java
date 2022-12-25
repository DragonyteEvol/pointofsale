/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.dao.EventDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Event;

/**
 *
 * @author dragonyte
 */
public class EventDaoImpl extends SqlConstructor implements EventDao {

    // table config
    final String TABLE = "events";
    final List<String> COLUMS = Arrays.asList("name", "description", "start_date", "end_date", "price","active");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETACTIVE = "select * from " + TABLE + " where active=1";

    private Connection connection;

    public EventDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(Event a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName());
            statement.setString(2, a.getDescription());
            statement.setString(3, a.getStart_date());
            statement.setString(4, a.getEnd_date());
            statement.setLong(5, a.getPrice());
            statement.setBoolean(6, a.isActive());
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
    public void delete(Event a) {
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
    public void modify(Event a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setString(2, a.getDescription());
            statement.setString(3, a.getStart_date());
            statement.setString(4, a.getEnd_date());
            statement.setLong(5, a.getPrice());
            statement.setBoolean(6, a.isActive());
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
    public List<Event> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Event> a = new ArrayList<>();
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
    public Event selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Event a = null;
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

    @Override
    public Event selectActive(){
        PreparedStatement statement = null;
        ResultSet set = null;
        Event a = null;
        try {
            statement = this.connection.prepareStatement(GETACTIVE);
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
    public Event convert(ResultSet set) throws SQLException {
        String name = set.getString("name");
        String description = set.getString("description");
        String start_date = set.getString("start_date");
        String end_date = set.getString("end_date");
        Long price = set.getLong("price");
        String created_at = set.getString("created_at");
        boolean active = set.getBoolean("active");
        Event event = new Event(set.getLong("id"), name, description, start_date, end_date, price, active,created_at);
        return event;
    }

}
