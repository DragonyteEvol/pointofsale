/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pointofsale.controllers.ModalController;
import pointofsale.controllers.UnitController;
import pointofsale.models.UnitModel;
import pointofsale.objects.Unit;
import pointofsale.views.modal.NewUnitView;

/**
 *
 * @author dragonyte
 */
public class NewUnitController extends ModalController implements ActionListener,FocusListener {

    private NewUnitView view;
    private UnitController superClass;

    public NewUnitController(UnitController superClass) {
        // view config
        this.view = new NewUnitView(null, true);
        this.view.setLocationRelativeTo(null);
        this.superClass = superClass;
        //events
        this.view.btnSave.addActionListener(this);
        //focus
        this.view.txtName.addFocusListener(this);
        this.view.txtPrefix.addFocusListener(this);
        
        this.view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = this.view.txtName.getText();
            String prefix = this.view.txtPrefix.getText();
            InsertThread insertThread = new InsertThread(name, prefix);
            insertThread.start();
            this.closeFrame(this.view);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
        if(source == this.view.txtPrefix){
            this.view.txtPrefix.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    // Thread for insert unit
    class InsertThread extends Thread {

        private String name;
        private String prefix;

        public InsertThread(String name, String prefix) {
            this.name = name;
            this.prefix = prefix;
        }

        // validate info of text fields
        private boolean validateRequest(Unit unit) {
            if (unit.getName().isBlank() || unit.getName().isEmpty()) {
                return false;
            } else if (unit.getPrefix().isBlank() || unit.getPrefix().isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        // create a unit from text fields
        private Unit createUnit() {
            return new Unit(null, name, prefix, null);
        }

        @Override
        public void run() {
            Unit unit = this.createUnit();
            if (this.validateRequest(unit)) {
                UnitModel unitModel = new UnitModel();
                unitModel.insert(unit);

            }
        }
    }

}
