package model.deck;

import model.board.Board;
import model.card.MailCard;
import model.card.mail.*;
import model.player.Player;
import view.MailCardPopup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MailCardDeck {
    private ArrayList<MailCard> mailCards;
    private ArrayList<MailCard> rejectedMailCards;

    /**
     * Constructor.
     * Post Condition: creates a mail card deck full of cards
     * @param board
     */
    public MailCardDeck(Board board)
    {
        mailCards = new ArrayList<>();
        rejectedMailCards = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            try {
                mailCards.add(new PayNeighbor(board));
                mailCards.add(new TakeFromNeighbor(board));
                mailCards.add(new Charity(board));
                mailCards.add(new Bill(board));
                mailCards.add(new MoveToDealOrBuyer(board));
                mailCards.add(new Advertisement(board));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    public void draw(Player player) {
        int lastIndex = this.mailCards.size()-1;
        MailCard currentMailCard = this.mailCards.get(lastIndex);
        currentMailCard.setOwner(player);
        currentMailCard.performAction();
        currentMailCard.setOwner(null);
        this.rejectedMailCards.add(currentMailCard);
        this.mailCards.remove(currentMailCard);
    }
}
