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
import pointofsale.dao.IngredientDao;
import pointofsale.dao.InventoryDao;
import pointofsale.dao.MovementInventoryDao;
import pointofsale.dao.ProductDao;
import pointofsale.dao.ProductIngredientDao;
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
        private IngredientDao ingredient=null;
        private InventoryDao inventory=null;
        private MovementInventoryDao movementInventory= null;
        private ProductDao productDao;
        private ProductIngredientDao productIngredientDao;

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

    @Override
    public IngredientDao getIngredientDao() {
        if(ingredient==null){
            this.ingredient = new IngredientDaoImpl(connection);
        }
        return this.ingredient;
    }

    @Override
    public InventoryDao getInventoryDao() {
        if(inventory==null){
            this.inventory = new InventoryDaoImpl(connection);
        }
        return this.inventory;
    }

    @Override
    public MovementInventoryDao getMovementInventoryDao() {
        if(movementInventory==null){
            this.movementInventory = new MovementInventoryDaoImpl(connection);
        }
        return this.movementInventory;
    }

    @Override
    public ProductDao getProductDao() {
        if(movementInventory==null){
            this.productDao = new ProductDaoImpl(connection);
        }
        return this.productDao;
    }

    @Override
    public ProductIngredientDao getProductIngredientDao() {
        if(movementInventory==null){
            this.productIngredientDao = new ProductIngredientDaoImpl(connection);
        }
        return this.productIngredientDao;
    }

    

}
