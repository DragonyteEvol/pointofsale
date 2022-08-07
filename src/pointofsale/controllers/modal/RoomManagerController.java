/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pointofsale.controllers.ModalController;
import pointofsale.models.PaymentMethodModel;
import pointofsale.models.RoomModel;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Room;
import pointofsale.views.modal.RentRoomView;
import pointofsale.views.modal.RoomManagerView;

/**
 *
 * @author dragonyte
 */
public class RoomManagerController extends ModalController implements ActionListener, ChangeListener {

    private RoomManagerView view;
    private RentRoomView secondView;
    private Room room;

    public RoomManagerController(Room room) {
        initComponents(room);
    }

    private void initComponents(Room room) {
        this.view = new RoomManagerView(null, true);
        this.secondView = new RentRoomView();
        this.room = room;

        Dimension dimension = view.getToolkit().getScreenSize();
        view.setSize(dimension.width / 2, dimension.height / 2);
        secondView.setSize(dimension.width / 2, dimension.height / 2);

        this.view.setResizable(false);

        setResource();
        setSecondResource();
        initEvents();
        this.view.setVisible(true);
    }

    private void initEvents() {
        this.view.btnEnd.addActionListener(this);
        this.view.btnSell.addActionListener(this);

        this.secondView.txtChild.addChangeListener(this);
        this.secondView.txtOld.addChangeListener(this);
        this.secondView.btnPay.addActionListener(this);

    }

    private void setResource() {
        view.txtCapacity.setText(String.valueOf(room.getCapacity()));
        view.txtCategorie.setText(room.getCategorie());
        view.txtNumber.setText(String.valueOf(room.getId()));
        view.txtPrice.setText(String.valueOf(room.getPrice()));
        if (room.isAllocatted()) {
            view.txtState.setText("Ocupado");
            view.btnSell.setText("Vender");
        } else {
            view.txtState.setText("Libre");
            view.btnSell.setText("Rentar");
        }
    }

    private void setSecondResource() {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.secondView.txtDate.setText(timeStamp);
        this.secondView.txtPrice.setText(String.valueOf(room.getPrice()));
    }

    private void changeView(JPanel panel, JPanel view) {
        panel.removeAll();
        panel.add(view);
        panel.revalidate();
        panel.repaint();
    }

    private Integer getPrice() {
        Integer childs = (Integer) this.secondView.txtChild.getValue();
        Integer old = (Integer) this.secondView.txtOld.getValue();
        Integer price = this.room.getPrice() + (childs * 50000) + (old * 80000);
        return price;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSell) {
            if (room.isAllocatted()) {
                SellProductsController sellProductsController = new SellProductsController(room);
            } else {
                changeView(this.view.pnDinamic, this.secondView);
            }
        }

        if (source == this.secondView.btnPay) {
            Integer total = getPrice();
            this.view.dispose();
            OrderPayController orderPayController = new OrderPayController(room, total, true);
        }

        if (source == this.view.btnEnd) {
            DislodgeThread dislodgeThread = new DislodgeThread(room);
            dislodgeThread.start();
            this.view.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        Object source = ce.getSource();
        if (source == this.secondView.txtChild || source == this.secondView.txtOld) {
            this.secondView.txtPrice.setText(String.valueOf(getPrice()));
        }
    }

    class DislodgeThread extends Thread {

        private Room room;

        public DislodgeThread(Room room) {
            this.room = room;
        }

        @Override
        public void run() {
            RoomModel roomModel = new RoomModel();
            roomModel.dislodge(room);
        }
    }
}
