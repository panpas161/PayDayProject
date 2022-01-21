package view;

import model.card.DealCard;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewDealCardsPopup extends JFrame {
    public ViewDealCardsPopup(Player player)
    {
        ArrayList<DealCard> dealCards = player.getDealCards();
        ArrayList<JPanel> cardPanels = new ArrayList<>();
        GridBagConstraints c = new GridBagConstraints();
        GridLayout grid = new GridLayout(dealCards.size()/8,8);
        grid.setHgap(25);
        this.setLayout(grid);
        for(int i=0;i<dealCards.size();i++)
        {
            cardPanels.add(new JPanel());
            cardPanels.get(i).setLayout(new GridBagLayout());
            c.gridx = 0;
            c.gridy = 0;
            cardPanels.get(i).add(
                new JLabel(
                    new ImageIcon(dealCards.get(i).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH))
                )
            );
            c.gridy = 1;
            JButton viewButton = new JButton("View");
            viewButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DealCardPopup dealCardPopup = new DealCardPopup(dealCards.get(1),player);
                            dealCardPopup.setButtonsEnabled(false);
                            dealCardPopup.setButtonsVisible(false);
                        }
                    }
            );
            cardPanels.get(i).add(viewButton,c);
        }
        c.gridx = 0;
        c.gridy = 0;
        for(int i=0;i<dealCards.size();i++)
        {
            if(i%6 == 0)
            {
                c.gridx++;
            }
            c.gridy++;
            this.add(cardPanels.get(i),c);
        }
        this.setLayout(new GridLayout(cardPanels.size()/5,4));
        this.setTitle(player.getName() + " - " + "Deal Cards");
        this.setSize(500,500);
        this.setVisible(true);
    }
}
