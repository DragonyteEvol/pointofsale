/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.EventModel;
import pointofsale.objects.Event;
import pointofsale.views.modal.NewEventView;

/**
 *
 * @author dragonyte
 */
public class EditEventController implements ActionListener {

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

        view.setResizable(false);
        view.setVisible(true);

    }

    private boolean validateRequest(String name, String description, Integer price) {
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
            Integer price = Integer.parseInt(String.valueOf(view.txtPrice.getValue()));
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
