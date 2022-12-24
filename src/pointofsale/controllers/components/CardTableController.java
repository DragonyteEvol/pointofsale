/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;
import pointofsale.MoneyConverter;
import pointofsale.controllers.Controller;
import pointofsale.controllers.modal.EditTableController;
import pointofsale.controllers.modal.OrderPayController;
import pointofsale.controllers.modal.SellProductsController;
import pointofsale.models.BillModel;
import pointofsale.models.EventModel;
import pointofsale.models.TableModel;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Event;
import pointofsale.objects.Table;
import pointofsale.views.components.CardTableView;
import pointofsale.views.modal.ConfirmEventMoney;

/**
 *
 * @author dragonyte
 */
public class CardTableController extends Controller implements ActionListener {

    private CardTableView view;
    private JPanel panel;
    private ConfirmEventMoney secondView;
    Table table;

    public CardTableController(JPanel panel, Table table) {
        initComponents(panel, table);
    }

    private void initComponents(JPanel panel, Table table) {
        this.view = new CardTableView();
        this.secondView = new ConfirmEventMoney(null, true);
        this.table = table;
        this.panel = panel;
        setInfo();
        initEvents();
        addComponent(view);
    }

    private void initEvents() {
        this.view.btnSell.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
        this.view.btnPay.addActionListener(this);
        this.view.btnEvent.addActionListener(this);
        this.secondView.btnSave.addActionListener(this);
    }

    private void setInfo() {
        this.view.txtNumber.setText(String.valueOf(this.table.getId()));
        BillModel billModel = new BillModel();
        BillTableTmp billTableTmp = billModel.checkBillTableTmp(table.getId());
        if (billTableTmp == null) {
            this.view.btnSell.setText("Vender");
            this.view.btnPay.setVisible(false);
        } else {
            this.view.btnSell.setText(MoneyConverter.convertDouble(billTableTmp.getTotal()));
            this.view.btnPay.setVisible(true);
        }
        if (table.getEvent_id() == 0) {
            this.view.btnEvent.setVisible(false);
            System.out.print("INVISIBLE" + table.getEvent_id());
        }else{
            
            this.view.btnEvent.setVisible(true);
            System.out.print("VISIBLE" + table.getEvent_id());
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
        if (source == this.view.btnSell) {
            SellProductsController sellProductsController = new SellProductsController(table);
            setInfo();
        }

        if (source == this.view.btnPay) {
            OrderPayController orderPayController = new OrderPayController(table);
            setInfo();
        }

        if (source == this.view.btnEdit) {
            EditTableController editTableController = new EditTableController(table);
            setInfo();
            if (editTableController.removed) {
                removeComponent(view);
            }
        }
        if (source == this.view.btnEvent) {
            //FALTA AGREGAR PRECIO ANTERIOR
            //secondView.txtPrice.setValue(event.getPrice());
            secondView.setLocationRelativeTo(null);
            secondView.setVisible(true);
            setInfo();
            view.repaint();
            view.revalidate();
        }

        if (source == secondView.btnSave) {
            DisableEvent disableEvent = new DisableEvent();
            disableEvent.start();
            secondView.dispose();
            setInfo();
            view.repaint();
            view.revalidate();
        }

    }

    class DisableEvent extends Thread {

        public void run() {
            String end_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            EventModel eventModel = new EventModel();
            Event event = eventModel.selectById(table.getEvent_id());
            event.setActive(false);
            event.setEnd_date(end_date);
            Integer price = Integer.valueOf(String.valueOf(secondView.txtPrice.getValue()));
            event.setPrice(price);
            eventModel = new EventModel();
            eventModel.update(event);
            TableModel tableModel = new TableModel();
            tableModel.disableEvent(event.getId());
            OrderPayController orderPayController = new OrderPayController(event);
            table.setEvent_id(0);
            setInfo();
            view.repaint();
            view.revalidate();
        }
    }

    /* class SetEvent extends Thread{
        public void run(){
            view.btnEvent.setIcon(null);
            EventModel eventModel = new EventModel();
            Event event = eventModel.selectById(table.getEvent_id());
            String message = event.getName();
            final String html = "<html><body style='width: %1spx'>%1s";
            view.btnEvent.setText(String.format(html, 10, message));
        }
    }*/
}
