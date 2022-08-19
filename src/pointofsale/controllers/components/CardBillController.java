/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pointofsale.MoneyConverter;
import pointofsale.models.BillModel;
import pointofsale.objects.Bill;
import pointofsale.objects.Product;
import pointofsale.views.components.CardBillView;

/**
 *
 * @author dragonyte
 */
public class CardBillController implements ActionListener {

    private Bill bill;
    private CardBillView view;
    private JPanel panel;

    public CardBillController(Bill bill, JPanel panel) {
        this.bill = bill;
        this.view = new CardBillView();
        this.panel = panel;

        SetResource setResource = new SetResource();
        setResource.run();

        view.txtPrice.setText(MoneyConverter.convertDouble(bill.getTotal_real()));

        panel.add(view);
        panel.repaint();
        panel.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    //THREADS
    class SetResource extends Thread {

        public void setProducts() {
            if (bill.isHousing()) {
                String name = "habitacion " + String.valueOf(bill.getClient_id());
                Integer price = (bill.getTotal_real());
                GridLayout gridLayout = new GridLayout(1, 3);
                view.pnBill.setLayout(gridLayout);
                view.pnBill.add(new JLabel(name));
                view.pnBill.add(new JLabel(MoneyConverter.convertDouble(price)));
                view.pnBill.add(new JLabel(MoneyConverter.convertDouble(price)));
            } else {
                BillModel billModel = new BillModel();
                List<Product> products = billModel.selectProductsByBill(bill);
                GridLayout gridLayout = new GridLayout(products.size(), 3);
                view.pnBill.setLayout(gridLayout);

                for (Product product : products) {
                    String name = product.getName();
                    Integer price = (product.getPrice());
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
