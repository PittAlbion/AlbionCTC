package CTCOffice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener{
	
	/*
	 * variable definitions
	 */
	private JMenuBar menuBar;
	private JMenu systemMenu,logMenu,userMenu;
	private JMenuItem systemExitItem;
	private JPanel mainPane;
	private Container mainContainer;
	private JTabbedPane tabPane;
	private JPanel trainPanel;
	private JPanel greenTrackPanel,redTrackPanel;
	private JPanel logPanel;
	
	//Main Method to start the program
	public static void main(String[] args) {
		new MainWindow();
	}

	MainWindow(){
		super("Albion Train Control v1.0");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		/* set up menu bars*/
		menuBar = new JMenuBar();
		systemMenu = new JMenu("System");
		
		//set up exit way to exit the system
		systemExitItem = new JMenuItem("Exit");
		systemExitItem.addActionListener(this);
		systemMenu.add(systemExitItem);
		
		logMenu = new JMenu("Log");
		
		userMenu = new JMenu("User");
		
		menuBar.add(systemMenu);
		menuBar.add(logMenu);
		menuBar.add(userMenu);
		this.setJMenuBar(menuBar);
		
		//set up container for tabs and log window
		mainContainer = this.getContentPane();
		mainPane = new JPanel();
		mainContainer.add(mainPane);
		mainPane.setLayout(new BorderLayout());
		
		//setup tab pane
		//trainPanel = new TrainPanel();
		//greenTrackPanel = new TrackPanel("Green");
		//redTrackPanel = new TrackPanel("Red");
		tabPane = new JTabbedPane();
		tabPane.addTab("Trains", trainPanel);
		tabPane.addTab("Green Track Blocks", greenTrackPanel);
		tabPane.addTab("Red Track Blocks", redTrackPanel);
		
		mainPane.add(tabPane,BorderLayout.CENTER);
		
		logPanel = LogPanel.CreateLogPanel();
		mainPane.add(logPanel,BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(systemExitItem)){
			dispose();
			System.exit(0);
		}
	}

}
