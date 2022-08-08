/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.models.IngredientModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.InventoryView;

/**
 *
 * @author dragonyte
 */
public class InventoryController extends Controller implements ActionListener,FocusListener {

    private InventoryView view;
    private JTable inventoryTable;

    public InventoryController(JPanel panel) {
        this.view = new InventoryView();
        initEvents();
        construcTable("");

        this.addView(this.view, panel);
    }
    
    private void initEvents(){
        this.view.txtSearch.addFocusListener(this);
        
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
    
    private void construcTable(String search){
        String rowTitle[]={"Nombre","Precio","Cantidad","Unidad","Creado"};
        String arrayData[][] = modelTable(search);
        
        inventoryTable = new JTable(arrayData,rowTitle);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(inventoryTable);
        view.pnTable.removeAll();
        view.pnTable.add(scrollPane);
        view.pnTable.repaint();
        view.pnTable.revalidate();
    }

    private String[][] modelTable(String search) {
        IngredientModel ingredientModel = new IngredientModel();
        List<Ingredient> ingredients = ingredientModel.search(search);

        String arrayData[][] = new String[ingredients.size()][5];

        for (int i = 0; i < ingredients.size(); i++) {
            arrayData[i][0] = ingredients.get(i).getName() + "";
            arrayData[i][1] = ingredients.get(i).getPrice()+ "";
            arrayData[i][2] = ingredients.get(i).getQuantity()+ "";
            arrayData[i][3] = ingredients.get(i).getUnit()+ "";
            arrayData[i][4] = ingredients.get(i).getCreated_at()+ "";
        }
        
        return arrayData;
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

}
