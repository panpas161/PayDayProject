package model.card.mail;

import functions.MessageGenerator;

import model.card.MailCard;

public class Bill extends MailCard {
    public Bill()
    {
        super(
                "Εξόφληση Λογαριασμού",
                MessageGenerator.Bill.getDescription(),
                null,
                ""
        );
    }

    @Override
    public void performAction() {

    }
}
