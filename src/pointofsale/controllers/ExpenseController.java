/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import pointofsale.MoneyConverter;
import pointofsale.models.ReportModel;
import pointofsale.objects.Report;
import pointofsale.views.accounting.DefaultAccountingView;

/**
 *
 * @author dragonyte
 */
public class ExpenseController extends Controller implements ActionListener {

    private DefaultAccountingView view;
    private JTable table;
    private List<Report> reports;

    public ExpenseController(JPanel panel) {
        this.view = new DefaultAccountingView();
        ReportModel reportModel = new ReportModel();
        reports = reportModel.select(reportModel.EXPENSEUNIQUE);
        construcTable(reports);

        view.cbTime.addActionListener(this);
        view.btnExport.addActionListener(this);

        panel.add(view);
    }

    private void construcTable(List<Report> reports) {
        String rowTitle[] = {"Id", "Nombre", "Perdidas", "Cantidad", "Fecha"};
        String arrayData[][] = modelTable(reports);

        table = new JTable(arrayData, rowTitle);
        view.scrollPane.setViewportView(table);
    }

    private String[][] modelTable(List<Report> reports) {

        String arrayData[][] = new String[reports.size()][5];

        for (int i = 0; i < reports.size(); i++) {
            arrayData[i][0] = Long.toString(reports.get(i).getId()) + "";
            arrayData[i][1] = reports.get(i).getName() + "";
            arrayData[i][2] = MoneyConverter.convertDouble(reports.get(i).getSubvalue()) + "";
            arrayData[i][3] = Long.toString(reports.get(i).getQuantity()) + "";
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
                reports = reportModel.select(reportModel.EXPENSEYEAR);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("AGRUPADO")) {
                ReportModel reportModel = new ReportModel();
                reports = reportModel.select(reportModel.EXPENSEINGREDIENT);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("MES")) {
                ReportModel reportModel = new ReportModel();
                reports = reportModel.select(reportModel.EXPENSEMONTH);
                construcTable(reports);
            }
            
            if (view.cbTime.getSelectedItem().equals("ESPECIFICO")) {
                ReportModel reportModel = new ReportModel();
                reports = reportModel.select(reportModel.EXPENSEUNIQUE);
                construcTable(reports);
            }
            if (view.cbTime.getSelectedItem().equals("DIA")) {
                ReportModel reportModel = new ReportModel();
                reports = reportModel.select(reportModel.EXPENSEDAY);
                construcTable(reports);
            }
        }
        
        if(source == view.btnExport){
            ExportController ec = new ExportController();
            try {
                String[] headers = new String[]{"id","nombre","perdidas","cantidad","fecha"};
                ec.createExcel(headers,reports,"gastos");
            } catch (IOException ex) {
                Logger.getLogger(ExpenseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
