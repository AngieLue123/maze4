import java.awt.Color;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MazeListener implements KeyListener, MouseListener, ActionListener{
	
	MazePanel gamePanel; //reference to panel game is played on
	Timer timer;
	
	public MazeListener(MazePanel panel) {
		gamePanel = panel;
		gamePanel.addKeyListener(this);
		gamePanel.addMouseListener(this);
		System.out.println("something");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Quit")) {
			System.exit(0);
		} else if(s.equals("Restart")) {
			gamePanel.restart(); 
		} else if(s.equals("NEXT")) {
			//show the maze now and remove the instructions.
			MazeMain.showPanel("Maze");
		}
	}


	@Override
	public void keyTyped(KeyEvent e) { // fill this in
		// TODO Auto-generated method stub
		System.out.println("key typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key pressed");
		int code = e.getKeyCode();
		
		
		if (code == KeyEvent.VK_LEFT && gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].isLeft() != true) {
			// add && check to make sure left is a valid spot
			// change color of the cells.
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.WHITE);
			gamePanel.goLeft();
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.MAGENTA);
			
		} else if (code == KeyEvent.VK_RIGHT && gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].isRight() != true) { //add check
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.WHITE);
			gamePanel.goRight();
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.MAGENTA);
			
		} else if (code == KeyEvent.VK_DOWN && gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].isBottom() != true) {
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.WHITE);
			gamePanel.goDown();
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.MAGENTA);
			
		} else if (code == KeyEvent.VK_UP && gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].isTop() != true) {
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.WHITE);
			gamePanel.goUp();
			gamePanel.getMaze().getGrid()[gamePanel.getCurrentRow()][gamePanel.getCurrentCol()].changeColor(Color.MAGENTA);
			
		}
		gamePanel.repaint();
		//if (gamePanel.getMaze().getGrid()[14][14].getC() == Color.MAGENTA) {
			//gamePanel.repaint();
		//}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		gamePanel.requestFocusInWindow();
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
