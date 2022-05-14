package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Map extends Entity{

    public Map(){
        getMapImage();
    }

    public void getMapImage(){
        try{
            map = ImageIO.read(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(map, 0, 0, 800, 800, null);

    }
}
