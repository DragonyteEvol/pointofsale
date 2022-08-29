/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import pointofsale.models.ChartController;
import pointofsale.objects.Report;
import pointofsale.views.dashboard.DashboardView;

/**
 *
 * @author dragonyte
 */
public class DashboardController extends Controller implements ActionListener {

    private DashboardView view;

    public DashboardController(JPanel panel) {
        this.view = new DashboardView();
        SetCharts setCharts = new SetCharts();
        setCharts.start();
        panel.removeAll();
        panel.add(view, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    //THREADS
    class SetCharts extends Thread {

        private void createPieDaySell() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("Ventas", chartController.selectReport(chartController.SELLCHARTDAY).getSubvalue());
            chartController = new ChartController();
            data.setValue("Gastos", chartController.selectReport(chartController.EXPENSECHARTDAY).getSubvalue());

            view.pnSellDay.add(createPie(data, "Ventas Diarias"));
            refreshView(view);
        }

        private void createPieDayMonth() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("Ventas", chartController.selectReport(chartController.SELLCHARTMONTH).getSubvalue());
            chartController = new ChartController();
            data.setValue("Gastos", chartController.selectReport(chartController.EXPENSEMONTH).getSubvalue());

            view.pnSellMonth.add(createPie(data, "Ventas Mensuales"));
            refreshView(view);
        }

        private void createPieDayYear() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("Ventas", chartController.selectReport(chartController.SELLCHARTYEAR).getSubvalue());
            chartController = new ChartController();
            data.setValue("Gastos", chartController.selectReport(chartController.EXPENSEYEAR).getSubvalue());

            view.pnSellYear.add(createPie(data, "Ventas Anuales"));
            refreshView(view);
        }

        private void createPieProducts() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();

            List<Report> reports = chartController.selectReports(chartController.PRODUCTS);

            for (Report report : reports) {
                data.setValue(report.getName(), report.getSubvalue());
            }
            view.pnProducts.add(createPie(data, "Productos Mas Vendidos"));
            refreshView(view);
        }

        private void createPiePeople() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();

            Report report = chartController.selectReport(chartController.PEOPLE);
            data.setValue("Personas", report.getSubvalue());

            view.pnPeople.add(createPie(data, "Abundancia"));
            refreshView(view);
        }

        private ChartPanel createPie(DefaultPieDataset data, String title) {
            JFreeChart jFreeChart = ChartFactory.createPieChart(title, data, true, true, true);
            jFreeChart.setBackgroundPaint(Color.WHITE);
            jFreeChart.getPlot().setBackgroundPaint(Color.WHITE);

            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setPreferredSize(new Dimension(400, 200));
            return chartPanel;
        }

        private ChartPanel createBar(DefaultCategoryDataset data,String title) {

            JFreeChart jFreeChart = ChartFactory.createBarChart3D(title,
                    "",
                    "Valor",
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    true);
            jFreeChart.setBackgroundPaint(Color.WHITE);
            jFreeChart.getPlot().setBackgroundPaint(Color.WHITE);
            CategoryPlot plot = jFreeChart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.WHITE);
            plot.setRangeGridlinePaint(Color.WHITE);
            //plot.setOutlineVisible(true);
            //plot.setShadowGenerator(null);
            
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setPreferredSize(new Dimension(400, 200));

            return chartPanel;
        }

        private ChartPanel createLine(DefaultCategoryDataset data,String title) {

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

        private void createTables() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.TABLES);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "Mesas", report.getName());
            }

            view.pnTables.add(createBar(data,"Ventas Por Mesa"));
            refreshView(view);
        }

        private void refreshView(Component view) {
            view.repaint();
            view.revalidate();
        }

        private void createUsersSells() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.USERSELL);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "Ventas", report.getName());
            }
            data.setValue(1000000, "Ventas", "Pepe Suarez");

            view.pnUsers.add(createLine(data,"Rendimiento De Usuarios"));
            refreshView(view);
        }

        private void createRooms() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.ROOMS);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "Habitacion", report.getName());
            }

            view.pnRooms.add(createBar(data,"Ventas Por Habitacion"));
            refreshView(view);
        }

        @Override
        public void run() {
            createPieDaySell();
            createPieDayMonth();
            createPieDayYear();
            createPieProducts();
            createTables();
            createRooms();
            createPiePeople();
            createUsersSells();
        }
    }
}
