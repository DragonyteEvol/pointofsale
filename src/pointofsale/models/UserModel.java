/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import pointofsale.objects.User;

/**
 *
 * @author dragonyte
 */
public class UserModel extends Model{
    public void insert(User user){
        this.dao.getUserDao().insert(user);
        this.saveChanges();
    }

    public User selectByMail(String mail){
	User user = this.dao.getUserDao().selectByMail(mail);
        this.closeConnection();
        return user;
    }

}
