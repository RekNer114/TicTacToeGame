package game;

import mainmenu.MainMenu;

import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame{
    JPanel optionPanel;
    JButton menu;
    static JLabel score;

    public GameFrame(boolean vs)
    {
            //vs= true - with bot
            //vs= false - with player

        this.setResizable(false); //frame are not resizable
        this.setVisible(true); //visibility true
        this.setSize(600, 700); //size of frame
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        optionPanel = new JPanel();
        optionPanel.setBackground(Color.BLACK);
        optionPanel.setLayout(null);
        optionPanel.setPreferredSize(new Dimension(600, 100));

        menu = new JButton();
        menu.setBackground(Color.BLACK);
        menu.setFocusable(false);
        menu.setText("<- Menu");
        menu.setForeground(Color.WHITE);
        menu.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        menu.setBounds(0, 0, 195, 100);
        menu.addActionListener(
                e ->
        {
            new MainMenu();
            GameSource.xScore = 0;
            GameSource.oScore = 0;
            this.dispose();
        });

        score = new JLabel();
        score.setForeground(Color.WHITE);
        score.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        score.setBounds(200, 0, 195, 100);
        score.setText(GameSource.getXScore() + " - " + GameSource.getOScore());

        optionPanel.add(score);
        optionPanel.add(menu);


        this.add(optionPanel, BorderLayout.NORTH);
        if(vs)
        {
            this.add(new VsBot(), BorderLayout.CENTER);
        }else
        {
            this.add(new VsPlayer(), BorderLayout.CENTER);
        }
    }

    public static void updateScore(){
        score.setText(GameSource.getXScore() + " - " + GameSource.getOScore());
    }
}
