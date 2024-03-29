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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pointofsale.MoneyConverter;
import pointofsale.controllers.ModalController;
import pointofsale.models.RoomModel;
import pointofsale.objects.Room;
import pointofsale.views.modal.RentRoomView;
import pointofsale.views.modal.RoomManagerView;
import pointofsale.views.modal.WarningUser;

/**
 *
 * @author dragonyte
 */
public class RoomManagerController extends ModalController implements ActionListener, ChangeListener {

    private RoomManagerView view;
    private RentRoomView secondView;
    private Room room;
    private boolean billActive;

    public RoomManagerController(Room room, boolean billActive) {
        initComponents(room, billActive);
    }

    private void initComponents(Room room, boolean billActive) {
        this.view = new RoomManagerView(null, true);
        this.secondView = new RentRoomView(null, true);
        this.room = room;
        this.billActive = billActive;

        this.view.setLocationRelativeTo(null);
        this.secondView.setLocationRelativeTo(null);

        setResource();
        setSecondResource();
        initEvents();
        this.view.setVisible(true);
    }

    private void initEvents() {
        this.view.btnEnd.addActionListener(this);
        this.view.btnSell.addActionListener(this);
        this.view.btnPay.addActionListener(this);

        this.secondView.txtChild.addChangeListener(this);
        this.secondView.txtOld.addChangeListener(this);
        this.secondView.btnPay.addActionListener(this);

    }

    private void setResource() {
        view.txtCapacity.setText(String.valueOf(room.getCapacity()));
        view.txtCategorie.setText(room.getCategorie());
        view.txtNumber.setText(String.valueOf(room.getId()));
        view.txtPrice.setText(MoneyConverter.convertDouble(room.getPrice()));
        if (room.isAllocatted()) {
            view.txtState.setText("Ocupado");
            view.btnSell.setText("Vender");
            view.btnPay.setVisible(true);
        } else {
            view.txtState.setText("Libre");
            view.btnSell.setText("Rentar");
            view.btnPay.setVisible(false);
        }
    }

    private void setSecondResource() {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.secondView.txtDate.setText(timeStamp);
        this.secondView.txtPrice.setText(MoneyConverter.convertDouble(room.getPrice()));
    }

    private Long getPrice() {
        Integer childs = (int) this.secondView.txtChild.getValue();
        Integer old = (int) this.secondView.txtOld.getValue();
        Long price = this.room.getPrice() + (childs * 50000) + (old * 80000);
        return price;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSell) {
            if (room.isAllocatted()) {
                SellProductsController sellProductsController = new SellProductsController(room);
                this.view.dispose();
            } else {
                this.view.dispose();
                this.secondView.setVisible(true);
            }
        }

        if (source == this.secondView.btnPay) {
            Long total = getPrice();
            this.secondView.dispose();
            OrderPayController orderPayController = new OrderPayController(room, total, true);

        }

        if (source == this.view.btnEnd) {
            System.out.println("DESDE");
            if (billActive) {
                System.out.println(billActive);
                WarningUser warningUser = new WarningUser(null, true);
                warningUser.txtWarning.setText("Debe pagar los productos");
                warningUser.setSize(new Dimension(350,200));
                warningUser.setLocationRelativeTo(null);
                warningUser.setVisible(true);
            } else {
                System.out.println(billActive);

                DislodgeThread dislodgeThread = new DislodgeThread(room);
                dislodgeThread.start();
                this.view.dispose();
            }
            System.out.println("FIN");

        }

        if (source == this.view.btnPay) {
            view.dispose();
            OrderPayController orderPayController = new OrderPayController(room);
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
