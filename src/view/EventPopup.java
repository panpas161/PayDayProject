package view;

import model.event.Event;

import javax.swing.*;

public class EventPopup extends JFrame {
    public EventPopup(Event event)
    {
        this.setTitle(event.getAlias());
    }
}
