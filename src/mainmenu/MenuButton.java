package mainmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuButton extends JButton {

    MenuButton(String name, Object listener, int y)
    {
        this.setBounds(250, y, 100 , 40);
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.setText(name);
        this.setFont(new Font ("Comic Sans MS", Font.BOLD, 12));
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.addActionListener((ActionListener) listener);
    }

}
