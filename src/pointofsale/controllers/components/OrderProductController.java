/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pointofsale.MoneyConverter;
import pointofsale.objects.Product;
import pointofsale.views.components.OrderProductView;
import pointofsale.views.modal.SellProductView;

/**
 *
 * @author dragonyte
 */
public class OrderProductController implements ActionListener,FocusListener{

    public OrderProductView view;
    private Product product;
    private SellProductView superView;
    private List<Product> listProduct;
    private JLabel txtPrice;
    private JPanel panel;

    public OrderProductController(List<Product> listProduct, Product product, SellProductView superView) {

        this.view = new OrderProductView();
        this.panel = superView.pnOrder;
        this.txtPrice = superView.txtPrice;

        this.listProduct = listProduct;
        this.product = product;
        setInfo();
        initEvents();

        addComponent(view);

    }
    
    private void initEvents(){
        this.view.btnLess.addActionListener(this);
        this.view.btnPlus.addActionListener(this);
        this.view.btnClose.addActionListener(this);
        //FOCUS
        this.view.txtQuantity.addFocusListener(this);
    }
    
    private void setPrice(){
        Long price=Long.valueOf(0);
        for(Product productp : listProduct){
            price += (productp.getPrice() * productp.getQuantity());
        }
        this.txtPrice.setText(MoneyConverter.convertDouble(price));
    }
    
    private void setInfo(){
        this.view.txtName.setText(product.getName());
        this.view.txtQuantity.setText(String.valueOf(product.getQuantity()));
        
        this.listProduct.add(product);
        setPrice();
    }

    private void addComponent(Component component) {
        this.panel.add(component);
        panel.revalidate();
        panel.repaint();
    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Long quantity = Long.valueOf(this.view.txtQuantity.getText());
        if(source==this.view.btnPlus){
            Long value = quantity + 1;
            this.view.txtQuantity.setText(String.valueOf(value));
            this.listProduct.remove(product);
            this.product.setQuantity(value);
            this.listProduct.add(product);
            setPrice();
        }
        
        if(source==this.view.btnLess){
            Long value = quantity - 1;
            this.view.txtQuantity.setText(String.valueOf(value));
            this.listProduct.remove(product);
            this.product.setQuantity(value);
            this.listProduct.add(product);
            setPrice();
        }
        
        if(source == this.view.btnClose){
            listProduct.remove(product);
            setPrice();
            removeComponent(view);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(this.view.txtQuantity== source){
            this.view.txtQuantity.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
