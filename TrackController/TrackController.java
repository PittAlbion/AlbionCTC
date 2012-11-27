package track_controller;

import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable, ActionListener {

		private JMenuBar menuBar;
		private JMenu fileMenu, helpMenu;
		private JMenuItem exit, runPLC, doc, about;
		private JDialog f;
		private JPanel mainPane;
		private Container mainContainer;
		private JPanel commandPanel, statisticPanel, outputPanel, selectPanel;
		
		public static void main(String [] args){
			new TrackController();
			
			CommandPanel.deactivate.setEnabled(false);
			CommandPanel.switcher.setEnabled(false);
		}
		
		TrackController()
		{
			super("Albion Track Controller v1.0");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setSize(800,600);
			setExtendedState(Frame.MAXIMIZED_BOTH);
			
			menuBar = new JMenuBar();
			fileMenu = new JMenu("File");
			helpMenu = new JMenu("Help");
			
			runPLC = new JMenuItem("Run PLC...");
			runPLC.addActionListener(this);
			fileMenu.add(runPLC);
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(this);
			fileMenu.add(exit);
			
			doc = new JMenuItem("Documentation");
			doc.addActionListener(this);
			helpMenu.add(doc);
			
			about = new JMenuItem("About");
			about.addActionListener(this);
			helpMenu.add(about);
			
			menuBar.add(fileMenu);
			menuBar.add(helpMenu);
			this.setJMenuBar(menuBar);
			
			mainContainer = this.getContentPane();
			mainPane = new JPanel();
			mainContainer.add(mainPane);
			mainPane.setLayout(new GridLayout(2,2));
			
			commandPanel = CommandPanel.CreateCommandPanel();
			selectPanel = SelectPanel.CreateSelectPanel();
			outputPanel = OutputPanel.CreateOutputPanel();
			statisticPanel = StatisticPanel.CreateStatisticPanel();
			
			commandPanel.setSize(new Dimension(200, 500));
			
			//CommandPanel.activate.setEnabled(false);
			
			mainPane.add(selectPanel);
			mainPane.add(commandPanel);
			mainPane.add(outputPanel);
			mainPane.add(statisticPanel);
			
			setVisible(true);
		}
		
		public void run(){
			
		}
		
		public static void GetSuggestion(Object [] s){

	        int i;
			String [] parsedString = new String[2];
	        String suggestionDest = s[0].toString();
	        String selector = s[1].toString();
			
			parsedString = selector.split("");
			String line = parsedString[0];
			int block = Integer.parseInt(parsedString[1]);
			
	        for (i=2; i<(s.length); i++){
	            if (suggestionDest.equals("Train")){ //Train Controller Suggestion
	                ;   // PassSuggestion. Some code to send the suggestion to the Train Controller
	            }else if (suggestionDest.equals("Track")){ //Track Controller Suggestion
	                useSuggestion(line, block, s[i].toString(), s[i+1].toString());
	            }
	            else    // Invalid Suggestion Destination, do nothing.
	                return;
	        }
			
	    }

		
		
	    private static void useSuggestion(String lineSelect, int trackSelect, String type, String value){
		
	            //Track trackBlock = tracks.get(line, trackSelect);
	            if (type.equals("Authority"))
	                ; //Do something safe involving the authority suggestion
	            else if(type.equals("Speed"))
	                ; //Do something safe involving the speed suggestion
	            else //Invalid suggestion
	                return; //do nothing
					
	    }
	    
	    
	    private static boolean activateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is inactive:
	    	//Check to make sure it is safe to activate crossing
	    	//Activate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    private static boolean deactivateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is activated:
	    	//Check to make sure all trains are out of the area and that
	    	//it is safe to deactivate the crossing
	    	//Deactivate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    private static boolean switchTrackSegment(String lineSelect, int trackSegement, int position){
	    	//Determine if the switch can safely be activated
	    	//Based on the arguments given, switch the track segment into the appropriate position.
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    private static boolean trainDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for trains
	    	//currently present on the system. If the circuit is broken (i.e. a train is present)
	    	//the function shall return true, otherwise false.
	    	return false;
	    }
	    
	    private static boolean brokenRailDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for rails that
	    	//are currently broken. If the circuit is non functional, the function shall return true,
	    	//otherwise false;
	    	return false;
	    }
	    
	    private static boolean checkStatus(){
	    	
	    	return true;
	    }
	    
	    public void actionPerformed(ActionEvent e){
	    	if(e.getSource().equals(exit)){
	    		System.exit(0);
	    	}
	    	else if (e.getSource().equals(doc)){
	    		
	    	}
	    	else if (e.getSource().equals(about)){
	    		
	    		f = new AboutBox(new JFrame());
	    		f.setVisible(true);
	    	}
	    	else if (e.getSource().equals(runPLC)){
	    		final JFileChooser fc = new JFileChooser();
	    		fc.setMultiSelectionEnabled(false);
	    		fc.setAcceptAllFileFilterUsed(false);
	    		
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("PLC Files", "plc");
	    		fc.setFileFilter(filter);
	    		
	    		int returnVal = fc.showOpenDialog(TrackController.this);
	    		
	    		if (returnVal == JFileChooser.APPROVE_OPTION){
	    			File file = fc.getSelectedFile();
	    			
	    			PLCImport.ParsePLCFile(file);
	    		}
	    	}
	    	else{
	    		
	    	}
	    }
}
