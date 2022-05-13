package entity;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Entity{

    public Enemy(){

        speed = 1;
        getEnemies();
    }

    public void getEnemies(){

        try{
            Enemy1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy1.png")));
            Enemy2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy2.png")));
            Enemy3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy3.png")));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
