/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pointofsale.controllers.Controller;
import pointofsale.controllers.components.CardIngredientWhitManagerController;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.ProductModel;
import pointofsale.models.UnitModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Product;
import pointofsale.objects.Unit;
import pointofsale.views.modal.AddIngredientProduct;
import pointofsale.views.modal.NewProductView;
import pointofsale.views.modal.PolimorphismView;

/**
 *
 * @author dragonyte
 */
public class NewProductController extends Controller implements ActionListener {

    private NewProductView view;
    private AddIngredientProduct secondView;
    private PolimorphismView thirdView;
    private Ingredient ingredientPolimorphism;
    private Product product;
    private Dimension dimension;
    private List<Ingredient> listQuatitys = new ArrayList<>();

    public NewProductController() {

        // view config
        this.view = new NewProductView(null, true);
        this.view.setResizable(false);

        dimension = view.getToolkit().getScreenSize();
        view.setSize(dimension.width / 2, dimension.height / 2);

        this.secondView = new AddIngredientProduct();
        this.thirdView = new PolimorphismView();

        //events
        this.view.btnNext.addActionListener(this);
        this.thirdView.btnSave.addActionListener(this);
        this.view.btnDelete.setVisible(false);
        this.secondView.btnSave.addActionListener(this);

        //threads
        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbCategorie);
        setResourceThread.start();

        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(this.secondView, this.listQuatitys);
        secondResourceThread.start();

        SetThirdResource setThirdResource = new SetThirdResource();
        setThirdResource.start();

        this.view.setVisible(true);

    }

    private void changeView(JPanel panel,Component component) {
        panel.removeAll();
        component.setSize(dimension.width / 2, dimension.height / 2);
        panel.add(component);
        panel.revalidate();
        panel.repaint();
    }

    private boolean validateRequest(String name) {
        return !(name.isBlank() || name.isEmpty());
    }
    
     private boolean validatePolimorphismRequest(Integer price,Integer required,Integer quantity,Integer minimum) {
        if(price==0 || required==0 || quantity==0 || minimum==0) {
            return false;
        } else {
            return true;
        }
    }


    private Product createProduct() {
        String name = this.view.txtName.getText();
        Integer price = (Integer) this.view.txtPrice.getValue();
        Integer time = (Integer) this.view.txtTime.getValue();
        Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
        Integer categorie_id = categorie.getId();
        Product productv = new Product();
        productv.setName(name);
        productv.setPrice(price);
        productv.setTime(time);
        productv.setCategorie_id(categorie_id);
        productv.setRoute_image("");
        return productv;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnNext) {

            if (validateRequest(this.view.txtName.getText())) {
                this.product = createProduct();
                if (view.chPolimorphism.isSelected()) {
                    this.changeView(this.view.pnDinamic,thirdView);
                } else {
                    this.changeView(this.view.pnDinamic,this.secondView);

                }
            } else {
                System.out.print("rellene los campos");
            }

        }
        if (source == this.secondView.btnSave) {
            InsertThread insertThread = new InsertThread(this.product, listQuatitys);
            insertThread.start();
        }
        
        if(source == this.thirdView.btnSave){
            Integer price = Integer.parseInt(String.valueOf(thirdView.txtPrice.getValue()));
            Integer required = Integer.parseInt(String.valueOf(thirdView.txtRequired.getValue()));
            Integer quantity = Integer.parseInt(String.valueOf(thirdView.txtQuantity.getValue()));
            Integer minimum = Integer.parseInt(String.valueOf(thirdView.txtMinimum.getValue()));
            if(validatePolimorphismRequest(price, required, quantity, minimum)){
                Categorie categorie = (Categorie) thirdView.cbCategorie.getSelectedItem();
                Unit unit = (Unit) thirdView.cbUnit.getSelectedItem();
                ingredientPolimorphism = new Ingredient(null, product.getName(), price, unit.getId(), categorie.getId(), quantity, minimum, "", null);
                InsertPolimorphis ip = new InsertPolimorphis(required);
                ip.start();
                view.dispose();
            }
        }
    }

    class InsertThread extends Thread {

        private Product product;
        private List<Ingredient> listIngredients;

        public InsertThread(Product product, List<Ingredient> listIngredients) {
            this.product = product;
            this.listIngredients = listIngredients;
        }

        @Override
        public void run() {
            ProductModel productModel = new ProductModel();
            productModel.insert(product, listIngredients);
        }
    }

    class SetResourceThread extends Thread {

        private JComboBox<Object> cbCategorie;

        public SetResourceThread(JComboBox<Object> cbCategorie) {
            this.cbCategorie = cbCategorie;
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesProducts();
            for (Categorie categorie : categories) {
                this.cbCategorie.addItem(categorie);
            }
        }

        @Override
        public void run() {
            setCategories();
        }
    }

    class SetSecondResourceThread extends Thread {

        private final AddIngredientProduct view;
        private List<Ingredient> listQuantitys;

        public SetSecondResourceThread(AddIngredientProduct view, List<Ingredient> listQuantitys) {
            this.view = view;
            this.listQuantitys = listQuantitys;
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();

            List<Categorie> categories = categorieModel.selectCategoriesIngredients();
            for (Categorie categorie : categories) {
                JScrollPane scrollPanel = new JScrollPane();
                JPanel panel = new JPanel();
                IngredientModel ingredientModel = new IngredientModel();
                String where = "ingredients.categorie_id=" + String.valueOf(categorie.getId());
                List<Ingredient> ingredients = ingredientModel.selectIngredientUnit(where);
                for (Ingredient ingredient : ingredients) {
                    CardIngredientWhitManagerController cardIngredientController = new CardIngredientWhitManagerController(ingredient, panel, this.view.pnInfo, this.listQuantitys);
                }
                scrollPanel.setViewportView(panel);
                this.view.tabbedPane.add(categorie.getName(), scrollPanel);
            }
        }

        @Override
        public void run() {
            setCategories();
        }
    }

    class SetThirdResource extends Thread {

        private void setUnits() {
            UnitModel unitModel = new UnitModel();
            List<Unit> units = unitModel.selectAll();
            for (Unit unit : units) {
                thirdView.cbUnit.addItem(unit);
            }
        }

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesIngredients();
            for (Categorie categorie : categories) {
                thirdView.cbCategorie.addItem(categorie);
            }
        }

        @Override
        public void run() {
            setCategories();
            setUnits();
        }
    }

    
    class InsertPolimorphis extends Thread {
        
        private Integer required;

        public InsertPolimorphis(Integer required) {
            this.required = required;
        }
        

        @Override
        public void run() {
            IngredientModel ingredientModel = new IngredientModel();
            ingredientModel.insertPolimorphism(product, ingredientPolimorphism,required);
        }
    }


    
}
