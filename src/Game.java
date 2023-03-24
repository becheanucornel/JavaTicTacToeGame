import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game implements ActionListener{
    JFrame frame = new JFrame();
    JPanel txt_panel = new JPanel();
    JPanel panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] spacesButtons = new JButton[9];
    int flag = 0;
    Random random = new Random();
    boolean player1;
    Game()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textField.setBackground(new Color(80, 80, 80));
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);
        txt_panel.setLayout(new BorderLayout());
        txt_panel.setBounds(0, 0, 800, 100);

        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(Color.black);

        for (int i = 0; i < 9; i++) {
            spacesButtons[i] = new JButton();
            panel.add(spacesButtons[i]);
            spacesButtons[i].setBackground(new Color(197, 197, 197));
            spacesButtons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            spacesButtons[i].setFocusable(false);
            spacesButtons[i].addActionListener(this);
        }

        txt_panel.add(textField);
        frame.add(txt_panel, BorderLayout.NORTH);
        frame.add(panel);
        startGame();
    }

    public void startGame() {
        try {
            textField.setText("Loading....");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int chance = random.nextInt(100);
        if (chance % 2 == 0) {
            player1 = true;
            textField.setText("X turn");
        } else {
            player1 = false;
            textField.setText("O turn");
        }
    }

    public void gameOver(String s){
        flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new Game();
        }
        else{
            frame.dispose();
        }

    }

    public void matchCheck() {
        if ((spacesButtons[0].getText() == "X") && (spacesButtons[1].getText() == "X") && (spacesButtons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((spacesButtons[0].getText() == "X") && (spacesButtons[4].getText() == "X") && (spacesButtons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((spacesButtons[0].getText() == "X") && (spacesButtons[3].getText() == "X") && (spacesButtons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((spacesButtons[1].getText() == "X") && (spacesButtons[4].getText() == "X") && (spacesButtons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((spacesButtons[2].getText() == "X") && (spacesButtons[4].getText() == "X") && (spacesButtons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((spacesButtons[2].getText() == "X") && (spacesButtons[5].getText() == "X") && (spacesButtons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        else if ((spacesButtons[3].getText() == "X") && (spacesButtons[4].getText() == "X") && (spacesButtons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        else if ((spacesButtons[6].getText() == "X") && (spacesButtons[7].getText() == "X") && (spacesButtons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        else if ((spacesButtons[0].getText() == "O") && (spacesButtons[1].getText() == "O") && (spacesButtons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((spacesButtons[0].getText() == "O") && (spacesButtons[3].getText() == "O") && (spacesButtons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((spacesButtons[0].getText() == "O") && (spacesButtons[4].getText() == "O") && (spacesButtons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((spacesButtons[1].getText() == "O") && (spacesButtons[4].getText() == "O") && (spacesButtons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((spacesButtons[2].getText() == "O") && (spacesButtons[4].getText() == "O") && (spacesButtons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((spacesButtons[2].getText() == "O") && (spacesButtons[5].getText() == "O") && (spacesButtons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((spacesButtons[3].getText() == "O") && (spacesButtons[4].getText() == "O") && (spacesButtons[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((spacesButtons[6].getText() == "O") && (spacesButtons[7].getText() == "O") && (spacesButtons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(flag == 9) {
            textField.setText("Match Tie");
            gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        spacesButtons[x1].setBackground(Color.RED);
        spacesButtons[x2].setBackground(Color.RED);
        spacesButtons[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            spacesButtons[i].setEnabled(false);
        }
        textField.setText("X wins");
        gameOver("X Wins");
    }
    public void oWins(int x1, int x2, int x3) {
        spacesButtons[x1].setBackground(Color.RED);
        spacesButtons[x2].setBackground(Color.RED);
        spacesButtons[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            spacesButtons[i].setEnabled(false);
        }
        textField.setText("O Wins");
        gameOver("O Wins");
    }

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == spacesButtons[i]) {
                if (player1) {
                    if (spacesButtons[i].getText() == "") {
                        spacesButtons[i].setForeground(new Color(244, 227, 120));
                        spacesButtons[i].setText("X");
                        player1 = false;
                        textField.setText("O turn");
                        flag++;
                        matchCheck();
                    }
                } else {
                    if (spacesButtons[i].getText() == "") {
                        spacesButtons[i].setForeground(new Color(170, 139, 222));
                        spacesButtons[i].setText("O");
                        player1 = true;
                        textField.setText("X turn");
                        flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
}