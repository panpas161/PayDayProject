package model.card.mail;

import functions.MessageGenerator;
import model.card.MailCard;

public class Advertisement extends MailCard {
    public Advertisement()
    {
        super(
            "Διαφήμιση",
                MessageGenerator.Advertisement.getDescription(),
                null,
                ""
        );
    }

    @Override
    public void performAction()
    {

    }
}
