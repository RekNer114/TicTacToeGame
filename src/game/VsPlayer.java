package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VsPlayer extends JFrame implements ActionListener {
    GameSource src = new GameSource(this);

    public VsPlayer()
    {

        for(int i =0; i<src.buttons.length; i++)
        {
            src.buttons[i] = new GameButton(this);
            this.add(src.buttons[i]);
        }

        this.setResizable(false); //frame are not resizable
        this.setLayout(new GridLayout(3, 3)); //no layout manager to move buttons easier
        this.setVisible(true); //visibility true
        this.setSize(600, 600); //size of frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<src.buttons.length; i++)
        {
            if(src.turn)
            {
                if (e.getSource() == src.buttons[i])
                {
                    src.buttons[i].setIcon(new ImageIcon("src/Icons/x.jpg"));
                    src.calc[i] = 1;
                    src.buttons[i].setEnabled(false);
                    src.turn = false;
                    src.turnsCount++;
                    src.checkWinner();
                }
            }else
            {
                if(e.getSource().equals(src.buttons[i])) {
                    src.buttons[i].setIcon(new ImageIcon("src/Icons/o.jpg"));
                    src.calc[i] = 2;
                    src.buttons[i].setEnabled(false);
                    src.turn = true;
                    src.turnsCount++;
                    src.checkWinner();
                }
            }
        }
    }
}
