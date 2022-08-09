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
import pointofsale.dao.MissingStockDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.MissingStock;

/**
 *
 * @author dragonyte
 */
public class MissingStockDaoImpl extends SqlConstructor implements MissingStockDao {

    // table config
    final String TABLE = "missing_stock";
    final List<String> COLUMS = Arrays.asList("ingredient_id", "showed");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWHERE = "select * from " + TABLE + " where ingredient_id=?";

    final String GETNOTIFICATION = "SELECT missing_stock.id,ingredients.created_at,ingredients.id as ingredient_id,ingredients.name,inventory.quantity,units.name as unit,missing_stock.showed from missing_stock INNER JOIN ingredients on ingredients.id = missing_stock.ingredient_id INNER join units on units.id = ingredients.unit_id INNER join inventory on inventory.ingredient_id = ingredients.id";

    private Connection connection;

    public MissingStockDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(MissingStock a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setInt(1, a.getIngredient_id());
            statement.setBoolean(2, a.isShowed());
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
    public void delete(MissingStock a) {
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
    public void modify(MissingStock a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getIngredient_id());
            statement.setBoolean(2, a.isShowed());
            statement.setInt(3, a.getId());
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
    public List<MissingStock> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<MissingStock> a = new ArrayList<>();
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
    public MissingStock selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        MissingStock a = null;
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
    public MissingStock convert(ResultSet set) throws SQLException {
        Integer ingredient_id = set.getInt("ingredient_id");
        String created_at = set.getString("created_at");
        boolean showed = set.getBoolean("showed");
        MissingStock missingStock = new MissingStock(set.getInt("id"), ingredient_id, showed, created_at);
        return missingStock;
    }

    public MissingStock convertNotification(ResultSet set) throws SQLException {
        Integer ingredient_id = set.getInt("ingredient_id");
        String created_at = set.getString("created_at");
        String name = set.getString("name");
        String unit = set.getString("unit");
        Integer quantity = set.getInt("quantity");
        boolean showed = set.getBoolean("showed");
        MissingStock missingStock = new MissingStock(set.getInt("id"), ingredient_id, showed, created_at);
        missingStock.setName(name);
        missingStock.setQuantity(quantity);
        missingStock.setUnit(unit);
        return missingStock;
    }

    @Override
    public List<MissingStock> selectNotification() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<MissingStock> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETNOTIFICATION);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertNotification(set));
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
    public MissingStock selectWhereIngredient(Integer ingredient_id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        MissingStock a = null;
        try {
            statement = this.connection.prepareStatement(GETWHERE);
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
