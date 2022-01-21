package model.card.mail;

import controller.Controller;
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

public class Charity extends MailCard {
    public Charity(Board board) throws IOException {
        super(
            "Φιλανθρωπία",
            MessageGenerator.Charity.getDescription(5),
            MessageGenerator.Charity.getImage(5),
            MessageGenerator.Charity.getChoice(5),
            board
        );
    }

    @Override
    public void performAction()
    {
        Player owner = getOwner();
        if(owner.getBalance() < 50)
        {
            owner.takeLoan(50);
        }
        owner.removeCash(50);
        Controller.jackpot.addValue(50);
        new MailCardPopup(this);
    }
}
