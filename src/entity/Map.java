package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Map extends Entity {

    public Map() {
        getMapImage();
    }

    public void getMapImage() {
        try {
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png")));
            StartScreen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_StartScreen.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (GamePanel.Running) {
            g2d.drawImage(map, 0, 0, 800, 800, null);

        } else {
            g2d.drawImage(StartScreen, 0, 0, 800, 800, null);
        }
    }
}
