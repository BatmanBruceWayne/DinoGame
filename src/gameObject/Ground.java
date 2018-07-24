package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;

public class Ground {
	private BufferedImage ground1;
	private BufferedImage ground2;
	private BufferedImage ground3;
	private ArrayList<ImageGround> groundList;
	public static final int GROUND_POSY = 100;
	private Dinosaur dinosaur;
	
	public Ground(int width, Dinosaur dinosaur) {
		this.dinosaur = dinosaur;
		try {
		
			ground1 = ImageIO.read(new File("assets/land1.png"));
			ground2 = ImageIO.read(new File("assets/land2.png"));
			ground3 = ImageIO.read(new File("assets/land3.png"));

		} catch (IOException ex) {}

		groundList = new ArrayList<ImageGround>();
		int numberOfImageGround = width / ground1.getWidth() + 2;
		for(int i = 0; i < numberOfImageGround; i++) {
			ImageGround imageGround = new ImageGround();
			imageGround.posX = i * ground1.getWidth();
			setImageLand(imageGround);
			groundList.add(imageGround);
		}
		
	}
	
	public void update() {
		Iterator<ImageGround> itr = groundList.iterator();
		ImageGround firstElement = itr.next();
		firstElement.posX -= dinosaur.getSpeed();
		float previousPosX = firstElement.posX;
		while(itr.hasNext()) {
			ImageGround element = itr.next();
			element.posX = previousPosX + ground1.getWidth();
			previousPosX = element.posX;
		}
		if(firstElement.posX < -ground1.getWidth()) {
			groundList.remove(firstElement);
			firstElement.posX = previousPosX + ground1.getWidth();
			setImageLand(firstElement);
			groundList.add(firstElement);
		}
	}
	
	private void setImageLand(ImageGround imgLand) {
		Random rand = new Random();
		int typeLand = rand.nextInt(2);
		if(typeLand == 1) {
			imgLand.image = ground1;
		} else if(typeLand == 2) {
			imgLand.image = ground3;
		} else {
			imgLand.image = ground2;
		}
	}
	
	
	public void draw(Graphics g) {
		for(ImageGround img : groundList) {
			g.drawImage(img.image, (int) img.posX, GROUND_POSY, null);
		}
	}

	private class ImageGround {
		float posX;
		BufferedImage image;
	}
}
