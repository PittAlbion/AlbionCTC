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
	private JMenuItem systemExitItem,logSaveItem;
	private JPanel mainPane;
	private Container mainContainer;
	private JTabbedPane tabPane;
	private TrainMaster trainMaster;
	private TrackMaster trackMaster;
	private JPanel trainPanel;
	private JPanel greenTrackPanel,redTrackPanel;
	private JPanel logPanel;
	
	//Main Method to start the program
	public static void main(String[] args){
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
		
		//setup the System
		systemExitItem = new JMenuItem("Exit");
		systemExitItem.addActionListener(this);
		systemMenu.add(systemExitItem);
		
		//setup log menu
		logMenu = new JMenu("Log");
		logSaveItem = new JMenuItem("Save..");
		logSaveItem.addActionListener(this);
		logMenu.add(logSaveItem);
		
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
		
		//setup train panel
		trainMaster = new TrainMaster();
		trainPanel = trainMaster.CreateTrainPanel();
		
		//setup track panel
		trackMaster = new TrackMaster();
		greenTrackPanel = trackMaster.CreateTrackPanel("Green");
		redTrackPanel = trackMaster.CreateTrackPanel("Red");
		//setup tab pane
		tabPane = new JTabbedPane();
		tabPane.addTab("Trains", trainPanel);
		tabPane.addTab("Green Track Blocks", greenTrackPanel);
		tabPane.addTab("Red Track Blocks", redTrackPanel);
		
		mainPane.add(tabPane,BorderLayout.CENTER);
		
		logPanel = LogPanel.CreateLogPanel();
		mainPane.add(logPanel,BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource().equals(systemExitItem)){
			LogPanel.UpdateLog("**System Shutting Down\n");
			//LogPanel.Save();
			dispose();
			System.exit(0);
		}
		else if(event.getSource().equals(logSaveItem)){
			//LogPanel.Save();
		}
	}
}
