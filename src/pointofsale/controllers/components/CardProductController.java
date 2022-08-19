/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.MoneyConverter;
import pointofsale.controllers.modal.EditProductController;
import pointofsale.models.ProductModel;
import pointofsale.objects.Product;
import pointofsale.views.components.CardProductView;

/**
 *
 * @author dragonyte
 */
public class CardProductController implements ActionListener{
     private Product product;
    public CardProductView view;
    private JPanel panel;

    public CardProductController(Product product, JPanel panel) {
        this.product = product;
        this.panel = panel;
        this.view = new CardProductView();
        setInfo();
        initEvents();

        this.panel.add(view);
    }

    private void setInfo() {
        this.view.txtName.setText(product.getName());
        this.view.txtPrice.setText(MoneyConverter.convertDouble(product.getPrice()));
        this.view.txtCategorie.setText(String.valueOf(product.getTime()));
        
    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        this.panel.repaint();
        this.panel.revalidate();
    }

    private void refreshCategorie() {
        ProductModel productModel = new ProductModel();
        this.product = productModel.selectById(product.getId());
        setInfo();
    }

    private void initEvents() {
        this.view.btnDelete.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnDelete) {
            DeleteThread deleteThread = new DeleteThread(product);
            deleteThread.start();
            removeComponent(this.view);
        }

        if (source == this.view.btnEdit) {
            EditProductController editProductController = new EditProductController(product);
            refreshCategorie();
        }
    }

    class DeleteThread extends Thread {

        private Product product;

        public DeleteThread(Product product) {
            this.product = product;
        }

        private void deleteProduct() {
            ProductModel productModel = new ProductModel();
            productModel.delete(product);
        }

        @Override
        public void run() {
            deleteProduct();
        }
    }
}
