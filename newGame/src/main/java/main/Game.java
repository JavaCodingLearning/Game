package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

 /** @author coding_java **/

public class Game extends Canvas implements Runnable{

    public static void main(String[] args) {
        new Game();
        
    }
    
    public static final int W = 650, H = W / 13 * 10;
    private Thread thread;
    private boolean running = false;
    
    public Game(){
        Window window = new Window(W, H, "new game", this);
   }
        
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
        
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
   
    public void run(){
        
      this.requestFocus();
      long lastTime = System.nanoTime(); // get current time to the nanosecond
      double amountOfTicks = 60.0; // set the number of ticks 
      double nanoseconds = 1000000000 / amountOfTicks; //divide 60 into 1e9 of nano seconds or about 1 second
      double delta = 0;
      long timer = System.currentTimeMillis(); // get current time
      int frames = 0; // set frame variable
      while(running) {
       long now = System.nanoTime(); // get current time in nonoseconds durring current loop
       delta += (now - lastTime) / nanoseconds;  // add the amount of change since the last loop
       lastTime = now; // set lastTime to now to prepare for next loop
       while(delta >= 1) {
        update();
        delta--;
       }
       if(running){
            render();  // render visuals of the game
       frames++; //frame has passed
       }
       if(System.currentTimeMillis() - timer > 1000) {  // if one second has passed
        timer += 1000;  // add a thousand to our timer for next time
        frames = 0;  // reset frame count for the next second
  
       }
      }
      stop(); // no longer running stop the thread
        
    
    }  

    private void update() {
    }

    private void render() {
        BufferStrategy b = this.getBufferStrategy();
        if (b == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = b.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, W, H);
        
        g.dispose();
        b.show();
    }
    
   
    
    
}



