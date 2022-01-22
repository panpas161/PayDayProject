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
    private int value;
    public MailCard(String title, String description, BufferedImage image,String confirmText,int value,Board board) {
        super(title,description,image);
        this.confirmText = confirmText;
        this.board = board;
        this.value = value;
        this.owner = null;
    }

    public MailCard(String title, String description, BufferedImage image,String confirmText,Board board) {
        super(title,description,image);
        this.confirmText = confirmText;
        this.board = board;
        this.value = 0;
        this.owner = null;
    }

    protected void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setConfirmText(String confirmText)
    {
        this.confirmText = confirmText;
    }

    public String getConfirmText()
    {
        return this.confirmText;
    }

    /**
     * Transformer.
     * Post Condition: changes the ownership of the card
     * @param owner: the new owner
     */
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    /**
     * Accessor.
     * Post Condition: returns the owner of the card
     * @return
     */
    public Player getOwner()
    {
        return this.owner;
    }
    /**
     * The property of the card
     */
    public abstract void performAction();
}
