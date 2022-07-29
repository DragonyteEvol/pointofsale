/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pointofsale.controllers.Controller;
import pointofsale.controllers.components.CardProductWhitManagerController;
import pointofsale.models.BillModel;
import pointofsale.models.CategorieModel;
import pointofsale.models.ProductModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Product;
import pointofsale.objects.Room;
import pointofsale.objects.Table;
import pointofsale.views.modal.SellProductView;

/**
 *
 * @author dragonyte
 */
public class SellProductsController extends Controller implements ActionListener {

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
        view.setSize(dimension.width / 2, dimension.height / 2);

        initEvents();

        this.view.setVisible(true);
    }

    private void initEvents() {
        this.view.btnSave.addActionListener(this);
        initTreads();
    }

    private void initTreads() {
        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(view);
        secondResourceThread.start();
    }
    
    private boolean validateRequest(){
        return !listProduct.isEmpty();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            if(validateRequest()){
                BillModel billModel = new BillModel();
                if(room==null){
                   billModel.insertTableOrder(table, listProduct);
                   this.view.dispose();
                }else{
                   billModel.insertRoomOrder(room, listProduct);
                   this.view.dispose();
                }
            }
        }

    }

    class SetSecondResourceThread extends Thread {

        private final SellProductView view;

        public SetSecondResourceThread(SellProductView view) {
            this.view = view;
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();

            List<Categorie> categories = categorieModel.selectCategoriesProducts();
            for (Categorie categorie : categories) {
                JScrollPane scrollPanel = new JScrollPane();
                JPanel panel = new JPanel();
                ProductModel productModel = new ProductModel();
                String where = "categorie_id=" + String.valueOf(categorie.getId());
                List<Product> products = productModel.selectWhere(where);
                for (Product product : products) {
                    CardProductWhitManagerController cardProductController = new CardProductWhitManagerController(view, product, categorie, listProduct);
                    cardProductController.addComponent(cardProductController.view, panel);
                }
                scrollPanel.setViewportView(panel);
                this.view.tabbedPane.add(categorie.getName(), scrollPanel);
            }
        }

        @Override
        public void run() {
            setCategories();
        }
    }

}
