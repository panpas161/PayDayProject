package model.event;

import controller.Config;
import model.player.Player;
import view.EventPopup;

import java.awt.image.BufferedImage;

public class PlayerWon extends Event{
    Player player;
    public PlayerWon(Player player) {
        super(4, "player_won", "Ο Παίκτης " + player.getName() + " Κέρδισε!", "", null);
        this.player = player;
        performAction();
    }

    @Override
    public void performAction() {
        Config.Events.playerWon(player);
        new EventPopup(this);
    }
}
