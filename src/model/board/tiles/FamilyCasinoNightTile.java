package model.board.tiles;

import functions.DaysChecker;
import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.player.Player;
import controller.Controller;
import view.TilePopup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FamilyCasinoNightTile extends Tile {
    public FamilyCasinoNightTile(int number,Board board) throws IOException {
        super(
        "Family Casino Night",
        "Εάν έφτασες σε αυτή τη θέση με περιττό αριθμό ζαριού δίνεις 500 ευρώ στο jackpot<br>Διαφορετικά πάιρνεις 500 ευρώ απο τη τράπζα",
            number,
            DaysChecker.Days.getDay(number),
            ImageIO.read(new File(PathFinder.Images.getImage("casino.png"))),
            board
        );
    }

    @Override
    public void performAction(Player player) {
        if(player.getDice().getCurrentValue()%2==0)
        {
            player.addCash(500);
            setDescription(
                    "<html>" +
                    getDescription() +
                    "Αποτέλεσμα: <br>" +
                    "Ήρθες εδώ με ζυγό αριθμό ζαριού<br>Κερδίζεις 500 ευρώ"+
                    "</html>"
            );
        }
        else
        {
            player.removeCash(500);
            Controller.jackpot.addValue(500);
            setDescription(
                    "<html>" +
                    getDescription() +
                    "Αποτέλεσμα: <br>" +
                    "Ήρθες εδώ με περιττό αριθμό ζαριού<br>Χάνεις 500 ευρώ"+
                    "</html>"
            );
        }
        new TilePopup(this);
    }
}
