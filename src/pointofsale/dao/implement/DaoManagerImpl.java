/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import pointofsale.dao.AditionalInformationDao;
import pointofsale.dao.AnnulmentDao;
import pointofsale.dao.BillDao;
import pointofsale.dao.CategorieDao;

import pointofsale.dao.DaoManager;
import pointofsale.dao.UnitDao;
import pointofsale.dao.UserDao;

/**
 *
 * @author dragonyte
 */
public class DaoManagerImpl implements DaoManager{
	private Connection connection;


	private UnitDao unit =null;
        private AnnulmentDao annulment =null;
        private AditionalInformationDao aditionalInformation =null;
        private BillDao bill =null;
        private CategorieDao categorie =null;
        private UserDao user =null;

	public DaoManagerImpl(Connection connection) {
		this.connection = connection;
	}

    @Override
    public UnitDao getUnitDao() {
		if(unit==null){
			this.unit = new UnitDaoImpl(connection);
		}
		return this.unit;
    }
    
    @Override
    public AnnulmentDao getAnnulmentDao() {
        if(annulment==null){
            this.annulment = new AnnulmentDaoImpl(connection);
        }
        return this.annulment;
    }
    
    @Override
    public AditionalInformationDao getAditionalInformationDao() {
        if(aditionalInformation==null){
            this.aditionalInformation = new AditionalInformationDaoImpl(connection);
        }
        return this.aditionalInformation;
    }

    @Override
    public BillDao getBillDao() {
        if(bill==null){
            this.bill = new BillDaoImpl(connection);
        }
        return this.bill;
    }

    @Override
    public CategorieDao getCategorieDao() {
        if(categorie==null){
            this.categorie = new CategorieDaoImpl(connection);
        }
        return this.categorie;
    }

    @Override
    public UserDao getUserDao() {
        if(user==null){
            this.user = new UserDaoImpl(connection);
        }
        return this.user;
    }

    

}
