/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.views.AboutView;
import pointofsale.views.additional.ConfigView;

/**
 *
 * @author dragonyte
 */
public class ConfigController extends Controller implements ActionListener {

    private ConfigView view;

    public ConfigController(JPanel panel) {
        this.view = new ConfigView();

        InfoController infoController = new InfoController(view.pnConfig);

        view.btnAbout.addActionListener(this);
        view.btnInfo.addActionListener(this);
        view.btnUsers.addActionListener(this);

        this.addViewFirstPlane(this.view, panel);
    }

    private void revalidateView(Component component) {
        component.repaint();
        component.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnAbout) {
            AboutView a = new AboutView(null, true);
        }
        if (source == view.btnInfo) {
            view.pnConfig.removeAll();
            InfoController infoController = new InfoController(view.pnConfig);
            revalidateView(view.pnConfig);
        }

        if (source == view.btnUsers) {
            view.pnConfig.removeAll();
            UserController userController = new UserController(view.pnConfig);
            revalidateView(view.pnConfig);
        }
    }
}
