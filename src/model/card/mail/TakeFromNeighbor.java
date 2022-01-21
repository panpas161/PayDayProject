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

public class TakeFromNeighbor extends MailCard {
    /**
     * Constructor.
     * Postcondition: Creates and initializes a take from neighbor card
     */
    public TakeFromNeighbor(Board board) throws IOException {
        super(
        "Πάρε λεφτά από τον γείτονα",
            MessageGenerator.TakeFromNeighbor.getDescription(),
            ImageIO.read(new File(PathFinder.Images.getImage("format.jpeg"))),
        "Πάρε 50 ευρώ απο τον αντίπαλο",
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
        rival.sendMoney(this.getOwner(),500);
        new MailCardPopup(this);
    }
}
