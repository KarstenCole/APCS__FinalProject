package entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Ship extends Entity{

    public Ship(){
        speed = 3;
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            ship = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Ship.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
