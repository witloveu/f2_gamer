
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private SpaceShip v;	
	private int life = 3;
	private Timer timer;
	private boolean p;
	
	private long score = 0;
	private double difficulty = 0.1;
	
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				process();
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
		p = true;
	}

	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	
	public void die(){
		stop();
		life--;
		JOptionPane.showMessageDialog(null, "You are die !\n"+"Life : " + life, "Reporter", JOptionPane.INFORMATION_MESSAGE);
		start();
	}
	
	private void process(){
		
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 100;

			}
		}
		gp.updateGameUI(this);	

		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
					
				if(life != 0)
					die();
				else
					gameover();
			return;
			}
		}
	}

	
	
	public void gameover(){
		stop();
		JOptionPane.showMessageDialog(null, "Game Over !\n" + "\n"+"Score : " + getScore(), "Reporter", JOptionPane.INFORMATION_MESSAGE);
	}

	public void stop(){
		timer.stop();
		p = false;
		
	}

	public void controlVehicle(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.1;
			break;
		}
	}

	
	public long getScore(){
		return score;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
}
