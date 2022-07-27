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
import pointofsale.views.modal.ReceipMoneyView;
import pointofsale.views.modal.RentRoomView;
import pointofsale.views.modal.RoomManagerView;

/**
 *
 * @author dragonyte
 */
public class RoomManagerController extends ModalController implements ActionListener, ChangeListener {

    private RoomManagerView view;
    private RentRoomView secondView;
    private ReceipMoneyView thidView;
    private Room room;

    public RoomManagerController(Room room) {
        initComponents(room);
    }

    private void initComponents(Room room) {
        this.view = new RoomManagerView(null, true);
        this.secondView = new RentRoomView();
        this.thidView = new ReceipMoneyView();
        this.room = room;

        Dimension dimension = view.getToolkit().getScreenSize();
        view.setSize(dimension.width / 2, dimension.height / 2);
        secondView.setSize(dimension.width / 2, dimension.height / 2);
        thidView.setSize(dimension.width / 2, dimension.height / 2);

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

        this.thidView.btn1000.addActionListener(this);
        this.thidView.btn2000.addActionListener(this);
        this.thidView.btn5000.addActionListener(this);
        this.thidView.btn10000.addActionListener(this);
        this.thidView.btn20000.addActionListener(this);
        this.thidView.btn50000.addActionListener(this);
        this.thidView.btn100000.addActionListener(this);
        this.thidView.btn200000.addActionListener(this);
        this.thidView.btnSave.addActionListener(this);
        this.thidView.txtPrice.addChangeListener(this);

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
        PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
        List<PaymentMethod> paymentMethods = paymentMethodModel.selectAll();
        for (PaymentMethod paymentMethod : paymentMethods) {
            this.secondView.cbMethodPayment.addItem(paymentMethod);
        }
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.secondView.txtDate.setText(timeStamp);
        this.secondView.txtPrice.setText(String.valueOf(room.getPrice()));
    }

    private void setThirdResource() {
        Double price = getPrice();
        this.thidView.txtTotal.setText(String.valueOf(price));
    }

    private void changeView(JPanel panel, JPanel view) {
        panel.removeAll();
        panel.add(view);
        panel.revalidate();
        panel.repaint();
    }

    private Double getPrice() {
        Integer childs = (Integer) this.secondView.txtChild.getValue();
        Integer old = (Integer) this.secondView.txtOld.getValue();
        Double price = this.room.getPrice() + (childs * 50000) + (old * 80000);
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
            PaymentMethod paymentMethod = (PaymentMethod) this.secondView.cbMethodPayment.getSelectedItem();
            if (paymentMethod.isVirtual()) {
                Double total = getPrice();
                AllocattedTread allocattedTread = new AllocattedTread(room, paymentMethod, total);
                allocattedTread.start();
                this.view.dispose();
            } else {
                changeView(this.view.pnDinamic, thidView);
                setThirdResource();
            }
        }

        if (source == this.thidView.btn1000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 1000);
        }

        if (source == this.thidView.btn2000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 2000);
        }

        if (source == this.thidView.btn5000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 5000);
        }

        if (source == this.thidView.btn10000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 10000);
        }

        if (source == this.thidView.btn20000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 20000);
        }

        if (source == this.thidView.btn50000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 50000);
        }

        if (source == this.thidView.btn100000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 100000);
        }

        if (source == this.thidView.btn200000) {
            Double price = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            this.thidView.txtPrice.setValue(price + 200000);
        }

        if (source == this.thidView.btnSave) {
            Double pay = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            PaymentMethod paymentMethod = (PaymentMethod) this.secondView.cbMethodPayment.getSelectedItem();
            Double total = getPrice();
            if (total <= pay) {
                AllocattedTread allocattedTread = new AllocattedTread(room, paymentMethod, total, pay);
                allocattedTread.start();
            }
            this.view.dispose();
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
        if (source == this.thidView.txtPrice) {
            Double pay = Double.parseDouble(this.thidView.txtPrice.getValue().toString());
            if (getPrice() >= pay) {
                this.thidView.txtExchange.setText("0");
            } else {
                this.thidView.txtExchange.setText(String.valueOf(pay - getPrice()));
            }
        }
    }

    class AllocattedTread extends Thread {

        private Room room;
        private PaymentMethod paymentMethod;
        private Double total, receibed;

        public AllocattedTread(Room room, PaymentMethod PaymentMethod, Double total, Double receibed) {
            this.room = room;
            this.paymentMethod = PaymentMethod;
            this.total = total;
            this.receibed = receibed;
        }

        public AllocattedTread(Room room, PaymentMethod paymentMethod, Double total) {
            this.room = room;
            this.paymentMethod = paymentMethod;
            this.total = total;
        }

        @Override
        public void run() {
            RoomModel roomModel = new RoomModel();
            if (receibed == null) {
                roomModel.allocateRoom(room, paymentMethod, total);
            } else {
                roomModel.allocateRoom(room, paymentMethod, total, receibed);
            }
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
