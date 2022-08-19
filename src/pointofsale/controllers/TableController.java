/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardTableController;
import pointofsale.controllers.modal.NewTableController;
import pointofsale.models.TableModel;
import pointofsale.objects.Table;
import pointofsale.views.sell.TableView;

/**
 *
 * @author dragonyte
 */
public class TableController extends Controller implements ActionListener{
    private TableView view;
    private JPanel panel;

    public TableController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.panel = panel;
        this.view = new TableView();
        setResources();
        panel.add(view,BorderLayout.CENTER);
        this.initEvents();
    }

    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
    }

    private void setResources(){
        TableModel tableModel = new TableModel();
        List<Table> tables = tableModel.selectAll();
        for(Table table : tables){
            CardTableController cardTableController = new CardTableController(this.view.pnTables,table);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source== this.view.btnCreate){
            NewTableController newTableController = new NewTableController();
            initComponents(this.panel);
        }
    }
}
