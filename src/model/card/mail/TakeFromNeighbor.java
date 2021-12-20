package model.card.mail;

import functions.MessageGenerator;
import model.card.MailCard;
import java.awt.image.BufferedImage;

public class TakeFromNeighbor extends MailCard {
    /**
     * Constructor.
     * Postcondition: Creates and initializes a take from neighbor card
     */
    public TakeFromNeighbor() {
        super(
        "Πάρε λεφτά από τον γείτονα",
            MessageGenerator.TakeFromNeighbor.getDescription(),
            null,
            ""
        );
    }

    @Override
    public void performAction()
    {

    }
}
