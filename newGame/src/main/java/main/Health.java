
package main;

import java.awt.Color;
import java.awt.Graphics;


/**
 * @author coding_java
 */
public class Health {
    
    public static int health = 100;
    public void tick(){
        health = Game.clamp(health, 1, 100);
    }
    
    public void render(Graphics g ){
        g.setColor(Color.black);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.red);
        g.fillRect(15, 15, health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
    }
    
}
