/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import pointofsale.ConfigGlobal;
import pointofsale.models.CashDrawerModel;
import pointofsale.models.ConfigModel;
import pointofsale.objects.AditionalInformation;
import pointofsale.objects.CashDrawer;
import pointofsale.views.additional.FileSelector;
import pointofsale.views.additional.InfoView;
import pointofsale.views.modal.CashDrawerPasswordView;

/**
 *
 * @author dragonyte
 */
public class InfoController implements ActionListener,FocusListener {

    private InfoView view;
    private CashDrawerPasswordView passwordView;
    private FileSelector selectorView;

    public InfoController(JPanel panel) {
        this.view = new InfoView();
        this.selectorView = new FileSelector(null, true);
        this.passwordView = new CashDrawerPasswordView(null, true);

        Dimension dimension = view.getToolkit().getScreenSize();
        selectorView.setSize(dimension.width / 2, dimension.height / 2);
        selectorView.setLocationRelativeTo(null);
        passwordView.setLocationRelativeTo(null);

        selectorView.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setConfig();
        view.btnSave.addActionListener(this);
        view.btnSelectRoute.addActionListener(this);
        view.btnDeleteAll.addActionListener(this);
        selectorView.fileChooser.addActionListener(this);
        //FOCUS
        this.view.txtNit.addFocusListener(this);
        this.view.txtName.addFocusListener(this);
        this.view.txtTip.addFocusListener(this);
        this.view.txtAddress.addFocusListener(this);
        this.view.txtPhone.addFocusListener(this);
        this.view.txtRoute.addFocusListener(this);

        panel.add(this.view);
    }

    private void setConfig() {
        AditionalInformation aditionalInformation = ConfigGlobal.getConfig();
        if (aditionalInformation != null) {
            view.txtName.setText(aditionalInformation.getName());
            view.txtNit.setText(aditionalInformation.getNit() + "");
            view.txtAddress.setText(aditionalInformation.getAddress());
            view.txtPhone.setText(aditionalInformation.getPhone() + "");
            view.txtRoute.setText(aditionalInformation.getLogo_path() + "");
        }
    }

    private boolean validateRequest(String name, Integer nit, Integer tip) {
        return !(name.isBlank() || nit == null || tip == null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnSave) {
            InsertConfig insertConfig = new InsertConfig();
            insertConfig.start();
        }

        if (source == view.btnSelectRoute) {
            selectorView.setVisible(true);
        }

        if (source == selectorView.fileChooser) {
            String command = ae.getActionCommand();
            if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                String path = String.valueOf(selectorView.fileChooser.getSelectedFile());
                view.txtRoute.setText(path);
                System.out.print(path);
                selectorView.dispose();
            } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                selectorView.dispose();
            }

        }
        if (source == view.btnDeleteAll) {
            String password = String.valueOf(passwordView.txtPassword.getPassword());
            if (!password.isBlank()) {
                CashDrawerModel cashDrawerModel = new CashDrawerModel();
                CashDrawer cashDrawer = cashDrawerModel.selectPassword();
                if (password.equals(cashDrawer.getPassword())) {
                    ConfigModel configModel = new ConfigModel();
                    configModel.deleteAllTables();
                    System.exit(0);
                }
            }

        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if(source == this.view.txtNit){
            this.view.txtNit.selectAll();
        }
        if(source == this.view.txtName){
            this.view.txtName.selectAll();
        }
        if(source == this.view.txtAddress){
            this.view.txtAddress.selectAll();
        }
        if(source == this.view.txtPhone){
            this.view.txtPhone.selectAll();
        }
        if(source == this.view.txtRoute){
            this.view.txtRoute.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    class InsertConfig extends Thread {

        @Override
        public void run() {
            String name = view.txtName.getText();
            Integer nit = Integer.parseInt(view.txtNit.getText());
            Integer tip = Integer.parseInt(String.valueOf(view.txtTip.getValue()));
            Integer phone = Integer.parseInt(view.txtPhone.getText());
            String address = view.txtAddress.getText();
            String route = view.txtRoute.getText();
            if (validateRequest(name, nit, tip)) {
                ConfigModel configModel = new ConfigModel();
                AditionalInformation aditionalInformation = ConfigGlobal.getConfig();
                if (aditionalInformation == null) {
                    aditionalInformation = new AditionalInformation(null, nit, name, route, tip, null);
                    aditionalInformation.setPhone(phone);
                    configModel.insert(aditionalInformation);
                } else {
                    aditionalInformation.setDefault_tip(tip);
                    aditionalInformation.setName(name);
                    aditionalInformation.setNit(nit);
                    aditionalInformation.setAddress(address);
                    aditionalInformation.setPhone(phone);
                    aditionalInformation.setLogo_path(route);
                    configModel.update(aditionalInformation);
                }
                ConfigGlobal.setConfig(ConfigGlobal.getDefaultConfig());
                setConfig();
            }
        }
    }
}
