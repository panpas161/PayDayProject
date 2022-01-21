package view;

import functions.PathFinder;
import model.deck.DealCardDeck;
import model.deck.MailCardDeck;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DecksView extends JPanel {
    JPanel dealCardDeckPanel;
    JPanel mailCardDeckPanel;
    JLabel dealCardDeckImage;
    JLabel mailCardDeckImage;
    public DecksView(DealCardDeck dealCardDeck, MailCardDeck mailCardDeck)
    {
        dealCardDeckPanel = new JPanel();
        mailCardDeckPanel = new JPanel();
        ImageIcon mailCardDeckIcon = new ImageIcon(PathFinder.Images.getImage("mailCard.png"));
        mailCardDeckIcon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon dealCardDeckIcon = new ImageIcon(PathFinder.Images.getImage("dealCard.png"));
        dealCardDeckIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        mailCardDeckImage = new JLabel(
                mailCardDeckIcon
        );
        dealCardDeckImage = new JLabel(
                dealCardDeckIcon
        );

        mailCardDeckImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        dealCardDeckImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        this.setLayout(new GridLayout(1,2));
        mailCardDeckPanel.add(mailCardDeckImage);
        dealCardDeckPanel.add(dealCardDeckImage);
    }
}
