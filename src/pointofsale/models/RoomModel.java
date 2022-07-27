/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.UserGlobal;
import pointofsale.objects.Atm;
import pointofsale.objects.Bill;
import pointofsale.objects.MoneyBox;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Room;

/**
 *
 * @author dragonyte
 */
public class RoomModel extends Model{
    
    public List<Room> selectAll(){
        List<Room> rooms = this.dao.getRoomDao().selectAll();
        this.closeConnection();
        return rooms;
    }
    
    public void update(Room room){
        this.dao.getRoomDao().modify(room);
        this.saveChanges();
    }
    
    public void remove(Room room){
        this.dao.getRoomDao().delete(room);
        this.saveChanges();
    }
    
    public Room selectByIdWhitCategorie(Long id){
        Room room = this.dao.getRoomDao().selectByIdWhitCategorie(id);
        this.closeConnection();
        return room;
    }
    
    public Room selectById(Integer id){
        Room room = this.dao.getRoomDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return room;
    }
    
    public void insert(Room room){
        this.dao.getRoomDao().insert(room);
        this.saveChanges();
    }
    
    public void setAllocatted(Room room){
        room.setAllocatted(true);
        this.dao.getRoomDao().modify(room);
    }
    
    public void dislodge(Room room){
        room.setAllocatted(false);
        this.dao.getRoomDao().modify(room);
        this.saveChanges();
    }
    
    public void allocateRoom(Room room, PaymentMethod paymentMethod,Double total,Double receibed){
        Bill bill = new Bill();
        bill.setClient_type(1);
        bill.setClient_id(room.getId());
        bill.setUser_id(UserGlobal.getUser().getId());
        bill.setPayment_method_id(paymentMethod.getId());
        bill.setHousing(true);
        bill.setTotal(total);
        bill.setTotal_real(total);
        
        this.dao.getBillDao().insert(bill);
        
        
        MoneyBox moneyBox = new MoneyBox();
        moneyBox.setEntry(receibed);
        moneyBox.setOut(receibed - total);
        moneyBox.setRequired(total);
        moneyBox.setUser_id(UserGlobal.getUser().getId());
        
        this.dao.getMoneyBoxDao().insert(moneyBox);
        
        String id = "1";
        
        Atm atm = this.dao.getAtmDao().selectById(Long.parseLong(id));
        if(atm==null){
            atm = new Atm(null, UserGlobal.getUser().getId(), total, null);
            this.dao.getAtmDao().insert(atm);
        }else{
            atm.setValue(atm.getValue()+total);
            this.dao.getAtmDao().modify(atm);
        }
        
        setAllocatted(room);
        saveChanges();
    }
    
    
    public void allocateRoom(Room room, PaymentMethod paymentMethod,Double total){
        Bill bill = new Bill();
        bill.setClient_type(1);
        bill.setClient_id(room.getId());
        bill.setUser_id(UserGlobal.getUser().getId());
        bill.setPayment_method_id(paymentMethod.getId());
        bill.setHousing(true);
        bill.setTotal(total);
        bill.setTotal_real(total);
        
        this.dao.getBillDao().insert(bill);
        
        
        setAllocatted(room);
        saveChanges();
    }
    
}
