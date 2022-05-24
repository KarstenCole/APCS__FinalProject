package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class Map extends Entity{

    BufferedImage ThreeHearts, TwoHearts, OneHeart;
    Font font;

    public Map() {
        getMapImage();
        getFont();
    }

    public void getFont(){

        try{

            font = Font.createFont(Font.TRUETYPE_FONT, new File("SM.TTF")).deriveFont(30f);
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
            g2d.drawString("0",235,55);
            g2d.drawImage(TwoHearts, 20,700,140,40,null);

        } else if(GamePanel.ShipAlive){

            g2d.drawImage(StartScreen, 0, 0, 800, 800, null);

        }else{

            g2d.drawImage(DeathScreen, 0, 0, 800, 800, null);

        }
    }
}
