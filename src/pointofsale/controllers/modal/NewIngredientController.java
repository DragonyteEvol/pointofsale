/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import pointofsale.controllers.ModalController;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.UnitModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.MovementInventory;
import pointofsale.objects.Unit;
import pointofsale.views.modal.NewIngredientView;

/**
 *
 * @author dragonyte
 */
public class NewIngredientController extends ModalController implements ActionListener {

    private NewIngredientView view;

    public NewIngredientController() {

        // view config
        this.view = new NewIngredientView(null, true);
        this.view.setResizable(false);

        //events
        this.view.btnSave.addActionListener(this);

        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbUnit, this.view.cbCategorie);
        setResourceThread.start();
        this.view.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            InsertThread insertThread = new InsertThread(this.view);
            insertThread.start();
        }
    }

    class SetResourceThread extends Thread {

        private JComboBox<String> cbUnit;
        private JComboBox<String> cbCategorie;

        public SetResourceThread(JComboBox<String> cbUnit, JComboBox<String> cbCategorie) {
            this.cbUnit = cbUnit;
            this.cbCategorie = cbCategorie;
        }

        private void setUnits() {
            UnitModel unitModel = new UnitModel();
            List<Unit> units = unitModel.selectAll();
            for (Unit unit : units) {
                this.cbUnit.addItem(unit.getName());
            }
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesIngredients();
            for (Categorie categorie : categories) {
                this.cbCategorie.addItem(categorie.getName());
            }
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
            Double price = Double.valueOf((Integer) this.view.txtPrice.getValue());
            Integer unit_id = this.view.cbUnit.getSelectedIndex() + 1;
            Double quantity = Double.valueOf((Integer) this.view.txtStock.getValue());
            Double minimum = Double.valueOf((Integer) this.view.txtMinimum.getValue());
            Integer categorie_id = this.view.cbCategorie.getSelectedIndex() + 1;
            
            //CREATE INGREDIENT
            Ingredient ingredient = new Ingredient();
            ingredient.setName(name);
            ingredient.setPrice(price);
            ingredient.setUnit_id(unit_id);
            ingredient.setQuantity(quantity);
            ingredient.setMinimum(minimum);
            ingredient.setCategorie_id(categorie_id);
            ingredient.setRoute_image("");
            return ingredient;
        }
        
       

        private void insertIngredient() {
            IngredientModel model = new IngredientModel();
            if (validateRequest()) {
                Ingredient ingredient = createIngredient();
                model.insert(ingredient,true);
            }
        }

        @Override
        public void run() {
            this.insertIngredient();
            this.view.dispose();
        }
    }
}
