/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.EditCategorieController;
import pointofsale.models.CategorieModel;
import pointofsale.objects.Categorie;
import pointofsale.views.components.CardCategorieView;
import pointofsale.views.modal.ConfirmDeleteView;

/**
 *
 * @author dragonyte
 */
public class CardCategorieController extends CardController implements ActionListener {
    
    private Categorie categorie;
    public CardCategorieView view;
    private JPanel panel;
    
    public CardCategorieController(Categorie categorie, JPanel panel) {
        this.categorie = categorie;
        this.panel = panel;
        
        this.view = new CardCategorieView();
        setInfo();
        initEvents();
        
        this.panel.add(view);
        
    }
    
    private void setInfo() {
        this.view.txtName.setText(categorie.getName());
        if (categorie.getTarget() == 0) {
            this.view.txtTarget.setText("Ingrediente");
        }
        
        if (categorie.getTarget() == 1) {
            this.view.txtTarget.setText("Producto");
        }
        
        if (categorie.getTarget() == 2) {
            this.view.txtTarget.setText("Habitacion");
        }
    }
    
    private void removeComponent(Component component) {
        this.panel.remove(component);
        this.panel.repaint();
        this.panel.revalidate();
    }
    
    private void refreshCategorie() {
        CategorieModel categorieModel = new CategorieModel();
        this.categorie = categorieModel.selectById(categorie.getId());
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
            EditCategorieController editCategorieController = new EditCategorieController(categorie);
            refreshCategorie();
        }
        
        if(source == deleteView.btnYes){
            DeleteThread deleteThread = new DeleteThread(categorie);
            deleteThread.start();
            removeComponent(this.view);
            deleteView.dispose();
        }
    }
    
    class DeleteThread extends Thread {
        
        private Categorie categorie;
        
        public DeleteThread(Categorie categorie) {
            this.categorie = categorie;
        }
        
        private void deleteCategorie() {
            CategorieModel categorieModel = new CategorieModel();
            categorieModel.delete(categorie);
        }
        
        @Override
        public void run() {
            deleteCategorie();
        }
    }
    
}
