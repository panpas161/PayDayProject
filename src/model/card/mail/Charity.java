package model.card.mail;

import functions.MessageGenerator;

import model.card.MailCard;

import java.awt.image.BufferedImage;

public class Charity extends MailCard {
    public Charity() {
        super(
            "",
            MessageGenerator.Charity.getDescription(),
            null,
            ""
        );
    }

    @Override
    public void performAction()
    {

    }
}
