/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.controllers.components.CardUnitController;
import pointofsale.controllers.modal.NewUnitController;
import pointofsale.models.UnitModel;
import pointofsale.objects.Unit;
import pointofsale.views.inventory.UnitView;

/**
 *
 * @author dragonyte
 */
public class UnitController extends Controller implements ActionListener, FocusListener {

    private UnitView view;
    private JPanel panel;

    public UnitController(JPanel panel) {
        this.view = new UnitView();
        this.initComponents(panel);

    }

    private void initComponents(JPanel panel) {
        // VARIABLES
        this.panel = panel;

        // print views
        panel.add(view);
        setUnits();

        this.initEvents();
    }

    // events
    private void initEvents() {
        this.view.btnCreate.addActionListener(this);

        this.view.txtSearch.addFocusListener(this);

        view.txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                search();
            }

            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }

    private void setUnits() {
        view.pnUnits.removeAll();
        SetResources sr = new SetResources();
        sr.start();
    }

    private void search() {
        SearchThread st = new SearchThread();
        st.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewUnitController newUnit = new NewUnitController(this);
            setUnits();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object source = fe.getSource();
        if (source == view.txtSearch) {
            view.txtSearch.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
    }

    class SetResources extends Thread {

        private void setResource() {
            UnitModel unitModel = new UnitModel();
            List<Unit> units = unitModel.selectAll();
            for (Unit unit : units) {
                CardUnitController cardUnitController = new CardUnitController(unit, view.pnUnits);
                view.pnUnits.repaint();
                view.pnUnits.revalidate();
            }
        }

        @Override
        public void run() {
            setResource();
        }
    }

    class SearchThread extends Thread {

        private void search(JPanel searchPanel) {
            String search = view.txtSearch.getText();

            UnitModel unitModell = new UnitModel();
            List<Unit> units = unitModell.search(search);

            searchPanel.removeAll();

            if (units.isEmpty()) {
                searchPanel.repaint();
                searchPanel.revalidate();
            } else {

                for (Unit unit : units) {
                    CardUnitController card = new CardUnitController(unit, searchPanel);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            }
        }

        @Override
        public void run() {
            search(view.pnUnits);
        }
    }
}
