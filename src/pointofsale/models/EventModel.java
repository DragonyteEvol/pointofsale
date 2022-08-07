/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Event;

/**
 *
 * @author dragonyte
 */
public class EventModel extends Model{
    
    public Event selectById(Integer id){
        Event event = this.dao.getEventDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return event;
    }
    
    public List<Event> selectAll(){
        List<Event> events = this.dao.getEventDao().selectAll();
        this.closeConnection();
        return events;
    }
    
    public Event selectActive(){
        Event event = this.dao.getEventDao().selectActive();
        this.closeConnection();
        return event;
    }
    
    public void insert(Event event){
        this.dao.getEventDao().insert(event);
        this.saveChanges();
    }
    
    public void update(Event event){
        this.dao.getEventDao().modify(event);
        this.saveChanges();
    }
    
    public void delete(Event event){
        this.dao.getEventDao().delete(event);
        this.saveChanges();
    }
}
