package view;

import model.event.Event;

import javax.swing.*;
import java.awt.*;

public class EventPopup extends JFrame {
    JLabel image;
    JLabel description;
    JButton[] options;
    public EventPopup(Event event)
    {
        this.setTitle(event.getAlias());
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        image = new JLabel(new ImageIcon(
            event.getImage()
        ));
        c.gridx = 0;
        c.gridy = 0;
        this.add(image,c);
        description = new JLabel(event.getDescription());
        c.gridx = 1;
        this.add(description,c);
        options = new JButton[event.getOptionsNumber()];
        c.gridx = 0;
        c.gridy = 2;
        for(int i=0;i<event.getOptionsNumber()-1;i++)
        {
            options[i].setText(event.getOptionStrings()[i]);
            c.gridx++;
            this.add(options[i],c);
        }
    }
}
