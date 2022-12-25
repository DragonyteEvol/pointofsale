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
import pointofsale.dao.AnnulmentDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.Annulment;

/**
 *
 * @author dragonyte
 */
public class AnnulmentDaoImpl extends SqlConstructor implements AnnulmentDao {

    // table config
    final String TABLE = "annulments";
    final List<String> COLUMS = Arrays.asList("reason", "user_id", "product_id", "quantity");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select annulments.*,users.name,products.name as product from "+TABLE+" INNER join users on users.id = annulments.user_id INNER join products on products.id = annulments.product_id";
    final String GETONE = "select * from " + TABLE + " where id=?";

    private Connection connection;

    public AnnulmentDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(Annulment a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT);
            statement.setString(1, a.getReason());
            statement.setLong(2, a.getUser_id());
            statement.setLong(3, a.getProduct_id());
            statement.setLong(4, a.getQuantity());
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
    public void delete(Annulment a) {
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
    public void modify(Annulment a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getReason());
            statement.setLong(2, a.getUser_id());
            statement.setLong(3, a.getProduct_id());
            statement.setLong(4, a.getQuantity());
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
    public List<Annulment> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Annulment> a = new ArrayList<>();
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
    public Annulment selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Annulment a = null;
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
    public Annulment convert(ResultSet set) throws SQLException {
        String reason = set.getString("reason");
        Long user_id = set.getLong("user_id");
        Long product_id = set.getLong("product_id");
        Long quantity = set.getLong("quantity");
        String created_at = set.getString("created_at");
        String name = set.getString("name");
        String product = set.getString("product");
        Annulment annulment = new Annulment(set.getLong("id"), reason, user_id, created_at);
        annulment.setProduct_id(product_id);
        annulment.setQuantity(quantity);
        annulment.setName(name);
        annulment.setProduct(product);
                
        return annulment;
    }
}
