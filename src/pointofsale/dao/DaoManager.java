/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

/**
 *
 * @author dragonyte
 */
public interface DaoManager {
	UnitDao getUnitDao();
        AnnulmentDao getAnnulmentDao();
        AditionalInformationDao getAditionalInformationDao();
        BillDao getBillDao();
        CategorieDao getCategorieDao();
}
