/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.controllers.modal.EditUserController;
import pointofsale.models.UserModel;
import pointofsale.objects.User;
import pointofsale.views.components.CardUserView;

/**
 *
 * @author dragonyte
 */
public class CardUserController extends CardController implements ActionListener{

    private CardUserView view;
    private User user;
    private JPanel panel;

    public CardUserController(JPanel panel,User user) {
        this.view = new CardUserView();
        this.user = user;
        this.panel = panel;
        
        view.btnDelete.addActionListener(this);
        view.btnEdit.addActionListener(this);
        deleteView.btnYes.addActionListener(this);
        setUser();
        
        panel.add(view);
    }
    
    private void setUser(){
        view.txtMail.setText(user.getMail());
        view.txtName.setText(user.getName());
        if(user.isAdmin()){
            view.txtAdmin.setText("Administrador");
        }else{
            view.txtAdmin.setText("Usuario");
        }
    }
    
    private void deleteComponent(Component component){
        panel.remove(component);
        panel.repaint();
        panel.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==view.btnDelete){
            deleteView.setVisible(true);
        }
        
        if(source==view.btnEdit){
            EditUserController e = new EditUserController(user);
            setUser();
        }
        
        if(source == deleteView.btnYes){
            DeleteUser deleteUser = new DeleteUser();
            deleteUser.start();
            deleteComponent(view);
            deleteView.dispose();
        }
    }
    
    class DeleteUser extends Thread{
        @Override
        public void run(){
            UserModel userModel = new UserModel();
            userModel.delete(user);
        }
    }
}
