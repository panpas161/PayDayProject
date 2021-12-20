package model.card.mail;

import functions.MessageGenerator;

import model.card.MailCard;

import java.awt.image.BufferedImage;

public class PayNeighbor extends MailCard {

    public PayNeighbor() {
        super(
                "Πλήρωσε τον γείτονα",
                MessageGenerator.PayNeighbor.getDescription(),
                null,
                "test"
        );
    }

    @Override
    public void performAction() {

    }
}
