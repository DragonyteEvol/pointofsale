/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.UserModel;
import pointofsale.objects.User;
import pointofsale.views.modal.EditUserView;

/**
 *
 * @author dragonyte
 */
public class EditUserController implements ActionListener{
    private EditUserView view;
    private User user;

    public EditUserController(User user) {
        this.view = new EditUserView(null, true);
        view.setMinimumSize(new Dimension(350,0));
        this.user=user;
        
        setUser();
        
        view.btnSave.addActionListener(this);
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    private void setUser(){
        view.txtMail.setText(user.getMail());
        view.txtName.setText(user.getName());
        view.txtPassword.setText(user.getPassword());
        if(user.isAdmin()){
            view.cbType.setSelectedIndex(0);
        }else{
            view.cbType.setSelectedIndex(1);
        }
    }
    
    private boolean validateRequest(String name, String mail,String password){
        return !(name.isBlank()||mail.isBlank()||password.isBlank());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == view.btnSave){
            UpdateUser u = new UpdateUser();
            u.start();
            view.dispose();
        }
    }
    
    class UpdateUser extends Thread{
        @Override
        public void run(){
            String name = view.txtName.getText();
            String mail = view.txtMail.getText();
            String password = view.txtPassword.getText();
            String type =(String) view.cbType.getSelectedItem();
            boolean admin;
            admin = "administrador".equals(type);
            if(validateRequest(name, mail, password)){
                UserModel um = new UserModel();
                user.setAdmin(admin);
                user.setName(name);
                user.setPassword(password);
                user.setMail(mail);
                um.update(user);
            }
        }
    }
}
