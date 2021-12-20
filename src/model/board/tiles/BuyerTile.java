package model.board.tiles;

import model.board.Tile;

import java.awt.image.BufferedImage;

public class BuyerTile extends Tile {

    public BuyerTile(int number, String day) {
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
