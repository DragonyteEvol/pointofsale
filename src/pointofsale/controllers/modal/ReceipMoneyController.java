/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pointofsale.models.RoomModel;
import pointofsale.views.modal.ReceipMoneyView;

/**
 *
 * @author dragonyte
 */
public class ReceipMoneyController implements ActionListener, ChangeListener {

    private ReceipMoneyView view;
    private Integer total;

    public ReceipMoneyController(Integer total) {
        this.total = total;

        setResource();
    }

    private void setResource() {
        this.view = new ReceipMoneyView(null, true);
        view.txtTotal.setText(String.valueOf(total));
        initEvents();

        view.setResizable(false);
        view.setVisible(true);
    }

    private void initEvents() {
        this.view.btn1000.addActionListener(this);
        this.view.btn2000.addActionListener(this);
        this.view.btn5000.addActionListener(this);
        this.view.btn10000.addActionListener(this);
        this.view.btn20000.addActionListener(this);
        this.view.btn50000.addActionListener(this);
        this.view.btn100000.addActionListener(this);
        this.view.btn200000.addActionListener(this);
        this.view.btnSave.addActionListener(this);
        this.view.txtPrice.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == this.view.btnSave) {
            Integer receibed = Integer.parseInt(String.valueOf(view.txtPrice.getValue()));
            if (total <= receibed) {
                RoomModel roomModel = new RoomModel();
                roomModel.cashRegister(total, receibed);
                view.dispose();
            }
        }

        if (source == this.view.btn1000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 1000);
        }

        if (source == this.view.btn2000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 2000);
        }

        if (source == this.view.btn5000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 5000);
        }

        if (source == this.view.btn10000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 10000);
        }

        if (source == this.view.btn20000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 20000);
        }

        if (source == this.view.btn50000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 50000);
        }

        if (source == this.view.btn100000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 100000);
        }

        if (source == this.view.btn200000) {
            Integer price = Integer.parseInt(this.view.txtPrice.getValue().toString());
            this.view.txtPrice.setValue(price + 200000);
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        Object source = ce.getSource();
        if (source == this.view.txtPrice) {
            Integer pay = Integer.parseInt(this.view.txtPrice.getValue().toString());
            if (total >= pay) {
                this.view.txtExchange.setText("0");
            } else {
                this.view.txtExchange.setText(String.valueOf(pay - total));
            }
        }
    }

}
