package model.card.mail;

import functions.MessageGenerator;
import functions.PathFinder;
import model.board.Board;
import model.card.MailCard;
import view.MailCardPopup;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Advertisement extends MailCard {
    public Advertisement(Board board) throws IOException {
        super(
            "Διαφήμιση",
                MessageGenerator.Advertisement.getDescription(),
                ImageIO.read(new File(PathFinder.Images.getImage("tiktok.png"))),
                "Πουλησέ την για 20 ευρώ",
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
