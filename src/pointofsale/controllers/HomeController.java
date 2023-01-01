/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import pointofsale.MissingGlobal;
import pointofsale.UserGlobal;
import pointofsale.controllers.modal.CashDrawerController;
import pointofsale.controllers.modal.LoginController;
import pointofsale.objects.MissingStock;
import pointofsale.views.HomeView;

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
        Dimension dimension = view.getToolkit().getScreenSize();
        Integer width = (dimension.width * 25) /26;
        Integer height = (dimension.height * 25) /26;
        view.setSize(width,height);
        this.view.setLocationRelativeTo(null);

        this.view.btnInventory.addActionListener(this);
        this.view.btnSell.addActionListener(this);
        this.view.btnDashboard.addActionListener(this);
        this.view.btnUser.addActionListener(this);
        this.view.btnAccounting.addActionListener(this);
        this.view.btnEvent.addActionListener(this);
        this.view.btnConfig.addActionListener(this);
        this.view.btnNotifications.addActionListener(this);
        this.view.btnCashDrawerUnlock.addActionListener(this);
        this.view.btnCalculator.addActionListener(this);
        HomeController.notificationButton = view.btnNotifications;
        HomeController.staticView = view;

        this.view.btnUser.setText(UserGlobal.getUser().getName());

        DashboardController dashboardController = new DashboardController(this.view.pnDinamic);

        checkNotifications();
        checkPrivileges();

        this.view.setVisible(true);

    }
    
    private void checkPrivileges(){
        if(UserGlobal.getUser().isWaiter() || !UserGlobal.getUser().isAdmin()){
            this.view.btnAccounting.setVisible(false);
            this.view.btnInventory.setVisible(false);
            this.view.btnEvent.setVisible(false);
            this.view.btnConfig.setVisible(false);
        }
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
            InventoryMenuController menuController = new InventoryMenuController(view.pnDinamic);
            InventoryController inventoryController = new InventoryController(view.pnDinamic);
        }
        if (source == this.view.btnSell) {
            view.pnDinamic.removeAll();
            SellMenuController sellMenuController = new SellMenuController(view.pnDinamic);
            TableController tableController = new TableController(view.pnDinamic);
        }
        if (source == this.view.btnDashboard) {
            view.pnDinamic.removeAll();
            DashboardController dashboardController = new DashboardController(this.view.pnDinamic);
        }

        if (source == this.view.btnAccounting) {
            AccountingMenuController accountingMenuController = new AccountingMenuController(view.pnDinamic);
            ExpenseController expenseController = new ExpenseController(view.pnDinamic);
        }

        if (source == this.view.btnUser) {
            LoginController loginController = new LoginController();
            if (loginController.logged) {
                this.view.dispose();
            }
        }

        if (source == this.view.btnEvent) {
            view.pnDinamic.removeAll();
            EventController eventController = new EventController(this.view.pnDinamic);
        }

        if (source == this.view.btnConfig) {
            view.pnDinamic.removeAll();
            ConfigController configController = new ConfigController(this.view.pnDinamic);
        }

        if (source == this.view.btnNotifications) {
            MissingGlobal.showAllNotifications();
        }
        
        if (source == this.view.btnCashDrawerUnlock) {
            CashDrawerController cashDrawerController = new CashDrawerController();
        }
        if(source == this.view.btnCalculator){
            Conversor conversor = new Conversor();
        }
    }

}
