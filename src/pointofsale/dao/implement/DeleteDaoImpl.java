/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import pointofsale.dao.DeleteDao;
import pointofsale.database.SqlConstructor;

/**
 *
 * @author dragonyte
 */
public class DeleteDaoImpl extends SqlConstructor implements DeleteDao {

    private Connection connection;
    private final List<String> tables = Arrays.asList("aditional_information",
            "annulments",
            "atm",
            "balance",
            "bill_restock",
            "bill_restock_ingredient",
            "bills",
            "bills_products",
            "bills_room_products_tmp",
            "bills_room_tmp",
            "bills_table_products_tmp",
            "bills_table_tmp",
            "categories",
            "command_product",
            "commands",
            "events",
            "ingredients",
            "inventory",
            "missing_stock",
            "money_box",
            "movement_inventory",
            "payment_methods",
            "product_ingredient",
            "products",
            "rooms",
            "tables",
            "units",
            "users",
            "users_sells");

    final private String DELETE = "DELETE FROM ";

    public DeleteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void deleteAllTables() {
        PreparedStatement statement = null;
        String sql ="";
        for(String table :tables){
            sql = sql + DELETE + table +";";
        }
        System.out.print(sql);
        try {
            statement = this.connection.prepareStatement(sql);
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

}
