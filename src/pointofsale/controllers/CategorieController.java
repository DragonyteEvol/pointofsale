/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pointofsale.controllers.components.CardCategorieController;
import pointofsale.controllers.modal.NewCategorieController;
import pointofsale.models.CategorieModel;
import pointofsale.objects.Categorie;
import pointofsale.views.inventory.CategorieView;

/**
 *
 * @author dragonyte
 */
public class CategorieController extends Controller implements ActionListener {

    private CategorieView view;
    private CategorieModel model;
    private JPanel panel;

    public CategorieController(JPanel panel) {
        this.initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        this.view = new CategorieView();
        this.panel = panel;
        this.model = new CategorieModel();

        this.setCategories();
        this.addView(this.view, panel);

        this.initEvents();
    }

    private void initEvents() {
        this.view.btnCreate.addActionListener(this);
    }

    private void setCategories() {
        List<Categorie> categories = this.model.selectAll();
        for (Categorie categorie : categories) {
            CardCategorieController cardCategorieController = new CardCategorieController(categorie,this.view.pnCategorie);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnCreate) {
            NewCategorieController newCategorie = new NewCategorieController();
            this.initComponents(this.panel);
        }
    }

}
