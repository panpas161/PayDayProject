package model.event;

import controller.Config;
import functions.PathFinder;
import model.player.Player;
import view.EventPopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PayDay extends Event{
    Player player;
    public PayDay(Player player) throws IOException {
        super(
                3,
                "payday",
                "PayDay",
                "Πέρασε ένας μήνας",
                ImageIO.read(new File(PathFinder.Images.getImage("logo.png"))),
                2
        );
        this.player = player;
        setOptionStrings(
                new String[]{
                    "Εντάξει",
                    "Πληρωμή Δανείων"
                }
        );
        performAction();
    }

    @Override
    public void performAction() {
        Config.Events.payDay(player);
        new EventPopup(this);
    }
}
