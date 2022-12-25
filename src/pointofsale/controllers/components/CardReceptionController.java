/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pointofsale.objects.Ingredient;
import pointofsale.views.components.CardReceipView;
import pointofsale.views.inventory.ReceptionView;
import pointofsale.views.modal.ConfirmReceipView;

/**
 *
 * @author dragonyte
 */
public class CardReceptionController implements ActionListener,FocusListener {

    private CardReceipView view;
    private ConfirmReceipView confirmView;
    private Ingredient ingredient;
    private ReceptionView superView;
    private JPanel panel;
    private List<Ingredient> listIngredients;

    public CardReceptionController(List<Ingredient> listIngredients, Ingredient ingredient, ReceptionView superView) {
        this.listIngredients = listIngredients;
        this.ingredient = ingredient;
        this.view = new CardReceipView();
        this.superView = superView;
        this.panel = superView.pnBase;

        view.txtName.setText(ingredient.getName());
        view.txtUnit.setText(ingredient.getUnit());
        view.txtCurrentQuantity.setText(String.valueOf(ingredient.getQuantity()));
        if (!"".equals(ingredient.getRoute_image())) {
            ImageIcon icon = new ImageIcon(ingredient.getRoute_image());
            Image img = icon.getImage();
            Image img_r = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img_r);
            view.txtImage.setIcon(icon);
        }
        
        //CLICK
        view.btnLess.addActionListener(this);
        view.btnPlus.addActionListener(this);
        view.btnSave.addActionListener(this);
        //FOCUS
        view.txtQuantity.addFocusListener(this);

        this.confirmView = new ConfirmReceipView(null, true);
        this.confirmView.setLocationRelativeTo(null);

        this.confirmView.btnClose.addActionListener(this);
        this.confirmView.btnSave.addActionListener(this);

        addComponent(view);
    }

    private void addComponent(Component component) {
        panel.add(component);
        panel.revalidate();
        panel.repaint();
    }

    private void showConfirmView() {
        this.confirmView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Long value = Long.valueOf(view.txtQuantity.getText());
        if (source == view.btnPlus) {
            view.txtQuantity.setText(String.valueOf(value + 1));
        }
        if (source == view.btnLess) {
            view.txtQuantity.setText(String.valueOf(value - 1));
        }
        if (source == view.btnSave) {
            if (value > 0) {
                showConfirmView();
            }
        }
        if (source == confirmView.btnSave) {
            Long price = Long.valueOf(String.valueOf(confirmView.txtPrice.getValue()));
            confirmView.dispose();
            ingredient.setQuantity(value);
            ingredient.setPrice(price);
            listIngredients.add(ingredient);
            CardReceipInfoController card = new CardReceipInfoController(listIngredients, ingredient,superView);
            card.setTotalPrice(superView.txtPrice);
        }
        if(source == confirmView.btnClose){
            confirmView.dispose();
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
