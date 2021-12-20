package model.event;

/**
 * Jackpot class represents the jackpot event
 */
public class Jackpot extends Event{
    private float value;
    /**
     * Constructor.
     * Postcondition: Creates and initializes a jackpot event
     */
    public Jackpot()
    {
        super(
            0,
            "jackpot"
        );
        this.value = 0;
    }
    /**
     * Accessor.
     * Postcondition: Returns the jackpot's value
     * @return the jackpot's value
     */
    public float getValue()
    {
        return this.value;
    }
    /**
     * Transformer.
     * Postcondition: sets the jackpot's value
     * @param value: the new jackpot value
     */
    public void setValue(float value)
    {
        this.value = value;
    }
    /**
     * Transformer.
     * Postcondition: adds a value to jackpot's existing value
     * @param value: the added jackpot value
     */
    public void addValue(float value)
    {
        this.value += value;
    }
    /**
     * Transformer.
     * Postcondition: decreases the jackpot's value
     * @param value: the decreased jackpot value
     */
    public void decreaseValue(float value)
    {
        this.value -= value;
    }
}
