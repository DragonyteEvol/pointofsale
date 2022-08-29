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
public class TableController extends Controller implements ActionListener {

    private TableView view;
    private JPanel panel;

    public TableController(JPanel panel) {
        this.view = new TableView();
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {

        this.panel = panel;

        panel.add(view, BorderLayout.CENTER);
        
        setTables();
        this.initEvents();
    }

    private void setTables() {
        view.pnTables.removeAll();
        SetResource sr = new SetResource();
        sr.start();
    }

    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewTableController newTableController = new NewTableController();
            setTables();
        }
    }

    class SetResource extends Thread {

        private void setResources() {
            TableModel tableModel = new TableModel();
            List<Table> tables = tableModel.selectAll();
            for (Table table : tables) {
                CardTableController cardTableController = new CardTableController(view.pnTables, table);
                view.pnTables.repaint();
                view.pnTables.revalidate();
            }
        }

        @Override
        public void run() {
            setResources();
        }
    }
}
