package Deadlocked;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


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
	public static JFrame map = new JFrame();
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
			tiles[i].setFocusable(false);
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
		map.addKeyListener(this);
		map.add(setup);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setSize(1920, 550);
		map.setVisible(true);
		map.setFocusable(true);
		map.hasFocus();

}

void randomDrop(int level) {
	Random j = new Random();
	int ah = j.nextInt(30);
	if(level == 1) {
		if(ah >= 0 && ah<=10) {
			System.out.println("You found 3 gold on the goblin");
			gold = gold+3;
		}
		else if(ah >= 11 && ah <= 28) {
			
		}
		else if( ah == 29) {
			System.out.println("Wow! You found a Potion of Strength!");
			AM+=.5;
		}
	}
	else if(level == 2) {
		if(ah >= 0 && ah<=10) {
			System.out.println("You found 10 gold in a treasure chest the goblins were guarding");
			gold = gold+10;
		}
		else if(ah >= 11 && ah <= 25) {
			System.out.println("You found 6 gold in a treasure chest the goblins were guarding");
			gold+=6;
		}
		else if( ah == 26) {
			System.out.println("Wow! You found a Potion of Strength!");
			AM+=.5;
		}
		else if( ah == 27) {
			System.out.println("Wow! You found a Potion of Health!");
			HP+=5;
		}
		else if( ah == 28) {
			System.out.println("Wow! You found some magic armor");
			AC+=3;
		}
		else if( ah == 29) {
			System.out.println("Wow! You found a Goblin Warhammer!");
			damage = 15;
		}
		
	}
}


public static void main(String [] args) {
	JOptionPane.showMessageDialog(null, "Welcome to my game! In this game you are the cyan colored square on a 5x9 tile board. You start on the far left and can only move to adjacent squares.");
	JOptionPane.showMessageDialog(null, "White squares have nothing on them, but colored squares all hold surprises!");
	JOptionPane.showMessageDialog(null, "Blue grants you a magic item, grey grants you a weapon, yellow gives you gold and has a small chance of holding a treasure, pink is the trader and will be moving around the map, green has a random amount of goblins you need to fight, and red is the final boss.");
	JOptionPane.showMessageDialog(null, "You can move however you'd like, but you must fight goblins once every  5 turns or you will lose. If you run out of health, you will lose.");
	JOptionPane.showMessageDialog(null, "You can check your stats by pressing F1 and you can check your equipment by pressing ESC. Have fun!");
	new Deadlocked().createGameUI();
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == goblin1) {
		goblin1HP = goblin1HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin1HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin1);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin2) {
		goblin2HP = goblin2HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin2HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin2);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin3) {
		goblin3HP = goblin3HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin3HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin3);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin4) {
		goblin4HP = goblin4HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin4HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin4);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin5) {
		goblin5HP = goblin5HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin5HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin5);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else {
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
	 map.hasFocus();
	}
}


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyPressed(KeyEvent e) {
	System.out.println(e.getKeyCode());
	if(e.getKeyCode() == KeyEvent.VK_F1) {
		JOptionPane.showMessageDialog(null, "You have: " + gold + " gold, " + HP + " health, " + AC + " armor, " + damage + " attack, and a " + AM + " attack modifier" );
		
	}
	else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		JOptionPane.showMessageDialog(null, "You have " + smokeBombs + " smoke bombs, " + freezePotions + " freeze potions, and " + spareHearts + " spare hearts");
	}
	
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
