/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import pointofsale.MoneyConverter;
import pointofsale.controllers.modal.EditIngredientController;
import pointofsale.models.IngredientModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.components.CardIngredientView;

/**
 *
 * @author dragonyte
 */
public class CardIngredientController extends CardController implements ActionListener {

    private Ingredient ingredient;
    public CardIngredientView view;
    private JPanel panel;

    public CardIngredientController(Ingredient ingredient, JPanel panel) {
        this.ingredient = ingredient;
        this.panel = panel;
        this.view = new CardIngredientView();
        setInfo();
        initEvents();

        this.panel.add(view);
    }

    private void setInfo() {
        this.view.txtName.setText(ingredient.getName());
        this.view.txtPrice.setText(MoneyConverter.convertDouble(ingredient.getPrice()));
        this.view.txtUnit.setText(Long.toString(ingredient.getUnit_id()));
        if (!"".equals(ingredient.getRoute_image())) {
            ImageIcon icon = new ImageIcon(ingredient.getRoute_image());
            Image img = icon.getImage();
            Image img_r = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img_r);
            view.txtImage.setIcon(icon);
        }

    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        this.panel.repaint();
        this.panel.revalidate();
    }

    private void refreshCategorie() {
        //IngredientModel ingredientModel = new IngredientModel();
        //this.ingredient = ingredientModel.selectById(ingredient.getId());
        setInfo();
    }

    private void initEvents() {
        this.view.btnDelete.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
        deleteView.btnYes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnDelete) {
            deleteView.setVisible(true);
        }

        if (source == this.view.btnEdit) {
            EditIngredientController editIngredientController = new EditIngredientController(ingredient);
            refreshCategorie();
        }

        if (source == deleteView.btnYes) {
            DeleteThread deleteThread = new DeleteThread(ingredient);
            deleteThread.start();
            removeComponent(this.view);
            deleteView.dispose();
        }
    }

    class DeleteThread extends Thread {

        private Ingredient ingredient;

        public DeleteThread(Ingredient ingredient) {
            this.ingredient = ingredient;
        }

        private void deleteIngredient() {
            IngredientModel ingredientModel = new IngredientModel();
            ingredientModel.delete(ingredient);
        }

        @Override
        public void run() {
            deleteIngredient();
        }
    }

}
