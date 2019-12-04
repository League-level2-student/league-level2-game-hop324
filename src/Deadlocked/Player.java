package Deadlocked;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Player extends Encounters implements ActionListener{
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
	movableUp = null;
	movableDown = null;
	movableLeft = null;
	movableRight = null;
	movableNE = null;
	movableNW = null;
	movableSE = null;
	movableSW = null;
	
}

void getMovableSpaces(int ahhh) {
	ahhh = position;
	if(position > 9) {
	movableUp = Deadlocked.tiles[position-9];
	}
	if(position < 36) {
	movableDown = Deadlocked.tiles[position+9];
	}
	if(position > 0) {
	movableLeft = Deadlocked.tiles[position-1];
	}
	if(position < 44) {
	movableRight = Deadlocked.tiles[position+1];
	}
	if(position > 7) {
	movableNE = Deadlocked.tiles[position-8];
	}
	if(position > 9) {
	movableNW = Deadlocked.tiles[position-10];
	}
	if(position < 35) {
	movableSE = Deadlocked.tiles[position+10];
	}
	if(position < 37) {
	movableSW = Deadlocked.tiles[position+8];
	}
	
	if(position == 0) {
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 44) {
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 36) {
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 8) {
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6 || position == 7) {
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 37 || position == 38 || position == 39 || position == 40 || position == 41 || position == 42 || position == 43) {
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position == 17 || position == 26 || position == 35) {
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else if(position% 9 == 0) {
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
	}
	else {
		Deadlocked.tiles[position-9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position-1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+9].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+10].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+1].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		Deadlocked.tiles[position+8].setBorder(new BevelBorder(1, Color.yellow, Color.yellow));
		
	}
	//else if(position)
	
}

void movePlayer(JButton ahh) {
	ahh = playerPosition;
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
