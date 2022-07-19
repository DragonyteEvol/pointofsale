/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import pointofsale.controllers.modal.NewProductController;
import pointofsale.models.ProductModel;
import pointofsale.objects.Product;
import pointofsale.views.inventory.ProductView;

/**
 *
 * @author dragonyte
 */
public class ProductController extends Controller implements ActionListener{

    private ProductView view;

    public ProductController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel){
        this.view = new ProductView();
        setProducts();
        this.addView(this.view, panel);
        
        this.initEvents();
    }
    
    private void initEvents(){
        this.view.btnCreate.addActionListener(this);
    }
    
    private void setProducts(){
        ProductModel productModel = new ProductModel();
        List<Product> products = productModel.selectAll();
        for(Product product : products){
            this.view.add(new JButton(product.getName()));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == this.view.btnCreate){
            NewProductController newProduct = new NewProductController();
        }
    }
    
}
