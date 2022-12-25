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
import pointofsale.views.components.CardIngredientWhitManagerView;

/**
 *
 * @author dragonyte
 */
public class CardIngredientWhitManagerController implements ActionListener,FocusListener {

    public CardIngredientWhitManagerView view;
    public Ingredient ingredient;
    private JPanel panel;
    private JPanel pnInfo;
    private List<Ingredient> listQuantitys;

    public CardIngredientWhitManagerController(Ingredient ingredient, JPanel panel, JPanel panelInfo, List<Ingredient> listQuantitys) {
        this.view = new CardIngredientWhitManagerView();
        this.pnInfo = panelInfo;
        this.ingredient = ingredient;
        this.listQuantitys = listQuantitys;
        this.panel = panel;
        setIngredientInfo();
        panel.add(view);

        this.view.btnAdd.addActionListener(this);
        this.view.btnLess.addActionListener(this);
        this.view.btnPlus.addActionListener(this);
        //FOCUS
        this.view.txtQuantity.addFocusListener(this);
    }

    private void setIngredientInfo() {
        view.txtName.setText(ingredient.getName());
        view.txtUnit.setText(ingredient.getUnit());
        if (!"".equals(ingredient.getRoute_image())) {
            ImageIcon icon = new ImageIcon(ingredient.getRoute_image());
            Image img = icon.getImage();
            Image img_r = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img_r);
            view.txtImage.setIcon(icon);
        }
    }

    private boolean validateRequest(Long quantity) {
        if (quantity == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void removeComponent(Component component) {
        this.panel.remove(component);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        Long quantity = Long.valueOf(this.view.txtQuantity.getText());
        if (source == this.view.btnAdd) {
            if (validateRequest(quantity)) {
                this.ingredient.setQuantity(quantity);
                this.listQuantitys.add(ingredient);
                CardIngredientInfoController cardIngredientInfoController = new CardIngredientInfoController(listQuantitys, ingredient, pnInfo);
                removeComponent(view);
            }

        }

        if (source == this.view.btnPlus) {
            Long sum = quantity + 1;
            this.view.txtQuantity.setText(String.valueOf(sum));
        }

        if (source == this.view.btnLess) {
            Long less = quantity - 1;
            this.view.txtQuantity.setText(String.valueOf(less));
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtQuantity){
            this.view.txtQuantity.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
