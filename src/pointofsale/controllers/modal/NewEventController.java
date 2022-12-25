/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import pointofsale.models.EventModel;
import pointofsale.models.TableModel;
import pointofsale.objects.Event;
import pointofsale.objects.Table;
import pointofsale.views.modal.NewEventView;

/**
 *
 * @author dragonyte
 */
public class NewEventController implements ActionListener,FocusListener{
    private NewEventView view;
    private Table table;

    public NewEventController(Table table) {
        this.view = new NewEventView(null, true);
        this.table = table;
        view.btnDelete.setVisible(false);
        //EVENTS
        view.btnSave.addActionListener(this);
        //FOCUS
        view.txtName.addFocusListener(this);
        view.txtDescription.addFocusListener(this);
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    private boolean validateRequest(String name,String description,Integer price){
        return !(name.isBlank() || description.isBlank() || price==null || price < 0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        System.out.print(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(view.txtDate.getDate()));
        if(source == view.btnSave){
            String name = view.txtName.getText();
            String description = view.txtDescription.getText();
            Integer price = Integer.valueOf(String.valueOf(view.txtPrice.getValue()));
            if(validateRequest(name, description, price)){
                EventModel eventModel = new EventModel();
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                Event event = new Event(null, name, description,timeStamp, "", price, true, null);
                eventModel.insert(event,table);
                view.dispose();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
        if(source==this.view.txtDescription){
            this.view.txtDescription.selectAll();
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
