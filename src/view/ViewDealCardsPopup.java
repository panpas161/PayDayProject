package view;

import model.card.DealCard;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewDealCardsPopup extends JFrame {
    public ViewDealCardsPopup(Player player)
    {
        ArrayList<DealCard> dealCards = player.getDealCards();
        ArrayList<JPanel> cardPanels = new ArrayList<>();
        for(int i=0;i<dealCards.size();i++)
        {
            cardPanels.add(new JPanel());
            cardPanels.get(i).add(
                    new JLabel(dealCards.get(i).getTitle())
            );
            cardPanels.get(i).add(
                    new JLabel(
                        new ImageIcon(dealCards.get(i).getImage())
                    )
            );
        }
        for(int i=0;i<dealCards.size();i++)
        {
            this.add(cardPanels.get(i));
        }
        this.setLayout(new GridLayout(cardPanels.size()/5,4));
        this.setTitle(player.getName() + " - " + "Deal Cards");
        this.setSize(400,500);
        this.setLayout(null);
        this.setVisible(true);
    }
}
