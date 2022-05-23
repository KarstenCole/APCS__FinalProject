package Main;

import entity.Enemy;
import entity.Missile;
import entity.Ship;

import java.awt.*;

public class EnemyGrid {

    public Enemy[][] enemies;
    Missile missile;
    Ship ship;

    public EnemyGrid(Missile missile, Ship s){
        this.missile = missile;
        ship = s;

        enemies = new Enemy[8][3];

        for(int x = 0; x<enemies.length; x++){
            for(int y = 0; y<enemies[0].length; y++){


                enemies[x][y] = new Enemy((int) (Math.random() * 4) + 1,(x*87),80 +(y*80), missile);

            }
        }

    }

    public void drawGrid(Graphics2D g2d){
        if(GamePanel.Running){
            for (Enemy[] enemy : enemies) {
                for (int y = 0; y < enemies[0].length; y++) {
                    enemy[y].draw(g2d);
                }
            }
        }
    }

    public void checkAllHitboxes(){
        if(GamePanel.Running){
            for (Enemy[] enemy : enemies) {
                for (int y = 0; y < enemies[0].length; y++) {
                    enemy[y].checkHitbox();
                }
            }
        }
    }

    public void checkShipIntersection(){
        if(GamePanel.Running && GamePanel.ShipAlive){
            for (Enemy[] enemy : enemies) {
                for (int y = 0; y < enemies[0].length; y++) {

                    if(

                        ((ship.getShipX()>=enemy[y].X &&
                        ship.getShipX()<=enemy[y].X+ enemy[y].getWidth()) ||
                        (ship.getShipX()+ ship.WIDTH >=enemy[y].X &&
                        ship.getShipX()+ship.WIDTH <=enemy[y].X+enemy[y].getWidth())) &&

                        ((ship.getShipY()>=enemy[y].Y &&
                        ship.getShipY()<=enemy[y].Y+enemy[y].getHeight())  ||
                        (ship.getShipY()+ship.HEIGHT>=enemy[y].Y &&
                        ship.getShipY()+ship.HEIGHT<=enemy[y].Y+enemy[y].getHeight()))


                    ){

                        GamePanel.ShipAlive = false;

                    }

                }
            }
        }
    }

    public boolean fireRandomMissile(){
        if(someOneAlive()) {
            int randomInt = (int) (Math.random() * 8);

            for (int i = enemies[randomInt].length - 1; i >= 0; i--) {

                if (enemies[randomInt][i].Alive) {

                    System.out.print(randomInt + ", " + i);
                    enemies[randomInt][i].shootMissile();
                    return true;

                }

            }
            fireRandomMissile();
        }
        return false;
    }

    public boolean someOneAlive(){

        for(int x = 0; x<enemies.length; x++){
            for(int y = 0; y<enemies[0].length; y++) {
            if(enemies[x][y].Alive){ return true; }
            }
        }

        return false;
    }

    public void checkallMissiles(){

        for(int x = 0; x<enemies.length; x++){
            for(int y = 0; y<enemies[0].length; y++) {
                enemies[x][y].checkMissile();
            }
        }
    }

}
