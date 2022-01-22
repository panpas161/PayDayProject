package model.deck;

import model.card.DealCard;
import model.player.Player;

import java.util.ArrayList;
/**
 * DealCardDeck class represents the deck of deal cards
 */
public class DealCardDeck {
    private ArrayList<DealCard> dealCards;
    private ArrayList<DealCard> rejectedDealCards;
    /**
     * Constructor.
     *
     * Postcondition Creates a new DealCardDeck with 'col' col and 'value' value.
     *
     */
    public DealCardDeck()
    {
        dealCards = new ArrayList<>();
        for(int i=0;i<64;i++)
        {
            dealCards.add(new DealCard());
        }
        rejectedDealCards = new ArrayList<>();
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
        int lastIndex = this.dealCards.size()-1;
        if(lastIndex == -1)
        {
            lastIndex = 0;
        }
        player.addDealCard(this.dealCards.get(lastIndex));
        this.rejectedDealCards.add(this.dealCards.get(lastIndex));
        this.dealCards.remove(lastIndex);
    }
}
