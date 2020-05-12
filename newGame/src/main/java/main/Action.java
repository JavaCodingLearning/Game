package main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**@author coding_java **/
public class Action extends KeyAdapter{
    private final Handler handler;
    
    public Action(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                //key events for p1
                if(key == KeyEvent.VK_UP) tempObject.setvelocityY(-5);
                if(key == KeyEvent.VK_DOWN) tempObject.setvelocityY(5);
                if(key == KeyEvent.VK_RIGHT) tempObject.setvelocityX(5);
                if(key == KeyEvent.VK_LEFT) tempObject.setvelocityX(-5);
            }
      }
        if(key == KeyEvent.VK_ESCAPE)System.exit(1);
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
                for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                //key events for player 1. So player will stop
                if(key == KeyEvent.VK_UP) tempObject.setvelocityY(0);
                if(key == KeyEvent.VK_DOWN) tempObject.setvelocityY(0);
                if(key == KeyEvent.VK_RIGHT) tempObject.setvelocityX(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setvelocityX(0);
                
            }    
      }
    }
}


