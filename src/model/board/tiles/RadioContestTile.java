package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.player.Player;
import view.TilePopup;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RadioContestTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the radio contest tile
     */
    public RadioContestTile(int number,Board board) throws IOException {
        super(
            "Radio Contest",
            "Η τράπεζα προσφέρει 1000 ευρώ στον παίκτη που θα φέρει τον μεγαλύτερο αριθμό",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("radio.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        Player player1 = board.getPlayer1();
        Player player2 = board.getPlayer2();
        while(true)
        {
            player1.getDice().rollEvent();
            player2.getDice().rollEvent();
            if(player1.getDice().getCurrentValue() != player2.getDice().getCurrentValue())
            {
                if(player1.getDice().getCurrentValue() > player2.getDice().getCurrentValue())
                {
                    player1.addCash(1000);
                    setDescription(
                            "<html>" +
                            getDescription() +
                            "<br>Result: <br>" +
                            player1.getName() + " Rolled " + player1.getDice().getCurrentValue() + "<br>" +
                            player2.getName() + " Rolled " + player2.getDice().getCurrentValue() + "<br>" +
                            player1.getName() + " Won!" +
                            "</html>"

                    );
                }
                else
                {
                    player2.addCash(1000);
                    setDescription(
                        "<html>" +
                        getDescription() +
                        "<br>Result: <br>" +
                        player1.getName() + " Rolled " + player1.getDice().getCurrentValue() + "<br>" +
                        player2.getName() + " Rolled " + player2.getDice().getCurrentValue() + "<br>" +
                        player2.getName() + " Won!" +
                        "</html>"
                    );
                }
                break;
            }
        }
        new TilePopup(this);
    }
}
