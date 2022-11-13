/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import pointofsale.ConfigGlobal;
import pointofsale.models.ConfigModel;
import pointofsale.objects.AditionalInformation;
import pointofsale.views.additional.FileSelector;
import pointofsale.views.additional.InfoView;

/**
 *
 * @author dragonyte
 */
public class InfoController implements ActionListener {
    

    private InfoView view;
    private FileSelector selectorView;

    public InfoController(JPanel panel) {
        this.view = new InfoView();
        this.selectorView = new FileSelector(null, true);

        Dimension dimension = view.getToolkit().getScreenSize();
        selectorView.setSize(dimension.width / 2, dimension.height / 2);
        selectorView.setLocationRelativeTo(null);

        selectorView.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setConfig();
        view.btnSave.addActionListener(this);
        view.btnSelectRoute.addActionListener(this);
        view.btnDeleteAll.addActionListener(this);
        selectorView.fileChooser.addActionListener(this);

        panel.add(this.view);
    }

    private void setConfig() {
        AditionalInformation aditionalInformation = ConfigGlobal.getConfig();
        if (aditionalInformation != null) {
            view.txtName.setText(aditionalInformation.getName());
            view.txtNit.setText(aditionalInformation.getNit() + "");
            view.txtTip.setValue(aditionalInformation.getDefault_tip());
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
            }else if(command.equals(JFileChooser.CANCEL_SELECTION)){
                selectorView.dispose();
            }

        }
        if(source== view.btnDeleteAll){
            
            ConfigModel configModel = new ConfigModel();
            configModel.deleteAllTables();
            System.exit(0);
        }
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
