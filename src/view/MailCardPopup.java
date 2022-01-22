package view;

import controller.Config;
import model.card.Card;
import model.card.MailCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailCardPopup extends JFrame {
    JLabel description;
    JButton confirm;
    JLabel image;
    public MailCardPopup(MailCard card)
    {
        GridBagConstraints c = new GridBagConstraints();
        this.setTitle(card.getTitle());
        this.setLayout(new GridBagLayout());
        image = new JLabel(new ImageIcon(card.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH)));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        c.ipady = 2;
        this.add(image,c);
        description = new JLabel(card.getDescription());
        c.gridx = 1;
        c.gridy = 0;
        this.add(description,c);
        confirm = new JButton(card.getConfirmText());
        c.gridy = 2;
        this.add(confirm,c);
        confirm.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        dispose();
                    }
                }
        );
        this.setVisible(true);
        this.setSize(Config.Dimensions.getSmallWidePopupSize());
    }

}
