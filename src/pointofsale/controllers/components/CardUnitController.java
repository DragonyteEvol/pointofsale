/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.EditUnitController;
import pointofsale.models.UnitModel;
import pointofsale.objects.Unit;
import pointofsale.views.components.CardUnitView;

/**
 *
 * @author dragonyte
 */
public class CardUnitController extends CardController implements ActionListener {

    private Unit unit;
    public CardUnitView view;
    private JPanel panel;

    public CardUnitController(Unit unit, JPanel panel) {
        this.view = new CardUnitView();
        this.unit = unit;
        this.panel = panel;
        setInfo();
        initEvents();

        this.panel.add(view);
    }

    private void setInfo() {
        this.view.txtName.setText(unit.getName());
        this.view.txtPrefix.setText(unit.getPrefix());
    }

    private void removeComponent(Component component) {
        this.panel.remove(component);
        this.panel.repaint();
        this.panel.revalidate();
    }

    private void refreshUnit() {
        UnitModel unitModel = new UnitModel();
        this.unit = unitModel.selectById(unit.getId());
        setInfo();
    }

    private void initEvents() {
        this.view.btnDelete.addActionListener(this);
        this.view.btnEdit.addActionListener(this);
        deleteView.btnYes.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnDelete) {
            deleteView.setVisible(true);
        }

        if (source == this.view.btnEdit) {
            EditUnitController editUnitController = new EditUnitController(unit);
            refreshUnit();
        }
        
        if(source == deleteView.btnYes){
            DeleteThread deleteThread = new DeleteThread(unit);
            deleteThread.start();
            removeComponent(this.view);
            deleteView.dispose();
        }
    }

    class DeleteThread extends Thread {

        private Unit unit;

        public DeleteThread(Unit unit) {
            this.unit = unit;
        }

        private void deleteUnit() {
            UnitModel unitModel = new UnitModel();
            unitModel.delete(unit);
        }

        @Override
        public void run() {
            deleteUnit();
        }
    }

}
