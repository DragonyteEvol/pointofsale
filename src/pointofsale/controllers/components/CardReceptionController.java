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
import pointofsale.objects.Ingredient;
import pointofsale.views.components.CardReceipView;
import pointofsale.views.inventory.ReceptionView;
import pointofsale.views.modal.ConfirmReceipView;

/**
 *
 * @author dragonyte
 */
public class CardReceptionController implements ActionListener {

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

        view.btnLess.addActionListener(this);
        view.btnPlus.addActionListener(this);
        view.btnSave.addActionListener(this);

        this.confirmView = new ConfirmReceipView(null, true);
        this.confirmView.setResizable(false);

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
        Integer value = Integer.valueOf(view.txtQuantity.getText());
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
            Integer price = Integer.valueOf(String.valueOf(confirmView.txtPrice.getValue()));
            confirmView.dispose();
            ingredient.setQuantity(value);
            ingredient.setPrice(price);
            listIngredients.add(ingredient);
            CardReceipInfoController card = new CardReceipInfoController(listIngredients, ingredient,superView);
            card.setTotalPrice(superView.txtPrice);
        }
    }

}
