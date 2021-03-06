package Main;

import entity.Map;
import entity.Missile;
import entity.Ship;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements Runnable, ActionListener {

    public static boolean Running = false;

    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 800;

    public static boolean SHIP_CANT_MOVE = false;

    final int FPS = 60;
    int fire = 0;
    int x = 0;

    public static boolean ShipAlive = true;

    public Missile missile = new Missile();

    KeyHandler keyH = new KeyHandler();

    public Ship ship = new Ship(keyH,missile);

    public Map map = new Map();

    public EnemyGrid enemyGrid = new EnemyGrid(missile,ship,map);

    JButton startButton;

    Thread gameThread;

    public static boolean FLICKER;

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

    // Game loop that runs the entire game, and executes all the methods.

    @Override
    public void run() {
            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;
            int shipAnimationChange = 0;
            int EnemyAnimationChange = 0;


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
                    EnemyAnimationChange++;
                    if(drawCount%30==0){
                        FLICKER = !FLICKER;
                    }
                    if(Ship.SHIP_JUST_SHOT){
                        shipAnimationChange++;
                        if(shipAnimationChange == 10){
                            ship.SHIP_JUST_SHOT = false;
                            shipAnimationChange = 0;
                        }
                    }
                    if(EnemyAnimationChange%4==0){
                        enemyGrid.updateDyingAnimations();
                    }
                }

                if (timer >= 1000000000) {

                    fire ++;
                    if((Running&&fire>=2)){
                        enemyGrid.fireRandomMissile();
                        fire = 0;
                    }
                    if (Ship.SHIP_LOST_A_LIFE){
                        x++;
                        if(x>1){
                            SHIP_CANT_MOVE = false;
                        }
                        if(x>2){
                            Ship.SHIP_LOST_A_LIFE = false;
                            x=0;
                        }
                    }

                    //System.out.println("FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

                if(ShipAlive == false){
                    repaint();
                }

            }
    }

    private void update() {

        ship.update();

        enemyGrid.update();

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

        if(!ShipAlive){
            map.draw(g2);

            g2.dispose();
        }
        else {

            map.draw(g2);

            enemyGrid.drawGrid(g2);

            ship.draw(g2);

            g2.dispose();
        }



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startButton)){
            Running = true;
            this.remove(startButton);
        }
    }
}
