package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements Runnable, ActionListener {

    public boolean Running = false;

    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 800;

    JButton startButton;


    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(null);
        startScreen();

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        startGameThread();
        while(Running){


            System.out.print(" Running ");


        }
    }

    public void startScreen(){

        ImageIcon start = new ImageIcon("APCS_Final_StartButton.png");

        startButton = new JButton();
        startButton.addActionListener(this);
//        startButton.setText("START");
        startButton.setBounds(185,400,400,100);
        startButton.setIcon(start);
        startButton.setFocusable(false);
        startButton.setBackground(new Color(172, 172, 172));

        this.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startButton)){
            Running = true;
        }
    }
}
