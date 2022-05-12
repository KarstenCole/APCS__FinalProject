package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ship {

    public Ship(){
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            ship = 5;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
