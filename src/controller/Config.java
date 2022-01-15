package controller;

import functions.PathFinder;
import model.board.Board;
import model.board.Tile;
import model.board.tiles.*;
import model.player.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Config {
    public static class Values
    {
        /**
         *
         * @param random
         * @return
         * @throws IOException
         */
        public static Tile[] Tiles(boolean random) throws IOException {
            if(!random)
            {
                Tile[] tiles = new Tile[32];
                tiles[0] = new StartTile();
                tiles[1] = new MessageTileOne(1);
                tiles[2] = new MessageTileTwo(2);
                tiles[3] = new MessageTileTwo(3);
                tiles[4] = new BuyerTile(4);
                tiles[5] = new FamilyCasinoNightTile(5);
                tiles[6] = new DealTile(6);
                tiles[7] = new BuyerTile(7);
                tiles[8] = new RadioContestTile(8);
                tiles[9] = new RadioContestTile(9);
                tiles[10] = new DealTile(10);
                tiles[11] = new SweepstakesTile(11);
                tiles[12] = new SweepstakesTile(12);
                tiles[13] = new LotteryTile(13);
                tiles[14] = new MessageTileTwo(14);
                tiles[15] = new MessageTileOne(15);
                tiles[16] = new MessageTileOne(16);
                tiles[17] = new YardSaleTile(17);
                tiles[18] = new DealTile(18);
                tiles[19] = new FamilyCasinoNightTile(19);
                tiles[20] = new BuyerTile(20);
                tiles[21] = new YardSaleTile(21);
                tiles[22] = new BuyerTile(22);
                tiles[23] = new MessageTileOne(23);
                tiles[24] = new BuyerTile(24);
                tiles[25] = new LotteryTile(25);
                tiles[26] = new MessageTileTwo(26);
                tiles[27] = new BuyerTile(27);
                tiles[28] = new DealTile(28);
                tiles[29] = new LotteryTile(29);
                tiles[30] = new DealTile(30);
                tiles[31] = new PayDayTile(31);
                return tiles;
            }
            else
            {
                return null;
            }
        }
        public static int gameMonths()
        {
            return 6;
        }
    }
    public static class Images
    {
        public static BufferedImage PawnPlayerOne() throws IOException
        {
            return ImageIO.read(new File(PathFinder.Images.getImage("pawn_blue.png")));
        }
        public static BufferedImage PawnPlayerTwo() throws IOException
        {
            return ImageIO.read(new File(PathFinder.Images.getImage("pawn_yellow.png")));
        }
    }
    public static class Events
    {
        public static void payDay(Player player)
        {
            player.setCurrentMonth(player.getCurrentMonth() + 1);
            if(player.getCurrentMonth() > Config.Values.gameMonths())
            {
                //discard player

            }
            else
            {
                player.setCurrentPosition(0);
            }
            player.addCash(3500);
            player.payAllBills();
            player.removeCash(player.getLoans()*10/100);
        }
        public static void playerWon(Player player)
        {

        }
        public static void jackpot(Player player)
        {

        }
    }
}
