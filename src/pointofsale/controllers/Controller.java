/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import javax.swing.JPanel;
import pointofsale.views.layouts.MenuLayout;

/**
 *
 * @author dragonyte
 */
public class Controller {
    //view methods
    
    // add a menu to a view
    public void addMenu(JPanel menu, JPanel panel) {
        
        //menu config 
        menu.setSize(229,382);
        
        //panel remove childs and add panel menu
        panel.removeAll();
        panel.add(menu);
        panel.revalidate();
        panel.repaint();
    }
    
    
    public void addView(JPanel view,JPanel window){
        window.removeAll();
        view.setSize(608,382);
        window.add(view);
        window.revalidate();
        window.repaint();
    }
    
    public void addViewFirstPlane(JPanel view,JPanel window){
        window.removeAll();
        view.setSize(814,382);
        window.add(view);
        window.revalidate();
        window.repaint();
    }
    
    public MenuLayout setMenuLayout(JPanel panel){
        panel.removeAll();
        MenuLayout layout = new MenuLayout();
        layout.setSize(814,382);
        panel.add(layout);
        panel.revalidate();
        panel.repaint();
        return layout;
    }
    
    
}
