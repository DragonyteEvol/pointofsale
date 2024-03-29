/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.User;

/**
 *
 * @author dragonyte
 */
public interface UserDao extends Dao<User, Long>{
    User selectByMail(String a);
    List<User> selectWaiters();
}
