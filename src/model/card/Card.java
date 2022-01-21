package model.card;

import java.awt.image.BufferedImage;
/**
 * This class represents each card of the deck
 */
public abstract class Card {
    private String title;
    private String description;
    private BufferedImage image;

    /**
     * Constructor.
     * Post Condition: constructs a card
     * @param title: the title of the card
     * @param description: the description of the card
     * @param image: the image of the card
     */
    public Card(String title, String description, BufferedImage image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    /**
     * Accessor.
     * Post Condition: returns the card's title
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Transformer.
     * Post Condition: sets the card's title to a certain value
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor.
     * Post Condition: returns the card's description
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImagePath(String path) {

    }
}
