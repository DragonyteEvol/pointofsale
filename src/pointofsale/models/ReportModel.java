/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Report;

/**
 *
 * @author dragonyte
 */
public class ReportModel extends Model{
    
    //TIPO DE REPORTE // AGRUPACION //PERIODO
    public String EXPENSEUNIQUE = "SELECT bill_restock_ingredient.id as id, ingredients.name as name, bill_restock_ingredient.quantity as quantity, bill_restock_ingredient.subvalue as subvalue, bill_restock_ingredient.created_at as updated_at from bill_restock_ingredient inner join ingredients on ingredients.id = bill_restock_ingredient.ingredient_id";
    public String EXPENSEMONTH = "SELECT bill_restock_ingredient.id as id, ingredients.name as name, sum(bill_restock_ingredient.quantity) as quantity, sum(bill_restock_ingredient.subvalue) as subvalue, strftime(\"%Y-%m\", bill_restock_ingredient.created_at) as updated_at from bill_restock_ingredient inner join ingredients on ingredients.id = bill_restock_ingredient.ingredient_id GROUP by updated_at,name";
    public String EXPENSEYEAR = "SELECT bill_restock_ingredient.id as id, ingredients.name as name, sum(bill_restock_ingredient.quantity) as quantity, sum(bill_restock_ingredient.subvalue) as subvalue, strftime(\"%Y\", bill_restock_ingredient.created_at) as updated_at from bill_restock_ingredient inner join ingredients on ingredients.id = bill_restock_ingredient.ingredient_id GROUP by updated_at,name";
    public String EXPENSEINGREDIENT = "SELECT bill_restock_ingredient.id as id, ingredients.name as name, sum(quantity) as quantity, sum(subvalue) as subvalue, bill_restock_ingredient.created_at as updated_at from bill_restock_ingredient inner join ingredients on ingredients.id = bill_restock_ingredient.ingredient_id group by bill_restock_ingredient.ingredient_id";
    
    public String SELLYEAR = "SELECT bills_products.id as id, products.name as name,sum(bills_products.quantity) as quantity, sum(bills_products.subvalue) as subvalue, strftime(\"%Y\", bills_products.created_at) as updated_at from bills_products inner join products on products.id = bills_products.product_id GROUP by updated_at,name";
    public String SELLMONTH = "SELECT bills_products.id as id, products.name as name,sum(bills_products.quantity) as quantity, sum(bills_products.subvalue) as subvalue, strftime(\"%Y-%m\", bills_products.created_at) as updated_at from bills_products inner join products on products.id = bills_products.product_id GROUP by updated_at,name";
    public String SELLUNIQUE = "SELECT bills_products.id as id, products.name as name,bills_products.quantity as quantity, bills_products.subvalue as subvalue,bills_products.created_at as updated_at from bills_products inner join products on products.id = bills_products.product_id";
    public String SELLPRODUCT = "SELECT bills_products.id as id, products.name as name,sum(bills_products.quantity) as quantity, sum(bills_products.subvalue) as subvalue,bills_products.created_at as updated_at from bills_products inner join products on products.id = bills_products.product_id GROUP BY products.id;";
    
   
    public List<Report> select(String sql){
        List<Report> reports = this.dao.getReportDao().select(sql);
        this.closeConnection();
        return reports;
    }
}
