import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpaceShip extends Sprite{
	int step = 8;
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(x-5, y+10, 10, 35);
		g.fillRect(x-16, y+20, 33,7);
		g.fillRect(x-20, y+40, 40,7);
		g.setColor(Color.RED);
		g.fillOval(x-6,y+16,11,20);
		g.setColor(Color.RED);
		g.fillRect(x-20, y+50, 10, 1);
		g.fillRect(x+10, y+50, 10, 1);
		
		
	}
	
	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}


		


}
