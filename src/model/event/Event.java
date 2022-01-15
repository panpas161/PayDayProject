package model.event;

import java.awt.image.BufferedImage;

/**
 * Event class represents the events of the game
 */
public abstract class Event {
    protected int id;
    protected String eventName;
    protected String description;
    protected String alias;
    protected BufferedImage image;
    private int optionsNumber;
    private String[] optionStrings;
    protected Event(int id, String eventName,String alias,String description,BufferedImage image)
    {
        this.id = id;
        this.eventName = eventName;
        this.alias = alias;
        this.description = description;
        this.image = image;
        optionsNumber = 5;
        optionStrings = new String[optionsNumber];
    }

    public int getId()
    {
        return this.id;
    }

    public String getEventName()
    {
        return this.eventName;
    }

    public String getAlias()
    {
        return this.alias;
    }

    public abstract void performAction();
}
