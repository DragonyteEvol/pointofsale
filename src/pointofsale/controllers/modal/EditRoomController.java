/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JComboBox;
import pointofsale.models.CategorieModel;
import pointofsale.models.RoomModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Room;
import pointofsale.views.modal.NewRoomView;

/**
 *
 * @author dragonyte
 */
public class EditRoomController implements ActionListener,FocusListener {

    private NewRoomView view;
    private Room room;
    public boolean removed=false;

    public EditRoomController(Room room) {
        this.view = new NewRoomView(null, true);
        this.view.setLocationRelativeTo(null);
        this.room = room;

        this.view.btnSave.addActionListener(this);
        this.view.btnRemove.addActionListener(this);
        //Focus
        this.view.txtDescription.addFocusListener(this);

        setInfo();
        SetResource setResource = new SetResource(this.view.cbCategorie, room);
        setResource.start();

        this.view.setVisible(true);
    }

    private void setInfo(){
        this.view.txtCapacity.setValue(room.getCapacity());
        this.view.txtDescription.setText(room.getDescription());
        this.view.txtPrice.setValue(room.getPrice());
        this.view.txtTitle.setText("Editar habitacion "+ String.valueOf(room.getId()));
    }
    
    public boolean validRequest(Integer capacity, Integer price) {
        if (capacity <= 0 || price <= 0) {
            return false;
        } else {
            return true;
        }
    }
    
     @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtDescription){
            this.view.txtDescription.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            Integer price = Integer.parseInt(String.valueOf(this.view.txtPrice.getValue()));
            Integer capacity = (Integer) this.view.txtCapacity.getValue();
            if (validRequest(capacity, price)) {
                String description = this.view.txtDescription.getText();
                Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
                UpdateThread updateThread = new UpdateThread(room,price, capacity, description, categorie);
                updateThread.start();
                this.view.dispose();
            }
        }
        
        if(source == this.view.btnRemove){
            RemoveThread removeThread = new RemoveThread(room);
            removeThread.start();
            removed = true;
            this.view.dispose();
        }
    }

    class SetResource extends Thread {

        private JComboBox<Object> cbCategorie;
        private Room room;

        public SetResource(JComboBox<Object> cbCategorie, Room room) {
            this.cbCategorie = cbCategorie;
            this.room = room;
        }

        private void setResource() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesRooms();
            for (Categorie categorie : categories) {
                if (Objects.equals(categorie.getId(), room.getCategorie_id())) {
                    this.cbCategorie.addItem(categorie);
                    this.cbCategorie.setSelectedItem(categorie);
                } else {
                    this.cbCategorie.addItem(categorie);
                }

            }
        }

        @Override
        public void run() {
            setResource();
        }
    }

    class UpdateThread extends Thread {

        private Room room;

        public UpdateThread(Room room,Integer price, Integer capacity, String description, Categorie categorie) {
            room.setCapacity(capacity);
            room.setRoute_image("");
            room.setDescription(description);
            room.setPrice(price);
            room.setCategorie_id(categorie.getId());
            this.room = room;
        }

        private void updateRoom() {
            RoomModel roomModel = new RoomModel();
            roomModel.update(room);
        }

        @Override
        public void run() {
            updateRoom();
        }
    }
    
     class RemoveThread extends Thread {

        private Room room;

        public RemoveThread(Room room) {
            this.room = room;
        }

        private void removeRoom() {
            RoomModel roomModel = new RoomModel();
            roomModel.remove(room);
        }

        @Override
        public void run() {
            removeRoom();
        }
    }
}
