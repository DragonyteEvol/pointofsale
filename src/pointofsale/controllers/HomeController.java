/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import pointofsale.EventGlobal;
import pointofsale.MissingGlobal;
import pointofsale.UserGlobal;
import pointofsale.controllers.modal.LoginController;
import pointofsale.objects.MissingStock;
import pointofsale.views.HomeView;
import pointofsale.views.layouts.MenuLayout;

/**
 *
 * @author dragonyte
 */
public class HomeController extends Controller implements ActionListener {

    HomeView view;
    static JButton eventButton;
    static JButton notificationButton;
    static HomeView staticView;

    public HomeController() {
        this.view = new HomeView();
        this.view.setResizable(false);
        this.view.setVisible(true);

        this.view.btnInventory.addActionListener(this);
        this.view.btnSell.addActionListener(this);
        this.view.btnDashboard.addActionListener(this);
        this.view.btnUser.addActionListener(this);
        this.view.btnAccounting.addActionListener(this);
        this.view.btnEvent.addActionListener(this);
        this.view.btnCurrentEvent.addActionListener(this);
        this.view.btnConfig.addActionListener(this);
        this.view.btnNotifications.addActionListener(this);
        HomeController.eventButton = view.btnCurrentEvent;
        HomeController.notificationButton = view.btnNotifications;
        HomeController.staticView = view;

        this.view.btnUser.setText(UserGlobal.getUser().getName());
        
        DashboardController dashboardController = new DashboardController(this.view.pnDinamic);

        checkEvent();
        checkNotifications();
    }

    public static void checkEvent() {
        if (EventGlobal.getEvent() == null) {
            eventButton.setVisible(false);
        } else {
            eventButton.setVisible(true);
            eventButton.setText(EventGlobal.getEvent().getName());
        }
        HomeController.staticView.repaint();
        HomeController.staticView.revalidate();
    }

    public static void checkNotifications() {
        List<MissingStock> missingStocks = MissingGlobal.getMissing();
        if (missingStocks != null) {
            notificationButton.setText(String.valueOf(missingStocks.size()));
        }
        HomeController.staticView.repaint();
        HomeController.staticView.revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnInventory) {
            MenuLayout layout = this.setMenuLayout(this.view.pnDinamic);
            InventoryMenuController menuController = new InventoryMenuController(layout.pnPanel, layout.pnWindow);
            InventoryController inventoryController = new InventoryController(layout.pnWindow);
        }
        if (source == this.view.btnSell) {
            MenuLayout layout = this.setMenuLayout(this.view.pnDinamic);
            SellMenuController sellMenuController = new SellMenuController(layout.pnPanel, layout.pnWindow);
            TableController tableController = new TableController(layout.pnWindow);
        }
        if (source == this.view.btnDashboard) {
            DashboardController dashboardController = new DashboardController(this.view.pnDinamic);
        }

        if (source == this.view.btnAccounting) {
            MenuLayout layout = this.setMenuLayout(this.view.pnDinamic);
            AccountingMenuController accountingMenuController = new AccountingMenuController(layout.pnPanel, layout.pnWindow);
            ExpenseController expenseController = new ExpenseController(layout.pnWindow);
        }

        if (source == this.view.btnUser) {
            LoginController loginController = new LoginController();
            if (loginController.logged) {
                this.view.dispose();
            }
        }

        if (source == this.view.btnEvent) {
            EventController eventController = new EventController(this.view.pnDinamic);
        }

        if (source == this.view.btnConfig) {
            ConfigController configController = new ConfigController(this.view.pnDinamic);
        }

        if (source == this.view.btnNotifications) {
            MissingGlobal.showAllNotifications();
        }
    }

}
