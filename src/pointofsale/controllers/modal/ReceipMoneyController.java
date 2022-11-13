/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pointofsale.MoneyConverter;
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
        view.txtTotal.setText(MoneyConverter.convertDouble(total));
        initEvents();

        view.setLocationRelativeTo(null);
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
                openCashDrawer();
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

    public void openCashDrawer() {

        byte[] open = {27, 112, 0, 100, (byte) 250};
//      byte[] cutter = {29, 86,49};
        PrintService pservice
                = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = pservice.createPrintJob();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(open, flavor, null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        try {
            job.print(doc, aset);
        } catch (PrintException ex) {
            System.out.println(ex.getMessage());
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
                this.view.txtExchange.setText(MoneyConverter.convertDouble(pay - total));
            }
        }
    }

}
