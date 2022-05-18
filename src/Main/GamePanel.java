package Main;

import entity.Map;
import entity.Missile;
import entity.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel<ship> extends JPanel implements Runnable, ActionListener {

    public static boolean Running = false;

    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 800;
    final int FPS = 60;

    public Missile missile = new Missile();

    KeyHandler keyH = new KeyHandler();

    public Ship ship = new Ship(keyH,missile);

    public Map map = new Map();

    public EnemyGrid enemyGrid = new EnemyGrid(missile);

    JButton startButton;

    Thread gameThread;

    public GamePanel(JLabel Bg){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(keyH);
        this.add(Bg);
        startScreen();

        missile.SetMissile(ship);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;


            while (gameThread != null) {

                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;
                timer += currentTime - lastTime;
                lastTime = currentTime;

                if ((delta >= 1)&&(Running)) {
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }

                if (timer >= 1000000000) {
                    System.out.println("FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

            }
    }

    private void update() {

        ship.update();

        enemyGrid.checkAllHitboxes();

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

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        map.draw(g2);

        enemyGrid.drawGrid(g2);

        ship.draw(g2);

        g2.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startButton)){
            Running = true;
            this.remove(startButton);
        }
    }
}
