package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author coding_java
 */
public class Player extends GameObject{
    
    private BufferedImage block_image;
    Random r = new Random();
    
    public Player(int x, int y, ID id, SpriteSheet ss){
        super(x, y, id, ss);
        block_image = ss.grabImage(1, 1, 32, 32);
    
        
        /* can call to set the x value,
        no matter whats in parameter
        */
 
    }

    public void tick() {
        x += velocityX;
        y += velocityY;
        
    }

    public void render(Graphics g) {
        g.drawImage(block_image, x, y, null);
        //if(id == ID.Player) g.setColor(Color.black);
        //else if(id == ID.Player2) g.setColor(Color.red);
        //g.fillRect(x, y, 32, 32);
    }
    
}
