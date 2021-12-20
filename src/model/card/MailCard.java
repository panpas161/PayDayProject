package model.card;

import model.card.Card;

import java.awt.image.BufferedImage;
/**
 * MailCard class represents a mail card
 */
public abstract class MailCard extends Card {
    private String confirmText;
    public MailCard(String title, String description, BufferedImage image,String confirmText) {
        super(title,description,image);
        this.confirmText = confirmText;
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
     * The property of the card
     */
    public abstract void performAction();
}
