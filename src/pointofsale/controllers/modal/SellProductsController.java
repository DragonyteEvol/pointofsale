/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.JTableHeader;
import pointofsale.controllers.Controller;
import pointofsale.controllers.PrintFunctions;
import pointofsale.controllers.components.CardProductWhitManagerController;
import pointofsale.models.BillModel;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.ProductModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Product;
import pointofsale.objects.Room;
import pointofsale.objects.Table;
import pointofsale.views.components.PrintCommand;
import pointofsale.views.modal.SellProductView;

/**
 *
 * @author dragonyte
 */
public class SellProductsController extends Controller implements ActionListener, FocusListener {

    private SellProductView view;
    private Dimension dimension;
    private Room room = null;
    private Table table = null;
    public List<Product> listProduct = new ArrayList<>();

    public SellProductsController(Room room) {
        this.room = room;
        initComponents();
    }

    public SellProductsController(Table table) {
        this.table = table;
        initComponents();
    }

    private void initComponents() {
        this.view = new SellProductView(null, true);
        this.view.setResizable(false);

        dimension = view.getToolkit().getScreenSize();
        Integer width = (dimension.width *2)/3;
        Integer height = (dimension.height *2)/3;
        view.setSize(width,height);

        setInfo();

        this.view.setVisible(true);
    }

    private void setInfo() {
        if (room != null) {
            view.txtTarget.setText("Habitacion " + room.getId());
        } else {
            view.txtTarget.setText("Mesa " + table.getId());
        }
        initEvents();
    }

    private void initEvents() {
        this.view.btnSave.addActionListener(this);

        this.view.txtSearch.addFocusListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search(view.pnProducts);
            }

            public void insertUpdate(DocumentEvent e) {
                search(view.pnProducts);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
        initTreads();
    }

    private void search(JPanel searchPanel) {
        String search = view.txtSearch.getText();

        ProductModel productModel = new ProductModel();
        List<Product> products = productModel.searchProducts(search);

        searchPanel.removeAll();

        if (products.isEmpty()) {
            searchPanel.repaint();
            searchPanel.revalidate();
        } else {

            for (Product product : products) {
                CardProductWhitManagerController cardProductController = new CardProductWhitManagerController(view, product, listProduct);
                cardProductController.addComponent(cardProductController.view, view.pnProducts);
                searchPanel.repaint();
                searchPanel.revalidate();
            }
        }
    }

    private void initTreads() {
        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(view);
        secondResourceThread.start();
    }

    private boolean validateRequest() {
        return !listProduct.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            if (validateRequest()) {
                BillModel billModel = new BillModel();
                if (room == null) {
                    billModel.insertTableOrder(table, listProduct);
                    this.view.dispose();
                } else {
                    billModel.insertRoomOrder(room, listProduct);
                    this.view.dispose();
                }
            }
            if (view.chPrint.isSelected()) {
                PrintCommand printCommand = new PrintCommand(null, true);
                if (room == null) {
                    printCommand.txtTarget.setText("Mesa " + table.getId());
                } else {
                    printCommand.txtTarget.setText("Habitacion " + room.getId());
                }
                PrintFunctions pf = new PrintFunctions();
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                printCommand.txtDate.setText(timeStamp);

                JTable tables = construcTable(listProduct);
                JTableHeader header = tables.getTableHeader();

                printCommand.pnTable.add(header, BorderLayout.NORTH);
                printCommand.pnTable.add(tables, BorderLayout.CENTER);
                printCommand.pnTable.repaint();
                printCommand.pnTable.revalidate();
                
                printCommand.setVisible(true);

                pf.print(printCommand);
            }
        }

    }

    private JTable construcTable(List<Product> products) {
        String rowTitle[] = {"Nombre", "Subvalor", "Cantidad"};
        String arrayData[][] = modelTable(products);

        JTable inventoryTable = new JTable(arrayData, rowTitle);
        return inventoryTable;
    }

    private String[][] modelTable(List<Product> products) {
        String arrayData[][] = new String[products.size()][3];

        for (int i = 0; i < products.size(); i++) {
            arrayData[i][0] = products.get(i).getName() + "";
            arrayData[i][1] = products.get(i).getPrice() + "";
            arrayData[i][2] = products.get(i).getQuantity() + "";
        }

        return arrayData;
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object source = fe.getSource();
        if (source == view.txtSearch) {
            view.txtSearch.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    class SetSecondResourceThread extends Thread {

        private final SellProductView view;

        public SetSecondResourceThread(SellProductView view) {
            this.view = view;
        }

        private void setCategorie() {
            CategorieModel categorieModel = new CategorieModel();

            List<Categorie> categories = categorieModel.selectCategoriesProducts();
            for (Categorie categorie : categories) {
                JButton button1 = new JButton(categorie.getName());
                button1.setBackground(Color.BLUE);
                button1.setForeground(Color.WHITE);
                view.pnCategories.add(button1);
                view.pnCategories.repaint();
                view.pnCategories.revalidate();
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ProductModel productModel = new ProductModel();
                        String where = " categorie_id=" + categorie.getId();
                        List<Product> products = productModel.selectWhere(where);
                        view.pnProducts.removeAll();
                        view.pnProducts.repaint();
                        view.pnProducts.revalidate();
                        for (Product product : products) {
                            CardProductWhitManagerController cardProductController = new CardProductWhitManagerController(view, product, listProduct);
                            cardProductController.addComponent(cardProductController.view, view.pnProducts);
                        }
                    }
                });
            }
        }

        private void setProduct() {
            ProductModel productModel = new ProductModel();
            List<Product> products = productModel.selectAll();
            for (Product product : products) {
                CardProductWhitManagerController cardProductController = new CardProductWhitManagerController(view, product, listProduct);
                cardProductController.addComponent(cardProductController.view, view.pnProducts);
            }
        }

        @Override
        public void run() {
            setCategorie();
            setProduct();
        }
    }

}
