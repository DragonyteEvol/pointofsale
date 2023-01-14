/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import pointofsale.ConfigGlobal;
import pointofsale.MoneyConverter;
import pointofsale.UserGlobal;
import pointofsale.controllers.PrintFunctions;
import pointofsale.models.BillModel;
import pointofsale.objects.Bill;
import pointofsale.objects.Product;
import pointofsale.views.components.CardBillView;
import pointofsale.views.components.PrintBill;

/**
 *
 * @author dragonyte
 */
public class CardBillController implements ActionListener {

    private Bill bill;
    private CardBillView view;
    private List<Product> products = new ArrayList<>();
    private JPanel panel;

    public CardBillController(Bill bill, JPanel panel) {
        this.bill = bill;
        this.view = new CardBillView();
        this.panel = panel;

        SetResource setResource = new SetResource();
        setResource.run();

        view.txtPrice.setText(MoneyConverter.convertDouble(bill.getTotal_real()));
        view.btnPrint.addActionListener(this);

        panel.add(view);
        panel.repaint();
        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnPrint) {
            if (source == view.btnPrint) {
                PrintBill printBill = new PrintBill(null, true);
                printBill.txtWorker.setText("Imprimido por: " + UserGlobal.getUser().getName());
                PrintFunctions pf = new PrintFunctions();
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                printBill.txtDate.setText(timeStamp);
                printBill.txtSubtotal.setText(bill.getTotal() + "");
                printBill.txtTotal.setText(bill.getTotal_real() + "");
                printBill.txtCompany.setText(ConfigGlobal.getConfig().getName());
                printBill.txtNit.setText(ConfigGlobal.getConfig().getNit() + "");
                printBill.txtAddress.setText(ConfigGlobal.getConfig().getAddress());
                printBill.txtPhone.setText(ConfigGlobal.getConfig().getPhone() + "");
                printBill.txtBill.setText(ConfigGlobal.getConfig().getName());
                printBill.txtBill.setText("Factura de compra");

                JTable tables = construcTable(products);
                JTableHeader header = tables.getTableHeader();

                printBill.pnFist.add(header, BorderLayout.NORTH);
                printBill.pnFist.add(tables, BorderLayout.CENTER);
                printBill.pnFist.repaint();
                printBill.pnFist.revalidate();

                printBill.setVisible(true);
                pf.print(printBill.pnBase);
            }
        }
    }

    private JTable construcTable(List<Product> products) {
        String rowTitle[] = {"Nombre", "Precio", "Cantidad"};
        String arrayData[][] = modelTable(products);
        DefaultTableModel defaultTableModel = new DefaultTableModel(arrayData, rowTitle);

        JTable inventoryTable = new JTable(defaultTableModel);
        inventoryTable.getColumnModel().getColumn(0).setCellRenderer(new WordWrapCellRenderer());
        return inventoryTable;
    }

    private String[][] modelTable(List<Product> products) {
        String arrayData[][] = new String[products.size()][3];

        for (int i = 0; i < products.size(); i++) {
            arrayData[i][0] = products.get(i).getName() + "";
            arrayData[i][1] = MoneyConverter.convertDouble(products.get(i).getPrice()) + "";
            arrayData[i][2] = products.get(i).getQuantity() + "";
        }

        return arrayData;
    }

    //THREADS
    class SetResource extends Thread {

        public void setProducts() {
            if (bill.isHousing()) {
                String name = "habitacion " + String.valueOf(bill.getClient_id());
                Long price = (bill.getTotal_real());
                GridLayout gridLayout = new GridLayout(1, 3);
                view.pnBill.setLayout(gridLayout);
                view.pnBill.add(new JLabel(name));
                view.pnBill.add(new JLabel(MoneyConverter.convertDouble(price)));
                view.pnBill.add(new JLabel(MoneyConverter.convertDouble(price)));
                products.add(new Product(null, name, price, Long.valueOf(0), "", Long.valueOf(1), null));
            } else {
                BillModel billModel = new BillModel();
                products = billModel.selectProductsByBill(bill);
                GridLayout gridLayout = new GridLayout(products.size(), 3);
                view.pnBill.setLayout(gridLayout);

                for (Product product : products) {
                    String name = product.getName();
                    Long price = (product.getPrice());
                    String quantity = String.valueOf(product.getQuantity());
                    view.pnBill.add(new JLabel(name));
                    view.pnBill.add(new JLabel(MoneyConverter.convertDouble(price)));
                    view.pnBill.add(new JLabel(quantity));
                }
            }
        }

        @Override
        public void run() {
            setProducts();
        }
    }

}
