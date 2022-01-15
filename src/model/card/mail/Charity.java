package model.card.mail;

import controller.Controller;
import functions.MessageGenerator;

import model.board.Board;
import model.card.MailCard;
import model.player.Player;
import view.MailCardPopup;

import java.awt.image.BufferedImage;

public class Charity extends MailCard {
    public Charity(Board board) {
        super(
            "",
            MessageGenerator.Charity.getDescription(),
            null,
            "",
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
