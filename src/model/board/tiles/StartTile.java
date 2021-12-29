package model.board.tiles;

import functions.PathFinder;
import model.board.Tile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StartTile extends Tile {
    public StartTile() throws IOException {
        super(
                1,
                "Start",
                ImageIO.read(new File(PathFinder.Images.getImage("start.png")))
        );
    }
    @Override
    public String getDate()
    {
        return this.day;
    }
    @Override
    public void performAction() {

    }
}
