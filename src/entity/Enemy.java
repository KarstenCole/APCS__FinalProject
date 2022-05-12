package entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Enemy {

    public Enemy(){
        getEnemies();
    }

    public void getEnemies(){

        try{
            Entity.Enemy1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy1.png")));
            Entity.Enemy2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
