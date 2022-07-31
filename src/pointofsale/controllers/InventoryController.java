/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import pointofsale.models.IngredientModel;
import pointofsale.objects.Ingredient;
import pointofsale.views.inventory.InventoryView;

/**
 *
 * @author dragonyte
 */
public class InventoryController extends Controller implements ActionListener {

    private InventoryView view;
    private JTable inventoryTable;

    public InventoryController(JPanel panel) {
        this.view = new InventoryView();
        construcTable();

        this.addView(this.view, panel);
    }
    
    private void construcTable(){
        String rowTitle[]={"Nombre","Precio","Cantidad","Unidad","Creado"};
        String arrayData[][] = modelTable();
        
        inventoryTable = new JTable(arrayData,rowTitle);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(inventoryTable);
        view.pnTable.add(scrollPane);
    }

    private String[][] modelTable() {
        IngredientModel ingredientModel = new IngredientModel();
        List<Ingredient> ingredients = ingredientModel.selectUnitQuantity();

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

}
