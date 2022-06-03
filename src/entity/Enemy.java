package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Entity{

    BufferedImage Enemy;
    public boolean Alive;
    boolean missileFired;
    Missile missile;
    int WIDTH,HEIGHT;
    boolean move = true;
    int downARow = 0;
    int inc = 1;
    public int value;

    public BufferedImage Missile;
    int MissileX=0;
    int MissileY=0;
    Ship ship;

    public int animation = 0;

    public Enemy(int EnemyNum, int X, int Y, Missile missile, Ship ship, int Speed){

        this.X = X;
        this.Y = Y;

        this.ship = ship;

        if(EnemyNum == 1){
            value = 20;
        }
        if(EnemyNum == 2){
            value = 30;
        }
        if(EnemyNum == 3){
            value = 40;
        }
        if(EnemyNum == 4){
            value = 50;
        }

        this.missile = missile;

        Alive = true;

        speed = Speed;
        getEnemies(EnemyNum);
    }

    public void getEnemies(int EnemyNum){
        if(EnemyNum == 1) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1.png")));
                Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/EnemyMissiles/APCS_Final_Enemy1Missile.png")));
                Animation1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation1.png")));
                Animation2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation2.png")));
                Animation3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation3.png")));
                Animation4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation4.png")));
                Animation5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation5.png")));

                WIDTH = 60;
                HEIGHT = 45;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 2) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2.png")));
                Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/EnemyMissiles/APCS_Final_Enemy2Missile.png")));
                Animation1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2Animation1.png")));
                Animation2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2Animation2.png")));
                Animation3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2Animation3.png")));
                Animation4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2Animation4.png")));
                Animation5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy2/APCS_Final_Enemy2Animation5.png")));
                WIDTH = 60;
                HEIGHT = 60;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 3) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy3/APCS_Final_Enemy3.png")));
                Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/EnemyMissiles/APCS_Final_Enemy3Missile.png")));
                Animation1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation1.png")));
                Animation2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation2.png")));
                Animation3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation3.png")));
                Animation4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation4.png")));
                Animation5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation5.png")));
                WIDTH = 60;
                HEIGHT = 50;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(EnemyNum == 4) {
            try {
                Enemy = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy4/APCS_Final_Enemy4.png")));
                Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/EnemyMissiles/APCS_Final_Enemy4Missile.png")));
                Animation1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation1.png")));
                Animation2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation2.png")));
                Animation3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation3.png")));
                Animation4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation4.png")));
                Animation5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Enemies/Enemy1/APCS_Final_Enemy1Animation5.png")));
                WIDTH = 60;
                HEIGHT = 45;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2d) {
        if(Alive) {

            g2d.drawImage(Enemy, X, Y, WIDTH, HEIGHT, null);

            if (move) {
                X += speed;
                move = false;
                downARow+=Math.abs(speed);
            } else {
                move = true;
            }
            if (downARow >= 120) {
                speed *= -1;
                Y += 20;
                downARow = 0;
            }
        } else if(animation>=1&&animation<=5){
            if(animation == 1) {
                g2d.drawImage(Animation1, X, Y, WIDTH, HEIGHT, null);
            } if(animation == 2) {
                g2d.drawImage(Animation2, X, Y, WIDTH, HEIGHT, null);
            } if(animation == 3) {
                g2d.drawImage(Animation3, X, Y, WIDTH, HEIGHT, null);
            } if(animation == 4) {
                g2d.drawImage(Animation4, X, Y, WIDTH, HEIGHT, null);
            } if(animation == 5) {
                g2d.drawImage(Animation5, X, Y, WIDTH, HEIGHT, null);
            }
            if (move) {
                X += speed;
                move = false;
                downARow+=Math.abs(speed);
            } else {
                move = true;
            }
            if (downARow >= 120) {
                speed *= -1;
                Y += 20;
                downARow = 0;
            }
        }
        if(missileFired){

            MissileY+=Math.abs(speed)+1;

            g2d.drawImage(Missile, MissileX,MissileY,null);
        }

    }

    public void checkHitbox(){
        if(Alive) {
            if ((missile.getXPosition() >= X &&
                    missile.getXPosition() <= X + WIDTH &&
                    missile.getYPosition() >= Y &&
                    missile.getYPosition() <= Y + HEIGHT) ||
                    (missile.get2ndXPosition() >= X &&
                            missile.get2ndXPosition() <= X + WIDTH &&
                            missile.getYPosition() >= Y &&
                            missile.getYPosition() <= Y + HEIGHT)) {

                Alive = false;

                missile.HitEnemy();


            }
        }

    }

    //public void

    public int getWidth(){
        return Enemy.getWidth();
    }

    public int getHeight(){
        return Enemy.getHeight();
    }

    public void shootMissile(){


        //System.out.print(" shot missile ");
        if(!missileFired) {
            missileFired = true;
            MissileX = X + WIDTH / 2 - 5;
            MissileY = Y + HEIGHT;
        }

    }

    public void checkMissile(){

        if(MissileY>800){
            missileFired = false;
        }

        if((MissileX >= ship.getShipX() &&
            MissileX <= ship.getShipX()+ship.getWidth()&&
            MissileY >= ship.getShipY() &&
            MissileY <= ship.getShipY()+ship.getHeight()) ||

            (MissileX+Missile.getWidth()>=ship.getShipX() &&
            MissileX+Missile.getWidth()<=ship.getShipX()+ship.getWidth() &&
            MissileY >= ship.getShipY() &&
            MissileY <= ship.getShipY()+ship.getHeight())){

            ship.loseALife();

        }


    }

}
