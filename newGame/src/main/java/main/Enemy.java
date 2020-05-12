package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author coding_java
 */
public class Enemy extends GameObject{
    
    private final BufferedImage enemy_image;
    public Enemy(int x, int y, ID id, SpriteSheet ss){
        super(x, y, id, ss);
        enemy_image = ss.grabImage(5, 5, 32, 32);
        
        velocityY = 5;
        velocityX = 5;
        
    }
    
        public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }
    
    public void tick(){
        x += velocityX;
        y += velocityY;
        //have to multiply velocity y by negative to 
        //bring it down. 
        if(y <= 0 || y >= Game.H - 32) velocityY *= -1;
        if(x <= 0 || x >= Game.W - 16) velocityX *= -1;
           
    }
    public void render(Graphics g){
       g.drawImage(enemy_image, x, y, null);
    }
}



