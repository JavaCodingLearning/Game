package main;
import java.awt.Graphics;import java.awt.Rectangle;
 /** @author coding_java */
public abstract class GameObject {
    protected int x, y;
    protected ID id;
    protected int velocityX, velocityY; //speed in x and y direction 
    protected SpriteSheet ss;
//contructor for game object:
    public GameObject(int x, int y, ID id, SpriteSheet ss){
        this.x = x;
        this.y = y;
        this.id = id;
        this.ss = ss;
    }  //abstract class will need to be in player and enemy class.
    public abstract void tick();
    public abstract void render(Graphics g);
    //new intersect method 
    public abstract Rectangle getBounds();
    public void setX(int x){     //setter and getter methods
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
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
    }     //get the velocity x and y 
    public int getvelocityX(){
        return velocityX;
    }
    public int getvelocityY(){
        return velocityY;
    }
}


