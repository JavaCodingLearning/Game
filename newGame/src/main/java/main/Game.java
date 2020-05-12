package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

 /** @author coding_java **/

public class Game extends Canvas implements Runnable{

    public static void main(String[] args) {
        Game game = new Game();
        
    }
    public static final int W = 650, H = W / 13 * 10;
    private Thread thread;
    private boolean running = false;
    private final SpriteSheet ss;
    private final Random r;
    private Health health;
    //create an instance of our handler 
    private final Handler handler;
    private BufferedImage sprite_sheet = null;
    
    public Game(){
        //need to initialize the handler first 
        handler = new Handler();
        this.addKeyListener(new Action(handler));
        
        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet = loader.loadImage("/spritesheet.png"); 
        
        ss = new SpriteSheet(sprite_sheet);
        Window window = new Window(W, H, "new game", this);
        health = new Health();
        r = new Random();
        //new player specs
        
        //put as many objects in game as you like 
        handler.addObject(new Player(100, 400, ID.Player, ss, handler)); //sets the coords 
        for (int i = 0; i < 3; i++)
        handler.addObject(new Enemy(r.nextInt(W), r.nextInt(H), ID.Enemy, ss)); //sets the coords 
        //handler.addObject(new Player(100, 200, ID.Player2)); //sets the coords 
        for (int i = 0; i < 2; i++)
        handler.addObject(new Enemy2(r.nextInt(W), r.nextInt(H), ID.Enemy2, ss)); //sets the coords 
        //handler.addObject(new Player(100, 200, ID.Player2)); //sets the coords         
       
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
        }catch(InterruptedException e){
        }
        
    }
    
    public void run(){
      
      this.requestFocus();
      long lastTime = System.nanoTime(); // get current time to the nanosecond
      double amountOfTicks = 60.0; // set the number of ticks 
      //divide 60 into 1e9 of nano seconds or about 1 second
      double nanoseconds = 1000000000 / amountOfTicks; 
      double delta = 0;
      long timer = System.currentTimeMillis(); // get current time
      int frames = 0; // set frame variable
      while(running) {
      // get current time in nonoseconds durring current loop
       long now = System.nanoTime(); 
       delta += (now - lastTime) / nanoseconds; //add the amount of change 
       //since the last loop
       lastTime = now; // set lastTime to now to prepare for next loop
       while(delta >= 1) {
        tick();
        delta--;
       }
       if(running){
            render();  // render visuals of the game
       frames++; //frame has passed
       }
       if(System.currentTimeMillis() - timer > 1000) { //if one second has passed
        timer += 1000;  // add a thousand to our timer for next time
        frames = 0;  // reset frame count for the next second
  
       }
      }
      stop(); // no longer running stop the thread
        
    
    }  

    private void tick() {
        handler.tick();
        health.tick();
    }
   
    private void render() {
        BufferStrategy b = this.getBufferStrategy();
        if (b == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = b.getDrawGraphics();
        
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, W, H);
        
        handler.render(g);
        health.render(g);
        
        g.dispose();
        b.show();
    }
    
    public static int clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else 
            return var;
    }

    
}



