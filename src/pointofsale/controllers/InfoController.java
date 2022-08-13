/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pointofsale.ConfigGlobal;
import pointofsale.models.ConfigModel;
import pointofsale.objects.AditionalInformation;
import pointofsale.views.additional.InfoView;

/**
 *
 * @author dragonyte
 */
public class InfoController implements ActionListener{
      private InfoView view;

    public InfoController(JPanel panel) {
        this.view = new InfoView();

        setConfig();
        view.btnSave.addActionListener(this);

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
    }

    class InsertConfig extends Thread {

        @Override
        public void run() {
            String name = view.txtName.getText();
            Integer nit = Integer.parseInt(view.txtNit.getText());
            Integer tip = Integer.parseInt(String.valueOf(view.txtTip.getValue()));
            Integer phone = Integer.parseInt(view.txtPhone.getText());
            String address = view.txtAddress.getText();
            if (validateRequest(name, nit, tip)) {
                ConfigModel configModel = new ConfigModel();
                AditionalInformation aditionalInformation = ConfigGlobal.getConfig();
                if (aditionalInformation == null) {
                    aditionalInformation = new AditionalInformation(null, nit, name, "", tip, null);
                    configModel.insert(aditionalInformation);
                } else {
                    aditionalInformation.setDefault_tip(tip);
                    aditionalInformation.setName(name);
                    aditionalInformation.setNit(nit);
                    aditionalInformation.setAddress(address);
                    aditionalInformation.setPhone(phone);
                    aditionalInformation.setLogo_path("");
                    configModel.update(aditionalInformation);
                }
                ConfigGlobal.setConfig(ConfigGlobal.getDefaultConfig());
                setConfig();
            }
        }
    }
}
