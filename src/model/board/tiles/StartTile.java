package model.board.tiles;

import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.player.Player;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StartTile extends Tile {
    public StartTile(Board board) throws IOException {
        super(

                "Start",
                "",
                0,
                "Start",
                ImageIO.read(new File(PathFinder.Images.getImage("start.png"))),
                board
        );
    }
    @Override
    public String getDate()
    {
        return this.day;
    }
    @Override
    public void performAction(Player player){
        ;
    }
}
