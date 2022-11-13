/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import pointofsale.ConfigGlobal;
import pointofsale.EventGlobal;
import pointofsale.MissingGlobal;
import pointofsale.MoneyConverter;
import pointofsale.UserGlobal;
import pointofsale.controllers.HomeController;
import pointofsale.controllers.PrintFunctions;
import pointofsale.models.AnnulmentModel;
import pointofsale.models.BillModel;
import pointofsale.models.PaymentMethodModel;
import pointofsale.models.RoomModel;
import pointofsale.objects.AditionalInformation;
import pointofsale.objects.Annulment;
import pointofsale.objects.Bill;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Event;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Product;
import pointofsale.objects.Room;
import pointofsale.objects.Table;
import pointofsale.views.components.PrintBill;
import pointofsale.views.modal.ConfirmAnnulmentView;
import pointofsale.views.modal.OrderPayView;

/**
 *
 * @author dragonyte
 */
public final class OrderPayController implements ActionListener, ChangeListener {

    private OrderPayView view;
    private ConfirmAnnulmentView annulmentView;
    private Room room = null;
    private Table table = null;
    private Integer realPrice;
    private Integer discount = 0;
    private Integer tip = 0;
    public Integer price = 0;
    private List<Product> products = new ArrayList<>();
    private BillTableTmp billTableTmp;
    private BillRoomTmp billRoomTmp;
    private boolean allocate = false;
    private Event event = null;
    private JTable tableProducts;

    public OrderPayController(Table table) {
        this.table = table;
        initView();
    }

    public OrderPayController(Room room) {
        this.room = room;
        initView();
    }

    public OrderPayController(Event event) {
        this.event = event;
        initView();
    }

    public OrderPayController(Room room, Integer price, boolean allocate) {
        this.room = room;
        this.allocate = allocate;
        this.realPrice = price;
        initView();
    }

    private void setDefaultTip() {
        AditionalInformation aditionalInformation = ConfigGlobal.getConfig();
        if (aditionalInformation != null) {
            view.txtTipPercent.setValue(aditionalInformation.getDefault_tip());
        }
    }

    public void initView() {
        this.view = new OrderPayView(null, true);
        this.annulmentView = new ConfirmAnnulmentView(null, true);

        annulmentView.setLocationRelativeTo(null);
        view.setLocationRelativeTo(null);

        SetResourceThread setResourceThread = new SetResourceThread();
        setResourceThread.start();
        if (allocate) {
            view.txtPrice.setText(MoneyConverter.convertDouble(realPrice));

            String arrayData[][] = new String[1][5];
            arrayData[0][0] = room.getId() + "";
            arrayData[0][1] = room.getDescription() + "";
            arrayData[0][2] = MoneyConverter.convertDouble(realPrice) + "";
            arrayData[0][3] = room.getCapacity() + "";
            
            products.add(new Product(null, room.getDescription(),realPrice,0, "", realPrice, null));

            String rowTitle[] = {"Habitacion no", "Descripcion", "Precio", "Capacidad"};

            tableProducts = new JTable(arrayData, rowTitle);
            view.pnScroll.setViewportView(tableProducts);
            updatePrice();
        }

        if (event != null) {
            realPrice = event.getPrice();
            System.out.print(realPrice);
            view.txtPrice.setText(MoneyConverter.convertDouble(realPrice));

            String arrayData[][] = new String[1][5];
            arrayData[0][0] = event.getId() + "";
            arrayData[0][1] = event.getDescription() + "";
            arrayData[0][2] = event.getPrice() + "";
            arrayData[0][3] = event.getStart_date() + "";

            String rowTitle[] = {"Event no", "Descripcion", "Fecha de inicio"};

            tableProducts = new JTable(arrayData, rowTitle);
            view.pnScroll.setViewportView(tableProducts);
        }

        view.btnPay.addActionListener(this);
        view.btnPrint.addActionListener(this);
        view.txtDiscountPercent.addChangeListener(this);
        view.txtDiscountPrice.addChangeListener(this);
        view.txtTipPercent.addChangeListener(this);
        view.txtTipPrice.addChangeListener(this);
        view.btnDelete.addActionListener(this);
        annulmentView.btnSave.addActionListener(this);
        annulmentView.btnCancel.addActionListener(this);

        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        PaymentMethod paymentMethod = (PaymentMethod) view.cbPaymentMethod.getSelectedItem();
        if (source == view.btnPay) {

            if (allocate) {
                AllocattedTread allocattedTread = new AllocattedTread(paymentMethod);
                allocattedTread.start();
            } else if (table != null || room != null) {
                InsertBill insertBill = new InsertBill();
                insertBill.start();
            } else {
                BillEvent billEvent = new BillEvent(paymentMethod);
                billEvent.start();
            }

            if (paymentMethod.isVirtual()) {
                view.dispose();
            } else {
                view.dispose();
                ReceipMoneyController receipMoneyController = new ReceipMoneyController(price);
            }
            MissingGlobal.showNotifications();

            HomeController.checkNotifications();
        }
        if (source == view.btnPrint) {
            PrintBill printBill = new PrintBill(null, true);
            printBill.txtWorker.setText("Atendido por: " + UserGlobal.getUser().getName());
            printBill.txtCompany.setText(ConfigGlobal.getConfig().getName());
            PrintFunctions pf = new PrintFunctions();
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            printBill.txtDate.setText(timeStamp);
            printBill.txtSubtotal.setText(realPrice + "");
            printBill.txtTotal.setText(price + "");
            printBill.txtAddress.setText(ConfigGlobal.getConfig().getAddress());
            printBill.txtPhone.setText(ConfigGlobal.getConfig().getPhone() + "");
            printBill.txtBill.setText(ConfigGlobal.getConfig().getName());
            printBill.txtBill.setText("Factura de compra");

            JTable tables = construcTable(products);
            JTableHeader header = tables.getTableHeader();

            printBill.pnTable.add(header, BorderLayout.NORTH);
            printBill.pnTable.add(tables, BorderLayout.CENTER);
            printBill.pnTable.repaint();
            printBill.pnTable.revalidate();

            printBill.setVisible(true);
            pf.print(printBill.pnBase);
        }

        if (source == view.btnDelete) {
            if (tableProducts.getSelectedRow() == -1) {
                JOptionPane jOptionPane = new JOptionPane("Elige un producto a eliminar");
                jOptionPane.setVisible(true);
            } else {
                annulmentView.setVisible(true);

            }
        }

        if (source == annulmentView.btnSave) {
            deleteProduct();
        }
    }

    private void deleteProduct() {
        Integer rowSelected = tableProducts.getSelectedRow();
        if (rowSelected != -1) {
            Product productSelected = products.get(rowSelected);
            String reason = annulmentView.txtReason.getText();
            Annulment annulment = new Annulment(null, reason, UserGlobal.getUser().getId(), null);
            annulment.setProduct_id(productSelected.getId());
            annulment.setQuantity(productSelected.getQuantity());

            AnnulmentModel am = new AnnulmentModel();
            am.insert(annulment);
            products.remove(productSelected);

            DefaultTableModel m = (DefaultTableModel) tableProducts.getModel();

            m.removeRow(rowSelected);
            annulmentView.dispose();
            realPrice = realPrice - productSelected.getPrice();
            updatePrice();
        }

    }

    private JTable construcTable(List<Product> products) {
        String rowTitle[] = {"Nombre", "Cantidad", "Subvalor"};
        String arrayData[][] = modelTable(products);
        DefaultTableModel defaultTableModel = new DefaultTableModel(arrayData, rowTitle);

        JTable inventoryTable = new JTable(defaultTableModel);
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

    @Override
    public void stateChanged(ChangeEvent ce) {
        updatePrice();
    }

    private void updatePrice() {
        Integer discountPrice = Integer.parseInt(String.valueOf(view.txtDiscountPrice.getValue()));
        Integer discountPercent = Integer.parseInt(String.valueOf(view.txtDiscountPercent.getValue()));
        Integer tipPrice = Integer.parseInt(String.valueOf(view.txtTipPrice.getValue()));
        Integer tipPercent = Integer.parseInt(String.valueOf(view.txtTipPercent.getValue()));

        tip = (tipPrice) + ((realPrice * tipPercent) / 100);

        price = (realPrice + tip);
        discount = (discountPrice) + ((price * discountPercent) / 100);
        price -= discount;

        if (price < 0) {
            view.txtPrice.setText("$0");
        } else {
            view.txtPrice.setText(MoneyConverter.convertDouble(price));
        }

    }

    //THREADS
    class SetResourceThread extends Thread {

        private void setPaymentMethods() {
            PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
            List<PaymentMethod> paymentMethods = paymentMethodModel.selectAll();
            for (PaymentMethod paymentMethod : paymentMethods) {
                view.cbPaymentMethod.addItem(paymentMethod);
            }
        }

        private void setTotal() {
            BillModel billModel = new BillModel();
            if (room == null && event == null) {
                billTableTmp = billModel.checkBillTableTmp(table.getId());
                view.txtPrice.setText(MoneyConverter.convertDouble(billTableTmp.getTotal()));
                realPrice = billTableTmp.getTotal();
                price = billTableTmp.getTotal();
            } else if (table == null && event == null) {
                billRoomTmp = billModel.checkBillRoomTmp(room.getId());
                view.txtPrice.setText(MoneyConverter.convertDouble(billRoomTmp.getTotal()));
                realPrice = billRoomTmp.getTotal();
                price = billRoomTmp.getTotal();
            } else {
                view.txtPrice.setText(MoneyConverter.convertDouble(event.getPrice()));
                realPrice = event.getPrice();
                price = event.getPrice();
            }

        }

        private void setProducts() {
            BillModel billModel = new BillModel();
            if (room == null) {
                products = billModel.selectProductsTableTmp(table.getId());
                construcTable(products);
            } else {
                products = billModel.selectProductsRoomTmp(room.getId());
                construcTable(products);
            }
        }

        private void construcTable(List<Product> products) {
            String rowTitle[] = {"Id", "Nombre", "Precio", "Cantidad", "Fecha"};
            String arrayData[][] = modelTable(products);

            DefaultTableModel defaultTableModel = new DefaultTableModel(arrayData, rowTitle);

            tableProducts = new JTable(defaultTableModel);
            view.pnScroll.setViewportView(tableProducts);

        }

        private String[][] modelTable(List<Product> reports) {
            String arrayData[][] = new String[reports.size()][5];

            for (int i = 0; i < reports.size(); i++) {
                arrayData[i][0] = reports.get(i).getId() + "";
                arrayData[i][1] = reports.get(i).getName() + "";
                arrayData[i][2] = MoneyConverter.convertDouble(reports.get(i).getPrice()) + "";
                arrayData[i][3] = reports.get(i).getQuantity() + "";
                arrayData[i][4] = reports.get(i).getCreated_at() + "";
            }

            return arrayData;
        }

        @Override
        public void run() {
            if (allocate) {
                setPaymentMethods();
            } else if (table != null || room != null) {
                setTotal();
                setProducts();
                setPaymentMethods();
            } else {
                setPaymentMethods();
                setTotal();
            }
            setDefaultTip();

        }
    }

    class InsertBill extends Thread {

        private Bill contructBill() {
            PaymentMethod paymentMethod = (PaymentMethod) view.cbPaymentMethod.getSelectedItem();
            Bill bill = new Bill();
            bill.setDescription("normal_sell");
            if (room == null) {
                bill.setClient_type(1);
                bill.setClient_id(table.getId());
                bill.setPeople(table.getCapacity());
            } else {
                bill.setClient_type(2);
                bill.setClient_id(room.getId());
                bill.setPeople(room.getCapacity());
            }
            bill.setUser_id(UserGlobal.getUser().getId());
            bill.setDiscount(discount);
            bill.setTip(tip);
            if (view.chCourtesy.isSelected()) {
                bill.setCourtesy(true);
            } else {
                bill.setCourtesy(false);
            }
            if (view.chInternalExpense.isSelected()) {
                bill.setInternal(true);
            } else {
                bill.setInternal(false);
            }
            bill.setPayment_method_id(paymentMethod.getId());
            bill.setHousing(false);
            bill.setPrinted(false);
            bill.setTotal(realPrice);
            bill.setTotal_real(price);
            if (EventGlobal.getEvent() != null) {
                bill.setEvent_id(EventGlobal.getEvent().getId());
            } else {
                bill.setEvent_id(0);
            }
            return bill;
        }

        @Override
        public void run() {
            Bill bill = contructBill();
            BillModel billModel = new BillModel();
            if (room == null) {
                billModel.sellProductTable(products, bill, billTableTmp);
            } else {
                billModel.sellProductRoom(products, bill, billRoomTmp);
            }
        }
    }

    class AllocattedTread extends Thread {

        private PaymentMethod paymentMethod;

        public AllocattedTread(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        @Override
        public void run() {
            RoomModel roomModel = new RoomModel();
            roomModel.allocateRoom(room, paymentMethod, realPrice, price);
        }
    }

    class BillEvent extends Thread {

        private PaymentMethod paymentMethod;

        public BillEvent(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        @Override
        public void run() {
            BillModel billModel = new BillModel();
            billModel.insertEvent(event, paymentMethod, realPrice, price);
        }
    }
}
