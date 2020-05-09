/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author mollymcconaghy
 */
public class Action extends KeyAdapter{
    private Handler handler;
    
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
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
                for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for p1
                //so player will stop 
                if(key == KeyEvent.VK_UP) tempObject.setvelocityY(0);
                if(key == KeyEvent.VK_DOWN) tempObject.setvelocityY(0);
                if(key == KeyEvent.VK_RIGHT) tempObject.setvelocityX(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setvelocityX(0);
                
            }
            
      }
    }
    
    
}



/* Action class for input from user. 
Then add methdods as a part of keyAdapter.
key will display a number value corresponding to number pressed.

In order to just have one player move, 
we need to loop through all the objects in our game 
and say which one has the ID of the object we want to move. 

*/