package Main;

import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args){

        ImageIcon image = new ImageIcon("APCS_Final_Ship.png");
        ImageIcon Background = new ImageIcon("APCS_Final_Map.png");
        JLabel label = new JLabel();
        label.setIcon(Background);
        label.setBounds(0,0,800,800);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Final Project");
        window.setResizable(false);
        window.setIconImage(image.getImage());

        GamePanel gamePanel = new GamePanel();
        gamePanel.add(label);
        window.add(gamePanel);


        window.setSize(800,795);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}
