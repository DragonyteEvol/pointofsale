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
	UserDao getUserDao();
	IngredientDao getIngredientDao();
	InventoryDao getInventoryDao();
	MovementInventoryDao getMovementInventoryDao();
        ProductDao getProductDao();
        ProductIngredientDao getProductIngredientDao();
        TableDao getTableDao();
        RoomDao getRoomDao();
        PaymentMethodDao getPaymentMethodDao();
        AtmDao getAtmDao();
        MoneyBoxDao getMoneyBoxDao();
        BillRoomTmpDao getBillRoomTmpDao();
        BillTableTmpDao getBillTableTmpDao();
        BillRoomProductTmpDao getBillRoomProductTmpDao();
        BillTableProductTmpDao getBillTableProductTmpDao();
        BillRestockDao getBillRestockDao();
        BillRestockIngredientDao getBillRestockIngredientDao();
        ReportDao getReportDao();
        BillProductDao getBillProductDao();
        EventDao getEventDao();
        MissingStockDao getMissingStockDao();
        DeleteDao getDeleteDao();
        CashDrawerDao getCashDrawerDao();
        TipDao getTipDao();
        BillCurrentDao getBillCurrentDao();
        BillRestockCurrentDao getBillRestockCurrentDao();
}
