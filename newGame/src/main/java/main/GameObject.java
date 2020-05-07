package main;

import java.awt.Graphics;

/**
 *
 * @author coding_java
 */
public abstract class GameObject {
    protected int x, y;
    protected ID id;
    protected int velocityX, velocityY; //speed in x and y direction 
    //contructor for game object:
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    //abstract class will need to be in player and enemy class.
    public abstract void tick();
    public abstract void render(Graphics g);
    //setter and getter methods
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return id;
    }
    public void setvelocityX(int velocityX){
        this.velocityX = velocityX;
    }
    public  void setvelocityY(int velocityY){
        this.velocityY = velocityY;
    }
    //get the velocity x and y 
    public int getvelocityX(){
        return velocityX;
    }
    public int getvelocityY(){
        return velocityY;
    }
    
    

}


