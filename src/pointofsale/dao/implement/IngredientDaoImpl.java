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
import pointofsale.dao.IngredientDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Ingredient;

/**
 *
 * @author dragonyte
 */
public class IngredientDaoImpl extends SqlConstructor implements IngredientDao {

    // table config
    final String TABLE = "ingredients";
    final List<String> COLUMS = Arrays.asList("name", "price", "unit_id", "categorie_id", "route_image","amenitie");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select ingredients.*,units.name as unit from " + TABLE +" inner join units on unit_id = units.id";
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWHERE = "select * from " + TABLE + " where ";
    final String GETUNIT = "SELECT ingredients.*,units.name as unit from ingredients INNER join units on ingredients.unit_id = units.id";
    final String GETRELPRODUCT = "SELECT ingredients.*,units.name as unit,product_ingredient.quantity as quantity from ingredients INNER join units on ingredients.unit_id = units.id INNER JOIN product_ingredient on product_ingredient.ingredient_id = ingredients.id";
    final String GETUNITQUANTITY = "SELECT ingredients.*,inventory.quantity,units.name as unit from ingredients INNER join inventory on ingredients.id=inventory.ingredient_id INNER join units On units.id = ingredients.unit_id";
    final String SEARCH = "SELECT ingredients.*,inventory.quantity,units.name as unit from " + TABLE + " INNER join inventory on ingredients.id=inventory.ingredient_id INNER join units On units.id = ingredients.unit_id where ingredients.name like ";
    final String GETMISSING = "select inventory.created_at as created_at,inventory.quantity,inventory.minimum,ingredients.*,units.name as unit from inventory INNER join ingredients on ingredients.id = inventory.ingredient_id INNER join units on units.id = ingredients.unit_id where quantity <= minimum and ingredient_id not in(SELECT ingredient_id from missing_stock)";
    final String GETAMENITIES = "select ingredients.*,categories.name as categorie, units.name as unit from "+ TABLE +" inner join units on units.id=ingredients.unit_id INNER join categories on categories.id = ingredients.categorie_id where amenitie=1";
    private Connection connection;

    public IngredientDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(Ingredient a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName());
            statement.setLong(2, a.getPrice());
            statement.setLong(3, a.getUnit_id());
            statement.setLong(4, a.getCategorie_id());
            statement.setString(5, a.getRoute_image());
            statement.setBoolean(6, a.isAmenitie());
            Long.valueOf(statement.executeUpdate());
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
    public void delete(Ingredient a) {
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
    public void modify(Ingredient a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setLong(2, a.getPrice());
            statement.setLong(3, a.getUnit_id());
            statement.setLong(4, a.getCategorie_id());
            statement.setString(5, a.getRoute_image());
            statement.setBoolean(6, a.isAmenitie());
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
    public List<Ingredient> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
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
    public Ingredient selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Ingredient a = null;
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
    public Ingredient convertIngredientUnit(ResultSet set, boolean quantity) throws SQLException {
        String unit = set.getString("unit");
        Ingredient ingredient = convert(set);
        ingredient.setUnit(unit);
        if (quantity) {
            Long quantitys = set.getLong("quantity");
            ingredient.setQuantity(quantitys);
        }
        return ingredient;
    }

    public Ingredient convert(ResultSet set) throws SQLException {
        String name = set.getString("name");
        Long price = set.getLong("price");
        Long unit_id = set.getLong("unit_id");
        Long categorie_id = set.getLong("categorie_id");
        String route_image = set.getString("route_image");
        String created_at = set.getString("created_at");
        boolean amenitie = set.getBoolean("amenitie");
        Ingredient ingredient = new Ingredient(set.getLong("id"), name, price, unit_id, categorie_id, route_image, created_at);
        if(set.getString("unit")!=null){
            ingredient.setUnit(set.getString("unit"));
        }
        return ingredient;
    }

    @Override
    public List<Ingredient> selectWhere(String where) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
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

    @Override
    public List<Ingredient> selectWhitUnit(String where) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            if (where.isBlank() || where.isEmpty()) {
                statement = this.connection.prepareStatement(GETUNIT);
            } else {
                statement = this.connection.prepareStatement(GETUNIT + " where " + where);
            }
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertIngredientUnit(set, false));
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
    public List<Ingredient> selectRelProduct(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETRELPRODUCT + " where product_ingredient.product_id=?");
            statement.setLong(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertIngredientUnit(set, true));
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
    public List<Ingredient> selectUnitQuantity() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETUNITQUANTITY);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertIngredientUnit(set, true));
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
    public List<Ingredient> search(String search) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(SEARCH + "'%" + search + "%'");
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertIngredientUnit(set, true));
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
    public List<Ingredient> selectMissing() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETMISSING);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertIngredientUnit(set,true));
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
    public List<Ingredient> selectAmenities() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Ingredient> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETAMENITIES);
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
