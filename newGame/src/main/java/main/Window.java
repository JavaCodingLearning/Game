package main;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/** @author coding_java **/
public class Window extends Canvas {
    public Window(int w, int h, String name, Game game){
        JFrame window = new JFrame(name);
        window.setPreferredSize(new Dimension(w, h));
        window.setMinimumSize(new Dimension(w, h));
        window.setMaximumSize(new Dimension(w, h));
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.add(game);
        window.setVisible(true);
        
        game.start();     
        
    }
    
}








