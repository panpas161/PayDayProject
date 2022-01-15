package model.board.tiles;

import model.board.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import functions.DaysChecker.Days;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import functions.PathFinder.Images;
import model.player.Player;

public class BuyerTile extends Tile {

    public BuyerTile(int number) throws IOException {
        super(
            number,
            Days.getDay(number),
            ImageIO.read(new File(Images.getImage("buyer.png")))
        );
    }

    @Override
    public void performAction(Player player) {
        new SelectDealCards();
    }
}

class SelectDealCards extends JFrame
{
    public SelectDealCards()
    {
        this.setTitle("Select a Deal Card");
    }
}