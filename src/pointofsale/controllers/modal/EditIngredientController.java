/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.InventoryModel;
import pointofsale.models.UnitModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.Unit;
import pointofsale.views.additional.FileSelector;
import pointofsale.views.modal.NewIngredientView;

/**
 *
 * @author dragonyte
 */
public class EditIngredientController implements ActionListener,FocusListener {

    private NewIngredientView view;
    private Ingredient ingredient;
    public boolean removed = false;
    private FileSelector selectorView;

    public EditIngredientController(Ingredient ingredient) {
        this.view = new NewIngredientView(null, true);
        this.selectorView = new FileSelector(null, true);
        this.view.setLocationRelativeTo(null);
        this.ingredient = ingredient;
        Dimension dimension = view.getToolkit().getScreenSize();

        selectorView.setSize(dimension.width / 2, dimension.height / 2);
        selectorView.setLocationRelativeTo(null);

        selectorView.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        this.view.btnSave.addActionListener(this);
        this.view.btnImage.addActionListener(this);
        selectorView.fileChooser.addActionListener(this);
         //FOCUS
        this.view.txtImage.addFocusListener(this);
        this.view.txtName.addFocusListener(this);

        setInfo();

        this.view.setVisible(true);
    }

    private void setInfo() {
        this.view.txtMinimum.setValue(0);
        this.view.txtName.setText(ingredient.getName());
        this.view.txtPrice.setValue(ingredient.getPrice());
        InventoryModel inventoryModel = new InventoryModel();
        Inventory inventory = inventoryModel.selectWhereIngredient(ingredient.getId());
        this.view.txtStock.setValue(inventory.getQuantity());
        this.view.txtMinimum.setValue(inventory.getMinimum());
        this.view.txtImage.setText(ingredient.getRoute_image());
        this.view.txtTitle.setText("Editar ingrediente");
        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbUnit, this.view.cbCategorie, ingredient);
        setResourceThread.start();
    }

    public boolean validRequest(String name, Long price) {
        return !(name.isBlank() || price == 0 || price == null);
    }
    
       @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source==this.view.txtImage){
            this.view.txtImage.selectAll();
        }
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = this.view.txtName.getText();
            String route_image= this.view.txtImage.getText();
            Long price = (Long) this.view.txtPrice.getValue();
            Long stock = (Long) this.view.txtStock.getValue();
            Long minimum = (Long) this.view.txtMinimum.getValue();
            Unit unit = (Unit) this.view.cbUnit.getSelectedItem();
            Long unit_id = unit.getId();
            Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
            Long categorie_id = categorie.getId();
            if (validRequest(name, price)) {
                this.ingredient.setName(name);
                this.ingredient.setPrice(price);
                this.ingredient.setQuantity(stock);
                this.ingredient.setMinimum(minimum);
                this.ingredient.setUnit_id(unit_id);
                this.ingredient.setCategorie_id(categorie_id);
                this.ingredient.setRoute_image(route_image);
                UpdateThread updateThread = new UpdateThread(ingredient);
                updateThread.start();
                this.view.dispose();
            }
        }
        if(source == view.btnImage){
            selectorView.setVisible(true);
        }
        
        if (source == selectorView.fileChooser) {
            String command = ae.getActionCommand();
            if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                String path = String.valueOf(selectorView.fileChooser.getSelectedFile());
                view.txtImage.setText(path);
                System.out.print(path);
                selectorView.dispose();
            }else if(command.equals(JFileChooser.CANCEL_SELECTION)){
                selectorView.dispose();
            }

        }
    }

    class SetResourceThread extends Thread {

        private JComboBox<Object> cbUnit;
        private JComboBox<Object> cbCategorie;
        private Ingredient ingredient;

        public SetResourceThread(JComboBox<Object> cbUnit, JComboBox<Object> cbCategorie, Ingredient ingredient) {
            this.cbUnit = cbUnit;
            this.cbCategorie = cbCategorie;
            this.ingredient = ingredient;
        }

        private void setUnits() {
            UnitModel unitModel = new UnitModel();
            List<Unit> units = unitModel.selectAll();
            for (Unit unit : units) {
                if (Objects.equals(unit.getId(), ingredient.getUnit_id())) {
                    this.cbUnit.addItem(unit);
                    this.cbUnit.setSelectedItem(unit);
                } else {
                    this.cbUnit.addItem(unit);
                }
            }
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesIngredients();
            for (Categorie categorie : categories) {
                if (Objects.equals(categorie.getId(), ingredient.getCategorie_id())) {
                    this.cbCategorie.addItem(categorie);
                    this.cbCategorie.setSelectedItem(categorie);
                } else {
                    this.cbCategorie.addItem(categorie);
                }
            }
        }

        @Override
        public void run() {
            setCategories();
            setUnits();
        }
    }

    class UpdateThread extends Thread {

        private Ingredient ingredient;

        public UpdateThread(Ingredient ingredient) {
            this.ingredient = ingredient;
        }

        private void updateIngredient() {
            IngredientModel ingredientModel = new IngredientModel();
            ingredientModel.update(ingredient);
        }

        @Override
        public void run() {
            updateIngredient();
        }
    }
}
