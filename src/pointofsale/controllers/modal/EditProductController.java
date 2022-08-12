/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pointofsale.controllers.components.CardIngredientInfoController;
import pointofsale.controllers.components.CardIngredientWhitManagerController;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.ProductModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Product;
import pointofsale.views.modal.AddIngredientProduct;
import pointofsale.views.modal.NewProductView;

/**
 *
 * @author dragonyte
 */
public class EditProductController implements ActionListener {

    private NewProductView view;
    private AddIngredientProduct secondView;
    private Product product;
    private Dimension dimension;
    private List<Ingredient> listQuatitys = new ArrayList<>();

    public EditProductController(Product product) {

        // view config
        this.view = new NewProductView(null, true);
        this.view.setResizable(false);
        this.product = product;

        dimension = view.getToolkit().getScreenSize();
        view.setSize(dimension.width / 2, dimension.height / 2);

        this.secondView = new AddIngredientProduct();

        //events
        this.view.btnNext.addActionListener(this);
        this.view.btnDelete.setVisible(false);
        this.secondView.btnSave.addActionListener(this);
        
        setInfo();

        //threads
        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbCategorie);
        setResourceThread.start();

        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(this.secondView, this.listQuatitys);
        secondResourceThread.start();

        this.view.setVisible(true);

    }
    
    private void setInfo(){
        this.view.txtTitle.setText("Editar producto");
        this.view.txtName.setText(product.getName());
        this.view.txtPrice.setValue(product.getPrice());
        this.view.txtTime.setValue(product.getTime());
    }

    private void changeView(JPanel panel) {
        panel.removeAll();
        this.secondView.setSize(dimension.width / 2, dimension.height / 2);
        panel.add(this.secondView);
        panel.revalidate();
        panel.repaint();
    }

    private boolean validateRequest(String name) {
        return !(name.isBlank() || name.isEmpty());
    }

    private Product createProduct(Product productv) {
        String name = this.view.txtName.getText();
        Integer price = (Integer) this.view.txtPrice.getValue();
        Integer time = (Integer) this.view.txtTime.getValue();
        Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
        Integer categorie_id = categorie.getId();
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
                this.product = createProduct(this.product);
                this.changeView(this.view.pnDinamic);
            } else {
                System.out.print("rellene los campos");
            }

        }
        if (source == this.secondView.btnSave) {
            UpdateThread updateThread = new UpdateThread(this.product, listQuatitys);
            updateThread.start();
            this.view.dispose();
        }
    }

    class UpdateThread extends Thread {

        private Product product;
        private List<Ingredient> listIngredients;

        public UpdateThread(Product product, List<Ingredient> listIngredients) {
            this.product = product;
            this.listIngredients = listIngredients;
        }

        @Override
        public void run() {
            ProductModel productModel = new ProductModel();
            productModel.update(product, listIngredients);
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
            
            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.selectRelProduct(product.getId());
            for(Ingredient ingredient : ingredients){
                listQuantitys.add(ingredient);
            }
            
            for(Ingredient ingredient : ingredients){
                CardIngredientInfoController card = new CardIngredientInfoController(listQuantitys, ingredient, view.pnInfo);
            }
        }

        @Override
        public void run() {
            setCategories();
        }
    }

}