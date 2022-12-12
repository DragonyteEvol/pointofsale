/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
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
    
    public void delete(User user){
        this.dao.getUserDao().delete(user);
        this.saveChanges();
    }
    
    public void update(User user){
        this.dao.getUserDao().modify(user);
        this.saveChanges();
    }
    
    public List<User> selectAll(){
        List<User> users = this.dao.getUserDao().selectAll();
        this.closeConnection();
        return users;
    }
    
    public List<User> selectWaiters(){
        List<User> users = this.dao.getUserDao().selectWaiters();
        this.closeConnection();
        return users;
    }

}
