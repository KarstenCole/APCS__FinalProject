package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Ship extends Entity{

    KeyHandler keyH;
    public String direction;
    boolean missileFired = false;
    Missile missile;
    public static int WIDTH;
    public static int HEIGHT;
    public static int LIVES = 3;
    public static boolean SHIP_LOST_A_LIFE = false;


    public Ship(KeyHandler keyH, Missile missile){
        X = 365;
        this.keyH = keyH;
        WIDTH = 70;
        HEIGHT = 70;
        Y = 600;
        speed = 4;
        direction = "";
        getPlayerImage();
        this.missile = missile;
    }

    public void getPlayerImage(){
        try{
            ship = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Ship.png")));
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png")));
            shipWShield = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_ShipWShield.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        if(GamePanel.Running) {
            if(SHIP_LOST_A_LIFE){
                g2d.drawImage(shipWShield, X - 15, Y - 10, WIDTH + 30, HEIGHT + 30, null);
            }else {
                g2d.drawImage(ship, X, Y, WIDTH, HEIGHT, null);
            }
        }
        if(missileFired){
            missile.draw(g2d);
            missile.go();
            if(missile.isOffMap()||missile.shotEnemy()){
                missileFired = false;
            }
        }
    }

    public void update() {
        if(!GamePanel.SHIP_CANT_MOVE) {
            if (keyH.upPressed ||
                    keyH.leftPressed ||
                    keyH.rightPressed ||
                    keyH.downPressed) {

                if (keyH.upPressed) {
                    direction = "up";
                    if(keyH.rightPressed){
                        direction = "up right";
                    } else if(keyH.leftPressed){
                        direction = "up left";
                    }
                } else if (keyH.downPressed) {
                    direction = "down";
                    if(keyH.rightPressed){
                        direction = "down right";
                    } else if(keyH.leftPressed){
                        direction = "down left";
                    }
                } else if (keyH.leftPressed) {
                    direction = "left";
                } else if (keyH.rightPressed) {
                    direction = "right";
                }
            }
            if(!SHIP_LOST_A_LIFE) {
                if ((keyH.spacePressed) && (!missileFired)) {
                    missile.ResetMissile();
                    missileFired = true;
                }
            }


            switch (direction) {
                case "up":
                    if (Y <= 0) {
                        direction = "";
                    }
                    break;
                case "down":
                    if (Y >= 757 - ship.getHeight()) {
                        direction = "";
                    }
                    break;
                case "right":
                    if (X >= 787 - ship.getWidth()) {
                        direction = "";
                    }
                    break;
                case "left":
                    if (X <= 0) {
                        direction = "";
                    }
                    break;
                case "up right":
                    if((Y <= 0)&&(X >= 787 - ship.getWidth())){
                        direction = "";
                    } else if((Y <= 0)){
                        direction = "slow right";
                    } else if(X >= 787 - ship.getWidth()){
                        direction = "slow up";
                    }
                    break;
                case "up left":
                    if((Y <= 0)&&(X <= 0)){
                        direction = "";
                    } else if(Y <= 0){
                        direction = "slow left";
                    } else if(X <= 0){
                        direction = "slow up";
                    }
                    break;
                case "down right":
                    if((Y >= 757 - ship.getHeight())&&(X >= 787 - ship.getWidth())){
                        direction = "";
                    } else if(X >= 787 - ship.getWidth()){
                        direction = "slow down";
                    } else if(Y >= 757 - ship.getHeight()){
                        direction = "slow right";
                    }
                    break;
                case "down left":
                    if((Y >= 757 - ship.getHeight())&&(X <= 0)){
                        direction = "";
                    } else if(X <= 0){
                        direction = "slow down";
                    } else if(Y >= 757 - ship.getHeight()) {
                        direction = "slow left";
                    }
                    break;
            }

            switch (direction) {
                case "up" -> Y -= speed;
                case "down" -> Y += speed;
                case "left" -> X -= speed;
                case "right" -> X += speed;
                case "slow up" -> Y -= speed*3/4;
                case "slow down" -> Y += speed*3/4;
                case "slow left" -> X -= speed*3/4;
                case "slow right" -> X += speed*3/4;
                case "up right" -> {
                    Y -= speed*3/4;
                    X += speed*3/4;
                }
                case "up left" -> {
                    Y -= speed*3/4;
                    X -= speed*3/4;
                }
                case "down right" ->{
                    Y += speed*3/4;
                    X += speed*3/4;
                }
                case "down left" ->{
                    Y += speed*3/4;
                    X -= speed*3/4;
                }
            }

            direction = "";
        }
    }

    public int getShipX(){
        return X;
    }

    public int getShipY(){
        return Y;
    }

    public int getWidth(){ return WIDTH;}

    public int getHeight(){ return HEIGHT;}

    public void loseALife(){

        LIVES--;
        if(LIVES == 0){
            GamePanel.ShipAlive = false;
        }
        SHIP_LOST_A_LIFE = true;
        GamePanel.SHIP_CANT_MOVE = true;

        Y = 590;
        X = 350;
    }

    public void resetShip(){
        X = 365;
        Y = 600;
    }

}
