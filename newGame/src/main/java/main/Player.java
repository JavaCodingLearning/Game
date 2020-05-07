/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mollymcconaghy
 */
public class Player extends GameObject{
    
    public Player(int x, int y, ID id){
        super(x, y, id);
        
        velocityX = 1;
        
        
        /* can call to set the x value,
        no matter whats in parameter
        */
 
    }

    public void tick() {
        x += velocityX;
        y += velocityY;
        
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
    }
    
}
