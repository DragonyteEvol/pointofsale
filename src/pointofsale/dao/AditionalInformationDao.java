/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.AditionalInformation;

/**
 *
 * @author dragonyte
 */
public interface AditionalInformationDao extends Dao<AditionalInformation, Long>{
    AditionalInformation selectFirst();
}
