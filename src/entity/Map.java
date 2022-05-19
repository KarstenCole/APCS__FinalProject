package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Map extends Entity {

    boolean startIsDeath = true;

    public Map() {
        getMapImage();
    }

    public void getMapImage() {
        try {
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png")));
            StartScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_StartScreen.png")));
            DeathScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_DeathScreen.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (GamePanel.Running && GamePanel.ShipAlive) {
            g2d.drawImage(map, 0, 0, 800, 800, null);


        } else if(GamePanel.ShipAlive){
            g2d.drawImage(StartScreen, 0, 0, 800, 800, null);
        }else{

            g2d.drawImage(DeathScreen, 0, 0, 800, 800, null);
        }
    }
}
