/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pointofsale.UserGlobal;
import pointofsale.controllers.HomeController;
import pointofsale.controllers.ModalController;
import pointofsale.models.UserModel;
import pointofsale.objects.User;
import pointofsale.views.modal.LoginView;

/**
 *
 * @author dragonyte
 */
public class LoginController extends ModalController implements ActionListener,FocusListener {

    private LoginView view;
    public boolean logged = false;
    private User user;

    public LoginController() {
        initComponents();
    }


    private void initComponents() {
        // view config
        this.view = new LoginView(null, true);
        this.view.setLocationRelativeTo(null);

        initEvents();
        this.view.setVisible(true);
    }

    private void initEvents() {
        //CLIC
        this.view.btnStar.addActionListener(this);
        this.view.btnRegister.addActionListener(this);
        //FOCUS
        this.view.txtUser.addFocusListener(this);
        this.view.txtPassword.addFocusListener(this);
    }

    // validate info of text fields
    private boolean validateRequest(String mail, String password) {
        if (mail.isEmpty() || password.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateUser(String mail, String password) {
        UserModel userModel = new UserModel();
        User user_v = userModel.selectByMail(mail);
        if (user_v == null) {
            return false;
        }
        if (password.equals(user_v.getPassword())) {
            this.user = user_v;
            return true;
        } else {
            return false;
        }
    }

    // create a unit from text fields
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnStar) {
            String mail = this.view.txtUser.getText();
            String password = String.valueOf(this.view.txtPassword.getPassword());
            if (validateRequest(mail, password)) {
                if (validateUser(mail, password)) {
                    this.view.dispose();
                    UserGlobal.setUser(user);
                    HomeController homeController = new HomeController();
                    logged = true;
                }
            }
        }
        if (source == this.view.btnRegister) {
            RegisterController registerController = new RegisterController();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtPassword){
            this.view.txtPassword.selectAll();
        }
        if(source == this.view.txtUser){
            this.view.txtUser.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
