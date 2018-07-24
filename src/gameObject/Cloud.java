package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Cloud {
	
	private Dinosaur dinosaur;
	private BufferedImage cloud;
	private ArrayList<ImageCloud> cloudList;
	public int SCREEN_WIDTH;
	
	public Cloud(int width, Dinosaur dinosaur) {
		this.dinosaur = dinosaur;
		this.SCREEN_WIDTH = width;
		try {
			cloud = ImageIO.read(new File("assets/cloud.png"));
		} catch (IOException ex) {}
		
		cloudList = new ArrayList<ImageCloud>();
		ImageCloud imageCloud = new ImageCloud();
		imageCloud.posX = 0;
		imageCloud.posY = 30;
		cloudList.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.posX = 150;
		imageCloud.posY = 40;
		cloudList.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.posX = 300;
		imageCloud.posY = 50;
		cloudList.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.posX = 450;
		imageCloud.posY = 20;
		cloudList.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.posX = 600;
		imageCloud.posY = 60;
		cloudList.add(imageCloud);
	}
	
	public void update() {
		Iterator<ImageCloud> itr = cloudList.iterator();
		ImageCloud firstElement = itr.next();
		firstElement.posX -= dinosaur.getSpeed()/8;
		while(itr.hasNext()) {
			ImageCloud element = itr.next();
			element.posX -= dinosaur.getSpeed()/8;
		}
		if(firstElement.posX < -cloud.getWidth()) {
			cloudList.remove(firstElement);
			firstElement.posX = SCREEN_WIDTH;
			cloudList.add(firstElement);
		}
	}
	
	public void draw(Graphics g) {
		for(ImageCloud img : cloudList) {
			g.drawImage(cloud, (int) img.posX, (int) img.posY, null);
		}
	}
	
	private class ImageCloud {
		float posX;
		float posY;
		BufferedImage image;
	}
}
