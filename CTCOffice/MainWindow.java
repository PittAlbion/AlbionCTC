//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion

package CTCOffice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import TrackController.AboutBox;
import TrackController.TrackController;
import TrackModel.trackBlock;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener{
	
	/*
	 * variable definitions
	 */
	private JMenuBar menuBar;
	private JMenu systemMenu,logMenu,helpMenu;
	private JMenuItem systemExitItem,systemAddTrain,logSaveItem,helpAboutItem;
	private JPanel mainPane;
	private Container mainContainer;
	private JTabbedPane tabPane;
	private TrainPanel trainPanel;
	private TrackPanel greenTrackPanel,redTrackPanel;
	public LogPanel logPanel;
	public TrackController trackController;
	public ArrayList<trackBlock> greenBlocks;
	public ArrayList<trackBlock> redBlocks;
	
	//Main Method to start the program
	public static void main(String[] args){
		new MainWindow();
	}

	MainWindow(){
		super("Albion Train Control v1.0");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		trackController = new TrackController(greenBlocks,redBlocks);
		new Thread(trackController).start();
		
		/* set up menu bars*/
		menuBar = new JMenuBar();
		systemMenu = new JMenu("System");
		
		//setup the System
		systemExitItem = new JMenuItem("Exit");
		systemExitItem.addActionListener(this);
		systemAddTrain = new JMenuItem("Add Train");
		systemAddTrain.addActionListener(this);
		
		systemMenu.add(systemAddTrain);
		systemMenu.add(systemExitItem);
		
		//setup log menu
		logMenu = new JMenu("Log");
		logSaveItem = new JMenuItem("Save..");
		logSaveItem.addActionListener(this);
		logMenu.add(logSaveItem);
		
		//setup help menu
		helpMenu = new JMenu("Help");
		helpAboutItem = new JMenuItem("About");
		helpAboutItem.addActionListener(this);
		helpMenu.add(helpAboutItem);
		
		
		
		menuBar.add(systemMenu);
		menuBar.add(logMenu);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
		
		//set up container for tabs and log window
		mainContainer = this.getContentPane();
		mainPane = new JPanel();
		mainContainer.add(mainPane);
		mainPane.setLayout(new BorderLayout());
		
		//setup log panel
		logPanel = new LogPanel();
		
		//setup train panel
		trainPanel = new TrainPanel(logPanel,trackController);
		

		//setup track panels
		greenTrackPanel = new TrackPanel("Green",logPanel,greenBlocks,trackController);
		redTrackPanel = new TrackPanel("Red",logPanel,redBlocks,trackController);
		//setup tab pane
		tabPane = new JTabbedPane();
		tabPane.addTab("Trains", trainPanel);
		tabPane.addTab("Green Track Blocks", greenTrackPanel);
		tabPane.addTab("Red Track Blocks", redTrackPanel);
		
		mainPane.add(tabPane,BorderLayout.CENTER);
		
		mainPane.add(logPanel,BorderLayout.PAGE_END);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource().equals(systemExitItem)){
			logPanel.UpdateLog("**System Shutting Down\n");
			logPanel.Save();
			dispose();
			System.exit(0);
		}
		else if(event.getSource().equals(logSaveItem)){
			logPanel.Save();
		}
		else if(event.getSource().equals(systemAddTrain)){
			logPanel.UpdateLog("Adding Train");
			//create train and add it to the system
		}else if(event.getSource().equals(helpAboutItem)){
			AboutBox about = new AboutBox(this);
			about.setVisible(true);
		}
	}
}
