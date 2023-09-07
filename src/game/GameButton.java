package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameButton extends JButton {

    public GameButton(Object listener)
    {
        this.setSize(200,200); //size
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //white border to separate buttons
        this.addActionListener((ActionListener) listener); //action listener
    }
}
