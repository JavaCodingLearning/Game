package main;
import com.sun.net.httpserver.Authenticator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/** @author coding_java */
public class Player extends GameObject{
     Handler handler;
    
    private BufferedImage block_image;
    Random r = new Random();
    
    public Player(int x, int y, ID id, SpriteSheet ss, Handler handler){
        super(x, y, id, ss);
        this.handler = handler;
        block_image = ss.grabImage(1, 1, 32, 32);
        /* can call to set the x value,
        no matter whats in parameter
        */
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }
    

    public void tick() {
        x += velocityX;
        y += velocityY;
          if(x < 0) x = 0;
          if(x > Game.W - 39) x = Game.W - 39;
          if(y < 0) y = 0;
          if(y > Game.H - 60) y = Game.H - 60;
          collision();
    }
    
    private void collision(){
        for(int i =0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Enemy || tempObject.getId() == ID.Enemy2){
                if(getBounds().intersects(tempObject.getBounds())){
                    Health.health -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(block_image, x, y, null);
        //if(id == ID.Player) g.setColor(Color.black);
        //else if(id == ID.Player2) g.setColor(Color.red);
        //g.fillRect(x, y, 32, 32);
    }
    
}



