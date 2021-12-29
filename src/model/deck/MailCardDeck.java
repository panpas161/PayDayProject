package model.deck;

import model.card.MailCard;
import model.card.mail.*;
import model.player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class MailCardDeck {
    private ArrayList<MailCard> mailCards;
    public MailCardDeck()
    {
        mailCards = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            mailCards.add(new PayNeighbor());
            mailCards.add(new TakeFromNeighbor());
            mailCards.add(new Charity());
            mailCards.add(new Bill());
            mailCards.add(new MoveToDealOrBuyer());
            mailCards.add(new Advertisement());
        }
        shuffle();
    }

    public ArrayList<MailCard> getDeck()
    {
        return this.mailCards;
    }
    /**
     * Transformer.
     *
     * Randomly shuffles the deck.
     *
     */
    public void shuffle()
    {
        Collections.shuffle(this.mailCards);
    }
    /**
     * Transformer.
     *
     * Allows a player to draw a card from the deck
     *
     * @param player: to which player should the card belong to
     */
    public void draw(Player player)
    {

    }
}
