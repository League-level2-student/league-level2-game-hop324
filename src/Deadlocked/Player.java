package Deadlocked;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Player implements ActionListener{
	public JButton playerPosition;
	public int position;
	public JButton movableUp;
	public JButton movableDown;
	public JButton movableLeft;
	public JButton movableRight;
	public JButton movableNE;
	public JButton movableNW;
	public JButton movableSE;
	public JButton movableSW;
	

	
	
void getPlayerPosition(JButton gamer, int index) {
	playerPosition = gamer;
	position = index;
}

void getMovableSpaces(int ahhh) {
	ahhh = position;
	movableUp = Deadlocked.tiles[position-9];
	movableDown = Deadlocked.tiles[position+9];
	movableLeft = Deadlocked.tiles[position-1];
	movableRight = Deadlocked.tiles[position+1];
	movableNE = Deadlocked.tiles[position-8];
	movableNW = Deadlocked.tiles[position-10];
	movableSE = Deadlocked.tiles[position+10];
	movableSW = Deadlocked.tiles[position+8];
	
	if(position% 9 == 0) {
	Deadlocked.tiles[position-9].setBackground(Color.yellow);
	Deadlocked.tiles[position-8].setBackground(Color.yellow);
	//Deadlocked.tiles[position-1].setBackground(Color.yellow);
	Deadlocked.tiles[position+9].setBackground(Color.yellow);
	Deadlocked.tiles[position+10].setBackground(Color.yellow);
	Deadlocked.tiles[position+1].setBackground(Color.yellow);
	}
	
}

void movePlayer(JButton ahh) {
	ahh = playerPosition;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
