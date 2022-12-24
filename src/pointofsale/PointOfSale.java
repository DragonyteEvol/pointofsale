/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pointofsale;

import pointofsale.controllers.modal.LoginController;


/**
 *
 * @author dragonyteevol
 */
public class PointOfSale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //HomeController a = new HomeController();
        ConfigGlobal.setConfig(ConfigGlobal.getDefaultConfig());

        MissingGlobal.setMissingStocks(MissingGlobal.getMissing());
        
        LoginController a = new LoginController();
    }
}

