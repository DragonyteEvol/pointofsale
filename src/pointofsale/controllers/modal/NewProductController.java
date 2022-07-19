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
import pointofsale.controllers.Controller;
import pointofsale.controllers.components.CardIngredientController;
import pointofsale.models.CategorieModel;
import pointofsale.models.IngredientModel;
import pointofsale.models.ProductModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.IngredientUnit;
import pointofsale.objects.Product;
import pointofsale.views.modal.AddIngredientProduct;
import pointofsale.views.modal.NewProductView;

/**
 *
 * @author dragonyte
 */
public class NewProductController extends Controller implements ActionListener {

    private NewProductView view;
    private AddIngredientProduct secondView;
    private Product product;
    private Dimension dimension;
    private List<IngredientUnit> listQuatitys=new ArrayList<>();

    public NewProductController() {

        // view config
        this.view = new NewProductView(null, true);
        this.view.setResizable(false);

        dimension = view.getToolkit().getScreenSize();
        view.setSize(dimension.width / 2, dimension.height / 2);

        this.secondView = new AddIngredientProduct();

        //events
        this.view.btnNext.addActionListener(this);
        this.secondView.btnSave.addActionListener(this);

        //threads
        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbCategorie);
        setResourceThread.start();

        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(this.secondView,this.listQuatitys);
        secondResourceThread.start();

        this.view.setVisible(true);

    }

    private void changeView(JPanel panel) {
        panel.removeAll();
        this.secondView.setSize(dimension.width / 2, dimension.height / 2);
        panel.add(this.secondView);
        panel.revalidate();
        panel.repaint();
    }

    private boolean validateRequest(String name) {
        if (name.isBlank() || name.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private Product createProduct() {
        String name = this.view.txtName.getText();
        Double price = Double.valueOf((Integer) this.view.txtPrice.getValue());
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
                this.changeView(this.view.pnDinamic);
            } else {
                System.out.print("rellene los campos");
            }

        }
        if (source == this.secondView.btnSave) {
            InsertThread insertThread = new InsertThread(this.product, listQuatitys);
            insertThread.start();
        }
    }

    class InsertThread extends Thread {

        private Product product;
        private List<IngredientUnit> listIngredients;

        public InsertThread(Product product, List<IngredientUnit> listIngredients) {
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
        private List<IngredientUnit> listQuantitys;

        public SetSecondResourceThread(AddIngredientProduct view,List<IngredientUnit> listQuantitys) {
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
                List<IngredientUnit> ingredients = ingredientModel.selectIngredientUnit(where);
                for (IngredientUnit ingredient : ingredients) {
                    CardIngredientController cardIngredientController = new CardIngredientController(ingredient, panel, this.view.pnInfo,this.listQuantitys);
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

    
}
