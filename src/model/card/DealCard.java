package model.card;

import functions.MessageGenerator;
import model.card.Card;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * This class represents a deal card
 */
public class DealCard extends Card {
    private int buyPrice;
    private int sellPrice;
    private String choice1;
    private String choice2;
    public DealCard()
    {
        super(
            MessageGenerator.DealCard.getTitle(),
            MessageGenerator.DealCard.getDescription(),
            MessageGenerator.DealCard.getImage()
        );
        this.buyPrice = MessageGenerator.DealCard.getCost();
        this.sellPrice = MessageGenerator.DealCard.getValue();
        this.choice1 = MessageGenerator.DealCard.getChoiceOne();
        this.choice2 = MessageGenerator.DealCard.getChoiceTwo();
        MessageGenerator.DealCard.setRandomValue(new Random().nextInt(MessageGenerator.DealCard.getTotalCards()));
    }

    public int getBuyPrice()
    {
        return this.buyPrice;
    }

    public int getSellPrice()
    {
        return this.sellPrice;
    }

    public String getChoice1()
    {
        return this.choice1;
    }

    public String getChoice2()
    {
        return this.choice2;
    }

    @Override
    public String toString() {
        return "DealCard{" +
                "buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                '}';
    }
}
