/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import pointofsale.models.ReportModel;
import pointofsale.objects.Report;
import pointofsale.views.accounting.DefaultAccountingView;

/**
 *
 * @author dragonyte
 */
public class SellController extends Controller implements ActionListener{
    private DefaultAccountingView view;
    private JTable table;

    public SellController(JPanel panel) {
        this.view = new DefaultAccountingView();
        ReportModel reportModel = new ReportModel();
        List<Report> reports = reportModel.select(reportModel.SELLUNIQUE);
        construcTable(reports);

        view.cbTime.addActionListener(this);

        this.addView(this.view, panel);
    }

    private void construcTable(List<Report> reports) {
        String rowTitle[] = {"Id", "Nombre", "Ventas", "Cantidad", "Fecha"};
        String arrayData[][] = modelTable(reports);

        table = new JTable(arrayData, rowTitle);
        view.scrollPane.setViewportView(table);
    }

    private String[][] modelTable(List<Report> reports) {

        String arrayData[][] = new String[reports.size()][5];

        for (int i = 0; i < reports.size(); i++) {
            arrayData[i][0] = reports.get(i).getId() + "";
            arrayData[i][1] = reports.get(i).getName() + "";
            arrayData[i][2] = reports.get(i).getSubvalue() + "";
            arrayData[i][3] = reports.get(i).getQuantity() + "";
            arrayData[i][4] = reports.get(i).getCreated_at() + "";
        }

        return arrayData;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.cbTime) {
            if (view.cbTime.getSelectedItem().equals("AÑO")) {
                ReportModel reportModel = new ReportModel();
                List<Report> reports = reportModel.select(reportModel.SELLYEAR);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("AGRUPADO")) {
                ReportModel reportModel = new ReportModel();
                List<Report> reports = reportModel.select(reportModel.SELLPRODUCT);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("MES")) {
                ReportModel reportModel = new ReportModel();
                List<Report> reports = reportModel.select(reportModel.SELLMONTH);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("ESPECIFICO")) {
                ReportModel reportModel = new ReportModel();
                List<Report> reports = reportModel.select(reportModel.SELLUNIQUE);
                construcTable(reports);
            }
        }
    }
}
