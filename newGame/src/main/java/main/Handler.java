/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author mollymcconaghy
 */
public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<>();
    //for loop for running through entire list
    //update and render all the game object 
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject newObject = object.get(i);
            newObject.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject newObject = object.get(i);
            newObject.render(g);
        }
    }
    //add and remove objects 
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    
    
    
   
    
}
