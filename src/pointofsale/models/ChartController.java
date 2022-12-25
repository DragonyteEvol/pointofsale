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
public class ChartController extends Model {

    public String SELLCHARTDAY = "SELECT id,\"chart\" as name,sum(total_real) as subvalue,\"1\" as quantity,strftime(\"%Y-%m-%d\", created_at) as updated_at  from bills GROUP by updated_at order by updated_at desc limit 1";
    public String SELLCHARTMONTH = "SELECT id,\"chart\" as name,sum(total_real) as subvalue,\"1\" as quantity,strftime(\"%Y-%m\", created_at) as updated_at  from bills GROUP by updated_at order by updated_at desc limit 1";
    public String SELLCHARTYEAR = "SELECT id,\"chart\" as name,sum(total_real) as subvalue,\"1\" as quantity,strftime(\"%Y\", created_at) as updated_at  from bills GROUP by updated_at order by updated_at desc limit 1";

    public String EXPENSECHARTDAY = "SELECT id,\"chart\" as name,sum(price) as subvalue,\"1\" as quantity,strftime(\"%Y-%m-%d\", created_at) as updated_at  from bill_restock GROUP by updated_at order by updated_at desc limit 1";
    public String EXPENSEMONTH = "SELECT id,\"chart\" as name,sum(price) as subvalue,\"1\" as quantity,strftime(\"%Y-%m\", created_at) as updated_at  from bill_restock GROUP by updated_at order by updated_at desc limit 1";
    public String EXPENSEYEAR = "SELECT id,\"chart\" as name,sum(price) as subvalue,\"1\" as quantity,strftime(\"%Y\", created_at) as updated_at  from bill_restock GROUP by updated_at order by updated_at desc limit 1";
    
    public String PRODUCTS = "select products.id,sum(quantity) as subvalue,name,1 as quantity, strftime(\"%Y-%m\", bills_products.created_at) as updated_at from bills_products inner join products on products.id = bills_products.product_id GROUP by products.id,updated_at Order by updated_at desc Limit 5";
    
    public String TABLES = "select id,sum(total_real) as subvalue,client_id as name,1 as quantity,strftime(\"%Y-%m\", created_at) as updated_at from bills where client_type=1 group by client_id order by name";
    public String ROOMS = "select id,sum(total_real) as subvalue,client_id as name,1 as quantity,strftime(\"%Y-%m\", created_at) as updated_at from bills where client_type=2 group by client_id order by name";
    public String LASTBILL = "select products.id,quantity,subvalue,name,bills_products.created_at as updated_at from bills_products inner join products on products.id = bills_products.product_id order by bills_products.created_at desc limit 5";
    public String PEOPLE ="Select id,\"people\" as name,1 as quantity,sum(people) as subvalue,strftime(\"%Y-%m\", created_at) as updated_at from bills group by updated_at order by updated_at desc limit 1";
    public String USERSELL = "Select user_id as id,name as name,1 as quantity,sum(total) as subvalue,strftime(\"%Y-%m\", bills.created_at) as updated_at from bills inner join users on users.id = bills.waiter_id where updated_at =  strftime('%Y-%m','now') group by waiter_id,updated_at order by updated_at desc";

    public Report selectReport(String sql) {
        Report report = this.dao.getReportDao().selectReport(sql);
        this.closeConnection();
        return report;
    }
    
    public List<Report> selectReports(String sql){
        List<Report> reports = this.dao.getReportDao().select(sql);
        this.closeConnection();
        return reports;
    }
}
