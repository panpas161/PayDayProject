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
                MessageGenerator.Bill.getDescription(5),
                MessageGenerator.Bill.getImage(5),
                MessageGenerator.Bill.getChoice(),
                board
        );
    }

    @Override
    public void performAction() {
        this.getOwner().addBills(500);
        new MailCardPopup(this);
    }
}
