package Deadlocked;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Encounters {
	
	public int HP = 10;
	public double AM = 1.0;
	public int AC = 10;
	public int damage = 1;
	public int gold = 0;
	public int smokeBombs = 0;
	public int spareHearts = 0;
	public int freezePotions = 0;
	
	int goblinTiles = 10;
	int dragonTile = 1;
	int traderTile = 1;
	int goldTiles = 10;
	int normalTiles = 12;
	int weaponTiles = 5;
	int magicItemTiles = 5;
	int tileDecider;
	int tracker = 0;
	Random randy = new Random();
	Random traderLocation = new Random();
	int traderPosition;
	
	void getTiles() {
		if(goblinTiles == 0 && dragonTile == 0 && normalTiles == 0 && goldTiles == 0 && weaponTiles == 0 && magicItemTiles == 0) {
			getNewTraderLocation(traderPosition);
		}
		else {
			for(int i = 0; i < 45; i++) {
				if(goblinTiles == 0 && dragonTile == 0 && normalTiles == 0 && goldTiles == 0 && weaponTiles == 0 && magicItemTiles == 0 && traderTile == 0) {
					i = 45;
					System.out.println("YEETUS");
				}
			tileDecider = randy.nextInt(7);
				if(tracker == 18) {
					System.out.println("Poopus");
					tracker++;
				}
				else if(tileDecider == 0 && normalTiles > 0) {
					normalTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.white);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 0 && normalTiles == 0 && i >= 0) {
					System.out.println("Bazoinga");
					i--;
				}
				else if(tileDecider == 1 && goldTiles > 0) {
					goldTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.yellow);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 1 && goldTiles == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");
				}
				else if(tileDecider == 2 && dragonTile > 0) {
					dragonTile--;
					Deadlocked.tiles[tracker].setBackground(Color.red);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 2 && dragonTile == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");
				}
				else if(tileDecider == 3 && goblinTiles > 0) {
					goblinTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.green);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 3 && goblinTiles == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");
				}
				else if(tileDecider == 4 && weaponTiles > 0) {
					weaponTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.gray);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 4 && weaponTiles == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");
				}
				else if(tileDecider == 5 && magicItemTiles > 0) {
					magicItemTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.blue);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 5 && magicItemTiles == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");
				}
				else if(tileDecider == 6 && traderTile > 0) {
					traderTile--;
					Deadlocked.tiles[tracker].setBackground(Color.PINK);
					System.out.println("Bazinga");
					tracker++;
				}
				else if(tileDecider == 6 && traderTile == 0 && i >= 0) {
					i--;
					System.out.println("Bazoinga");

				}
		
			}
		}
	}
	

	
	
	
	void getNewTraderLocation(int yes) {
		
	}
	
	void getResource(int pos) {
		if(Deadlocked.tiles[pos].getBackground() == Color.blue){
			System.out.println("Stinky");
			Random heh = new Random();
			int decider = heh.nextInt(3);
			if(decider == 0) {
				System.out.println("You got some magic armor!");
				AC += 3;
			}
			else if(decider == 1) {
				System.out.println("You got a potion of strength!");
				AM += .5;
			}
			else if(decider == 2) {
				System.out.println("You got a potion of health!");
				HP += 5;
			}

		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.PINK){
		  String reee = JOptionPane.showInputDialog("Howdy! Welcome to the trader! Please select a category: Magic Items, Weapons, or Equipment!");
		   if(reee.equalsIgnoreCase("Magic Items" ) && gold >= 10) {
			   String pepe = JOptionPane.showInputDialog("Sure, they all cost 10 gold! Which'd you like? Magic Armor, Potion of Strength, or Potion of Health?");
			   if(pepe.equalsIgnoreCase("Magic Armor")) {
				   System.out.println("You got some magic armor!");
					AC += 3;
			   	}
			   else if(pepe.equalsIgnoreCase("Potion of Strength")) {
				   System.out.println("You got a potion of strength!");
					AM += .5;
			   	}
				else if(pepe.equalsIgnoreCase("Potion of Health")) {
					System.out.println("You got a potion of health!");
					HP += 5;
				}
			   gold-=10;
		   }
		   else if(reee.equalsIgnoreCase("Weapons")) {
			   String pepe = JOptionPane.showInputDialog("Sure! Would you like a Sword(5G), Axe(10G), or Bow(10G)");
			   if(pepe.equalsIgnoreCase("Sword") && gold >= 5) {
				   System.out.println("You got a sword!");
				   damage = 5;
				   gold-=5;
			   }
			   else if(pepe.equalsIgnoreCase("Axe") && gold >= 10) {
				   damage = 10;
				   AC-=3;
				   gold-=10;
			   }
			   else if(pepe.equalsIgnoreCase("Bow") && gold >= 10) {
				   damage = 5;
				   AC+=3;
				   gold-=10;
			   }
		   }
		   else if(reee.equalsIgnoreCase("Equipment")) {
			   String pepe = JOptionPane.showInputDialog("Sure! Which'd you like? Smoke Bomb(5G), Spare Heart(10G), or Freeze Potion(5G)?");
			   if(pepe.equalsIgnoreCase("Smoke Bomb") && gold >= 5) {
				   System.out.println("You got a Smoke Bomb!");
				   smokeBombs++;
			   }
			   else if(pepe.equalsIgnoreCase("Spare Heart") && gold >= 10) {
				   spareHearts++;
			   }
			   else if(pepe.equalsIgnoreCase("Freeze Potion") && gold >= 5) {
				   freezePotions++;
				   gold-=5;
			   }
		   }
		   else {
			   
		   }
		   System.out.println("Thanks for shopping!");
	
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.gray){
		  
				Random heh = new Random();
				int decider = heh.nextInt(3);
				if(decider == 0) {
					System.out.println("You got a Sword");
					if(damage < 5) {
						damage = 5;
					}
					else {
						System.out.println("You scrap it for 3G");
						gold+=3;
					}
				}
				else if(decider == 1) {
					System.out.println("You got an Axe");
					if(damage <= 10) {
						damage = 10;
						AC-=3;
					}
					else {
						System.out.println("You scrap it for 6G");
						gold+=6;
					}
				}
				else if(decider == 2) {
					System.out.println("You got a Bow");
					if(damage <= 6) {
						damage = 6;
						AC+=3;
					}
					else {
						System.out.println("You scrap it for 6G");
						gold+=6;
					}
				}
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.green){
			 gerbleEncounter();
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.red){
			 dragonEncounter();
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.yellow){
		  Random ehh = new Random();
		  int monay = ehh.nextInt(10)+1;
		  gold+=monay;
		  System.out.println("You found " + monay + " gold");
		 }
	}
	
	void gerbleEncounter() {
		
	}
	
	void dragonEncounter() {}

	
}
