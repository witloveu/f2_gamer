import java.awt.Color;
import java.awt.*;
import javax.swing.JFrame;
import java.util.ArrayList;

  public class Main {
  	public static void main(String[] args){
  		JFrame frame = new JFrame("TEST");
  		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		frame.setSize(400, 600);
		frame.getContentPane().setLayout(new BorderLayout());
 
 		SpaceShip v = new SpaceShip(180, 500, 20, 20);
 		GamePanel gp = new GamePanel();
 		GameEngine engine = new GameEngine(gp, v); 

 		gp.sprites.add(v);
 		

  		frame.addKeyListener(engine);
 		frame.getContentPane().setBackground(Color.BLACK);
 		frame.add(gp);
  		frame.setVisible(true);

  		engine.start();
  }


  
}