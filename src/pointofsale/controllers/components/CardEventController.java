/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;
import pointofsale.EventGlobal;
import pointofsale.MoneyConverter;
import pointofsale.controllers.HomeController;
import pointofsale.controllers.modal.EditEventController;
import pointofsale.controllers.modal.OrderPayController;
import pointofsale.models.BillModel;
import pointofsale.models.EventModel;
import pointofsale.objects.Bill;
import pointofsale.objects.Event;
import pointofsale.views.components.CardEventView;
import pointofsale.views.modal.ConfirmEventMoney;

/**
 *
 * @author dragonyte
 */
public class CardEventController implements ActionListener {

    private CardEventView view;
    private ConfirmEventMoney secondView;
    private JPanel panel;
    private Event event;

    public CardEventController(Event event, JPanel panel) {
        this.view = new CardEventView();
        this.secondView = new ConfirmEventMoney(null, true);
        this.event = event;
        this.panel = panel;
        
        initEvents();

        SetInfo setInfo = new SetInfo();
        setInfo.start();

        panel.add(view);
        panel.repaint();
        panel.revalidate();
    }

    private void initEvents() {
        view.btnEdit.addActionListener(this);
        view.btnEnd.addActionListener(this);
        secondView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnEdit) {
            EditEventController editEventController = new EditEventController(event);
            SetInfo setInfo = new SetInfo();
            setInfo.start();
        }

        if (source == view.btnEnd) {
            secondView.txtPrice.setValue(event.getPrice());
            secondView.setLocationRelativeTo(null);
            secondView.setVisible(true);
        }
        
        if(source == secondView.btnSave){
            EventModel eventModel = new EventModel();
            String end_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

            event.setActive(false);
            event.setEnd_date(end_date);
            Integer price = Integer.parseInt(String.valueOf(secondView.txtPrice.getValue()));
            event.setPrice(price);
            eventModel.update(event);
            
            EventGlobal.setEvent(EventGlobal.getEventActive());
            secondView.dispose();
            
            OrderPayController orderPayController = new OrderPayController(event);
            
            SetInfo setInfo = new SetInfo();
            setInfo.start();
            HomeController.checkEvent();
        }
        
    }

    class SetInfo extends Thread {

        private void setInfo() {
            view.txtName.setText(String.valueOf(event.getName()));
            view.txtPrice.setText(MoneyConverter.convertDouble(event.getPrice()));
            view.txtDescription.setText((event.getDescription()));
            view.txtDescription.setPreferredSize(new Dimension(150,20));
            setCollect();
            setDate();
        }

        private void setCollect() {
            BillModel billModel = new BillModel();
            Bill bill = billModel.selectCollectEvent(event);
            Integer value = 0;
            if (null != bill) {
                value = bill.getTotal_real() + event.getPrice();
            }
            view.txtCollect.setText(MoneyConverter.convertDouble(value));
        }

        private void setDate() {
            if (event.isActive()) {
                view.txtDate.setText(String.valueOf(event.getCreated_at()));
            } else {
                view.btnEnd.setVisible(false);
                view.txtDate.setText(event.getStart_date() + " - " + event.getEnd_date());
            }
        }

        @Override
        public void run() {
            setInfo();
        }
    }
    
}
