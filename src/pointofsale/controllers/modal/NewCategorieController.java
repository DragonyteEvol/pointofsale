/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.controllers.ModalController;
import pointofsale.models.CategorieModel;
import pointofsale.objects.Categorie;
import pointofsale.views.modal.NewCategorieView;

/**
 *
 * @author dragonyte
 */
public class NewCategorieController extends ModalController implements ActionListener{
    private NewCategorieView view;
    private CategorieModel model;

    public NewCategorieController() {
        this.model = new CategorieModel();
        
		// view config
        this.view = new NewCategorieView(null, true);
        this.view.setResizable(false);
        
        //events
        this.view.btnSave.addActionListener(this);
       
        this.view.setVisible(true);
    }
    
	// validate info of text fields
    private boolean validateRequest(Categorie categorie){
        String name = categorie.getName();
        if(name.isBlank() || name.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    private Categorie createCategorie(){
        String name = this.view.txtName.getText();
        Integer target = this.view.cbTarget.getSelectedIndex();
        return new Categorie(null, name, target, null);
    }
	// create a unit from text fields
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnSave){
            Categorie categorie = this.createCategorie();
            if(validateRequest(categorie)){
                this.model.insert(categorie);
                this.closeFrame(this.view);
            }
        }      
    }
}
