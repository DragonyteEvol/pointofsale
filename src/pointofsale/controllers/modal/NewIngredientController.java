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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import pointofsale.controllers.ModalController;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.UnitModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Unit;
import pointofsale.views.additional.FileSelector;
import pointofsale.views.modal.NewIngredientView;

/**
 *
 * @author dragonyte
 */
public class NewIngredientController extends ModalController implements ActionListener,FocusListener {

    private NewIngredientView view;
    private FileSelector selectorView;

    public NewIngredientController() {

        // view config
        this.view = new NewIngredientView(null, true);
        this.view.setLocationRelativeTo(null);
        this.selectorView = new FileSelector(null, true);
        
        Dimension dimension = view.getToolkit().getScreenSize();
        selectorView.setSize(dimension.width / 2, dimension.height / 2);
        selectorView.setLocationRelativeTo(null);

        selectorView.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        //events
        this.view.btnSave.addActionListener(this);
        this.view.btnImage.addActionListener(this);
        selectorView.fileChooser.addActionListener(this);
        //FOCUS
        this.view.txtImage.addFocusListener(this);
        this.view.txtName.addFocusListener(this);

        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbUnit, this.view.cbCategorie);
        setResourceThread.start();
        this.view.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            if (view.chAmenitie.isSelected()) {
                InsertAmenitie insertAmenitie = new InsertAmenitie();
                insertAmenitie.start();
                view.dispose();
            } else {
                InsertThread insertThread = new InsertThread(this.view);
                insertThread.start();
                view.dispose();
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

    class SetResourceThread extends Thread {

        private JComboBox<Object> cbUnit;
        private JComboBox<Object> cbCategorie;

        public SetResourceThread(JComboBox<Object> cbUnit, JComboBox<Object> cbCategorie) {
            this.cbUnit = cbUnit;
            this.cbCategorie = cbCategorie;
        }

        private void setUnits() {
            UnitModel unitModel = new UnitModel();
            List<Unit> units = unitModel.selectAll();
            for (Unit unit : units) {
                this.cbUnit.addItem(unit);
            }
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesIngredients();
            for (Categorie categorie : categories) {
                this.cbCategorie.addItem(categorie);
            }
        }

        private void setIngredients() {

        }

        @Override
        public void run() {
            setCategories();
            setUnits();
        }
    }

    class InsertThread extends Thread {

        private NewIngredientView view;

        public InsertThread(NewIngredientView view) {
            this.view = view;
        }

        private boolean validateRequest() {
            String name = this.view.txtName.getText();
            if (name.isBlank() || name.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        private Ingredient createIngredient() {
            String name = this.view.txtName.getText();
            Long price = (Long) this.view.txtPrice.getValue();
            Unit unit = (Unit) this.view.cbUnit.getSelectedItem();
            Long unit_id = unit.getId();
            Long quantity = (Long) this.view.txtStock.getValue();
            Long minimum = (Long) this.view.txtMinimum.getValue();
            String image_route = this.view.txtImage.getText();
            Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
            Long categorie_id = categorie.getId();

            //CREATE INGREDIENT
            Ingredient ingredient = new Ingredient();
            ingredient.setName(name);
            ingredient.setPrice(price);
            ingredient.setUnit_id(unit_id);
            ingredient.setQuantity(quantity);
            ingredient.setMinimum(minimum);
            ingredient.setCategorie_id(categorie_id);
            ingredient.setRoute_image(image_route);
            ingredient.setAmenitie(false);
            return ingredient;
        }

        private void insertIngredient() {
            IngredientModel model = new IngredientModel();
            if (validateRequest()) {
                Ingredient ingredient = createIngredient();
                model.insert(ingredient, true);
            }
        }

        @Override
        public void run() {
            this.insertIngredient();
        }
    }

    class InsertAmenitie extends Thread {

        private Ingredient createIngredient() {
            String name = view.txtName.getText();
            Long price = (Long) view.txtPrice.getValue();
            Unit unit = (Unit) view.cbUnit.getSelectedItem();
            Long unit_id = unit.getId();
            Long quantity = (Long) view.txtStock.getValue();
            Long minimum = (Long) view.txtMinimum.getValue();
            Categorie categorie = (Categorie) view.cbCategorie.getSelectedItem();
            Long categorie_id = categorie.getId();

            //CREATE INGREDIENT
            Ingredient ingredient = new Ingredient();
            ingredient.setName(name);
            ingredient.setPrice(price);
            ingredient.setUnit_id(unit_id);
            ingredient.setQuantity(quantity);
            ingredient.setMinimum(minimum);
            ingredient.setCategorie_id(categorie_id);
            ingredient.setAmenitie(true);
            ingredient.setRoute_image("");
            if (view.chAmenitie.isSelected()) {
                ingredient.setAmenitie(true);
            }
            return ingredient;
        }

        private boolean validateRequest() {
            String name = view.txtName.getText();
            if (name.isBlank() || name.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        private void insertIngredient() {
            IngredientModel model = new IngredientModel();
            if (validateRequest()) {
                Ingredient ingredient = createIngredient();
                model.insert(ingredient, true);
            }
        }

        @Override
        public void run() {
            this.insertIngredient();
        }
    }
}
