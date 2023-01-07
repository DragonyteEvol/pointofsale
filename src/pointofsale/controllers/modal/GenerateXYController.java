/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import pointofsale.MoneyConverter;
import pointofsale.controllers.PrintFunctions;
import pointofsale.models.BillModel;
import pointofsale.models.InventoryModel;
import pointofsale.objects.Atm;
import pointofsale.objects.Bill;
import pointofsale.objects.BillRestock;
import pointofsale.views.components.FormatXYView;
import pointofsale.views.components.XView;
import pointofsale.views.modal.ConfirmDeleteView;
import pointofsale.views.modal.GenerateXYView;

/**
 *
 * @author sebastian.yanez
 */
public class GenerateXYController implements ActionListener{

    private GenerateXYView view;
    private ConfirmDeleteView confirmDeleteView;
    private FormatXYView formatView;
    
    public GenerateXYController() {
        this.view = new GenerateXYView(null,true);
        this.confirmDeleteView = new ConfirmDeleteView(null, true);
        
        this.formatView = new FormatXYView(null, true);
        this.view.setLocationRelativeTo(null);
        this.confirmDeleteView.setLocationRelativeTo(null);

        this.view.btnAcept.addActionListener(this);
        this.view.btnCancel.addActionListener(this);
        this.view.rbX.addActionListener(this);
        this.view.rbY.addActionListener(this);
        this.confirmDeleteView.btnNo.addActionListener(this);
        this.confirmDeleteView.btnYes.addActionListener(this);

        this.view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.rbX){
            this.view.rbX.setSelected(true);
            this.view.rbY.setSelected(false);
        }
        if(source==this.view.rbY){
            this.view.rbY.setSelected(true);
            this.view.rbX.setSelected(false);
        }
        if(source==this.view.btnCancel){
            this.view.dispose();
        }
        if(source==this.view.btnAcept){
            if(this.view.rbX.isSelected()){
                final String message = "Desea continuar?, Se borran los datos referentes al dia de hoy, se eliminara informacion de propinas y tambien se asginara un valor de 500.000 pesos en la caja registradora";
                final String html = "<html><body style='width: %1spx'>%1s";
                confirmDeleteView.txtMessage.setText(String.format(html, 200,message));
                confirmDeleteView.setVisible(true);
            }else{
                GenerateY generateY = new GenerateY();
                generateY.start();
                view.dispose();
            }
        }
        if(source==this.confirmDeleteView.btnNo){
            confirmDeleteView.dispose();
            this.view.dispose();
        }
        if(source==this.confirmDeleteView.btnYes){
            GenerateX generateX = new GenerateX();
            generateX.start();
            confirmDeleteView.dispose();
            view.dispose();
        }
    }
    
    class GenerateX extends Thread{
        public void run(){
            BillModel billModel = new BillModel();
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            Long sum = Long.valueOf(0);
            List<Bill> bills = billModel.generateY();
            for(Bill bill : bills){
                XView xView = new XView(bill.getDescription(), bill.getTotal());
                formatView.pnBill.add(xView);
                sum += bill.getTotal();
            }
            billModel= new BillModel();
            BillRestock billLost = billModel.getLostDay();
            Long total = sum - billLost.getPrice();
            formatView.txtDate.setText(timeStamp);
            formatView.txtType.setText("FORMATO X");
            formatView.txtLost.setText(MoneyConverter.convertDouble(billLost.getPrice()));
            formatView.txtSum.setText(MoneyConverter.convertDouble(sum));
            formatView.txtTotal.setText(MoneyConverter.convertDouble(total));
            formatView.setVisible(true);
            //IMPRIMIR
            PrintFunctions pf = new PrintFunctions();
            pf.print(formatView.pnBase);
            //ATM
            InventoryModel inventoryModel = new InventoryModel();
            Atm atm = inventoryModel.selectAtm();
            atm.setValue(Long.valueOf(500000));
            inventoryModel = new InventoryModel();
            inventoryModel.updateAtm(atm);
            
            //DELETE TABLE
            System.out.println("Incio");
            billModel = new BillModel();
            billModel.deleteCurrentDay();
            System.err.println("Final");
            
        }
    }
   
    
    class GenerateY extends Thread{
        public void run(){
            BillModel billModel = new BillModel();
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            Long sum = Long.valueOf(0);
            List<Bill> bills = billModel.generateY();
            for(Bill bill : bills){
                XView xView = new XView(bill.getDescription(), bill.getTotal());
                formatView.pnBill.add(xView);
                sum += bill.getTotal();
            }
            billModel= new BillModel();
            BillRestock billLost = billModel.getLostDay();
            Long total = sum - billLost.getPrice();
            formatView.txtDate.setText(timeStamp);
            formatView.txtType.setText("FORMATO Y");
            formatView.txtLost.setText(MoneyConverter.convertDouble(billLost.getPrice()));
            formatView.txtSum.setText(MoneyConverter.convertDouble(sum));
            formatView.txtTotal.setText(MoneyConverter.convertDouble(total));
            formatView.setVisible(true);
            
            //IMPRIMIR
            PrintFunctions pf = new PrintFunctions();
            pf.print(formatView.pnBase);
            
        }
    }
}
