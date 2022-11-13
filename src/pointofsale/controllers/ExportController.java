/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import pointofsale.ConfigGlobal;
import pointofsale.objects.Report;

/**
 *
 * @author dragonyte
 */
public class ExportController {

    public void createExcel(String[] headers,List<Report> reports,String file_name) throws FileNotFoundException, IOException {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HHmmss").format(Calendar.getInstance().getTime());
        String time  = timeStamp.replace("/","_");
        String route = ConfigGlobal.getConfig().getLogo_path() + "/" + file_name + "_" + time +".csv";
        CSVWriter writer = new CSVWriter(new FileWriter(route));
        writer.writeNext(headers);

        System.out.println();
        reports.forEach(row -> {
            Report d = (Report) row;
            String id = String.valueOf(d.getId());
            String name = d.getName();
            String price = String.valueOf(d.getSubvalue());
            String quantity = String.valueOf(d.getQuantity());
            String created_at = d.getCreated_at();

            String[] line = new String[]{id, name, price,quantity,created_at};
            writer.writeNext(line);
        });

        writer.close();
        System.out.print("exported");
    }
}
