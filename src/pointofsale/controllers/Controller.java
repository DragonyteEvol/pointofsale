/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import javax.swing.JPanel;

/**
 *
 * @author dragonyte
 */
public class Controller {
    //view methods
    
    // add a menu to a view
    public void addMenu(JPanel menu, JPanel panel) {
        
        //menu config 
        menu.setSize(200,382);
        
        //panel remove childs and add panel menu
        panel.removeAll();
        panel.add(menu);
        panel.revalidate();
        panel.repaint();
    }
    
    // add a view to a father's panel whitout recharge or remove the childs's views
    public void addViewWhitoutRefresh(JPanel view,JPanel panel){
        view.setSize(614,382);
        view.setLocation(201, 0);
        
        panel.add(view);
    }
}
