
import java.awt.*;

import javax.swing.*;

public class MazeMain extends JFrame{
	JPanel mainPanel;
	MazePanel maze = new MazePanel();
	CardLayout cardLayout;
	MazeListener l = new MazeListener(maze);


	public static void main (String[] args) {
		//super("Maze Game");
		MazeMain game = new MazeMain();
		game.setMain();

		JMenuBar menuBar = new JMenuBar();
		JMenu mazeMenu = new JMenu("Maze");
		JMenuItem quit = new JMenuItem("Quit");
		JMenuItem restart = new JMenuItem("Restart");
		quit.addActionListener(game.l);
		restart.addActionListener(game.l);
		mazeMenu.add(quit);
		mazeMenu.addSeparator();
		mazeMenu.add(restart);
		menuBar.add(mazeMenu);
		game.setJMenuBar(menuBar);

		//window.add(mainPanel);

		mazeContainer.add(content); 

		mainPanel.add(container, "Intro");
		mainPanel.add(mazeContainer, "Maze");
		window.add(mainPanel);

		window.setSize(600, 645);
		window.setLocation(100,100);
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setResizable(false);  // User can't change the window's size.
		window.setVisible(true);
		cardlayout.show(mainPanel, "Maze");
		//container.requestFocusInWindow();

	}

	public void setMain() {
		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);

		JPanel titleScreenPanel = setTitle(); 
		JPanel secondScreenPanel = setMaze(); 

		mainPanel.add(titleScreenPanel, "TitleScreen");	
		mainPanel.add(secondScreenPanel, "MazeScreen");
		cardLayout.show(mainPanel, "TitleScreen");

	}

	public JPanel setMaze() {
		JPanel second = new JPanel();  

	//	second.setLayout(new BorderLayout());
	//	MazePanel maze = new MazePanel();
	//	l = new MazeListener(maze);
		second.add(maze);
		
		
		return second;
	}

	public JPanel setTitle() {
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		JLabel instructions = new JLabel("Welcome to Angelina's Maze Game! After clicking the NEXT button below, click on the maze to begin.");
		title.add(instructions, BorderLayout.CENTER);
		JButton nextButton = new JButton("NEXT");
		title.add(nextButton, BorderLayout.SOUTH);	
		return title;
	}

	public void showPanel(String panelName) {
		cardlayout.show(mainPanel, panelName);
		//	content.requestFocusInWindow();
	}

}
