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
import pointofsale.dao.BillRestockIngredientDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillRestockIngredient;

/**
 *
 * @author dragonyte
 */
public class BillRestockIngredientDaoImpl extends SqlConstructor implements BillRestockIngredientDao {

    // table config
    final String TABLE = "bill_restock_ingredient";
    final List<String> COLUMS = Arrays.asList("bill_restock_id", "ingredient_id", "quantity", "subvalue");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public BillRestockIngredientDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(BillRestockIngredient a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setLong(1, a.getBill_restock_id());
            statement.setLong(2, a.getIngredient_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getSubvalue());
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
    public void delete(BillRestockIngredient a) {
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
    public void modify(BillRestockIngredient a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getBill_restock_id());
            statement.setLong(2, a.getIngredient_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getSubvalue());
            statement.setLong(5, a.getId());
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
    public List<BillRestockIngredient> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillRestockIngredient> a = new ArrayList<>();
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
    public BillRestockIngredient selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillRestockIngredient a = null;
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
    public BillRestockIngredient convert(ResultSet set) throws SQLException {
        Long bill_restock_id = set.getLong("bill_restock_id");
        Long ingredient_id = set.getLong("ingredient_id");
        Long quantity = set.getLong("quantity");
        Long subvalue = set.getLong("subvalue");
        String created_at = set.getString("created_at");
        BillRestockIngredient billRestockIngredient = new BillRestockIngredient(set.getLong("id"), bill_restock_id, ingredient_id, quantity, subvalue, created_at);
        return billRestockIngredient;
    }
}
