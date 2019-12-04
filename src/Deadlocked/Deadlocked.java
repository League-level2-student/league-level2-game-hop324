package Deadlocked;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Deadlocked extends Player implements KeyListener  {
	//Define Variables
	public int currentScreen;
	public int startScreen = 0;
	public int gameScreen = 1;
	public int endScreen = 2;
	
	JButton player;
	
	//StartScreen Stuff Start
	
	public JFrame start = new JFrame();

	
	//StartScreen Stuff End
	
	//GameScreen Stuff Start
	public JFrame map = new JFrame();
	JPanel setup = new JPanel();
	public static JButton[] tiles = new JButton[45];
	
	
	
	//GameScreen Stuff End
	
	//End of Variables Section
	
	
	
	
void createGameUI() {
		for(int i = 0; i < 45; i++) {

			JButton ahh = new JButton();
			tiles[i] = ahh;
			tiles[i].setPreferredSize(new Dimension(200, 100));
			tiles[i].setOpaque(true);
			tiles[i].setBorderPainted(false);
			tiles[i].addActionListener(this);
			if(i == 18) {
				player = tiles[i];
				player.setBackground(Color.cyan);
				player.setOpaque(true);
				getPlayerPosition(player, i);
			}
			setup.add(tiles[i]);
		
		}
		getMovableSpaces(18);
		getTiles();
		map.add(setup);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(1920, 550);
		map.setVisible(true);

}


public static void main(String [] args) {
	new Deadlocked().createGameUI();
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == movableUp) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-9);
		System.out.println("Up");
		player = movableUp;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-9);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableDown) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+9);
		System.out.println("Down");
		player = movableDown;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+9);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableLeft) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-1);
		System.out.println("Left");
		player = movableLeft;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-1);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableRight) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+1);
		System.out.println("Right");
		player = movableRight;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+1);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableNE) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-8);
		System.out.println("NE");
		player = movableNE;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-8);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableNW) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-10);
		System.out.println("NW");
		player = movableNW;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-10);
		getMovableSpaces(position);

	}
	else if(e.getSource() == movableSW) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+8);
		System.out.println("SW");
		player = movableSW;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+8);
		getMovableSpaces(position);
	}
	else if(e.getSource() == movableSE) {
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+10);
		System.out.println("SE");
		player = movableSE;
		player.setBackground(Color.cyan);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+10);
		getMovableSpaces(position);
	}
	else {
		System.out.println("You can't move that far!");
	}
	
			 
	
	
	
	
	
}


@Override
public void keyTyped(KeyEvent e) {
}


@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_TAB) {
		System.out.println("Your HP is: " + HP + ", your Attack Modifier is: " + AM + ", your Armor Class is: " + AC + ", and yoour have " + gold + " gold");
	}
}


@Override
public void keyReleased(KeyEvent e) {

	
}
}
