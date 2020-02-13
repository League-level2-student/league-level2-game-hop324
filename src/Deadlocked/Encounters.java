package Deadlocked;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Encounters implements ActionListener {
	
	public JFrame battleField = new JFrame();
	public JPanel UI = new JPanel();
	
	public double HP = 20;
	public double maxHP = HP;
	public double AM = 1.0;
	public int AC = 10;
	public int damage = 1;
	public int gold = 0;
	public int spareHearts = 0;
	public int freezePotions = 0;
	
	public JButton goblin1;
	public double goblin1HP = 10;
	public JButton goblin2;
	public double goblin2HP = 10;
	public JButton goblin3;
	public double goblin3HP = 10;
	public JButton goblin4;
	public double goblin4HP = 10;
	public JButton goblin5;
	public double goblin5HP = 10;
	
	public double goblinD = 3;
	public int goblinCount;
	public double goblinDTracker;
	
	public JButton useFreeze;

	
	int goblinTiles = 12;
	public int remainingGoblins = 12;
	int dragonTile = 1;
	int traderTile = 1;
	int goldTiles = 5;
	int normalTiles = 16;
	int weaponTiles = 5;
	int magicItemTiles = 5;
	int tileDecider;
	boolean traderSet = true;
	int tracker = 0;
	Random randy = new Random();
	Random traderLocation = new Random();
	int traderPosition;
	
	
	public JButton dragon;
	public double dragonHP = 1000;
	public int dragonAC = 10;
	public double dragonAM = 1.0;
	public int dragonD = 35;
	
	public static JTextArea battleLog = new JTextArea(10, 40);
	public static JScrollPane painTwo = new JScrollPane(battleLog);
	
	
	void getTiles() {
		if(goblinTiles == 0 && dragonTile == 0 && normalTiles == 0 && goldTiles == 0 && weaponTiles == 0 && magicItemTiles == 0) {
			getNewTraderLocation();
		}
		else {
			for(int i = 0; i < 45; i++) {
				if(goblinTiles == 0 && dragonTile == 0 && normalTiles == 0 && goldTiles == 0 && weaponTiles == 0 && magicItemTiles == 0 && traderTile == 0) {
					i = 45;
					Deadlocked.log.append("YEETUS" + "\n");
				}
			tileDecider = randy.nextInt(7);
				if(tracker == 18) {
					 
					tracker++;
				}
				else if(tileDecider == 0 && normalTiles > 0) {
					normalTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.white);
					 
					tracker++;
				}
				else if(tileDecider == 0 && normalTiles == 0 && i >= 0) {
					 
					i--;
				}
				else if(tileDecider == 1 && goldTiles > 0) {
					goldTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.yellow);
					ImageIcon coin =new ImageIcon(getClass().getResource("coinSprite.png"));
					Image ing = coin.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					coin = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(coin);
					tracker++;
				}
				else if(tileDecider == 1 && goldTiles == 0 && i >= 0) {
					i--;
					 
				}
				else if(tileDecider == 2 && dragonTile > 0) {
					dragonTile--;
					Deadlocked.tiles[tracker].setBackground(Color.red);
					ImageIcon coin =new ImageIcon(getClass().getResource("dragonSprite.png"));
					Image ing = coin.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					coin = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(coin);
					tracker++;
				}
				else if(tileDecider == 2 && dragonTile == 0 && i >= 0) {
					i--;
					 
				}
				else if(tileDecider == 3 && goblinTiles > 0) {
					goblinTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.green);
					ImageIcon goblin =new ImageIcon(getClass().getResource("gerbleSprite.png"));
					Image ing = goblin.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					goblin = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(goblin);
					tracker++;
				}
				else if(tileDecider == 3 && goblinTiles == 0 && i >= 0) {
					i--;
					 
				}
				else if(tileDecider == 4 && weaponTiles > 0) {
					weaponTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.gray);
					ImageIcon weapon =new ImageIcon(getClass().getResource("weaponSprite.png"));
					Image ing = weapon.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					weapon = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(weapon);
					tracker++;
				}
				else if(tileDecider == 4 && weaponTiles == 0 && i >= 0) {
					i--;
					 
				}
				else if(tileDecider == 5 && magicItemTiles > 0) {
					magicItemTiles--;
					Deadlocked.tiles[tracker].setBackground(Color.blue);
					ImageIcon coin =new ImageIcon(getClass().getResource("magicItem.png"));
					Image ing = coin.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					coin = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(coin);
					tracker++;
				}
				else if(tileDecider == 5 && magicItemTiles == 0 && i >= 0) {
					i--;
					 
				}
				else if(tileDecider == 6 && traderTile > 0) {
					traderTile--;
					Deadlocked.tiles[tracker].setBackground(Color.PINK);
					traderPosition = tracker;
					ImageIcon merchant =new ImageIcon(getClass().getResource("merchantSprite.png"));
					Image ing = merchant.getImage();
					Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					merchant = new ImageIcon(newing);
					Deadlocked.tiles[tracker].setIcon(merchant);
					tracker++;
				}
				else if(tileDecider == 6 && traderTile == 0 && i >= 0) {
					i--;
					 

				}
		
			}
		}
	}
	
	void getNewTraderLocation() {
		Deadlocked.tiles[traderPosition].setBackground(Color.white);
		Deadlocked.log.append("yeet" + "\n");
		int numberOfTraders = 0;
		for(int i = 0; i <44; i++) {
			if(Deadlocked.tiles[i].getBackground() == Color.PINK) {
				numberOfTraders++;
				if(numberOfTraders > 1) {
					Deadlocked.tiles[i].setBackground(Color.white);
					Deadlocked.tiles[i].setIcon(null);
					numberOfTraders--;
					Deadlocked.log.append("fat yeet" + "\n");
				}
				
			}
		}
		if(numberOfTraders <= 0) {
			Deadlocked.log.append("Fattest yeet" + "\n");
			Random reee = new Random();
			while(!traderSet) {
				Deadlocked.log.append("ascended yeet" + "\n");
				int ahhh = reee.nextInt(44);
				for(int i = 0; i < 44; i++) {
					if(ahhh == i && Deadlocked.tiles[i].getBackground() == Color.white && i != traderPosition) {
						traderPosition = i;
						ImageIcon merchant =new ImageIcon(getClass().getResource("merchantSprite.png"));
						Image ing = merchant.getImage();
						Image newing = ing.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
						merchant = new ImageIcon(newing);
						Deadlocked.tiles[i].setIcon(merchant);
						Deadlocked.tiles[i].setBackground(Color.PINK);
						traderSet = true;
					}
				}
			}
		}
	}
	
	void getResource(int pos) {
		if(Deadlocked.tiles[pos].getBackground() == Color.white) {
			if(Deadlocked.goblinAmbush >= 5) {
				JOptionPane.showMessageDialog(null, "You waited too long! The goblins ambush you" + "\n");
				gerbleEncounter();
				remainingGoblins++;
			}
		}
		else if(Deadlocked.tiles[pos].getBackground() == Color.blue){
			Random heh = new Random();
			int decider = heh.nextInt(3);
			if(decider == 0) {
				Deadlocked.log.append("You got some magic armor!" + "\n");
				AC += 3;
			}
			else if(decider == 1) {
				Deadlocked.log.append("You got a potion of strength!" + "\n");
				AM += .5;
			}
			else if(decider == 2) {
				Deadlocked.log.append("You got a potion of health!" + "\n");
				HP += 10;
				maxHP +=10;
			}
			if(Deadlocked.goblinAmbush >= 5) {
				JOptionPane.showMessageDialog(null, "You waited too long! The goblins ambush you");
				gerbleEncounter();
				remainingGoblins++;
			}
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.PINK){
		 shopping();
		 }
		 else if(Deadlocked.tiles[pos].getBackground() == Color.gray){
		  
				Random heh = new Random();
				int decider = heh.nextInt(3);
				if(decider == 0) {
					Deadlocked.log.append("You got a Sword" + "\n");
					if(damage < 5) {
						damage = 5;
					}
					else {
						Deadlocked.log.append("You scrap it for 3G" + "\n");
						gold+=3;
					}
				}
				else if(decider == 1) {
					Deadlocked.log.append("You got an Axe" + "\n");
					if(damage < 10) {
						damage = 10;
					}
					else {
						Deadlocked.log.append("You scrap it for 6G" + "\n");
						gold+=6;
					}
				}
				else if(decider == 2) {
					Deadlocked.log.append("You got a Bow" + "\n");
					if(damage < 6) {
						damage = 7;
					}
					else {
						Deadlocked.log.append("You scrap it for 6G" + "\n");
						gold+=6;
					}
				}
				if(Deadlocked.goblinAmbush >= 5) {
					JOptionPane.showMessageDialog(null, "You waited too long! The goblins ambush you");
					gerbleEncounter();
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
		  int monay = ehh.nextInt(7)+3;
		  gold+=monay;
		  Deadlocked.log.append("You found " + monay + " gold" + "\n");
		  Random jeff = new Random();
		  int treasure = jeff.nextInt(25);
		  if(treasure == 0) {
			  Deadlocked.log.append("Wow! You found a treasure chest! Inside is a Spare Heart!" + "\n");
			  spareHearts++;
		  }
		  else if(treasure == 1) {
			  Deadlocked.log.append("Wow! You found a treasure chest! Inside is a Freeze Potion!" + "\n");
			  freezePotions++;
		  }
		  else if(treasure == 2) {
			  Deadlocked.log.append("Wow! You found a treasure chest! Inside is a Freeze Potion!" + "\n");
			  freezePotions++;
		  }
			if(Deadlocked.goblinAmbush >= 5) {
				JOptionPane.showMessageDialog(null, "You waited too long! The goblins ambush you");
				gerbleEncounter();
			}
		 }
	}

	

	void gerbleEncounter() {
		Deadlocked.goblinAmbush = 0;
		
		Random f = new Random();
		int x = f.nextInt(5)+1;
		goblinCount = x;
		JOptionPane.showMessageDialog(null, "Oh no! " + x + " goblins appear!");
		Deadlocked.map.setVisible(false);
		battleField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleField.setSize(500, 700);
		battleField.add(UI);
		for(int i = 0; i < x; i++) {
			if(i == 0) {
				goblin1 = new JButton();
				goblin1.addActionListener(this);
				goblin1.setText("Goblin" + (i+1));
				UI.add(goblin1);
				goblin1.setMaximumSize(new Dimension(50, 25));
				goblin1.setLocation((10*i), 400);
			}
			else if(i == 1) {
				goblin2 = new JButton();
				goblin2.addActionListener(this);
				goblin2.setText("Goblin" + (i+1));
				UI.add(goblin2);
				goblin2.setMaximumSize(new Dimension(50, 25));
				goblin2.setLocation((10*i), 400);
			}
			else if(i == 2) {
				goblin3 = new JButton();
				goblin3.addActionListener(this);
				goblin3.setText("Goblin" + (i+1));
				UI.add(goblin3);
				goblin3.setMaximumSize(new Dimension(50, 25));
				goblin3.setLocation((10*i), 400);
			}
			else if(i == 3) {
				goblin4 = new JButton();
				goblin4.addActionListener(this);
				goblin4.setText("Goblin" + (i+1));
				UI.add(goblin4);
				goblin4.setMaximumSize(new Dimension(50, 25));
				goblin4.setLocation((10*i), 400);
			}
			else if(i == 4) {
				goblin5 = new JButton();
				goblin5.addActionListener(this);
				goblin5.setText("Goblin" + (i+1));
				UI.add(goblin5);
				goblin5.setMaximumSize(new Dimension(50, 25));
				goblin5.setLocation((10*i), 400);
			}
			
		}
		if(freezePotions > 0) {
			useFreeze = new JButton();
			useFreeze.addActionListener(this);
			useFreeze.setText("Use Freeze Potion");
			UI.add(useFreeze);
		}
		UI.add(painTwo);
		battleField.setVisible(true);
	}

	
	
	void dragonEncounter() {
		for(int i = 0; i < 45; i++) {
			Deadlocked.tiles[i].setBackground(Color.white);
		}
		JOptionPane.showMessageDialog(null, "You enter a large cave to find a large red dragon that roars at you.");
		if(freezePotions > 0) {
			useFreeze = new JButton();
			useFreeze.addActionListener(this);
			useFreeze.setText("Use Freeze Potion");
			UI.add(useFreeze);
		}
		dragon = new JButton();
		dragon.setPreferredSize(new Dimension(500, 250));
		dragon.setOpaque(true);
		dragon.setBorderPainted(false);
		dragon.addActionListener(this);
		dragon.setFocusable(false);
		dragon.setText("The Dragon");
		UI.add(dragon);
		battleField.add(UI);
		Deadlocked.map.setVisible(false);
		battleField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleField.setSize(500, 700);
		battleField.setVisible(true);
	}


void shopping() {
	 String reee = JOptionPane.showInputDialog("Howdy! Welcome to the trader! Please select a category: Magic Items, Weapons, or Equipment!");
	 if(reee == null) {
		 shopping();
	 }
	   if(reee.equalsIgnoreCase("Magic Items" ) && gold >= 10) {
		   String pepe = JOptionPane.showInputDialog("Sure, they all cost 10 gold! Which'd you like? Magic Armor, Potion of Strength, or Potion of Health?");
		   if(pepe.equalsIgnoreCase("Magic Armor")) {
			   Deadlocked.log.append("You got some magic armor!" + "\n");
				AC += 3;
		   	}
		   else if(pepe.equalsIgnoreCase("Potion of Strength")) {
			   Deadlocked.log.append("You got a potion of strength!" + "\n");
				AM += .5;
		   	}
			else if(pepe.equalsIgnoreCase("Potion of Health")) {
				Deadlocked.log.append("You got a potion of health!" + "\n");
				HP += 10;
				maxHP +=10;
			}
		   gold-=10;
	   }
	   else if(reee.equalsIgnoreCase("Magic Items" ) && gold <= 10) {
		   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
	   }
	   else if(reee.equalsIgnoreCase("Weapons")) {
		   String pepe = JOptionPane.showInputDialog("Sure! Would you like a Sword(5G), Axe(10G), or Bow(7G)");
		   if(pepe.equalsIgnoreCase("Sword") && gold >= 5) {
			   Deadlocked.log.append("You got a sword!" + "\n");
			   damage = 5;
			   gold-=5;
		   }
		   else if(reee.equalsIgnoreCase("Sword" ) && gold <= 5) {
			   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
		   }
		   else if(pepe.equalsIgnoreCase("Axe") && gold >= 10) {
			   damage = 10;
			   gold-=10;
		   }
		   else if(reee.equalsIgnoreCase("Axe" ) && gold <= 10) {
			   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
		   }
		   else if(pepe.equalsIgnoreCase("Bow") && gold >= 6) {
			   damage = 7;
			   gold-=10;
		   }
		   else if(reee.equalsIgnoreCase("Bow" ) && gold <= 6) {
			   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
		   }
	   }
	   else if(reee.equalsIgnoreCase("Equipment")) {
		   String pepe = JOptionPane.showInputDialog("Sure! Which'd you like? Spare Heart(20G) or Freeze Potion(5G)?");
		   if(pepe.equalsIgnoreCase("Spare Heart") && gold >= 20) {
			   spareHearts++;
			   Deadlocked.log.append("You got a Spare Heart!" + "\n");
			   gold-=20;
		   }
		   else if(reee.equalsIgnoreCase("Spare Heart" ) && gold <= 20) {
			   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
		   }
		   else if(pepe.equalsIgnoreCase("Freeze Potion") && gold >= 5) {
			   Deadlocked.log.append("You got a Freeze Potion" + "\n");
			   freezePotions++;
			   gold-=5;
		   }
		   else if(reee.equalsIgnoreCase("Freeze Potion" ) && gold <= 5) {
			   Deadlocked.log.append("Sorry, you don't have enough gold for that." + "\n");
		   }
	   }
	  /* else if(reee.equalsIgnoreCase("PizzaTime")) {
		   String pepe = JOptionPane.showInputDialog("Are you sure you want to initiate Pizza Time? Yes or No");
		   if(pepe.equalsIgnoreCase("Yes")) {
			   JOptionPane.showMessageDialog(null, "Very well then. Bagels");
			   HP += 10000;
			   AM += 10;
			   damage += 100;
			   AC += 100;
			   gold+= 10000;
		   }
	   }
	   */

	  String aghjrfdsjahflke = JOptionPane.showInputDialog("Would you like to keep shopping? Yes or No");
	  if(aghjrfdsjahflke == null) {
		  shopping();
	  }
	  else if(aghjrfdsjahflke.equalsIgnoreCase("Yes")) {
		  shopping();
	  }
	  else if(aghjrfdsjahflke.equalsIgnoreCase("No")) {
		  getNewTraderLocation();
	  }
	
	  
	   Deadlocked.log.append("Thanks for shopping!" + "\n");
	   traderSet = false;
	   getNewTraderLocation();
		if(Deadlocked.goblinAmbush >= 5) {
			JOptionPane.showMessageDialog(null, "You waited too long! The goblins ambush you");
			gerbleEncounter();
		}
}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

	
}
