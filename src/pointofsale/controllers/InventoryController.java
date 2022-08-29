/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.MoneyConverter;
import pointofsale.models.IngredientModel;
import pointofsale.models.InventoryModel;
import pointofsale.objects.Ingredient;
import pointofsale.objects.MovementInventory;
import pointofsale.views.inventory.InventoryView;

/**
 *
 * @author dragonyte
 */
public class InventoryController extends Controller implements ActionListener, FocusListener, MouseListener {

    private InventoryView view;
    private JTable inventoryTable;
    private List<MovementInventory> movementInventorys;
    List<Ingredient> ingredients;
    
    public InventoryController(JPanel panel) {
        this.view = new InventoryView();
        SearchThread st = new SearchThread("");
        st.start();

        

        panel.add(view);
    }

    private void initEvents() {
        this.view.txtSearch.addFocusListener(this);
        inventoryTable.addMouseListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                String search = view.txtSearch.getText();
                construcTable(search);
            }

            public void insertUpdate(DocumentEvent e) {
                String search = view.txtSearch.getText();
                construcTable(search);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    private void construcTable(String search) {
        String rowTitle[] = {"id", "Nombre", "Precio", "Cantidad", "Unidad", "Creado"};
        String arrayData[][] = modelTable(search);

        inventoryTable = new JTable(arrayData, rowTitle);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(inventoryTable);
        view.pnTable.removeAll();
        view.pnTable.add(scrollPane);
        view.pnTable.repaint();
        view.pnTable.revalidate();
    }

    private String[][] modelTable(String search) {
        IngredientModel ingredientModel = new IngredientModel();
        ingredients = ingredientModel.search(search);

        String arrayData[][] = new String[ingredients.size()][6];

        for (int i = 0; i < ingredients.size(); i++) {
            arrayData[i][0] = ingredients.get(i).getId() + "";
            arrayData[i][1] = ingredients.get(i).getName() + "";
            arrayData[i][2] = MoneyConverter.convertDouble(ingredients.get(i).getPrice()) + "";
            arrayData[i][3] = ingredients.get(i).getQuantity() + "";
            arrayData[i][4] = ingredients.get(i).getUnit() + "";
            arrayData[i][5] = ingredients.get(i).getCreated_at() + "";
        }
        setIngredient(ingredients.get(0));
        return arrayData;
    }
    
    private void setIngredient(Ingredient ingredient){
        view.txtName.setText(ingredient.getName());
        view.txtQuanity.setText(ingredient.getQuantity()+"");
        view.txtUnit.setText(ingredient.getUnit()+"");
        view.txtCategorie.setText(ingredient.getCategorie()+"");
         if (!"".equals(ingredient.getRoute_image())) {
            ImageIcon icon = new ImageIcon(ingredient.getRoute_image());
            Image img = icon.getImage();
            Image img_r = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img_r);
            view.txtImage.setIcon(icon);
        }
        InventoryModel inventoryModel = new InventoryModel();
        movementInventorys=inventoryModel.getMovementInventory(ingredient.getId());
        
        String arrayData[][] = new String[movementInventorys.size()][3];

        for (int i = 0; i < movementInventorys.size(); i++) {
            arrayData[i][0] = movementInventorys.get(i).getQuantity()+ "";
            arrayData[i][1] = movementInventorys.get(i).isAddition()+ "";
            arrayData[i][2] = movementInventorys.get(i).getCreated_at()+ "";
        }
        
        String rowTitle[] = {"Cantidad","Adicion","Fecha"};

        JTable movementTable = new JTable(arrayData, rowTitle);
        view.pnMovementTable.removeAll();
        view.pnMovementTable.add(movementTable.getTableHeader(),BorderLayout.NORTH);
        view.pnMovementTable.add(movementTable,BorderLayout.CENTER);
        view.pnMovementTable.repaint();
        view.pnMovementTable.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object source = fe.getSource();
        if (source == view.txtSearch) {
            view.txtSearch.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        SetIngredient si = new SetIngredient();
        si.start();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    class SearchThread extends Thread{
        
        private String search;

        public SearchThread(String search) {
            this.search = search;
        }
        
        @Override
        public void run(){
            construcTable(search);
            initEvents();
        }
    }
    
    class SetIngredient extends Thread{
        @Override
        public void run(){
            int number_row = inventoryTable.getSelectedRow();
            setIngredient(ingredients.get(number_row));
        }
    }
}
