package model.card.mail;

import functions.MessageGenerator;

import model.board.Board;
import model.card.MailCard;
import view.MailCardPopup;

public class Bill extends MailCard {
    public Bill(Board board)
    {
        super(
                "Εξόφληση Λογαριασμού",
                MessageGenerator.Bill.getDescription(),
                null,
                "",
                board
        );
    }

    @Override
    public void performAction() {
        this.getOwner().addBills(500);
        new MailCardPopup(this);
    }
}
