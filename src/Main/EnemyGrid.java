package Main;

import entity.Enemy;
import entity.Missile;

import java.awt.*;
import java.util.Random;

public class EnemyGrid {

    public Enemy[][] enemies;
 //  Random random = new Random();
    Missile missile;

    public EnemyGrid(Missile missile){
        this.missile = missile;

        enemies = new Enemy[8][3];

        for(int x = 0; x<enemies.length; x++){
            for(int y = 0; y<enemies[0].length; y++){

                enemies[x][y] = new Enemy(1,50+(x*87),20+(y*80), missile);

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


}
