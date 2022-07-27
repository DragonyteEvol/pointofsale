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
import pointofsale.dao.RoomDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Room;

/**
 *
 * @author dragonyte
 */
public class RoomDaoImpl extends SqlConstructor implements RoomDao {

    // table config
    final String TABLE = "rooms";
    final List<String> COLUMS = Arrays.asList("route_image", "capacity", "description", "price", "allocatted", "categorie_id");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETONEWHITCATEGORIE = "select "+ TABLE +".*,categories.name as categorie from rooms INNER join categories on categories.id = rooms.categorie_id where rooms.id=?";

    private Connection connection;

    public RoomDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(Room a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setString(1, a.getRoute_image());
            statement.setInt(2, a.getCapacity());
            statement.setString(3, a.getDescription());
            statement.setDouble(4, a.getPrice());
            statement.setBoolean(5, a.isAllocatted());
            statement.setInt(6, a.getCategorie_id());

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
    public void delete(Room a) {
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
    public void modify(Room a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getRoute_image());
            statement.setInt(2, a.getCapacity());
            statement.setString(3, a.getDescription());
            statement.setDouble(4, a.getPrice());
            statement.setBoolean(5, a.isAllocatted());
            statement.setInt(6, a.getCategorie_id());
            statement.setInt(7, a.getId());
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
    public List<Room> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Room> a = new ArrayList<>();
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
    public Room selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Room a = null;
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
    public Room selectByIdWhitCategorie(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Room a = null;
        try {
            statement = this.connection.prepareStatement(GETONEWHITCATEGORIE);
            statement.setLong(1, id);
            set = statement.executeQuery();
            if (set.next()) {
                a = convert(set);
                a.setCategorie(set.getString("categorie"));
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
    public Room convert(ResultSet set) throws SQLException {
        String route_image = set.getString("route_image");
        Integer capacity = set.getInt("capacity");
        String description = set.getString("description");
        Double price = set.getDouble("price");
        Integer categorie_id = set.getInt("categorie_id");
        boolean allocatted = set.getBoolean("allocatted");
        String created_at = set.getString("created_at");
        Room room = new Room(set.getInt("id"), route_image, capacity, description, price, categorie_id, allocatted, created_at);
        return room;
    }

}
