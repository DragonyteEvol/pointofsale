/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.controllers.ModalController;
import pointofsale.models.TableModel;
import pointofsale.objects.Table;
import pointofsale.views.modal.NewTableView;

/**
 *
 * @author dragonyte
 */
public class NewTableController extends ModalController implements ActionListener {

    private NewTableView view;

    public NewTableController() {
        this.view = new NewTableView(null, true);
        this.view.setLocationRelativeTo(null);

        this.view.btnSave.addActionListener(this);
        this.view.btnRemove.setVisible(false);

        this.view.setVisible(true);
    }

    public boolean validRequest(Integer capacity) {
        if (capacity <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            Integer capacity =(Integer) this.view.txtCapacity.getValue();
            Integer price =(Integer) this.view.txtPrice.getValue();
            if(validRequest(capacity)){
                InsertThread insertThread = new InsertThread(price, capacity);
                insertThread.start();
                this.view.dispose();
            }
        }
    }

    class InsertThread extends Thread {

        private Table table;

        public InsertThread(Integer price, Integer capacity) {
            Table table = new Table(null, capacity, price, null);
            this.table = table;
        }

        private void insertTable() {
            TableModel tableModel = new TableModel();
            tableModel.insert(table);
        }

        @Override
        public void run() {
            insertTable();
        }
    }

}
