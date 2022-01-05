package view;

import model.card.DealCard;

import javax.swing.*;
import java.util.ArrayList;

public class ViewCardsPopup extends JFrame {
    public ViewCardsPopup(ArrayList<DealCard> dealCards)
    {
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
        this.setSize(400,500);
        this.setLayout(null);
        this.setVisible(true);
    }
}
