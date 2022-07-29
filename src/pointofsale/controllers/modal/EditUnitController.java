/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.UnitModel;
import pointofsale.objects.Unit;
import pointofsale.views.modal.NewUnitView;

/**
 *
 * @author dragonyte
 */
public class EditUnitController implements ActionListener{
    
    private NewUnitView view;
    private Unit unit;
    public boolean removed = false;

    public EditUnitController(Unit unit) {
        this.view = new NewUnitView(null, true);
        this.view.setResizable(false);
        this.unit = unit;

        this.view.btnSave.addActionListener(this);
        this.view.btnDelete.addActionListener(this);

        setInfo();

        this.view.setVisible(true);
    }

    private void setInfo() {
        this.view.txtTitle.setText("Editar unidad");
        this.view.txtName.setText(unit.getName());
        this.view.txtPrefix.setText(unit.getPrefix());

    }

    public boolean validRequest(String name,String prefix) {
        return !(name.isBlank() || prefix.isBlank());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = this.view.txtName.getText();
            String prefix = this.view.txtPrefix.getText();
            if (validRequest(name,prefix)) {
                this.unit.setName(name);
                this.unit.setPrefix(prefix);
                UpdateThread updateThread = new UpdateThread(unit);
                updateThread.start();
                this.view.dispose();
            }
        }
    }

    class UpdateThread extends Thread {

        private Unit unit;

        public UpdateThread(Unit unit) {
            this.unit = unit;
        }

        private void updateUnit() {
            UnitModel unitModel = new UnitModel();
            unitModel.update(unit);
        }

        @Override
        public void run() {
            updateUnit();
        }
    }
}
