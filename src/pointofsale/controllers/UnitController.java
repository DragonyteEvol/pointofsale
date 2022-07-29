/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardUnitController;
import pointofsale.controllers.modal.NewUnitController;
import pointofsale.models.UnitModel;
import pointofsale.objects.Unit;
import pointofsale.views.inventory.UnitView;

/**
 *
 * @author dragonyte
 */
public class UnitController extends Controller implements ActionListener {

    private UnitView view;
    private UnitModel unitModel;
    private JPanel panel;

    public UnitController(JPanel panel) {
        this.initComponents(panel);

    }

    private void initComponents(JPanel panel) {
        // VARIABLES
        this.view = new UnitView();
        this.unitModel = new UnitModel();
        this.panel = panel;

        this.setResource(this.view);
        // print views
        this.addView(this.view, panel);

        this.initEvents();
    }

    // events
    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
    }

    private void setResource(JPanel view) {
        List<Unit> units = this.unitModel.selectAll();
        for (Unit unit : units) {
            CardUnitController cardUnitController = new CardUnitController(unit, this.view.pnUnits);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewUnitController newUnit = new NewUnitController(this);
            this.initComponents(this.panel);
        }
    }
}
