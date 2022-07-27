/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Product;
import pointofsale.views.components.CardProductView;
import pointofsale.views.modal.SellProductView;

/**
 *
 * @author dragonyte
 */
public class CardProductController implements ActionListener {

    public CardProductView view;
    private SellProductView superView;
    private Product product;
    private Categorie categorie;
    private List<Product> listProduct;

    public CardProductController(SellProductView superView, Product product, Categorie categorie,List<Product> listProduct) {
        initComponents(superView, product, categorie,listProduct);
    }

    private void initComponents(SellProductView superView,Product product, Categorie categorie,List<Product> listproduct) {
        this.view = new CardProductView();
        this.superView = superView;
        this.listProduct = listproduct;

        this.product = product;
        this.categorie = categorie;
        
        setInfo();
        initEvents();
    }
    
    //ozuna
    private void setInfo(){
        this.view.txtCategorie.setText(categorie.getName());
        this.view.txtName.setText("<html><p>"+ product.getName() +"</p></html>");
    }

    private void initEvents() {
        this.view.btnAdd.addActionListener(this);
        this.view.btnPlus.addActionListener(this);
        this.view.btnLess.addActionListener(this);
    }

    public void addComponent(Component component,JPanel panel) {
        panel.add(component);
        panel.revalidate();
        panel.repaint();
    }
    
    private boolean validateRequest(Integer quantity){
        if(quantity <= 0 || quantity ==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Integer quantity = Integer.valueOf(this.view.txtQuantity.getText());
        if (source == this.view.btnAdd) {
            if(validateRequest(quantity)){
                product.setQuantity(quantity);
                OrderProductController order = new OrderProductController(listProduct, product,superView);
            }
        }
        
        if(source == this.view.btnPlus){
            Integer sum = quantity + 1;
            this.view.txtQuantity.setText(String.valueOf(sum));
        }
        
        if(source == this.view.btnLess){
            Integer less = quantity - 1;
            this.view.txtQuantity.setText(String.valueOf(less));
        }
    }
}
