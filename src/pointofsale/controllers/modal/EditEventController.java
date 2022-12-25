/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pointofsale.models.EventModel;
import pointofsale.objects.Event;
import pointofsale.views.modal.NewEventView;

/**
 *
 * @author dragonyte
 */
public class EditEventController implements ActionListener,FocusListener {

    private NewEventView view;
    private Event event;

    public EditEventController(Event event) {
        this.view = new NewEventView(null, true);
        this.event = event;

        view.txtTitle.setText("Editar evento");
        view.txtDescription.setText(event.getDescription());
        view.txtName.setText(event.getName());
        view.txtPrice.setValue(event.getPrice());

        view.btnDelete.addActionListener(this);
        view.btnSave.addActionListener(this);
        //FOCUS
        view.txtName.addFocusListener(this);
        view.txtDescription.addFocusListener(this);

        view.setLocationRelativeTo(null);
        view.setVisible(true);

    }

    private boolean validateRequest(String name, String description, Long price) {
        return !(name.isBlank() || description.isBlank() || price == null || price < 0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnDelete) {
            DeleteEvent deleteEvent = new DeleteEvent();
            deleteEvent.start();
            view.dispose();
        }

        if (source == view.btnSave) {
            UpdateEvent updateEvent = new UpdateEvent();
            updateEvent.start();
            view.dispose();
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

    class DeleteEvent extends Thread {

        private void deleteEvent() {
            EventModel eventModel = new EventModel();
            eventModel.delete(event);
        }

        @Override
        public void run() {
            deleteEvent();
        }
    }

    class UpdateEvent extends Thread {

        private void updateEvent() {
            String name = view.txtName.getText();
            String description = view.txtDescription.getText();
            Long price = Long.valueOf(String.valueOf(view.txtPrice.getValue()));
            if (validateRequest(name, description, price)) {
                event.setName(name);
                event.setDescription(description);
                event.setPrice(price);
            }
        }

        @Override
        public void run() {
            EventModel eventMode = new EventModel();
            updateEvent();
            eventMode.update(event);

        }
    }

}
