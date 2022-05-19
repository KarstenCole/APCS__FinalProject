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


    public Ship(KeyHandler keyH, Missile missile){
        X = 365;
        this.keyH = keyH;
        WIDTH = 70;
        HEIGHT = 70;
        Y = 600;
        speed = 3;
        direction = "";
        getPlayerImage();
        this.missile = missile;
    }

    public void getPlayerImage(){
        try{
            ship = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Ship.png")));
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Maps/APCS_Final_Map.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        if(GamePanel.Running) {
            g2d.drawImage(ship, X, Y, WIDTH, HEIGHT, null);
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
        if (keyH.upPressed ||
                keyH.leftPressed ||
                keyH.rightPressed ||
                keyH.downPressed) {

            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if(keyH.rightPressed){
                direction = "right";
            }
        }

        if((keyH.spacePressed)&&(!missileFired)) {
            missile.ResetMissile();
            missileFired = true;
        }


        switch(direction){
            case "up":
                if(Y<=0){ direction = "";}
                break;
            case "down":
                if(Y>=757-ship.getHeight()){ direction = "";}
                break;
            case "right":
                if(X>=787-ship.getWidth()){direction = "";}
                break;
            case "left":
                if(X<=0) {direction = "";}
                break;
        }

        switch (direction) {
            case "up" -> Y -= speed;
            case "down" -> Y += speed;
            case "left" -> X -= speed;
            case "right" -> X += speed;
        }

        direction = "";
    }

    public int getShipX(){
        return X;
    }

    public int getShipY(){
        return Y;
    }

}
