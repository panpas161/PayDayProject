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
        super(MessageGenerator.DealCard.getTitle(), MessageGenerator.DealCard.getDescription(new Random().nextInt(19) + 1), MessageGenerator.DealCard.getImage(new Random().nextInt(19) + 1));
        int randomValue = new Random().nextInt(19) + 1;
        this.buyPrice = MessageGenerator.DealCard.getCost(randomValue);
        this.sellPrice = MessageGenerator.DealCard.getValue(randomValue);
        this.choice1 = MessageGenerator.DealCard.getChoiceOne();
        this.choice2 = MessageGenerator.DealCard.getChoiceTwo();
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
}
