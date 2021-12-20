package model.event;

/**
 * Event class represents the events of the game
 */
public abstract class Event {
    private int id;
    private String eventName;

    protected Event(int id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }
}
