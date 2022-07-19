/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import pointofsale.objects.IngredientUnit;
import pointofsale.views.components.CardIngredientView;

/**
 *
 * @author dragonyte
 */
public class CardIngredientController implements ActionListener {

    private CardIngredientView view;
    private IngredientUnit ingredient;
    private JPanel pnInfo;
    private List<IngredientUnit> listQuantitys;

    public CardIngredientController(IngredientUnit ingredient, JPanel panel, JPanel panelInfo, List<IngredientUnit> listQuantitys) {
        this.view = new CardIngredientView(ingredient);
        this.pnInfo = panelInfo;
        this.ingredient = ingredient;
        this.listQuantitys = listQuantitys;
        panel.add(view);

        this.view.btnAdd.addActionListener(this);
    }

    private boolean validateRequest(Double quantity) {
        if (quantity.isNaN() || quantity == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void addComponent(Component component) {
        this.pnInfo.add(component);
        pnInfo.revalidate();
        pnInfo.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnAdd) {
            Double quantity = Double.valueOf((Integer) this.view.txtQuantity.getValue());
            if (validateRequest(quantity)) {
                this.ingredient.setQuantity(quantity);
                this.listQuantitys.add(ingredient);
                addComponent(new JButton(ingredient.getName()));
            }

        }

    }
}
