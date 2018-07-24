package dinosaur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import gameObject.Cloud;
import gameObject.Dinosaur;
import gameObject.Ground;

public class GameThread extends JPanel implements Runnable, KeyListener{
	
	private static final int START_GAME_STATE = 0;
	private static final int GAME_PLAYING_STATE = 1;
	private static final int GAME_OVER_STATE = 2;
	private Thread thread;
	
	private Ground ground;
	private Cloud cloud;
	private int gameState = GAME_PLAYING_STATE;
	private Dinosaur dinosaur;
	
	GameThread(){
		dinosaur = new Dinosaur();
		ground = new Ground(DinosaurGame.SCREEN_WIDTH, dinosaur);
		cloud = new Cloud(DinosaurGame.SCREEN_WIDTH, dinosaur);
		dinosaur.setSpeed(1.0f);
	}
	
	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void update() {
		ground.update();
		cloud.update();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.decode("#f7f7f7"));
		g.fillRect(0, 0, getWidth(), getHeight());
		ground.draw(g);
		cloud.draw(g);
	}
	
	public void run() {
		while(true) {
			update();
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
