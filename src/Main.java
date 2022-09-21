import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Game yuh = new Game();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Tic-Tac-Toe");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(yuh);
        obj.setVisible(true);
    }

}
