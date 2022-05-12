package entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Ship {

    public Ship(){
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            Entity.ship = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Ship.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
