package model.card;

import model.card.Card;

import java.awt.image.BufferedImage;
/**
 * This class represents a deal card
 */
public class DealCard extends Card {
    private int buyPrice;
    private int sellPrice;
    private String choice1;
    private String choice2;
    public DealCard(String title, String description, BufferedImage image,int buyPrice,int sellPrice,String choice1,String choice2)
    {
        super(title,description,image);
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }
}
