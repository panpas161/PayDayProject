package model.card;

import java.awt.image.BufferedImage;
/**
 * This class represents each card of the deck
 */
public abstract class Card {
    private String title;
    private String description;
    private BufferedImage image;

    public Card(String title, String description, BufferedImage image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
