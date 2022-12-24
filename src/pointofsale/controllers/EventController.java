/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.util.List;
import javax.swing.JPanel;
import pointofsale.controllers.components.CardEventController;
import pointofsale.models.EventModel;
import pointofsale.objects.Event;
import pointofsale.views.event.EventView;

/**
 *
 * @author dragonyte
 */
public class EventController extends Controller{

    private EventView view;

    public EventController(JPanel panel) {
        this.view = new EventView();

        panel.add(view);
        setEvent();
        panel.repaint();
        panel.revalidate();
    }


    private void setEvent() {
        view.pnEvents.removeAll();
        SetResource setResource = new SetResource();
        setResource.start();
    }

    class SetResource extends Thread {

        private void setEvent() {
            EventModel eventModel = new EventModel();
            List<Event> events = eventModel.selectAll();
            for (Event event : events) {
                CardEventController card = new CardEventController(event, view.pnEvents);
                view.pnEvents.repaint();
                view.pnEvents.revalidate();
            }
            view.pnEvents.repaint();
            view.pnEvents.revalidate();
        }

        @Override
        public void run() {
            setEvent();
        }
    }
}
