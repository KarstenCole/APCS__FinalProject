package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Enemy {

    public Enemy(){
        getEnemies();
    }

    public void getEnemies(){

        try{
            Entity.Enemy1 = ImageIO.read(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
