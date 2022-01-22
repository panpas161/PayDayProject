package view;

import controller.Config;
import model.card.DealCard;
import model.card.MailCard;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DealCardPopup extends JFrame {
    JLabel image;
    JLabel description;
    JButton choice1;
    JButton choice2;
    public DealCardPopup(DealCard card, Player player)
    {
        GridBagConstraints c = new GridBagConstraints();
        this.setTitle("Συμφωνία");
        this.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        image = new JLabel(
            new ImageIcon(card.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH))
        );
        this.add(image,c);

        c.gridx = 1;
        c.gridy = 0;
        description = new JLabel();
        description.setText(
                "<html>"+
                card.getDescription() +
                "<br>Τιμή Αγοράς: " + card.getBuyPrice() +
                "<br>Τιμή Πώλησης: " + card.getSellPrice() +
                "</html>"
        );
        this.add(description,c);
        c.gridx = 0;
        c.gridy = 1;
        choice1 = new JButton(card.getChoice1());
        this.add(choice1,c);
        choice1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player.addDealCard(card);
                        player.removeCash(card.getBuyPrice());

                        setVisible(false);
                        dispose();
                    }
                }
        );
        c.gridx =  1;
        c.gridy = 1;
        choice2 = new JButton(card.getChoice2());
        this.add(choice2,c);
        choice2.addActionListener(
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

    public void setButtonsVisible(boolean visible)
    {
        this.choice1.setVisible(visible);
        this.choice2.setVisible(visible);
    }

    public void setButtonsEnabled(boolean enabled)
    {
        this.choice1.setEnabled(enabled);
        this.choice2.setEnabled(enabled);
    }
}
