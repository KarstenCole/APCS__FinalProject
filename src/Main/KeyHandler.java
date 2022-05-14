package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
            System.out.print("pressing button");
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
            System.out.print("pressing button");

        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
            System.out.print("pressing button");

        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
            System.out.print("pressing button");

        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = true;
            System.out.print("pressing button");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }
}
