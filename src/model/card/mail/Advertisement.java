package model.card.mail;

import functions.MessageGenerator;
import model.board.Board;
import model.card.MailCard;
import view.MailCardPopup;

public class Advertisement extends MailCard {
    public Advertisement(Board board)
    {
        super(
            "Διαφήμιση",
                MessageGenerator.Advertisement.getDescription(),
                null,
                "",
                board
        );
    }

    @Override
    public void performAction()
    {
        this.getOwner().addCash(20);
        new MailCardPopup(this);
    }
}
