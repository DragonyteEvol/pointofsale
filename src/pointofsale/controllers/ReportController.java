/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import pointofsale.UserGlobal;
import pointofsale.controllers.components.CardBillController;
import pointofsale.models.BillModel;
import pointofsale.models.InventoryModel;
import pointofsale.objects.Atm;
import pointofsale.objects.Bill;
import pointofsale.objects.MoneyBox;
import pointofsale.views.accounting.DefaultAccountingView;
import pointofsale.views.accounting.ExpenseView;
import pointofsale.views.accounting.ReportView;
import pointofsale.views.modal.EditMoney;
import pointofsale.views.modal.WarningUser;

/**
 *
 * @author dragonyte
 */
public class ReportController extends Controller implements ActionListener {

    private ReportView view;
    private List<MoneyBox> moneyBoxs;
    private Atm atm;
    private EditMoney editMoney;

    public ReportController(JPanel panel) {
        this.view = new ReportView();
        this.editMoney = new EditMoney(null, true);
        editMoney.setResizable(false);
        
        view.btnEdit.addActionListener(this);
        editMoney.btnSave.addActionListener(this);

        SetResource setResource = new SetResource();
        setResource.start();

        this.addView(this.view, panel);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == view.btnEdit){
            editMoney.txtValue.setText(atm.getValue()+"");
            editMoney.setVisible(true);
        }
        
        if(source == editMoney.btnSave){
            if(UserGlobal.getUser().isAdmin()){
                ModifyBox m = new ModifyBox();
                m.start();
                editMoney.dispose();
                SetResource s = new SetResource();
                s.start();
            }else{
                WarningUser u = new WarningUser(null, true);
                u.setResizable(false);
                u.setVisible(true);
            }
        }
    }

    private ChartPanel createLineBar(DefaultCategoryDataset data) {

        JFreeChart jFreeChart = ChartFactory.createLineChart("movimiento en caja",
                "salida - entrada",
                "valor",
                data,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(400, 200));

        return chartPanel;
    }

    private void createMovementLineChart() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        InventoryModel inventoryModel = new InventoryModel();
        moneyBoxs = inventoryModel.selectMovementBox();
        for (MoneyBox moneyBox : moneyBoxs) {
            data.setValue(moneyBox.getEntry(), "entrada", moneyBox.getCreated_at());
            data.setValue(moneyBox.getOut(), "salida", moneyBox.getCreated_at());
        }

        view.pnGraph.add(createLineBar(data));
        view.pnGraph.repaint();
        view.pnGraph.revalidate();
    }

    private void construcTable(List<MoneyBox> moneyBoxs) {
        String rowTitle[] = {"id", "entrada", "salida", "requerido", "fecha"};
        String arrayData[][] = modelTable(moneyBoxs);

        JTable table = new JTable(arrayData, rowTitle);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        view.pnTable.add(scrollPane);
        view.pnTable.repaint();
        view.pnTable.revalidate();
    }

    private String[][] modelTable(List<MoneyBox> reports) {

        String arrayData[][] = new String[reports.size()][5];

        for (int i = 0; i < reports.size(); i++) {
            arrayData[i][0] = reports.get(i).getId() + "";
            arrayData[i][1] = reports.get(i).getEntry()+ "";
            arrayData[i][2] = reports.get(i).getOut()+ "";
            arrayData[i][3] = reports.get(i).getRequired()+ "";
            arrayData[i][4] = reports.get(i).getCreated_at() + "";
        }

        return arrayData;
    }

    //THREADS
    class SetResource extends Thread {

        @Override
        public void run() {
            view.pnGraph.removeAll();
            view.pnTable.removeAll();
            InventoryModel inventoryModel = new InventoryModel();
            atm = inventoryModel.selectAtm();
            view.txtTotal.setText(atm.getValue() + "");
            createMovementLineChart();
            construcTable(moneyBoxs);
        }
    }
    
    class ModifyBox extends Thread{
        @Override
        public void run(){
            InventoryModel i = new InventoryModel();
            i.updateAtm(atm);
        }
    }
}
