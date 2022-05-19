package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Entity{

    BufferedImage Enemy;
    boolean Alive;
    Missile missile;
    int WIDTH,HEIGHT;
    boolean move = true;
    int downARow = 0;
    int inc = 1;

    public Enemy(int EnemyNum, int X, int Y, Missile missile){

        this.X = X;
        this.Y = Y;

        WIDTH = 60;
        HEIGHT = 60;


        this.missile = missile;

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
        if(Alive) {

            g2d.drawImage(Enemy, X, Y, WIDTH, HEIGHT, null);

            if (move) {
                X += inc;
                move = false;
                downARow++;
            } else {
                move = true;
            }
            if (downARow == 120) {
                inc *= -1;
                Y += 20;
                downARow = 0;
            }
        }
    }

    public void checkHitbox(){

        if((missile.getXPosition()>=X &&
            missile.getXPosition()<=X+WIDTH &&
            missile.getYPosition()>=Y &&
            missile.getYPosition()<=Y+HEIGHT) ||
                (missile.get2ndXPosition()>=X &&
                missile.get2ndXPosition()<=X+WIDTH &&
                missile.getYPosition()>=Y &&
                missile.getYPosition()<=Y+HEIGHT)){

            Alive = false;
            missile.HitEnemy();
            X = -1000;
            Y = -1000;

        }

    }

    public int getWidth(){
        return Enemy.getWidth();
    }

    public int getHeight(){
        return Enemy.getHeight();
    }

}
