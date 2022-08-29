/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardRoomController;
import pointofsale.controllers.modal.NewRoomController;
import pointofsale.models.RoomModel;
import pointofsale.objects.Room;
import pointofsale.views.sell.RoomView;

/**
 *
 * @author dragonyte
 */
public class RoomController extends Controller implements ActionListener {

    private RoomView view;
    private JPanel panel;

    public RoomController(JPanel panel) {
        this.view = new RoomView();
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.panel = panel;
        
        panel.add(view, BorderLayout.CENTER);
        
        setRooms();
        this.initEvents();

    }

    private void setRooms() {
        view.pnRooms.removeAll();
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
            NewRoomController newRoomController = new NewRoomController();
            setRooms();
        }
    }

    class SetResource extends Thread {

        private void setResources() {
            RoomModel tableModel = new RoomModel();
            List<Room> rooms = tableModel.selectAll();
            for (Room room : rooms) {
                CardRoomController cardRoomController = new CardRoomController(view.pnRooms, room);
                view.pnRooms.repaint();
                view.pnRooms.revalidate();
            }
        }

        public void run() {
            setResources();
        }
    }
}
