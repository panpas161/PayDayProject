package model.card.mail;

import functions.MessageGenerator;

import functions.PathFinder;
import model.board.Board;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PayNeighbor extends MailCard {

    public PayNeighbor(Board board) throws IOException {
        super(
                "Πλήρωσε τον γείτονα",
                MessageGenerator.PayNeighbor.getDescription(),
                ImageIO.read(new File(PathFinder.Images.getImage("monitor.png"))),
                "Πλήρωσε 60 ευρώ",
                board
        );
    }

    @Override
    public void performAction()
    {
        Player rival;
        if(this.getOwner() == board.getPlayer1())
        {
            rival = board.getPlayer2();
        }
        else
        {
            rival = board.getPlayer1();
        }
        this.getOwner().sendMoney(rival,60);
        new MailCardPopup(this);
    }
}
