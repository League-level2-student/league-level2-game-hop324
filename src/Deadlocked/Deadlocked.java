package Deadlocked;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Component;
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
	
	public boolean gamer = false;
	
	public boolean goblinsAreRestless = false;
	public boolean freezeActive = false;
	
	public static int turns = 0;
	public static int goblinAmbush = 0;
	
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
	//Final Boss Identifier
	if(((JButton) e.getSource()).getBackground() == Color.red && remainingGoblins == 0) {
		dragonEncounter();
	}
	else if(((JButton) e.getSource()).getBackground() == Color.red && remainingGoblins != 0) {
		System.out.println("You're not ready to move there yet. You must defeat all the goblins first.");
	}
	else {
		if(e.getSource() == dragon) {
			if(freezeActive) {
				dragonD = 0;
			}
			dragonHP = dragonHP-((AM*damage)-dragonAC);
			System.out.println("You dealt: " + (AM*damage) + " damage.");
			if(dragonHP <= 0) {
				System.out.println("You killed the dragon! You win!");
				battleField.dispose();
				map.dispose();
				}
		Random DA = new Random();
		int attack = DA.nextInt(4);
			if(attack == 0) {
				if(dragonAM > 0) {
				HP = HP-((dragonD*dragonAM)-AC);
				System.out.println("The dragon hits you with it's claws and does " + ((dragonD*dragonAM)-AC) + " damage");
				}
			}
			else if(attack == 1) {
				System.out.println("The dragon sharpens it's claws");
				dragonAM+=.25;
			}
			else if(attack == 2) {
				System.out.println("The dragon uses it's flame breath! It deals " + (30-AC) + " damage and melts some of your armor");
				HP = HP-=30;
				AC-=3;
			}
			else if(attack == 3) {
				System.out.println("The dragon covers it's scales in treasure to increase it's armor");
				dragonAC+=5;
			}
				freezeActive = false;
				
			if(HP <=0 && spareHearts <= 0) {
					System.out.println("You died!");
					map.dispose();
					battleField.dispose();
		}
		}
		
	//Final Boss Identifier
	
	
	System.out.println(turns);
	if(turns <= 20) {
		goblinD = 1;
		goblinDTracker = goblinD;
	}
	else if(turns > 20 ) {
		if(!goblinsAreRestless) {
		JOptionPane.showMessageDialog(null, "The goblins grow restless, their damage is increased from now on");
		goblinsAreRestless = true;
		}
		goblinD = 3;
		goblinDTracker = goblinD;
	}
	
	if(AC >= 25) {
		goblinD = goblinD-1.5;
		goblinDTracker = goblinD;
	}
	else if(AC >= 19) {
		goblinD= goblinD-1;
		goblinDTracker = goblinD;
	}
	else if(AC >= 13) {
		goblinD= goblinD-0.5;
		goblinDTracker = goblinD;
		
	}
	
	if(e.getSource() == goblin1) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin1HP = goblin1HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin1HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin1);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				remainingGoblins--;
				if(remainingGoblins == 0) {
					JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				}
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			freezeActive = false;
			goblinD = goblinDTracker;
			System.out.println(goblinD);
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin2) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin2HP = goblin2HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin2HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin2);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				remainingGoblins--;
				if(remainingGoblins == 0) {
					JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				}
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin3) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin3HP = goblin3HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		goblinD = 3;
		if(goblin3HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin3);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				remainingGoblins--;
				if(remainingGoblins == 0) {
					JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				}
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin4) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin4HP = goblin4HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin4HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin4);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				remainingGoblins--;
				if(remainingGoblins == 0) {
					JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				}
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == goblin5) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin5HP = goblin5HP-(AM*damage);
		System.out.println("You dealt: " + (AM*damage) + " damage.");
		if(goblin5HP <= 0) {
			System.out.println("You killed a goblin!");
			goblinCount--;
			UI.remove(goblin5);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				remainingGoblins--;
				if(remainingGoblins == 0) {
					JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				}
				System.out.println("You won!");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			System.out.println("You took: " + goblinCount*goblinD + " damage");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				System.out.println("You died!");
				map.dispose();
				battleField.dispose();
		}
	}
	else if(e.getSource() == useFreeze) {
		System.out.println("You freeze the enemies solid!");
		freezePotions--;
		freezeActive = true;
		if(freezePotions <= 0) {
			UI.remove(useFreeze);
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
		 turns++;
		 goblinAmbush++;
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
		 turns++;
		 goblinAmbush++;
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
		 turns++;
		 goblinAmbush++;
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
		 turns++;
		 goblinAmbush++;
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
		 turns++;
		 goblinAmbush++;
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
		 turns++;
		 goblinAmbush++;

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
		 turns++;
		 goblinAmbush++;
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
			 turns++;
			 goblinAmbush++;
		}
		else {
			System.out.println("You can't move that far!");
		}
	}
	 if(remainingGoblins == 0) {
		 goblinAmbush = 0;
	 }
	}
	 map.hasFocus();
	
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
	if(e.getKeyCode() == KeyEvent.VK_6) {
		gamer = true;
	}
	if(e.getKeyCode() == KeyEvent.VK_9 && gamer) {
		for(int i = 0; i < 45; i++) {
			if(tiles[i].getBackground() == Color.green) {
				tiles[i].setBackground(Color.white);
			}
			remainingGoblins = 0;
			System.out.println("Bazinga");
			System.out.println("All the goblins were evaporated by the power of Waluigi's war cry.");
		}
	}
	
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
