package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Missile extends Entity{

    Ship SHIP;
    public boolean shotEnemy = false;

    public Missile(){
        getMissileImage();

        speed = 7;
    }

    public void SetMissile(Ship s){

        this.SHIP = s;
        X = SHIP.getShipX()+(SHIP.ship.getWidth()/2)-(Missile.getWidth()/2);
        Y = SHIP.getShipY()-Missile.getHeight();

    }

    public void getMissileImage(){
        try{
            Missile = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Ship/APCS_Final_Missile.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        if(GamePanel.Running && !shotEnemy) {
            g2d.drawImage(Missile, X, Y, 12, 21, null);
        }
    }

    public void go(){

        Y -= speed;

    }

    public void ResetMissile(){
        X = SHIP.getShipX()+(SHIP.ship.getWidth()/2)-(Missile.getWidth()/2);
        Y = SHIP.getShipY()-Missile.getHeight();
        shotEnemy = false;
    }

    public boolean shotEnemy(){
        return shotEnemy;
    }

    public void HitEnemy(){
        ResetMissile();
        shotEnemy = true;
    }


    public boolean isOffMap(){
        return Y < 0;
    }

    public int getXPosition(){
        return X;
    }
    public int get2ndXPosition(){
        return X+Missile.getWidth();
    }

    public int getYPosition(){return Y;}
}
