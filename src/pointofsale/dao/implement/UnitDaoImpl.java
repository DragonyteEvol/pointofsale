/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pointofsale.objects.Unit;
import pointofsale.dao.UnitDao;
import pointofsale.database.SqlConstructor;

/**
 *
 * @author dragonyte
 */
public class UnitDaoImpl extends SqlConstructor implements UnitDao {

    // table config
    final String TABLE = "units";
    final List<String> COLUMS = Arrays.asList("name", "prefix");

    // queries
    String INSERT;
    String UPDATE;
    final String DELETE = "delete from " + TABLE + " where id=?";
    final String GETALL = "select * from " + TABLE;
    final String GETONE = "select * from " + TABLE + " where id=?";
    final String GETWHERE = "select * from " + TABLE + " where ";
    final String SEARCH = "select * from " + TABLE + " where name like ";

    private Connection connection;

    public UnitDaoImpl(Connection connection) {
        this.connection = connection;
        this.UPDATE = setUpdate(this.TABLE, this.COLUMS);
        this.INSERT = setInsert(this.TABLE, this.COLUMS);
    }

    // insert row 
    @Override
    public Long insert(Unit a) {
        PreparedStatement statement = null;
        Long rowId = null;
        try {
            statement = this.connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName());
            statement.setString(2, a.getPrefix());
		    Long.valueOf(statement.executeUpdate());
			ResultSet idKey = statement.getGeneratedKeys();
			if(idKey.next()){
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
    public void delete(Unit a) {
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
    public void modify(Unit a) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(UPDATE);
            statement.setString(1, a.getName());
            statement.setString(2, a.getPrefix());
            statement.setLong(3, a.getId());
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
    public List<Unit> selectAll() {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Unit> a = new ArrayList<>();
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
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return a;

    }

    // select row for id
    @Override
    public Unit selectById(Long id) {
        PreparedStatement statement = null;
        ResultSet set = null;
        Unit a = null;
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
    public Unit convert(ResultSet set) throws SQLException {
        String name = set.getString("name");
        String prefix = set.getString("prefix");
        String created_at = set.getString("created_at");
        Unit unit = new Unit(set.getLong("id"), name, prefix, created_at);
        return unit;
    }

    @Override
    public List<Unit> selectWhere(String where) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Unit> a = new ArrayList<>();
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
    public List<Unit> search(String search) {
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Unit> a = new ArrayList<>();
        try {
            statement = this.connection.prepareStatement(SEARCH + "'%" + search +"%'");
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
