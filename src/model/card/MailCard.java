package model.card;

import model.board.Board;
import model.card.Card;
import model.player.Player;

import java.awt.image.BufferedImage;
/**
 * MailCard class represents a mail card
 */
public abstract class MailCard extends Card {
    private String confirmText;
    private Player owner;
    protected Board board;
    public MailCard(String title, String description, BufferedImage image,String confirmText,Board board) {
        super(title,description,image);
        this.confirmText = confirmText;
        this.board = board;
        this.owner = null;
    }

    public void setConfirmText(String confirmText)
    {
        this.confirmText = confirmText;
    }

    public String getConfirmText()
    {
        return this.confirmText;
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    public Player getOwner()
    {
        return this.owner;
    }
    /**
     * The property of the card
     */
    public abstract void performAction();
}
