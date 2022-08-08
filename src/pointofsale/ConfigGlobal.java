/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale;

import pointofsale.models.ConfigModel;
import pointofsale.objects.AditionalInformation;

/**
 *
 * @author dragonyte
 */
public class ConfigGlobal {
    static AditionalInformation config;

    public ConfigGlobal() {
    }

    public static AditionalInformation getConfig() {
        return config;
    }

    public static void setConfig(AditionalInformation config) {
        ConfigGlobal.config = config;
    }
    
    public static AditionalInformation getDefaultConfig(){
        ConfigModel configModel = new ConfigModel();
        AditionalInformation aditionalInformation_m = configModel.selectDefaultConfig();
        return aditionalInformation_m;
    }
    
}
