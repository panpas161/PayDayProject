package model.board.tiles;

import model.board.Board;
import model.board.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import functions.DaysChecker.Days;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import functions.PathFinder.Images;
import model.card.DealCard;
import model.player.Player;
import view.DealCardPopup;

public class BuyerTile extends Tile {

    public BuyerTile(int number, Board board) throws IOException {
        super(
            number,
            Days.getDay(number),
            ImageIO.read(new File(Images.getImage("buyer.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        new SelectDealCards(player);
    }
}

class SelectDealCards extends JFrame
{
    public SelectDealCards(Player player)
    {
        this.setTitle("Sell a Deal Card");
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
            JButton sellButton = new JButton("Sell");
            sellButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new DealCardPopup(dealCards.get(1),player);
                        }
                    }
            );
            cardPanels.get(i).add(sellButton,c);
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
        this.setVisible(true);
        this.setSize(400,400);
    }
}