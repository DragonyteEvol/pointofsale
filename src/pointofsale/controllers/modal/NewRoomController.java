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
import javax.swing.JComboBox;
import pointofsale.controllers.ModalController;
import pointofsale.models.CategorieModel;
import pointofsale.models.RoomModel;
import pointofsale.objects.Categorie;
import pointofsale.objects.Room;
import pointofsale.views.modal.NewRoomView;

/**
 *
 * @author dragonyte
 */
public class NewRoomController extends ModalController implements ActionListener,FocusListener {

    private NewRoomView view;

    public NewRoomController() {
        this.view = new NewRoomView(null, true);
        this.view.setLocationRelativeTo(null);
//clic
        this.view.btnSave.addActionListener(this);
        //Focus
        this.view.txtDescription.addFocusListener(this);
        this.view.btnRemove.setVisible(false);

        SetResource setResource = new SetResource(this.view.cbCategorie);
        setResource.start();

        this.view.setVisible(true);
    }

    public boolean validRequest(Long capacity, Long price) {
        if (capacity <= 0 || price <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public Room createRoom(Long price, Long capacity, String description, Categorie categorie) {
        Room room_n = new Room();
        room_n.setCapacity(capacity);
        room_n.setRoute_image("");
        room_n.setDescription(description);
        room_n.setPrice(price);
        room_n.setCategorie_id(categorie.getId());
        return room_n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            Long price = Long.valueOf(String.valueOf(this.view.txtPrice.getValue()));
            Long capacity = Long.valueOf(String.valueOf(this.view.txtCapacity.getValue()));
            if (validRequest(capacity, price)) {
                String description = this.view.txtDescription.getText();
                Categorie categorie = (Categorie) this.view.cbCategorie.getSelectedItem();
                InsertThread insertThread = new InsertThread(createRoom(price, capacity, description, categorie));
                insertThread.start();
                this.view.dispose();
            }
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

    class SetResource extends Thread {

        private JComboBox<Object> cbCategorie;

        public SetResource(JComboBox<Object> cbCategorie) {
            this.cbCategorie = cbCategorie;
        }

        private void setResource() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectCategoriesRooms();
            for (Categorie categorie : categories) {
                this.cbCategorie.addItem(categorie);
            }
        }

        @Override
        public void run() {
            setResource();
        }
    }

    
    class InsertThread extends Thread {
        
        private Room room;

        public InsertThread(Room room) {
            this.room = room;
        }
        
        

        private void insertRoom() {
            RoomModel roomModel = new RoomModel();
            roomModel.insert(room);
        }

        @Override
        public void run() {
            insertRoom();
        }
    }
    
}
