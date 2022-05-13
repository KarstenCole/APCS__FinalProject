package entity;

import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Ship extends Entity{

    KeyHandler keyH = new KeyHandler();
    public String direction;
    public int ShipX;
    public int ShipY;

    public Ship(){
        ShipX = 365;
        ShipY = 700;
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

    public void draw(Graphics2D g2d){
        g2d.drawImage(ship, ShipX,ShipY, 70,70, null);
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
            } else {
                direction = "right";
            }
        }

        if(direction!=null) {
            switch (direction) {
                case "up" -> ShipY -= speed;
                case "down" -> ShipY += speed;
                case "left" -> ShipX -= speed;
                case "right" -> ShipX += speed;
            }
        }
    }

}
