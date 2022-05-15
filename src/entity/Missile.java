package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Missile extends Entity{

    Ship SHIP;

    public Missile(Ship s){
        getMissileImage();
        this.SHIP = s;
        X = SHIP.getShipX()+(SHIP.ship.getWidth()/2)-(Missile.getWidth()/2);
        Y = SHIP.getShipY()-Missile.getHeight();
        speed = 5;
    }

    public void getMissileImage(){
        try{
            Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Missile.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        if(GamePanel.Running) {
            g2d.drawImage(Missile, X, Y, 12, 21, null);
        }
    }

    public void go(){
        Y -= speed;
    }

    public void ResetMissile(){
        X = SHIP.getShipX()+(SHIP.ship.getWidth()/2)-(Missile.getWidth()/2);
        Y = SHIP.getShipY()-Missile.getHeight();
    }

    public boolean isOffMap(){
        return Y < 0;
    }
}
