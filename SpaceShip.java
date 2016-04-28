import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpaceShip extends Sprite{
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		
		
	}
	
	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}


	


}
