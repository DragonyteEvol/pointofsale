/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import pointofsale.models.EventModel;
import pointofsale.objects.Event;
import pointofsale.views.modal.NewEventView;

/**
 *
 * @author dragonyte
 */
public class NewEventController implements ActionListener{
    private NewEventView view;

    public NewEventController() {
        this.view = new NewEventView(null, true);
        
        view.btnDelete.setVisible(false);
        view.btnSave.addActionListener(this);
        
        view.setResizable(false);
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
                eventModel.insert(event);
                view.dispose();
            }
        }
    }
}
