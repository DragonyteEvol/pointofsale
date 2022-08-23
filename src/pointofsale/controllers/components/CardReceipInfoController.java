/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pointofsale.MoneyConverter;
import pointofsale.objects.Ingredient;
import pointofsale.views.components.CardReceipInfoView;
import pointofsale.views.inventory.ReceptionView;

/**
 *
 * @author dragonyte
 */
public class CardReceipInfoController implements ActionListener{
    
    private CardReceipInfoView view;
    private List<Ingredient> listIngredient;
    private Ingredient ingredient;
    private JPanel panel;
    private JLabel txtPrice;

    public CardReceipInfoController(List<Ingredient> listIngredient,Ingredient ingredient,ReceptionView panel) {
        this.listIngredient = listIngredient;
        this.ingredient = ingredient;
        this.view = new CardReceipInfoView();
        this.panel = panel.pnInfo;
        this.txtPrice = panel.txtPrice;
        
        
        this.view.txtName.setText(ingredient.getName());
        this.view.txtQuantity.setText(String.valueOf(ingredient.getQuantity()));
        this.view.txtUnit.setText(ingredient.getUnit());
        
        //events
        this.view.btnDrop.addActionListener(this);
        
        addComponent(view);
    }
    
    public void setTotalPrice(JLabel label){
        Integer value = 0;
        for(Ingredient ingredientp: listIngredient){
            value += ingredientp.getPrice();
        }
        label.setText(MoneyConverter.convertDouble(value));
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
        if(source==this.view.btnDrop){
            this.listIngredient.remove(this.ingredient);
            setTotalPrice(txtPrice);
            removeComponent(view);
        }
    }

}
