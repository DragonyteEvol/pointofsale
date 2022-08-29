/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import pointofsale.EventGlobal;
import pointofsale.controllers.components.CardEventController;
import pointofsale.controllers.modal.NewEventController;
import pointofsale.models.EventModel;
import pointofsale.objects.Event;
import pointofsale.views.event.EventView;

/**
 *
 * @author dragonyte
 */
public class EventController extends Controller implements ActionListener {

    private EventView view;

    public EventController(JPanel panel) {
        this.view = new EventView();

        view.btnCreate.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnCreate) {
            NewEventController controller = new NewEventController();
            EventGlobal.setEvent(EventGlobal.getEventActive());
            setEvent();
            HomeController.checkEvent();
        }
    }

    class SetResource extends Thread {

        private void setEvent() {
            view.pnEvents.removeAll();
            EventModel eventModel = new EventModel();
            List<Event> events = eventModel.selectAll();
            for (Event event : events) {
                System.out.print(event.getName());
                CardEventController card = new CardEventController(event, view.pnEvents);
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
