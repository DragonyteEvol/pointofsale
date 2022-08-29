/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.controllers.components.CardProductController;
import pointofsale.controllers.modal.NewProductController;
import pointofsale.models.ProductModel;
import pointofsale.objects.Product;
import pointofsale.views.inventory.ProductView;

/**
 *
 * @author dragonyte
 */
public class ProductController extends Controller implements ActionListener, FocusListener {

    private ProductView view;

    public ProductController(JPanel panel) {
        this.view = new ProductView();

        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {

        panel.add(view);
        setProducts();
        this.initEvents();

    }

    public void setProducts() {
        view.pnProducts.removeAll();
        SetResource sr = new SetResource();
        sr.start();
    }

    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
        this.view.txtSearch.addActionListener(this);
        this.view.txtSearch.addFocusListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search();
            }

            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    private void search() {
        SearchThread st = new SearchThread();
        st.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewProductController newProduct = new NewProductController();
            setProducts();
        }
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

    class SetResource extends Thread {

        private void setProducts() {
            ProductModel productModel = new ProductModel();
            List<Product> products = productModel.selectAll();
            for (Product product : products) {
                CardProductController cardProductController = new CardProductController(product, view.pnProducts);
                view.pnProducts.repaint();
                view.pnProducts.revalidate();
            }
        }

        @Override
        public void run() {
            setProducts();
        }
    }

    class SearchThread extends Thread {

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
                    CardProductController cardProductController = new CardProductController(product, searchPanel);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            }
        }

        @Override
        public void run() {
            search(view.pnProducts);
        }
    }
}
