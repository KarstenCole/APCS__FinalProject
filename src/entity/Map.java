package entity;

import Main.EnemyGrid;
import Main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class Map extends Entity{

    BufferedImage ThreeHearts, TwoHearts, OneHeart;
    Font font;
    public int score;
    ArrayList<Enemy> deadEnemies = new ArrayList<>();


    public Map() {
        getMapImage();
        getFont();
        score = 0;
    }

    public void getFont(){

        try{

            font = Font.createFont(Font.TRUETYPE_FONT, new File("m42.TTF")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("SM.TTF")));

        }catch(IOException | FontFormatException e){

        }

    }
    public void getMapImage() {
        try {
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png")));
            StartScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_StartScreen.png")));
            DeathScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_DeathScreen.png")));
            ThreeHearts = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/Lives/APCS_Final_3Lives.png")));
            TwoHearts = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/Lives/APCS_Final_2Lives.png")));
            OneHeart = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/Lives/APCS_Final_1Lives.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (GamePanel.Running && GamePanel.ShipAlive) {

            g2d.drawImage(map, 0, 0, 800, 800, null);
            g2d.setColor(new Color(255, 255, 255));
            g2d.setFont(font);
            g2d.drawString("SCORE: "+score,30,55);
            g2d.drawString("LEVEL: "+ EnemyGrid.Level,500,55);


            if(Ship.LIVES==2) {
                g2d.drawImage(TwoHearts, 20, 700, 140, 40, null);
            }
            if(Ship.LIVES==3) {
                g2d.drawImage(ThreeHearts, 20, 700, 140, 40, null);
            }
            if(Ship.LIVES==1) {
                g2d.drawImage(OneHeart, 20, 700, 140, 40, null);
            }

        } else if(GamePanel.ShipAlive){

            g2d.drawImage(StartScreen, 0, 0, 800, 800, null);

        }else{
            g2d.setColor(new Color(255, 255, 255));
            g2d.setFont(font);
            g2d.drawImage(DeathScreen, 0, 0, 800, 800, null);
            g2d.drawString("LEVEL: "+ EnemyGrid.Level,256,550);
            g2d.drawString("SCORE: "+score,256,480);


        }
    }

    public void increaseScore(Enemy enemy, int inc){

        if(!deadEnemies.contains(enemy)){
            deadEnemies.add(enemy);
            score += inc;
        }

    }
}
