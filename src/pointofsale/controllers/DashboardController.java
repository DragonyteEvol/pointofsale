/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
        this.addViewFirstPlane(this.view, panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    //THREADS
    class SetCharts extends Thread {

        private void createPieDaySell() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("ventas", chartController.selectReport(chartController.SELLCHARTDAY).getSubvalue());
            chartController = new ChartController();
            data.setValue("gastos", chartController.selectReport(chartController.EXPENSECHARTDAY).getSubvalue());

            view.pnSellDay.add(createPie(data, "ventas diarias"));
            refreshView(view);
        }

        private void createPieDayMonth() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("ventas", chartController.selectReport(chartController.SELLCHARTMONTH).getSubvalue());
            chartController = new ChartController();
            data.setValue("gastos", chartController.selectReport(chartController.EXPENSEMONTH).getSubvalue());

            view.pnSellMonth.add(createPie(data, "ventas mensuales"));
            refreshView(view);
        }

        private void createPieDayYear() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();
            data.setValue("ventas", chartController.selectReport(chartController.SELLCHARTYEAR).getSubvalue());
            chartController = new ChartController();
            data.setValue("gastos", chartController.selectReport(chartController.EXPENSEYEAR).getSubvalue());

            view.pnSellYear.add(createPie(data, "ventas anuales"));
            refreshView(view);
        }

        private void createPieProducts() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();

            List<Report> reports = chartController.selectReports(chartController.PRODUCTS);

            for (Report report : reports) {
                data.setValue(report.getName(), report.getSubvalue());
            }
            view.pnProducts.add(createPie(data, "productos mas vendidos"));
            refreshView(view);
        }

        private void createPiePeople() {
            DefaultPieDataset data = new DefaultPieDataset();

            ChartController chartController = new ChartController();

            Report report = chartController.selectReport(chartController.PEOPLE);
            data.setValue("personas", report.getSubvalue());

            view.pnPeople.add(createPie(data, "abundancia"));
            refreshView(view);
        }

        private ChartPanel createPie(DefaultPieDataset data, String title) {
            JFreeChart jFreeChart = ChartFactory.createPieChart(title, data, true, true, true);

            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setMouseWheelEnabled(true);
            chartPanel.setPreferredSize(new Dimension(400, 200));

            return chartPanel;
        }

        private ChartPanel createBar(DefaultCategoryDataset data) {

            JFreeChart jFreeChart = ChartFactory.createBarChart("ventas por mesas",
                    "Mesa",
                    "Valor",
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

        private ChartPanel createLine(DefaultCategoryDataset data) {

            JFreeChart jFreeChart = ChartFactory.createWaterfallChart("ventas por mesas",
                    "Mesa",
                    "Valor",
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

        private void createTables() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.TABLES);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "tables", report.getName());
            }

            view.pnTables.add(createBar(data));
            refreshView(view);
        }
        
        private void refreshView(Component view){
            view.repaint();
            view.revalidate();
        }

        private void createUsersSells() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.USERSELL);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "tables", report.getName());
            }
            data.setValue(1000000, "tables", "Pepe suarez");

            view.pnUsers.add(createLine(data));
            refreshView(view);
        }

        private void createRooms() {
            DefaultCategoryDataset data = new DefaultCategoryDataset();

            ChartController sell = new ChartController();
            List<Report> reports = sell.selectReports(sell.ROOMS);
            for (Report report : reports) {
                data.setValue(report.getSubvalue(), "Habitacion", report.getName());
            }

            view.pnRooms.add(createBar(data));
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
