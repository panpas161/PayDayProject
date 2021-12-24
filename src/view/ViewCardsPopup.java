package view;

import model.card.DealCard;

import javax.swing.*;
import java.util.ArrayList;

public class ViewCardsPopup extends JFrame {
    public ViewCardsPopup(ArrayList<DealCard> dealCards)
    {
        this.setSize(400,500);
        this.setLayout(null);
        this.setVisible(true);
    }
}
