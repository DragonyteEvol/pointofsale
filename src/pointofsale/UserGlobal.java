/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale;

import pointofsale.objects.User;

/**
 *
 * @author dragonyte
 */
public class UserGlobal {
    static User user;

    public UserGlobal(User user) {
        UserGlobal.user = user;
        
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserGlobal.user = user;
    }
    
    
}
