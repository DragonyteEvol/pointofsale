/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.Report;

/**
 *
 * @author dragonyte
 */
public interface ReportDao {
    List<Report> select(String SQL);
    Report selectReport(String SQL);
}
