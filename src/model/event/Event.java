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

    /**
     * Constructor.
     * Post Condition: creates a new event instance
     * @param id: the id of the event
     * @param eventName: the debug name of the event
     * @param alias: the display name of the event
     * @param description: the description of the event
     * @param image: the image of the event
     * @param optionsNumber: how many options the user has when this event occurs
     */
    protected Event(int id, String eventName,String alias,String description,BufferedImage image, int optionsNumber)
    {
        this.id = id;
        this.eventName = eventName;
        this.alias = alias;
        this.description = description;
        this.image = image;
        this.optionsNumber = optionsNumber;
        optionStrings = new String[optionsNumber];
    }

    /**
     * Accessor.
     * Post Condition: returns the id of the event
     * @return
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Accessor.
     * Post Condition: returns the debug name of the event
     * @return
     */
    public String getEventName()
    {
        return this.eventName;
    }

    /**
     * Accessor.
     * Post Condition: returns the display name of the event
     * @return
     */
    public String getAlias()
    {
        return this.alias;
    }

    /**
     * Accessor.
     * Post Condition: returns the event's description
     * @return
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Accessor.
     * Post Condition: returns the amount of the options
     * @return
     */
    public int getOptionsNumber()
    {
        return this.optionsNumber;
    }

    /**
     * Accessor.
     * Post Condition: returns an array of the available options
     * @return
     */
    public String[] getOptionStrings()
    {
        return this.optionStrings;
    }

    /**
     * Transformer.
     * Post Condition: sets the array of available options
     * @param optionStrings
     */
    protected void setOptionStrings(String[] optionStrings)
    {
        this.optionStrings = optionStrings;
    }

    /**
     * Accessor.
     * Post Condition: returns the image of the event
     * @return
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /**
     * Transformer.
     * Post Condition: the action that is performed when the event occurs
     */
    public abstract void performAction();
}
