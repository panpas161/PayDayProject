package view;

import controller.Config;
import model.event.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPopup extends JFrame {
    JLabel image;
    JLabel description;
    protected JButton[] options;
    public EventPopup(Event event)
    {
        this.setTitle(event.getAlias());
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if(event.getImage() != null) {
            image = new JLabel(new ImageIcon(
                    event.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)
            ));
        }
        else
        {
            image = new JLabel();
        }
        c.gridx = 0;
        c.gridy = 0;
        this.add(image,c);
        description = new JLabel(event.getDescription());
        c.gridx = 1;
        this.add(description,c);

        this.setSize(Config.Dimensions.getSmallWidePopupSize());
        this.setVisible(true);
    }
}
