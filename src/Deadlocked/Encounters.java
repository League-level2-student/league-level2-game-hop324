package Deadlocked;

import java.awt.Color;
import java.util.Random;

public class Encounters {
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
}
