package model.event;

import controller.Config;
import functions.PathFinder;
import model.player.Player;
import view.EventPopup;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerWon extends Event{
    Player player;
    public PlayerWon(Player player) {
        super(
            4,
            "player_won",
        "Τέλος Παιχνιδιού",
            "Ο Παίκτης " + player.getName() + " Κέρδισε!",
            null,
            1
        );
        this.player = player;
        performAction();
    }

    @Override
    public void performAction() {
        new EventPopup(this);
        Config.Events.playerWon(player);
    }
}
