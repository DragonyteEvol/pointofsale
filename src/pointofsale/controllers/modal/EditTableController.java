/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.TableModel;
import pointofsale.objects.Table;
import pointofsale.views.modal.NewTableView;

/**
 *
 * @author dragonyte
 */
public class EditTableController implements ActionListener{
    
    private NewTableView view;
    private Table table;
    public boolean removed=false;
    
     public EditTableController(Table table) {
        this.view = new NewTableView(null, true);
        this.view.setLocationRelativeTo(null);
        this.table = table;

        this.view.btnSave.addActionListener(this);
        this.view.btnRemove.addActionListener(this);
        this.view.btnEvent.addActionListener(this);

        setInfo();
        
        this.view.setVisible(true);
    }
     
    private void setInfo(){
        this.view.txtTitle.setText("Editar mesa " + String.valueOf(table.getId()));
        this.view.txtCapacity.setValue(table.getCapacity());
        this.view.txtPrice.setValue(table.getPrice());
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
                        System.out.print("ok");

            Integer price =Integer.parseInt(String.valueOf(this.view.txtPrice.getValue()));
            if(validRequest(capacity)){
                table.setCapacity(capacity);
                table.setPrice(price);
                UpdateThread insertThread = new UpdateThread(table);
                insertThread.start();
                this.view.dispose();
            }
        }
        
        if(source == this.view.btnRemove){
            RemoveThread removeThread = new RemoveThread(table);
            removeThread.start();
            removed=true;
            this.view.dispose();
        }
        if (source == this.view.btnEvent) {
            NewEventController nec = new NewEventController(table);
            this.view.dispose();
        }
    }

    class UpdateThread extends Thread {

        private Table table;

        public UpdateThread(Table table) {
            this.table = table;
        }

        private void updateTable() {
            TableModel tableModel = new TableModel();
            tableModel.update(table);
        }

        @Override
        public void run() {
            updateTable();
        }
    }
    
    class RemoveThread extends Thread {

        private Table table;

        public RemoveThread(Table table) {
            this.table = table;
        }

        private void removeTable() {
            TableModel tableModel = new TableModel();
            tableModel.remove(table);
        }

        @Override
        public void run() {
            removeTable();
        }
    }
    
}
