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
import java.util.ArrayList;
import java.util.Collections;

public class Config {
    public static class Values
    {
        /**
         *
         * @param random
         * @return
         * @throws IOException
         */
        public static Tile[] Tiles(boolean random,Board board) throws IOException {
            if(!random)
            {
                Tile[] tiles = new Tile[32];
                tiles[0] = new StartTile(board);
                tiles[1] = new MessageTileOne(1,board);
                tiles[2] = new MessageTileTwo(2,board);
                tiles[3] = new MessageTileTwo(3,board);
                tiles[4] = new BuyerTile(4,board);
                tiles[5] = new FamilyCasinoNightTile(5,board);
                tiles[6] = new DealTile(6,board);
                tiles[7] = new BuyerTile(7,board);
                tiles[8] = new RadioContestTile(8,board);
                tiles[9] = new RadioContestTile(9,board);
                tiles[10] = new DealTile(10,board);
                tiles[11] = new SweepstakesTile(11,board);
                tiles[12] = new SweepstakesTile(12,board);
                tiles[13] = new LotteryTile(13,board);
                tiles[14] = new MessageTileTwo(14,board);
                tiles[15] = new MessageTileOne(15,board);
                tiles[16] = new MessageTileOne(16,board);
                tiles[17] = new YardSaleTile(17,board);
                tiles[18] = new DealTile(18,board);
                tiles[19] = new FamilyCasinoNightTile(19,board);
                tiles[20] = new BuyerTile(20,board);
                tiles[21] = new YardSaleTile(21,board);
                tiles[22] = new BuyerTile(22,board);
                tiles[23] = new MessageTileOne(23,board);
                tiles[24] = new BuyerTile(24,board);
                tiles[25] = new LotteryTile(25,board);
                tiles[26] = new MessageTileTwo(26,board);
                tiles[27] = new BuyerTile(27,board);
                tiles[28] = new DealTile(28,board);
                tiles[29] = new LotteryTile(29,board);
                tiles[30] = new DealTile(30,board);
                tiles[31] = new PayDayTile(31,board);
                return tiles;
            }
            else
            {
//                ArrayList<Tile> tempTiles = new ArrayList<>();
//                Tile[] tiles = new Tile[32];
//                for(int i=0;i<8;i++)
//                {
//                    tempTiles.add(new MessageTileOne());
//                }
//                for(int i=0;i<5;i++)
//                {
//                    tempTiles.add(new DealTile());
//                }
//                for(int i=0;i<3;i++)
//                {
//                    tempTiles.add(new LotteryTile());
//                }
//                for(int i=0;i<2;i++)
//                {
//                    tempTiles.add(new RadioContestTile());
//                    tempTiles.add(new FamilyCasinoNightTile());
//                    tempTiles.add(new SweepstakesTile());
//                    tempTiles.add(new YardSaleTile());
//                }
//                for(int i=0;i<6;i++)
//                {
//                    tempTiles.add(new BuyerTile());
//                }
//                Collections.shuffle(tempTiles);
//                tiles[0] = new StartTile();
//                for(int i=1;i<31;i++)
//                {
//                    tiles[i] = tempTiles.get(i-1);
//                    tiles[i].construct(i,board);
//                }
//                tiles[31] = new PayDayTile();
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
