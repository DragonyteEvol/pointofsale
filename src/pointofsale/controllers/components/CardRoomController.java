/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.EditRoomController;
import pointofsale.controllers.modal.RoomManagerController;
import pointofsale.models.BillModel;
import pointofsale.models.RoomModel;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.Room;
import pointofsale.views.components.CardRoomView;

/**
 *
 * @author dragonyte
 */
public class CardRoomController implements ActionListener {

    private CardRoomView view;
    private JPanel panel;
    private Room room;

    public CardRoomController(JPanel panel, Room room) {
        initComponents(panel, room);
    }

    private void initComponents(JPanel panel, Room table) {
        this.view = new CardRoomView();
        this.room = table;
        this.panel = panel;
        setInfo();
        initEvents();
        addComponent(view);
    }

    private void initEvents() {
        this.view.btnStatus.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
    }

    private void setInfo() {
        this.view.txtNumber.setText(String.valueOf(this.room.getId()));
        this.view.txtPrice.setText(String.valueOf(this.room.getPrice()));
        this.view.txtCapacity.setText(String.valueOf(this.room.getCapacity()));
        isAllocatted();
    }

    private void addComponent(Component component) {
        this.panel.add(component);
        panel.revalidate();
        panel.repaint();
    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        panel.revalidate();
        panel.repaint();
    }

    private void isAllocatted() {
        if (this.room.isAllocatted()) {
            BillModel billModel = new BillModel();
            BillRoomTmp billRoomTmp = billModel.checkBillRoomTmp(room.getId());
            if (billRoomTmp == null) {
                this.view.btnStatus.setText("Allocated");
            } else {
                this.view.btnStatus.setText(String.valueOf(billRoomTmp.getTotal()));
            }
        } else {
            this.view.btnStatus.setText("Rent");
        }
    }

    private void refreshRoom() {
        RoomModel roomModel = new RoomModel();
        this.room = roomModel.selectById(room.getId());
        this.setInfo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnStatus) {
            RoomManagerController roomManagerController = new RoomManagerController(this.room);
            isAllocatted();
            refreshRoom();
            view.repaint();
            view.revalidate();
        }

        if (source == this.view.btnEdit) {
            EditRoomController editRoomController = new EditRoomController(room);
            if (editRoomController.removed) {
                removeComponent(this.view);
            } else {
                refreshRoom();
            }
        }
    }
}