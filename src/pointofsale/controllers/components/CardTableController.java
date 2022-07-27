/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.Controller;
import pointofsale.controllers.modal.EditTableController;
import pointofsale.controllers.modal.SellProductsController;
import pointofsale.models.BillModel;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Table;
import pointofsale.views.components.CardTableView;

/**
 *
 * @author dragonyte
 */
public class CardTableController extends Controller implements ActionListener {

    private CardTableView view;
    private JPanel panel;
    Table table;

    public CardTableController(JPanel panel, Table table) {
        initComponents(panel, table);
    }

    private void initComponents(JPanel panel,Table table) {
        this.view = new CardTableView();
        this.table = table;
        this.panel = panel;
        setInfo();
        initEvents();
        addComponent(view);
    }

    private void initEvents(){
        this.view.btnSell.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
    }
    
    private void setInfo() {
        this.view.txtNumber.setText(String.valueOf(this.table.getId()));
        BillModel billModel = new BillModel();
        BillTableTmp billTableTmp = billModel.checkBillTableTmp(table.getId());
        if(billTableTmp==null){
            this.view.btnSell.setText("Vender");
            this.view.btnPay.setVisible(false);
        }else{
            this.view.btnSell.setText(String.valueOf(billTableTmp.getTotal()));
            this.view.btnPay.setVisible(true);
        }
    }

    private void addComponent(Component component) {
        this.panel.add(component);
        panel.revalidate();
        panel.repaint();
    }
    
    private void removeComponent(Component component) {
        this.panel.remove(component);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == this.view.btnSell){
            SellProductsController sellProductsController = new SellProductsController(table);
            setInfo();
        }
        
        if(source == this.view.btnEdit){
            EditTableController editTableController = new EditTableController(table);
            setInfo();
            if(editTableController.removed){
                removeComponent(view);
            }
        }
    }
}
