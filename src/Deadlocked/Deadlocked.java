package Deadlocked;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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
	public static JPanel setup = new JPanel();
	public static JButton[] tiles = new JButton[45];
	public static JTextArea log = new JTextArea(25, 130);
	public static JScrollPane pain;
	
	public boolean goblinsDed = false;
	public boolean goblinsAlive = true;
	
	
	
	//GameScreen Stuff End
	
	//End of Variables Section
	
	
	
	
void createGameUI() {
		for(int i = 0; i < 45; i++) {

			JButton ahh = new JButton();
			tiles[i] = ahh;
			tiles[i].setPreferredSize(new Dimension(200, 100));
			tiles[i].setOpaque(true);
			tiles[i].setBorderPainted(true);
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
			tiles[i].addActionListener(this);
			tiles[i].setFocusable(false);
			if(i == 18) {
				player = tiles[i];
				player.setBackground(Color.cyan);
				ImageIcon coin = new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
				Image ing = coin.getImage();
				Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				coin = new ImageIcon(newing);
				tiles[i].setIcon(coin);
				player.setOpaque(true);
				getPlayerPosition(player, i);
			}
			setup.add(tiles[i]);
		
		}
		pain = new JScrollPane(log);
		pain.setPreferredSize(new Dimension(1920, 200));
		log.setEditable(false);
		pain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setup.add(pain);
		//log.setFont("Arial", Font.BOLD, 16););
		//log.setPreferredSize(new Dimension(1800, 300));
		getMovableSpaces(18);
		getTiles();
		map.addKeyListener(this);
		map.add(setup);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		map.setSize(1920,1000);
		map.setVisible(true);
		map.setFocusable(true);
		map.setTitle( "You have: " + gold + " gold, " + HP + " health, " + AC + " armor, " + damage + " attack, and a " + AM + " attack modifier");
		map.hasFocus();

}

void randomDrop(int level) {
	Random j = new Random();
	int ah = j.nextInt(30);
	if(level == 1) {
		if(ah >= 0 && ah<=10) {
			log.append(" You found 3 gold on the goblin" + "\n");
			gold = gold+3;
		}
		else if(ah >= 11 && ah <= 28) {
			
		}
		else if( ah == 29) {
			log.append(" Wow! You found a Potion of Strength!" + "\n");
			AM+=.5;
		}
	}
	else if(level == 2) {
		if(ah >= 0 && ah<=10) {
			log.append(" You found 10 gold in a treasure chest the goblins were guarding" + "\n");
			gold = gold+10;
		}
		else if(ah >= 11 && ah <= 25) {
			log.append(" You found 6 gold in a treasure chest the goblins were guarding" + "\n");
			gold+=6;
		}
		else if( ah == 26) {
			log.append(" Wow! You found a Potion of Strength!" + "\n");
			AM+=.5;
		}
		else if( ah == 27) {
			log.append(" Wow! You found a Potion of Health!" + "\n");
			HP+=5;
		}
		else if( ah == 28) {
			log.append(" Wow! You found some magic armor" + "\n");
			AC+=3;
		}
		else if( ah == 29) {
			log.append(" Wow! You found a Goblin Warhammer!" + "\n");
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
	remainingGoblins = 0;
	//Final Boss Identifier
	if(((JButton) e.getSource()).getBackground() == Color.red && goblinsDed) {
		dragonEncounter();
	}
	else if(((JButton) e.getSource()).getBackground() == Color.red && !goblinsDed) {
		log.append(" You're not ready to move there yet. You must defeat all the goblins first." + "\n");
	}
	else {
		if(e.getSource() == dragon) {
			dragonHP = dragonHP-((AM*damage)-dragonAC);
			battleLog.append(" You dealt: " + ((AM*damage)-dragonAC) + " damage." + "\n");
			if(dragonHP <= 0) {
				JOptionPane.showMessageDialog(null," You killed the dragon! You win!" + "\n");
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				battleField.dispose();
				map.dispose();
				}
			if(!freezeActive) {
		Random DA = new Random();
		int attack = DA.nextInt(4);
			if(attack == 0) {
				if(dragonAM > 0) {
				HP = HP-((dragonD*dragonAM)-AC);
				battleLog.append(" The dragon hits you with it's claws and does " + ((dragonD*dragonAM)-AC) + " damage" + "\n");
				}
			}
			else if(attack == 1) {
				battleLog.append(" The dragon sharpens it's claws" + "\n");
				dragonAM+=.25;
			}
			else if(attack == 2) {
				battleLog.append(" The dragon uses it's flame breath! It deals " + (30-AC) + " damage and melts some of your armor" + "\n");
				HP = HP-=30;
				AC-=3;
			}
			else if(attack == 3) {
				battleLog.append(" The dragon covers it's scales in treasure to increase it's armor" + "\n");
				dragonAC+=5;
			}
			freezeActive = false;
			}
				
			if(HP <=0 && spareHearts <= 0) {
					JOptionPane.showMessageDialog(null," You died!" + "\n");
					map.dispose();
					battleField.dispose();
		}
			
		}
		
	//Final Boss Identifier
	
	if(turns <= 20) {
		goblinD = 1;
		goblinDTracker = 1;
		if(AC >= 25) {
			goblinD = 0;
			goblinDTracker = 0;
		}
		else if(AC >= 19) {
			goblinD= 0.5;
			goblinDTracker = 0.5;
		}
		else if(AC >= 13) {
			goblinD= 0.75;
			goblinDTracker = 0.75;
			
		}
	}
	else if(turns > 20 ) {
		if(!goblinsAreRestless) {
		JOptionPane.showMessageDialog(null, "The goblins grow restless, their damage is increased from now on");
		goblinsAreRestless = true;
		}
		goblinD = 3;
		goblinDTracker = 3;
		if(AC >= 25) {
			goblinD = 1.5;
			goblinDTracker = 1.5;
		}
		else if(AC >= 19) {
			goblinD= 2;
			goblinDTracker = 2;
		}
		else if(AC >= 13) {
			goblinD= 2.5;
			goblinDTracker = 2.5;
			
		}
	}
	
	if(e.getSource() == goblin1) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin1HP = goblin1HP-(AM*damage);
		battleLog.append(" You dealt: " + (AM*damage) + " damage." + "\n");
		if(goblin1HP <= 0) {
			battleLog.append(" You killed a goblin!" + "\n");
			goblinCount--;
			UI.remove(goblin1);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				battleField.dispose();
				for(int i = 0; i < 45; i++) {
					if(tiles[i].getBackground() == Color.green) {
						remainingGoblins++;
					}
					}
				if(remainingGoblins <= 0) {
					goblinsAlive = false;
					}
				else {
					remainingGoblins = 0;
				}
					if(!goblinsAlive) {
						goblinsDed = true;
						JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				
					}
				battleLog.append(" You won!" + "\n");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			battleLog.append(" You took: " + goblinCount*goblinD + " damage" + "\n");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				battleLog.append(" You died!" + "\n");
				map.dispose();
				battleField.dispose();
		}
			else if(HP <= 0 && spareHearts > 0) {
				spareHearts--;
				battleLog.append(" Your spare heart brought you back to life!" + "\n");
				HP = maxHP;
			}
	}
	else if(e.getSource() == goblin2) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin2HP = goblin2HP-(AM*damage);
		battleLog.append(" You dealt: " + (AM*damage) + " damage." + "\n");
		if(goblin2HP <= 0) {
			battleLog.append(" You killed a goblin!" + "\n");
			goblinCount--;
			UI.remove(goblin2);
			randomDrop(1);
			if(goblinCount == 0) {
				battleField.dispose();
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				for(int i = 0; i < 45; i++) {
					if(tiles[i].getBackground() == Color.green) {
						remainingGoblins++;
					}
					}
				if(remainingGoblins <= 0) {
					goblinsAlive = false;
					}
				else {
					remainingGoblins = 0;
				}
					if(!goblinsAlive) {
						goblinsDed = true;
						JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				
					}
				battleLog.append(" You won!" + "\n");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			battleLog.append(" You took: " + goblinCount*goblinD + " damage" + "\n");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleLog.append(" You died!" + "\n");
				map.dispose();
				battleField.dispose();
		}
			else if(HP <= 0 && spareHearts > 0) {
				spareHearts--;
				battleLog.append(" Your spare heart brought you back to life!" + "\n");
				HP = maxHP;
			}
	}
	else if(e.getSource() == goblin3) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin3HP = goblin3HP-(AM*damage);
		battleLog.append(" You dealt: " + (AM*damage) + " damage." + "\n");
		goblinD = 3;
		if(goblin3HP <= 0) {
			battleLog.append(" You killed a goblin!" + "\n");
			goblinCount--;
			UI.remove(goblin3);
			randomDrop(1);
			if(goblinCount == 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				battleField.dispose();
				for(int i = 0; i < 45; i++) {
					if(tiles[i].getBackground() == Color.green) {
						remainingGoblins++;
					}
					}
				if(remainingGoblins <= 0) {
					goblinsAlive = false;
					}
				else {
					remainingGoblins = 0;
				}
					if(!goblinsAlive) {
						goblinsDed = true;
						JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				
					}
				battleLog.append(" You won!" + "\n");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			battleLog.append(" You took: " + goblinCount*goblinD + " damage" + "\n");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleLog.append(" You died!" + "\n");
				map.dispose();
				battleField.dispose();
		}
			else if(HP <= 0 && spareHearts > 0) {
				spareHearts--;
				battleLog.append(" Your spare heart brought you back to life!" + "\n");
				HP = maxHP;
			}
	}
	else if(e.getSource() == goblin4) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin4HP = goblin4HP-(AM*damage);
		battleLog.append(" You dealt: " + (AM*damage) + " damage." + "\n");
		if(goblin4HP <= 0) {
			battleLog.append(" You killed a goblin!" + "\n");
			goblinCount--;
			UI.remove(goblin4);
			randomDrop(1);
			if(goblinCount == 0) {
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				for(int i = 0; i < 45; i++) {
					if(tiles[i].getBackground() == Color.green) {
						remainingGoblins++;
					}
					}
				if(remainingGoblins <= 0) {
					goblinsAlive = false;
					}
				else {
					remainingGoblins = 0;
				}
					if(!goblinsAlive) {
						goblinsDed = true;
						JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				
					}
				battleLog.append(" You won!" + "\n");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			battleLog.append(" You took: " + goblinCount*goblinD + " damage" + "\n");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				battleLog.append(" You died!" + "\n");
				map.dispose();
				battleField.dispose();
		}
			else if(HP <= 0 && spareHearts > 0) {
				spareHearts--;
				battleLog.append(" Your spare heart brought you back to life!" + "\n");
				HP = maxHP;
			}
	}
	else if(e.getSource() == goblin5) {
		if(freezeActive) {
			goblinD = 0;
		}
		goblin5HP = goblin5HP-(AM*damage);
		battleLog.append(" You dealt: " + (AM*damage) + " damage." + "\n");
		if(goblin5HP <= 0) {
			battleLog.append(" You killed a goblin!" + "\n");
			goblinCount--;
			UI.remove(goblin5);
			randomDrop(1);
			if(goblinCount == 0) {
				String logTracker = battleLog.getText();
				battleLog.setText("");
				log.append(logTracker + "\n");
				if(freezePotions > 0) {
				UI.remove(useFreeze);
				}
				battleField.dispose();
				for(int i = 0; i < 45; i++) {
					if(tiles[i].getBackground() == Color.green) {
						remainingGoblins++;
					}
					}
				if(remainingGoblins <= 0) {
					goblinsAlive = false;
					}
				else {
					remainingGoblins = 0;
				}
					if(!goblinsAlive) {
						goblinsDed = true;
						JOptionPane.showMessageDialog(null, "You have rid the world of goblins! You will no longer be ambushed! You are now ready to face the final boss.");
				
					}
					battleLog.append(" You won!" + "\n");
				randomDrop(2);
				map.setVisible(true);
			}
			}
			HP = HP-(goblinCount*goblinD);
			battleLog.append(" You took: " + goblinCount*goblinD + " damage" + "\n");
			freezeActive = false;
			goblinD = goblinDTracker;
			if(HP <=0 && spareHearts <= 0) {
				battleLog.append(" You died!" + "\n");
				map.dispose();
				battleField.dispose();
		}
			else if(HP <= 0 && spareHearts > 0) {
				spareHearts--;
				battleLog.append(" Your spare heart brought you back to life!" + "\n");
				HP = maxHP;
			}
	}
	else if(e.getSource() == useFreeze) {
		battleLog.append(" You freeze the enemies solid!" + "\n");
		freezePotions--;
		freezeActive = true;
		if(freezePotions <= 0) {
			UI.remove(useFreeze);
		}
	}
	
	else {
	 if(e.getSource() == movableUp) {
		tiles[position].setBackground(Color.white);
		tiles[position].setIcon(null);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-9);
		player = movableUp;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-9);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
	else if(e.getSource() == movableDown) {
		tiles[position].setBackground(Color.white);
		tiles[position].setIcon(null);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+9);
		player = movableDown;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+9);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
	else if(e.getSource() == movableLeft) {
		tiles[position].setBackground(Color.white);
		tiles[position].setIcon(null);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-1);
		player = movableLeft;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-1);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
	else if(e.getSource() == movableRight) {
		tiles[position].setIcon(null);
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+1);
		player = movableRight;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+1);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
	else if(e.getSource() == movableNE) {
		tiles[position].setIcon(null);
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-8);
		player = movableNE;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-8);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
	else if(e.getSource() == movableNW) {
		tiles[position].setIcon(null);
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position-10);
		player = movableNW;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position-10);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;

	}
	else if(e.getSource() == movableSW) {
		tiles[position].setIcon(null);
		tiles[position].setBackground(Color.white);
		for(int i = 0; i < 45; i++) {
			tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
		}
		getResource(position+8);
		player = movableSW;
		player.setBackground(Color.cyan);
		ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
		Image ing = coin.getImage();
		Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coin = new ImageIcon(newing);
		player.setIcon(coin);
		player.setOpaque(true);
		player.setBorderPainted(false);
		getPlayerPosition(player, position+8);
		getMovableSpaces(position);
		 turns++;
		 goblinAmbush++;
	}
		else if(e.getSource() == movableSE) {
			tiles[position].setIcon(null);
			tiles[position].setBackground(Color.white);
			for(int i = 0; i < 45; i++) {
				tiles[i].setBorder(new BevelBorder(1, Color.white, Color.white));
			}
			getResource(position+10);
			player = movableSE;
			player.setBackground(Color.cyan);
			ImageIcon coin =new ImageIcon(getClass().getResource("REEEEEE.jpeg"));
			Image ing = coin.getImage();
			Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			coin = new ImageIcon(newing);
			player.setIcon(coin);
			player.setOpaque(true);
			player.setBorderPainted(false);
			getPlayerPosition(player, position+10);
			getMovableSpaces(position);
			 turns++;
			 goblinAmbush++;
		}
		else {
			log.append(" You can't move that far!" + "\n");
		}
	}
	 if(goblinsDed) {
		 goblinAmbush = 0;
	 }
	}
	if(HP < maxHP) {
		HP++;
	}
	 map.hasFocus();
	map.setTitle( "You have: " + gold + " gold, " + HP + " health, " + AC + " armor, " + damage + " attack, and a " + AM + " attack modifier");
}


@Override
public void keyTyped(KeyEvent e) {
	
}


@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_F1) {
		JOptionPane.showMessageDialog(null, "You have: " + gold + " gold, " + HP + " health, " + AC + " armor, " + damage + " attack, and a " + AM + " attack modifier" );
		
	}
	else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		JOptionPane.showMessageDialog(null, "You have " + freezePotions + " freeze potions and " + spareHearts + " spare hearts");
	}
	if(e.getKeyCode() == KeyEvent.VK_P) {
		gamer = true;
	}
	if(e.getKeyCode() == KeyEvent.VK_T && gamer) {
		for(int i = 0; i < 45; i++) {
			if(tiles[i].getBackground() == Color.green) {
				tiles[i].setBackground(Color.white);
			}

		}
		log.append(" Bazinga" + "\n");
		log.append(" All the goblins were evaporated by the power of Waluigi's war cry." + "\n");
	}
	
}


@Override
public void keyReleased(KeyEvent e) {
	
}
}
