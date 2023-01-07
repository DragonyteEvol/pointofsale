/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import pointofsale.views.additional.FileSelector;
import pointofsale.views.modal.AddIngredientProduct;
import pointofsale.views.modal.NewProductView;

/**
 *
 * @author dragonyte
 */
public class EditProductController implements ActionListener,FocusListener {

    private NewProductView view;
    private AddIngredientProduct secondView;
    private Product product;
    private Dimension dimension;
    private List<Ingredient> listQuatitys = new ArrayList<>();
    private FileSelector selectorView;

    public EditProductController(Product product) {

        // view config
        this.view = new NewProductView(null, true);
        this.view.setLocationRelativeTo(null);
        this.selectorView = new FileSelector(null, true);
        this.product = product;
        
        Dimension dimension = view.getToolkit().getScreenSize();

        selectorView.setSize(dimension.width / 2, dimension.height / 2);
        selectorView.setLocationRelativeTo(null);

        selectorView.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        

        this.secondView = new AddIngredientProduct();

        //events
        this.view.btnNext.addActionListener(this);
        this.view.btnImage.addActionListener(this);
        this.view.btnDelete.setVisible(false);
        this.secondView.btnSave.addActionListener(this);
        selectorView.fileChooser.addActionListener(this);
         //FOCUS
        this.view.txtName.addFocusListener(this);
        this.view.txtImage.addFocusListener(this);
        

        setInfo();

        //threads
        SetResourceThread setResourceThread = new SetResourceThread(this.view.cbCategorie);
        setResourceThread.start();

        SetSecondResourceThread secondResourceThread = new SetSecondResourceThread(this.secondView, this.listQuatitys);
        secondResourceThread.start();

        this.view.setVisible(true);

    }

    private void setInfo() {
        this.view.txtTitle.setText("Editar producto");
        this.view.txtName.setText(product.getName());
        this.view.txtPrice.setValue(product.getPrice());
        this.view.txtTime.setValue(product.getTime());
        this.view.txtImage.setText(product.getRoute_image());
    }

    private void changeView(JPanel panel) {
        panel.removeAll();
        panel.add(this.secondView);
        panel.revalidate();
        panel.repaint();
    }

    private boolean validateRequest(String name) {
        return !(name.isBlank() || name.isEmpty());
    }

    private Product createProduct(Product productv) {
        String name = this.view.txtName.getText();
        Long price = Long.valueOf(String.valueOf(this.view.txtPrice.getValue()));
        Long time = Long.valueOf(String.valueOf(this.view.txtTime.getValue()));
        Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
        String route_image = this.view.txtImage.getText();
        Long categorie_id = categorie.getId();
        productv.setName(name);
        productv.setPrice(price);
        productv.setTime(time);
        productv.setCategorie_id(categorie_id);
        productv.setRoute_image(route_image);
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
        if(source == this.view.txtImage){
            this.view.txtImage.selectAll();
        }
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
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
                JButton button1 = new JButton(categorie.getName());
                button1.setBackground(Color.BLUE);
                button1.setForeground(Color.WHITE);
                view.pnCategories.add(button1);
                view.pnCategories.repaint();
                view.pnCategories.revalidate();
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        IngredientModel ingredientModel = new IngredientModel();
                        String where = " categorie_id=" + categorie.getId();
                        List<Ingredient> ingredients = ingredientModel.selectIngredientUnit(where);
                        view.pnIngredients.removeAll();
                        view.pnIngredients.repaint();
                        view.pnIngredients.revalidate();
                        for (Ingredient ingredient : ingredients) {
                            CardIngredientWhitManagerController cardIngredientController = new CardIngredientWhitManagerController(ingredient, view.pnIngredients, view.pnInfoo, listQuantitys);
                        }
                    }
                });
            }
        }

        private void setIngredients() {
            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.selectAll();
            for (Ingredient ingredient : ingredients) {
                CardIngredientWhitManagerController cardIngredientController = new CardIngredientWhitManagerController(ingredient, view.pnIngredients, view.pnInfoo, listQuantitys);
                view.pnIngredients.repaint();
                view.pnIngredients.revalidate();
            }
        }

        private void setInfoProduct() {
            IngredientModel ingredientModel = new IngredientModel();
            List<Ingredient> ingredients = ingredientModel.selectRelProduct(product.getId());
            for (Ingredient ingredient : ingredients) {
                listQuantitys.add(ingredient);
            }

            for (Ingredient ingredient : ingredients) {
                CardIngredientInfoController card = new CardIngredientInfoController(listQuantitys, ingredient, view.pnInfoo);
            }
        }


        @Override
        public void run() {
            setCategories();
            setInfoProduct();
            setIngredients();
        }
    }

}
