package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VsBotGame extends JFrame implements ActionListener {
    GameButton[] buttons = new GameButton[9]; // ui buttons
    int [] calc = new int[9]; //need to calculate winner;
    boolean turn = true; // true - x turn | false - o turn

    Random bot = new Random(); // "bot"))))))))))))))))))))))))))))))))))))))))


    public VsBotGame()
    {
        for(int i =0; i<buttons.length; i++)
        {
            buttons[i] = new GameButton(this);
            this.add(buttons[i]);
        }

        this.setResizable(false); //frame are not resizable
        this.setLayout(new GridLayout(3, 3)); //no layout manager to move buttons easier
        this.setVisible(true); //visibility true
        this.setSize(600, 600); //size of frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<9; i++){ //
            if (e.getSource() == buttons[i]){


                buttons[i].setIcon(new ImageIcon("src/Icons/x.jpg"));
                calc[i] = 1;
                buttons[i].setEnabled(false);
                turn = false;

                System.out.println("My turn");
                checkWinner();
                BotMove();


            }

        }
    }

    private void BotMove() {
        System.out.println("Bot turn");
        if(!turn)
        {
            int move = bot.nextInt(8);
            if(calc[move] == 0)
            {
                buttons[move].setIcon(new ImageIcon("src/Icons/o.jpg"));
                buttons[move].setEnabled(false);
                calc[move] = 2;
                checkWinner();
            }else
            {
                BotMove();
            }
        }

    }

    private void checkWinner() {
        //rows
        for(int i = 0; i<=6; i+=3)
        {
            if(calc[i]!=0 && calc[i] == calc[i+1] && calc[i] == calc[i+2])
            {
                if(calc[i] == 1) {
                    JOptionPane.showMessageDialog(null, "x wins");
                }
                if(calc[i] == 2)
                {
                    JOptionPane.showMessageDialog(null, "o wins");
                }
                restart();
            }
        }
        //columns
        for(int i = 0; i<3; i++)
        {
            if(calc[i]!=0 && calc[i] == calc[i+3] && calc[i] == calc[i+6])
            {
                if(calc[i] == 1) {
                    JOptionPane.showMessageDialog(null, "x wins");

                }
                if(calc[i] == 2)
                {
                    JOptionPane.showMessageDialog(null, "o wins");

                }
                restart();

            }
        }
        //diagonals

        // 0 4 8
        if(calc[0]!=0 && calc[0] == calc[4] && calc[0] == calc[8])
        {
            if(calc[0] == 1) {
                JOptionPane.showMessageDialog(null, "x wins");

            }
            if(calc[0] == 2)
            {
                JOptionPane.showMessageDialog(null, "o wins");

            }
            restart();
        }
        if(calc[2]!=0 && calc[2] == calc[4] && calc[2] == calc[6])
        {
            if(calc[2] == 1) {
                JOptionPane.showMessageDialog(null, "x wins");

            }
            if(calc[2] == 2)
            {
                JOptionPane.showMessageDialog(null, "o wins");

            }
            restart();
        }
    }

    private void restart() {
        turn = true;
        for(int i = 0; i< buttons.length; i++)
        {
            buttons[i].setEnabled(true);
            buttons[i].setIcon(null);
            calc[i] = 0;
        }
    }
}
