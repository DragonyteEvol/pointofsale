/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.dao.implement;

import java.sql.Connection;
import java.util.List;

import pointofsale.dao.DaoManager;
import pointofsale.dao.UnitDao;
import pointofsale.database.DataBaseConnection;
import pointofsale.objects.Unit;

/**
 *
 * @author dragonyte
 */
public class DaoManagerImpl implements DaoManager{
	private Connection connection;


	private UnitDao unit =null;

	public DaoManagerImpl() {
		DataBaseConnection databaseConnection= new DataBaseConnection();
		this.connection = databaseConnection.connect();
	}

    @Override
    public UnitDao getUnitDao() {
		if(unit==null){
			this.unit = new UnitDaoImpl(connection);
		}
		return this.unit;
    }
    
    public static void main(String[] a){
        DaoManagerImpl dao = new DaoManagerImpl();
        List<Unit> units = dao.getUnitDao().selectAll();
        for(Unit x:units){
            System.out.println(x.toString());
        }
    }

}
