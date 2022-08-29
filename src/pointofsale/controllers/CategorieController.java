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

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pointofsale.controllers.components.CardCategorieController;
import pointofsale.controllers.modal.NewCategorieController;
import pointofsale.models.CategorieModel;
import pointofsale.objects.Categorie;
import pointofsale.views.inventory.CategorieView;

/**
 *
 * @author dragonyte
 */
public class CategorieController extends Controller implements ActionListener, FocusListener {

    private CategorieView view;
    private JPanel panel;

    public CategorieController(JPanel panel) {
        this.view = new CategorieView();

        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.panel = panel;

        panel.add(view);
        setCategories();
        this.initEvents();
    }

    private void setCategories() {
        view.pnCategorie.removeAll();
        SetResources sr = new SetResources();
        sr.start();
    }

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

    private void search() {
        SearchThread st = new SearchThread();
        st.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewCategorieController newCategorie = new NewCategorieController();
            setCategories();
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

        private void setCategories() {
            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.selectAll();

            for (Categorie categorie : categories) {
                CardCategorieController cardCategorieController = new CardCategorieController(categorie, view.pnCategorie);
                view.pnCategorie.repaint();
                view.pnCategorie.revalidate();
            }

        }

        public void run() {
            setCategories();
        }
    }

    class SearchThread extends Thread {

        private void search(JPanel searchPanel) {
            String search = view.txtSearch.getText();

            CategorieModel categorieModel = new CategorieModel();
            List<Categorie> categories = categorieModel.search(search);

            searchPanel.removeAll();

            if (categories.isEmpty()) {
                searchPanel.repaint();
                searchPanel.revalidate();
            } else {

                for (Categorie categorie : categories) {
                    CardCategorieController card = new CardCategorieController(categorie, searchPanel);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            }
        }

        @Override
        public void run() {
            search(view.pnCategorie);
        }
    }
}
