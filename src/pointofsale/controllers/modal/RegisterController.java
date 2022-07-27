/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.controllers.ModalController;
import pointofsale.models.UserModel;
import pointofsale.objects.User;
import pointofsale.views.modal.RegisterView;

/**
 *
 * @author dragonyte
 */
public class RegisterController extends ModalController implements ActionListener{
    
    private RegisterView view;

    public RegisterController() {
        initComponents();
    }

    private void initComponents() {
        // view config
        this.view = new RegisterView(null, true);
        this.view.setResizable(false);

        initEvents();
        this.view.setVisible(true);
    }

    private void initEvents() {
        this.view.btnRegister.addActionListener(this);
    }

    // validate info of text fields
    private boolean validateRequest(String name,String mail,String password) {
        if(mail.isBlank()|| password.isBlank() || name.isBlank()){
            return false;
        }else{
            return true;
        }
    }
    
    private boolean registerUser(String name,String mail, String password){
        if(validateRequest(name, mail, password)){
            User user = new User();
            user.setMail(mail);
            user.setName(name);
            user.setPassword(password);
            user.setAdmin(false);
            UserModel userModel = new UserModel();
            userModel.insert(user);
            return true;
        }else{
            return false;
        }
    }

    // create a unit from text fields
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source==this.view.btnRegister){
            String mail = this.view.txtMail.getText();
            String password = String.valueOf(this.view.txtPassword.getPassword());
            String name = this.view.txtName.getText();
            if(registerUser(name, mail, password)){
                this.view.dispose();
            }
        }
    }
}
