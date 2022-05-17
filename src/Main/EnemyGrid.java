package Main;

import entity.Enemy;

import java.awt.*;
import java.util.Random;

public class EnemyGrid {

    public Enemy[][] enemies;
    Random random = new Random();

    public EnemyGrid(){

        enemies = new Enemy[3][8];

        for(int x = 0; x<enemies.length; x++){
            for(int y = 0; y<enemies[0].length; y++){

                enemies[x][y] = new Enemy(1,50+(x*80),20+(y*80));

            }
        }

    }

    public void drawGrid(Graphics2D g2d){
        if(GamePanel.Running){
            for(int x = 0; x<enemies.length; x++){
                for(int y = 0; y<enemies[0].length; y++){

                    enemies[x][y].draw(g2d);
                }
            }
        }
    }

}
