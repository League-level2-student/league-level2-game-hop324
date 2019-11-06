package Deadlocked;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

public class Deadlocked extends JPanel {
	//Define Variables
	public int currentScreen;
	public int startScreen = 0;
	public int gameScreen = 1;
	public int endScreen = 2;
	
	//StartScreen Stuff Start
	
	public JFrame start = new JFrame();

	
	//StartScreen Stuff End
	
	//GameScreen Stuff Start
	public JFrame map = new JFrame();
	JPanel setup = new JPanel();
	JButton tiles[] = new JButton[50];
	//GameScreen Stuff End
	
	//End of Variables Section
	
	
	
	
void createGameUI() {
		for(int i = 0; i < 45; i++) {
			JButton ahh = new JButton();
			tiles[i] = ahh;
			tiles[i].setPreferredSize(new Dimension(200, 100));
			setup.add(tiles[i]);
		
		}
		map.add(setup);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(1080, 1920);
		map.setVisible(true);

}


public static void main(String [] args) {
	new Deadlocked().createGameUI();
}
}
