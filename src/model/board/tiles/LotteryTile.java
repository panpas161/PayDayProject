package model.board.tiles;

import model.board.Tile;

import java.awt.image.BufferedImage;

public class LotteryTile extends Tile {
    /**
     * Constructor.
     * Postcondition: Creates and initializes the lottery tile
     */
    public LotteryTile(int number, String day) {
        super(
            number,
            day,
            null
        );
    }

    @Override
    public void performAction() {

    }
}
