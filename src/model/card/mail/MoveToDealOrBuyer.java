package model.card.mail;

import functions.MessageGenerator;

import model.card.MailCard;

import java.awt.image.BufferedImage;

public class MoveToDealOrBuyer extends MailCard {

    public MoveToDealOrBuyer() {
        super(
        "Μετακίνηση σε θέση Συμφωνίας/Αγοραστή.",
            MessageGenerator.MoveToDealOrBuyer.getDescription(),
            null,
            ""
        );
    }

    @Override
    public void performAction() {

    }
}
