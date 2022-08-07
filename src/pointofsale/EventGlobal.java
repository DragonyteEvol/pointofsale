/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale;

import pointofsale.models.EventModel;
import pointofsale.objects.Event;

/**
 *
 * @author dragonyte
 */
public class EventGlobal {
    
    static Event event;

    public EventGlobal(Event event) {
        EventGlobal.event = event;
    }


    public static Event getEvent() {
        return event;
    }

    public static void setEvent(Event event) {
        EventGlobal.event = event;
    }
    
    public static Event getEventActive(){
        EventModel eventModel = new EventModel();
        Event event_a = eventModel.selectActive();
        return event_a;
    }
    
}
