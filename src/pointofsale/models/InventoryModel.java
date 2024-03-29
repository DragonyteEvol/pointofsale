/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.UserGlobal;
import pointofsale.objects.Atm;
import pointofsale.objects.BillRestock;
import pointofsale.objects.BillRestockIngredient;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.MissingStock;
import pointofsale.objects.MoneyBox;
import pointofsale.objects.MovementInventory;

/**
 *
 * @author dragonyte
 */
public class InventoryModel extends Model {

    public void insert(Inventory inventory) {
        this.dao.getInventoryDao().insert(inventory);
        this.saveChanges();
    }

    public void insert(Inventory inventory, MovementInventory movementInventory) {
        this.dao.getInventoryDao().insert(inventory);
        this.dao.getMovementInventoryDao().insert(movementInventory);
    }

    public Inventory selectWhereIngredient(Long id) {
        Inventory inventory = this.dao.getInventoryDao().selectWhereIngredient("ingredient_id=" + String.valueOf(id));
        this.closeConnection();
        return inventory;
    }

    public void receiptInventory(List<Ingredient> listIngredients, Long price) {
        //restock
        BillRestock billRestock = new BillRestock(null, UserGlobal.getUser().getId(), price, null);
        Long billRestockId = this.dao.getBillRestockDao().insert(billRestock);
        billRestock.setId(billRestockId);
        this.dao.getBillRestockCurrentDao().insert(billRestock);
        for (Ingredient ingredient : listIngredients) {
            //inventory
            Inventory inventory = this.dao.getInventoryDao().selectWhereIngredient("ingredient_id=" + String.valueOf(ingredient.getId()));
            System.out.println("ASDLKJASLK" + String.valueOf(inventory.getId()));
            Long value = inventory.getQuantity() + ingredient.getQuantity();
            inventory.setQuantity(value);
            //movement
            MovementInventory movementInventory = new MovementInventory(null, ingredient.getId(), ingredient.getQuantity(), true, false, null);
            //restock ingredients
            BillRestockIngredient billRestockIngredient = new BillRestockIngredient(null, billRestockId, ingredient.getId(), ingredient.getQuantity(), ingredient.getPrice(), null);
            
            this.dao.getBillRestockIngredientDao().insert(billRestockIngredient);
            this.dao.getMovementInventoryDao().insert(movementInventory);
            this.dao.getInventoryDao().modify(inventory);
            checkMissing(ingredient.getId());
        }
        this.saveChanges();

    }
    
    private void checkMissing(Long id){
        MissingStock missingStock = this.dao.getMissingStockDao().selectWhereIngredient(id);
        if(missingStock!=null){
            Inventory inventory =this.dao.getInventoryDao().selectMissingIngredient(id);
            if(inventory==null){
                this.dao.getMissingStockDao().delete(missingStock);
            }
        }
    }
    
    public List<MissingStock> selectMissing(){
        List<MissingStock> missingStocks = this.dao.getMissingStockDao().selectNotification();
        this.closeConnection();
        return missingStocks;
    }
    
    public void updateNotification(MissingStock missingStock){
        this.dao.getMissingStockDao().modify(missingStock);
        this.saveChanges();
    }
    
    public Atm selectAtm(){
        List<Atm> atms = this.dao.getAtmDao().selectAll();
        Atm box=null;
        for(Atm atm : atms){
            box = atm;
        }
        this.closeConnection();
        return box;
    }
    
    public List<MoneyBox> selectMovementBox(){
        List<MoneyBox> moneyBoxs = this.dao.getMoneyBoxDao().selectAll();
        this.closeConnection();
        return moneyBoxs;
    }
    
    public void updateAtm(Atm atm){
        this.dao.getAtmDao().modify(atm);
        this.saveChanges();
    }
    
    public List<MovementInventory> getMovementInventory(Long id){
        List<MovementInventory> movementInventorys = this.dao.getMovementInventoryDao().getByIngredient(id);
        this.closeConnection();
        return movementInventorys;
    }
}
