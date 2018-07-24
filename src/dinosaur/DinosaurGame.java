package dinosaur;

import javax.swing.JFrame;

public class DinosaurGame extends JFrame{
	
	public static final int SCREEN_WIDTH = 600;
	public int SCREEN_HEIGHT = 200;
	private GameThread gameThread;

	DinosaurGame(){
		super("DinosaurGame");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		gameThread = new GameThread();
		
        //addKeyListener(gameThread);
        add(gameThread);

	}
	
	public void startGame() {
		setVisible(true);
		gameThread.startGame();
	}
	
	public static void main(String[] args) {
		(new DinosaurGame()).startGame();;
	}
	
	
}
