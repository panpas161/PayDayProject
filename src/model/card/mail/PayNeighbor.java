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
import java.util.Random;

public class PayNeighbor extends MailCard {

    public PayNeighbor(Board board) throws IOException {
        super(
                "Πλήρωσε τον γείτονα",
                MessageGenerator.PayNeighbor.getDescription(),
                MessageGenerator.PayNeighbor.getImage(),
                MessageGenerator.PayNeighbor.getConfirmText(),
                MessageGenerator.PayNeighbor.getValue(),
                board
        );
        MessageGenerator.PayNeighbor.setRandomValue(new Random().nextInt(MessageGenerator.PayNeighbor.getTotalCards()));
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
