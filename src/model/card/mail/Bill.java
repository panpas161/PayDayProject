package model.card.mail;

import functions.MessageGenerator;

import functions.PathFinder;
import model.board.Board;
import model.card.MailCard;
import view.MailCardPopup;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Bill extends MailCard {
    public Bill(Board board) throws IOException {
        super(
                "Εξόφληση Λογαριασμού",
                MessageGenerator.Bill.getDescription(),
                MessageGenerator.Bill.getImage(),
                MessageGenerator.Bill.getConfirmText(),
                MessageGenerator.Bill.getValue(),
                board
        );
        MessageGenerator.Bill.setRandomValue(new Random().nextInt(MessageGenerator.Bill.getTotalCards()));
    }

    @Override
    public void performAction() {
        this.getOwner().addBills(this.getValue());
        new MailCardPopup(this);
    }
}
