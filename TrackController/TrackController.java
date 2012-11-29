//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable, ActionListener {

		private JMenuBar menuBar;
		private JMenu fileMenu, helpMenu;
		private JMenuItem exit, runPLC, doc, about;
		private JDialog f;
		private static JPanel mainPane;
		private Container mainContainer;
		CommandPanel commandPanel;
		OutputPanel outputPanel;
		SelectPanel selectPanel;
		StatisticPanel statisticPanel;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		public static void main(String [] args) throws InterruptedException{
			
			new TrackController(new ArrayList<trackBlock>(), new ArrayList<trackBlock>());
			
				
		}
		
		public TrackController(ArrayList<trackBlock> green, ArrayList<trackBlock> red)
		{
			super("Albion Track Controller v1.0");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setResizable(false);
			this.setMaximumSize(new Dimension(600,600));
			this.setPreferredSize(new Dimension(600,600));
			setExtendedState(Frame.NORMAL);
			
			
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
			mainPane.setLayout(new GridBagLayout());
			GridBagConstraints c= new GridBagConstraints();
			
			commandPanel = new CommandPanel();
			selectPanel = new SelectPanel();
			outputPanel = new OutputPanel();
			statisticPanel = new StatisticPanel();
			
			//statisticPanel.setSize(new Dimension(200, 200));
			//CommandPanel.activate.setEnabled(false);
			//mainPane.add(selectPanel);
			//mainPane.add(commandPanel);
			//mainPane.add(outputPanel);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 400;
			c.weighty = 300;
			c.gridwidth = 1;
			c.gridheight = 1;
			
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			
			selectPanel.setPreferredSize(new Dimension(300,300));
			mainPane.add(selectPanel, c);
			
			c.gridx = 1;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_END;
			mainPane.add(commandPanel, c);
			
			c.weightx = 200;
			c.weighty = 400;
			
			c.gridx = 0;
			c.gridy = 1;
			c.anchor = GridBagConstraints.LAST_LINE_START;
			mainPane.add(outputPanel,c);
			
			c.weighty = 200;
			c.gridx = 1;
			c.gridy = 1;
			c.anchor = GridBagConstraints.LAST_LINE_END;
			mainPane.add(statisticPanel,c);
			
			pack();
			
			setVisible(true);
		
		}
		
		public void run(){
			
		}
		
		public void GetSuggestion(Object [] s){

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

		
		
	    private void useSuggestion(String lineSelect, int trackSelect, String type, String value){
		
	    		boolean safe = false;
	            //Track trackBlock = tracks.get(line, trackSelect);
	            if (type.equals("Authority")){
	                safe = checkStatus(); //Do something safe involving the authority suggestion
	                if(safe){ //change Authority
	                	//trackBlock.setAuthority(value);
	                }
	            }
	            else if(type.equals("Speed")){
	                safe = checkStatus(); //Do something safe involving the speed suggestion
	                if (safe){ //change speed
	                	//trackBlock.setSpeed(value);
	                }
	            }
	            else //Invalid suggestion
	                return; //do nothing
					
	    }
	    
	    
	    @SuppressWarnings("unused")
		private boolean activateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is inactive:
	    	//Check to make sure it is safe to activate crossing
	    	//Activate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean deactivateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is activated:
	    	//Check to make sure all trains are out of the area and that
	    	//it is safe to deactivate the crossing
	    	//Deactivate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean switchTrackSegment(String lineSelect, int trackSegement, int position){
	    	//Determine if the switch can safely be activated
	    	//Based on the arguments given, switch the track segment into the appropriate position.
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean trainDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for trains
	    	//currently present on the system. If the circuit is broken (i.e. a train is present)
	    	//the function shall return true, otherwise false.
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean brokenRailDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for rails that
	    	//are currently broken. If the circuit is non functional, the function shall return true,
	    	//otherwise false;
	    	return false;
	    }
	    
	    private boolean checkStatus(){
	    	
	    	return false;
	    }
	    
	    public void actionPerformed(ActionEvent e){
	    	if(e.getSource().equals(exit)){
	    		System.exit(0);
	    	}
	    	else if (e.getSource().equals(doc)){
	    		//do some crap with documentation
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
	    			
	    			try {
						PLCImport.ParsePLCFile(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	    		}
	    	}
	    	else{
	    		
	    	}
	    }
}
