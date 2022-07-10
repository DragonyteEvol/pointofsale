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
public class NewUnitController implements ActionListener{
    
    private NewUnitView view;
	private UnitModel model;

    public NewUnitController() {

		this.model = new UnitModel();
        
        this.view = new NewUnitView(null, true);
        this.view.setResizable(false);
        
        //events
        this.view.btnSave.addActionListener(this);
       
        
        this.view.setVisible(true);
    }
    
    private boolean validateRequest(Unit unit){
        if(unit.getName().isBlank() || unit.getName().isEmpty()){
            return false;
        }else if(unit.getPrefix().isBlank() || unit.getPrefix().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private Unit createUnit(){
        String name = this.view.txtName.getText();
        String prefix = this.view.txtPrefix.getText();
        return new Unit(null,name,prefix,null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnSave){
            Unit unit = this.createUnit();
            if(this.validateRequest(unit)){
				this.model.insert(unit);
            }
        }      
    }
    
}
