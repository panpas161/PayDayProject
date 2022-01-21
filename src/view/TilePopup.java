package view;

import model.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TilePopup extends JFrame {
    JLabel image;
    JLabel description;
    JButton confirm;
    public TilePopup(Tile tile)
    {
        GridBagConstraints c = new GridBagConstraints();
//        this.setTitle(tile.getTitle());
        this.setLayout(new GridBagLayout());
        image = new JLabel(new ImageIcon(tile.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(image,c);
        description = new JLabel("description");
        c.gridx = 1;
        c.gridy = 0;
        this.add(description,c);
        confirm = new JButton("Εντάξει");
        c.gridx = 1;
        c.gridy = 1;
        this.add(confirm,c);
        confirm.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        dispose();
                    }
                }
        );
        this.setVisible(true);
        this.setSize(400,400);
    }
}
