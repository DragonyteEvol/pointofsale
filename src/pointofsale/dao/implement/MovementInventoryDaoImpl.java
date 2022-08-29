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
import pointofsale.dao.MovementInventoryDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.MovementInventory;

/**
 *
 * @author dragonyte
 */
public class MovementInventoryDaoImpl extends SqlConstructor implements MovementInventoryDao {

    // table config
    final String TABLE = "movement_inventory";
    final List<String> COLUMS = Arrays.asList("ingredient_id", "quantity", "addition", "substraction");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String DELETEWHERE = "delete from " + TABLE + " where ";
    final String GETALL = "select id,entry,out,required,user_id,strftime(\"%Y-%m-%d\",created_at) as created_at from "+TABLE+" ORDER by created_at DESC Limit 200;";
    final String GETBYINGREDIENT = "select * from "+TABLE+" WHERE ingredient_id=? ORDER by created_at DESC Limit 200";
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public MovementInventoryDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(MovementInventory a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setInt(1, a.getIngredient_id());
            statement.setInt(2, a.getQuantity());
            statement.setBoolean(3, a.isAddition());
            statement.setBoolean(4, a.isSubstraction());
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
    public void delete(MovementInventory a) {
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
    public void modify(MovementInventory a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getIngredient_id());
            statement.setInt(2, a.getQuantity());
            statement.setBoolean(3, a.isAddition());
            statement.setBoolean(4, a.isSubstraction());
            statement.setInt(5, a.getId());
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
    public List<MovementInventory> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<MovementInventory> a = new ArrayList<>();
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
    public MovementInventory selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        MovementInventory a = null;
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
    public MovementInventory convert(ResultSet set) throws SQLException {
        Integer ingredient_id = set.getInt("ingredient_id");
        Integer quantity = set.getInt("quantity");
        Boolean addition = set.getBoolean("addition");
        Boolean substraction = set.getBoolean("substraction");
        String created_at = set.getString("created_at");
        MovementInventory movementInventory = new MovementInventory(set.getInt("id"), ingredient_id, quantity, addition, substraction, created_at);
        return movementInventory;
    }

    @Override
    public void deleteWhere(String where) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETEWHERE + where);
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

    @Override
    public List<MovementInventory> getByIngredient(int id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<MovementInventory> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETBYINGREDIENT);
            statement.setLong(1, id);
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
