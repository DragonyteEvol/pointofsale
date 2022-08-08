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
import pointofsale.dao.BillRoomTmpDao;
import pointofsale.database.SqlConstructor;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.Product;

/**
 *
 * @author dragonyte
 */
public class BillRoomTmpDaoImpl extends SqlConstructor implements BillRoomTmpDao {

    // table config
    final String TABLE = "bills_room_tmp";
    final List<String> COLUMS = Arrays.asList("room_id", "total");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWHEREROOMID = "select * from " + TABLE + " where room_id=?";
     final String GETPRODUCTS = "SELECT products.id,quantity,name,subvalue,bills_room_products_tmp.created_at as updated_at from bills_room_tmp inner join bills_room_products_tmp on bills_room_products_tmp.bill_tmp_id = bills_room_tmp.id inner join products on products.id = bills_room_products_tmp.product_id where bills_room_tmp.room_id=?";


    private Connection connection;

    public BillRoomTmpDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Integer insert(BillRoomTmp a) {
        PreparedStatement statement = null;
        Integer rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, a.getRoom_id());
            statement.setInt(2, a.getTotal());
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
    public void delete(BillRoomTmp a) {
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
    public void modify(BillRoomTmp a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setInt(1, a.getRoom_id());
            statement.setInt(2, a.getTotal());
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
    public List<BillRoomTmp> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<BillRoomTmp> a = new ArrayList<>();
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
    public BillRoomTmp selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillRoomTmp a = null;
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
    public BillRoomTmp convert(ResultSet set) throws SQLException {
        Integer room_id = set.getInt("room_id");
        Integer total = set.getInt("total");
        String created_at = set.getString("created_at");
        BillRoomTmp billRoom = new BillRoomTmp(set.getInt("id"), room_id, total, created_at);
        return billRoom;
    }

    @Override
    public BillRoomTmp selectByRoomId(Integer id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        BillRoomTmp a = null;
        try {
            statement = this.connection.prepareStatement(GETWHEREROOMID);
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
    public List<Product> selectProducts(Integer id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Product> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(GETPRODUCTS);
            statement.setInt(1, id);
            set = statement.executeQuery();
            while (set.next()) {
                a.add(convertProduct(set));
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
    public Product convertProduct(ResultSet set) throws SQLException {
        Integer id = set.getInt("id");
        String name = set.getString("name");
        Integer quantity = set.getInt("quantity");
        Integer subvalue = set.getInt("subvalue");
        String created_at = set.getString("updated_at");
        Product product = new Product();
        product.setId(id);
        product.setCreated_at(created_at);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(subvalue);
        return product;
    }

}
