import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel {

    char xMark = 'x';
    char oMark = 'o';

    boolean game = false;

    boolean current = true;
    JButton[] buttons = new JButton[9];

    public Game(){
        setLayout(new GridLayout(3,3));
        initializeButtons();
    }

    public void initializeButtons(){
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setOpaque(true);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 40));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource();
                    if(current) {
                        buttonClicked.setText(String.valueOf(xMark));

                        current = false;
                    } else {
                        buttonClicked.setText(String.valueOf(oMark));
                        current = true;
                    }
                    displayVictor();
                }
            });
            add(buttons[i]);
        }
    }
    public void displayVictor(){
        if(checkForWinner()){
            current = !current;
            JOptionPane pane = new JOptionPane();
            int dialogResult;
            if(current){
                dialogResult = JOptionPane.showConfirmDialog(pane, "X WINS!!!", "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            } else{
                dialogResult = JOptionPane.showConfirmDialog(pane, "O WINS!!!", "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
            if(dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
            else System.exit(0);
        }
        else if(checkDraw()){
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "DRAW!!!", "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
            else System.exit(0);
        }

    }

    private void resetTheButtons() {
        for (int i = 0; i < 9; i++) {
            current = true;
            buttons[i].setText("");
            buttons[i].setBackground(Color.BLACK);
            System.exit(0);
        }
    }

    public boolean checkDraw() {
        boolean full = true;
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText() == ""){
                full = false;
            }
        }
        return full;
    }

    public boolean checkForWinner(){
        return checkRow() || checkCol() || checkDiag();
    }
    public boolean checkRow(){
        for(int i = 0; i < 9; i+=3){
            if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && buttons[i].getText() != ("")){
                game = true;
                buttons[i].setForeground(Color.GREEN);
                buttons[i + 1].setForeground(Color.GREEN);
                buttons[i + 2].setForeground(Color.GREEN);
                break;
            }
        }
        return game;
    }
    public boolean checkCol(){
        for(int i = 0; i < 3; i++){
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && buttons[i].getText() != ("")) {
                game = true;
                buttons[i].setForeground(Color.GREEN);
                buttons[i + 3].setForeground(Color.GREEN);
                buttons[i + 6].setForeground(Color.GREEN);
                break;
            }
        }
        return game;
    }
    public boolean checkDiag(){
        if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && buttons[0].getText() != ("")){
            game = true;
            buttons[0].setForeground(Color.GREEN);
            buttons[4].setForeground(Color.GREEN);
            buttons[8].setForeground(Color.GREEN);
        }
        if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && buttons[2].getText() != ("")){
            game = true;
            buttons[2].setForeground(Color.GREEN);
            buttons[4].setForeground(Color.GREEN);
            buttons[6].setForeground(Color.GREEN);
        }
        return game;
    }
}
