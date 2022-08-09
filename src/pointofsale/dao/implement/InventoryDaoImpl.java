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

import pointofsale.dao.InventoryDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Inventory;

/**
 *
 * @author dragonyte
 */
public class InventoryDaoImpl extends SqlConstructor implements InventoryDao {

    // table config
    final String TABLE = "inventory";
    final List<String> COLUMS = Arrays.asList("ingredient_id", "quantity", "minimum");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String DELETEWHERE = "delete from " + TABLE + " where ";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String SELECTWHERE = "select * from "+ TABLE + " where ";
    final String GETMISSINGREDIENT = "select * from "+TABLE+" where quantity <= minimum and ingredient_id=?";

    private Connection connection;

    public InventoryDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(Inventory a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, a.getIngredient_id());
            statement.setInt(2, a.getQuantity());
            statement.setInt(3, a.getMinimum());
            statement.executeUpdate();
            ResultSet idKey = statement.getGeneratedKeys();
            if (idKey.next()) {
                rowId = idKey.getInt(1);
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
    public void delete(Inventory a) {
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
    public void modify(Inventory a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getIngredient_id());
            statement.setInt(2, a.getQuantity());
            statement.setInt(3, a.getMinimum());
            statement.setInt(4, a.getId());
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
    public List<Inventory> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Inventory> a = new ArrayList<>();
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
    public Inventory selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Inventory a = null;
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
    public Inventory selectWhereIngredient(String where) {
         PreparedStatement statement = null;
        ResultSet set = null;
        Inventory a = null;
        try {
            statement = this.connection.prepareStatement(SELECTWHERE + where);
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
    public Inventory convert(ResultSet set) throws SQLException {
        Integer ingredient_id = set.getInt("ingredient_id");
        Integer quantity = set.getInt("quantity");
        Integer minimum = set.getInt("minimum");
        String created_at = set.getString("created_at");
        Inventory inventory = new Inventory(set.getInt("id"), ingredient_id, quantity, minimum, created_at);
        return inventory;
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
    public Inventory selectMissingIngredient(Integer ingredient_id){
        PreparedStatement statement = null;
        ResultSet set = null;
        Inventory a = null;
        try {
            statement = this.connection.prepareStatement(GETMISSINGREDIENT);
            statement.setInt(1, ingredient_id);
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
