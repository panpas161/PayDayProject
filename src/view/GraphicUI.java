package view;
import controller.Controller;
import functions.MessageGenerator;
import model.board.Board;
import model.card.mail.Bill;
import model.player.Player;
import view.BoardView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import functions.PathFinder.Images;

public class GraphicUI extends JFrame {
    Controller controller;
    JLabel logo;
    BoardView boardPanel;
    InfoBoxView infoBox;
    PlayerUI playerOnePanel;
    PlayerUI playerTwoPanel;
    JPanel left,right;
    Board board;
    final int WIDTH = 1000;
    final int HEIGHT = 800;
    public GraphicUI() throws IOException {
        controller = new Controller();
        board = controller.getBoard();
        left = new JPanel();
        left.setLayout(new GridBagLayout());

        right = new JPanel();
        right.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        //logo
        ImageIcon logoIcon = new ImageIcon(Images.getImage("logo.png"));
        logo = new JLabel(new ImageIcon(logoIcon.getImage().getScaledInstance(WIDTH/2,200,Image.SCALE_SMOOTH)));
        c.gridx = 0;
        c.gridy = 0;
        left.add(logo,c);

        //board
        c.gridx = 0;
        c.gridy = 1;
        boardPanel = new BoardView(board, board.getPlayer1(), board.getPlayer2());
        left.add(boardPanel,c);
        playerOnePanel = new PlayerUI(controller.getBoard().getPlayer1(), controller.getTurn());

        //player1 panel
        c.fill = 3;
        c.gridx = 0;
        c.gridy = 0;
        right.add(playerOnePanel,c);

        //info box
        infoBox = new InfoBoxView(controller.getTurn().getCurrentPlayer());
        boardPanel.addInfoBoxView(infoBox);
        c.gridy = 1;
        right.add(infoBox,c);

        //player2 panel
        playerTwoPanel = new PlayerUI(controller.getBoard().getPlayer2(), controller.getTurn());
        c.gridy = 3;
        right.add(playerTwoPanel,c);

        //listeners
        playerOnePanel.setEndTurnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!playerTwoPanel.getEndTurn().isEnabled())
                {
                    controller.getTurn().nextTurn();
                    playerTwoPanel.setEnabledButtons(true);
                    playerTwoPanel.updatePlayerInfo();
                    playerOnePanel.setEnabledButtons(false);
                    playerOnePanel.updatePlayerInfo();
                    infoBox.setCurrentPlayer(board.getPlayer2());
                }
            }
        });

        playerTwoPanel.setEndTurnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!playerOnePanel.getEndTurn().isEnabled())
                {
                    controller.getTurn().nextTurn();
                    playerOnePanel.setEnabledButtons(true);
                    playerTwoPanel.setEnabledButtons(false);
                    infoBox.setCurrentPlayer(board.getPlayer1());
                }
            }
        });

        //left panel

//        left.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        this.add(left,c);

        //right panel
        c.gridwidth = 2;
        c.gridx = 1;
        c.weightx = 0;
        this.add(right,c);


        this.setLayout(new GridLayout(1,2));
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
//        new MailCardPopup(new Bill(new Board(new Player("test",215231,null),new Player("test",125125,null))));
        new GraphicUI();
    }
}
