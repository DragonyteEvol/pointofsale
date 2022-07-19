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
import pointofsale.objects.IngredientUnit;
import pointofsale.views.components.CardIngredientInfoView;

/**
 *
 * @author dragonyte
 */
public class CardIngredientInfoController implements ActionListener{

    private CardIngredientInfoView view;
    private List<IngredientUnit> listIngredient;
    private IngredientUnit ingredient;
    private JPanel panel;

    public CardIngredientInfoController(List<IngredientUnit> listIngredient,IngredientUnit ingredient,JPanel panel) {
        this.listIngredient = listIngredient;
        this.ingredient = ingredient;
        this.view = new CardIngredientInfoView();
        this.panel = panel;
        
        this.view.txtName.setText(ingredient.getName());
        this.view.txtQuantity.setText(String.valueOf(ingredient.getQuantity()));
        this.view.txtUnit.setText(ingredient.getUnit());
        
        //events
        this.view.btnDrop.addActionListener(this);
        
        addComponent(view);
        
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
            removeComponent(view);
        }
    }


}
