package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Entity{

    BufferedImage Enemy;
    boolean Alive;

    public Enemy(int EnemyNum, int X, int Y){

        this.X = X;
        this.Y = Y;

        Alive = true;

        speed = 1;
        getEnemies(EnemyNum);
    }

    public void getEnemies(int EnemyNum){
        if(EnemyNum == 1) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy1.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 2) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 3) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy3.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 4) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/APCS_Final_Enemy4.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2d) {
        if(Alive){
            g2d.drawImage(Enemy, X, Y, 60, 60, null);
        }
    }

}
