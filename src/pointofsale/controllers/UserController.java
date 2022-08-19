/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.util.List;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardUserController;
import pointofsale.models.UserModel;
import pointofsale.objects.User;
import pointofsale.views.additional.UserView;

/**
 *
 * @author dragonyte
 */
public class UserController {
    
    private UserView view;

    public UserController(JPanel panel) {
        this.view = new UserView();
        
        SetUser setUser = new SetUser();
        setUser.start();
        
        panel.add(view);
    }
    
    class SetUser extends Thread{
        @Override
        public void run(){
            UserModel userModel = new UserModel();
            List<User> users = userModel.selectAll();
            
            for(User user: users){
                CardUserController card = new CardUserController(view.pnUsers, user);
            }
            
            view.pnUsers.repaint();
            view.pnUsers.revalidate();
        }
    }
    
}
