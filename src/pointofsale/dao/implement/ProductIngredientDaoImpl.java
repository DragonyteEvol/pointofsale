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
import pointofsale.dao.ProductIngredientDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.ProductIngredient;

/**
 *
 * @author dragonyte
 */
public class ProductIngredientDaoImpl extends SqlConstructor implements ProductIngredientDao {

    // table config
    final String TABLE = "product_ingredient";
    final List<String> COLUMS = Arrays.asList("product_id", "ingredient_id", "quantity");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String DELETEWHERE = "delete from " + TABLE + " where ";
    final String GETALL = "select * from " + TABLE;
    final String GETWHERE = "select * from " + TABLE + " where ";
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public ProductIngredientDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(ProductIngredient a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setLong(1, a.getProduct_id());
            statement.setLong(2, a.getIngredient_id());
            statement.setLong(3, a.getQuantity());
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
    public void delete(ProductIngredient a) {
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
    public void modify(ProductIngredient a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setLong(1, a.getProduct_id());
            statement.setLong(2, a.getIngredient_id());
            statement.setLong(3, a.getQuantity());
            statement.setLong(4, a.getId());
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
    public List<ProductIngredient> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<ProductIngredient> a = new ArrayList<>();
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
    public ProductIngredient selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        ProductIngredient a = null;
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
    public ProductIngredient convert(ResultSet set) throws SQLException {
        Long product_id = set.getLong("product_id");
        Long ingredient_id = set.getLong("ingredient_id");
        Long quantity = set.getLong("quantity");
        String created_at = set.getString("created_at");
        ProductIngredient productIngredient = new ProductIngredient(set.getLong("id"), product_id, ingredient_id, quantity, created_at);
        return productIngredient;
    }

    @Override
    public void deleteWhere(String where) {
         PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(DELETEWHERE+where);
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
    public List<ProductIngredient> selectWhere(String where) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<ProductIngredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETWHERE + where);
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
