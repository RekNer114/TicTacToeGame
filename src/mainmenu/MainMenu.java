package mainmenu;

import game.GameFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    MenuButton vsBot, vsPlayer, exit;
    public MainMenu()
    {
        vsBot = new MenuButton("Vs Bot", this,200);
        vsPlayer = new MenuButton("Vs Player", this,300);
        exit = new MenuButton("Exit", this,400);

        //new frame for main menu
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.getContentPane().setBackground(Color.BLACK);
        this.add(vsBot);
        this.add(vsPlayer);
        this.add(exit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vsBot))
        {
            this.dispose();
            new GameFrame(true);
        }

        if (e.getSource().equals(vsPlayer))
        {
            this.dispose();
            new GameFrame(false);
        }

        if (e.getSource().equals(exit))
        {
            System.exit(0);
        }

    }
}
