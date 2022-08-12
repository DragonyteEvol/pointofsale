/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import com.opencsv.CSVWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Report;

/**
 *
 * @author dragonyte
 */
public class ExportController {

    public void createExcel(String[] headers,List<Report> reports) throws FileNotFoundException, IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("data.csv"));
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
