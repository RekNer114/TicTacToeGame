package game;

import javax.swing.*;


public class GameSource {
    GameButton[] buttons = new GameButton[9]; // ui buttons
    int[] calc = new int[9]; //need to calculate winner;
    boolean turn = true; // true - x turn | false - o turn
    byte turnsCount = 0;

    static int xScore = 0;
     static int oScore = 0;

    GameSource(Object listener) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new GameButton(listener);

        }
    }

    public void checkWinner() {
        //rows
        for (int i = 0; i <= 6; i += 3) {
            if (calc[i] != 0 && calc[i] == calc[i + 1] && calc[i] == calc[i + 2]) {
                if (calc[i] == 1) {
                    JOptionPane.showMessageDialog(null, "x wins");
                    xScore++;
                }
                if (calc[i] == 2) {
                    JOptionPane.showMessageDialog(null, "o wins");
                    oScore++;
                }
                restart();
            }
        }
        //columns
        for (int i = 0; i < 3; i++) {
            if (calc[i] != 0 && calc[i] == calc[i + 3] && calc[i] == calc[i + 6]) {
                if (calc[i] == 1) {
                    JOptionPane.showMessageDialog(null, "x wins");
                    xScore++;

                }
                if (calc[i] == 2) {
                    JOptionPane.showMessageDialog(null, "o wins");
                    oScore++;
                }
                restart();

            }
        }
        //diagonals

        // 0 4 8
        if (calc[0] != 0 && calc[0] == calc[4] && calc[0] == calc[8]) {
            if (calc[0] == 1) {
                JOptionPane.showMessageDialog(null, "x wins");
                xScore++;
            }
            if (calc[0] == 2) {
                JOptionPane.showMessageDialog(null, "o wins");
                oScore++;
            }
            restart();
        }
        if (calc[2] != 0 && calc[2] == calc[4] && calc[2] == calc[6]) {
            if (calc[2] == 1) {
                JOptionPane.showMessageDialog(null, "x wins");
                xScore++;
            }
            if (calc[2] == 2) {
                JOptionPane.showMessageDialog(null, "o wins");
                oScore++;
            }
            restart();
        }

        if(turnsCount == 9)
        {
            JOptionPane.showMessageDialog(null, "draw");
            restart();
        }
    }

    private void restart() {
        turn = true;
        turnsCount = 0;
        GameFrame.updateScore();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setIcon(null);
            calc[i] = 0;
        }

    }

    public static int getXScore()
    {
        return xScore;
    }

    public static int getOScore()
    {
        return oScore;
    }
}
