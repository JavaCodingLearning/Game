package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author coding_java
 */
public class Player extends GameObject{
    Random r = new Random();
    
    public Player(int x, int y, ID id){
        super(x, y, id);
    
        
        /* can call to set the x value,
        no matter whats in parameter
        */
 
    }

    public void tick() {
        x += velocityX;
        y += velocityY;
        
    }

    public void render(Graphics g) {
        if(id == ID.Player) g.setColor(Color.black);
        else if(id == ID.Player2) g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }
    
}
