package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VsBot extends JPanel implements ActionListener {
    GameSource src = new GameSource(this);
    Random bot = new Random(); // "bot"))))))))))))))))))))))))))))))))))))))))


    public VsBot()
    {
        for(int i =0; i<src.buttons.length; i++)
        {
            src.buttons[i] = new GameButton(this);
            this.add(src.buttons[i]);
        }
        this.setLayout(new GridLayout(3, 3)); //no layout manager to move buttons easier
        this.setSize(600,600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<9; i++){ //
            if (e.getSource() == src.buttons[i]){


                src.buttons[i].setIcon(new ImageIcon("src/Icons/x.jpg"));
                src.calc[i] = 1;
                src.buttons[i].setEnabled(false);
                src.turn = false;

                System.out.println("My turn");
                src.turnsCount++;
                src.checkWinner();
                BotMove();


            }

        }
    }

    private void BotMove() {
        System.out.println("Bot turn");
        if(!src.turn)
        {
            int move = bot.nextInt(8);
            if(src.calc[move] == 0)
            {
                src.buttons[move].setIcon(new ImageIcon("src/Icons/o.jpg"));
                src.buttons[move].setEnabled(false);
                src.calc[move] = 2;
                src.turnsCount++;
                src.checkWinner();
            }else
            {
                BotMove();
            }
        }
    }
}
