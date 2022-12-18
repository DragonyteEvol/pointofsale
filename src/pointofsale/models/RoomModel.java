/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.EventGlobal;
import pointofsale.UserGlobal;
import pointofsale.objects.Atm;
import pointofsale.objects.Bill;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.MoneyBox;
import pointofsale.objects.MovementInventory;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Room;

/**
 *
 * @author dragonyte
 */
public class RoomModel extends Model {

    public List<Room> selectAll() {
        List<Room> rooms = this.dao.getRoomDao().selectAll();
        this.closeConnection();
        return rooms;
    }

    public void update(Room room) {
        this.dao.getRoomDao().modify(room);
        this.saveChanges();
    }

    public void remove(Room room) {
        this.dao.getRoomDao().delete(room);
        this.saveChanges();
    }

    public Room selectByIdWhitCategorie(Long id) {
        Room room = this.dao.getRoomDao().selectByIdWhitCategorie(id);
        this.closeConnection();
        return room;
    }

    public Room selectById(Integer id) {
        Room room = this.dao.getRoomDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return room;
    }

    public void insert(Room room) {
        this.dao.getRoomDao().insert(room);
        
        this.saveChanges();
    }

    public void setAllocatted(Room room) {
        room.setAllocatted(true);
        this.dao.getRoomDao().modify(room);
    }

    public void dislodge(Room room) {
        room.setAllocatted(false);
        this.dao.getRoomDao().modify(room);
        this.saveChanges();
    }

    public void allocateRoom(Room room, PaymentMethod paymentMethod, Integer total,Integer realTotal) {
        Bill bill = new Bill();
        bill.setWaiter_id(0);
        bill.setClient_type(1);
        bill.setClient_id(room.getId());
        bill.setUser_id(UserGlobal.getUser().getId());
        System.out.print(paymentMethod.getId());
        bill.setPayment_method_id(paymentMethod.getId());
        bill.setHousing(true);
        if(EventGlobal.getEvent()!=null){
            bill.setEvent_id(EventGlobal.getEvent().getId());
        }
        bill.setTotal(total);
        bill.setTotal_real(realTotal);

        Integer bill_id=this.dao.getBillDao().insert(bill);
        bill.setId(bill_id);
        this.dao.getBillCurrentDao().insert(bill);
        
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectAmenities();
        for(Ingredient ingredient : ingredients){
            System.out.print(ingredient.getName());
            MovementInventory movementInventory = new MovementInventory(null, ingredient.getId() ,room.getCapacity(), false, true, null);
            this.dao.getMovementInventoryDao().insert(movementInventory);
            
            Inventory inventory= this.dao.getInventoryDao().selectWhereIngredient("ingredient_id="+ ingredient.getId());
            inventory.setQuantity(inventory.getQuantity()- room.getCapacity());
            this.dao.getInventoryDao().modify(inventory);
        }

        setAllocatted(room);
        saveChanges();
    }

    public void cashRegister(Integer total, Integer receibed) {
        MoneyBox moneyBox = new MoneyBox();
        moneyBox.setEntry(receibed);
        moneyBox.setOut(receibed - total);
        moneyBox.setRequired(total);
        moneyBox.setUser_id(UserGlobal.getUser().getId());

        this.dao.getMoneyBoxDao().insert(moneyBox);

        String id = "1";

        Atm atm = this.dao.getAtmDao().selectById(Long.parseLong(id));
        if (atm == null) {
            atm = new Atm(null, UserGlobal.getUser().getId(), total, null);
            this.dao.getAtmDao().insert(atm);
        } else {
            atm.setValue(atm.getValue() + total);
            this.dao.getAtmDao().modify(atm);
        }
        
        this.saveChanges();
    }

}
