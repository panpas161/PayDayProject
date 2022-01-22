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

public class Advertisement extends MailCard {
    public Advertisement(Board board) throws IOException {
        super(
            "Διαφήμιση",
                MessageGenerator.Advertisement.getDescription(),
                ImageIO.read(new File(PathFinder.Images.getImage("tiktok.png"))),
                MessageGenerator.Advertisement.getConfirmText(),
                MessageGenerator.Advertisement.getValue(),
                board
        );
        MessageGenerator.Advertisement.setRandomValue(new Random().nextInt(MessageGenerator.Advertisement.getTotalCards()));

    }

    @Override
    public void performAction()
    {
        this.getOwner().addCash(this.getValue());
        new MailCardPopup(this);
    }
}
