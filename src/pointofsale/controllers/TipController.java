/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import pointofsale.MoneyConverter;
import pointofsale.UserGlobal;
import pointofsale.models.ChartController;
import pointofsale.models.InventoryModel;
import pointofsale.models.TipModel;
import pointofsale.objects.Atm;
import pointofsale.objects.MoneyBox;
import pointofsale.objects.Report;
import pointofsale.objects.Tip;
import pointofsale.views.accounting.ReportView;
import pointofsale.views.accounting.TipView;
import pointofsale.views.modal.EditMoney;
import pointofsale.views.modal.WarningUser;

/**
 *
 * @author dragonyte
 */
public class TipController extends Controller implements ActionListener {

    private TipView view;

    public TipController(JPanel panel) {
        this.view = new TipView();


        SetResource setResource = new SetResource();
        setResource.start();

        panel.add(view);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

    }

    private void calculateTotalTip() {
        TipModel tipModel = new TipModel();
        List<Tip> tips = tipModel.selectTipUser();
        Long tip = Long.decode("0"); 
        for (Tip tipp : tips) {
            tip += tipp.getTip();
        }
        view.txtTotal.setText(MoneyConverter.convertDouble(tip));
    }

    private void createMovementLineChart() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        TipModel tipModel = new TipModel();
        List<Tip> tips = tipModel.selectTipUser();
        for (Tip tip : tips) {
            data.setValue(tip.getTip(), "propinas", tip.getUser_name());
        }

        view.pnGraph.add(createLine(data, "Propinas"));
        view.pnGraph.repaint();
        view.pnGraph.revalidate();
    }

    private ChartPanel createLine(DefaultCategoryDataset data, String title) {

        JFreeChart jFreeChart = ChartFactory.createWaterfallChart(title,
                "",
                "Valor",
                data,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);

        jFreeChart.setBackgroundPaint(Color.WHITE);
        jFreeChart.getPlot().setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = jFreeChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(400, 200));

        return chartPanel;
    }

    private void construcTable(List<Tip> tips, JPanel panel) {
        String rowTitle[] = {"Propina", "Mesero"};
        String arrayData[][] = modelTable(tips);

        JTable table = new JTable(arrayData, rowTitle);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        panel.add(scrollPane);
        panel.repaint();
        panel.revalidate();
    }

    private String[][] modelTable(List<Tip> reports) {

        String arrayData[][] = new String[reports.size()][5];

        for (int i = 0; i < reports.size(); i++) {
            arrayData[i][0] = MoneyConverter.convertDouble(reports.get(i).getTip()) + "";
            arrayData[i][1] = reports.get(i).getUser_name() + "";
        }

        return arrayData;
    }

    //THREADS
    class SetResource extends Thread {

        @Override
        public void run() {
            view.pnGraph.removeAll();
            view.pnTable.removeAll();
            TipModel tipModel = new TipModel();
            List<Tip> tips = tipModel.selectAll();
            createMovementLineChart();
            construcTable(tips, view.pnTable);
            tipModel = new TipModel();
            tips = tipModel.selectTipUser();
            construcTable(tips, view.pnTableTip);
            calculateTotalTip();
        }
    }

}
