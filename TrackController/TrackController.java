package track_controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable, ActionListener {

		private JMenuBar menuBar;
		private JMenu fileMenu, helpMenu;
		private JMenuItem exit, runPLC, doc, about;
		private JPanel mainPane;
		private Container mainContainer;
		private JPanel commandPanel, statisticPanel, outputPanel, selectPanel;
		
		public static void main(String [] args){
			new TrackController();
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
			mainPane.setLayout(new BorderLayout());
			
			commandPanel = CommandPanel.CreateCommandPanel();
			selectPanel = SelectPanel.CreateSelectPanel();
			outputPanel = OutputPanel.CreateOutputPanel();
			statisticPanel = StatisticPanel.CreateStatisticPanel();
			
			mainPane.add(commandPanel, BorderLayout.WEST);
			mainPane.add(selectPanel, BorderLayout.NORTH);
			mainPane.add(outputPanel, BorderLayout.SOUTH);
			mainPane.add(statisticPanel, BorderLayout.EAST);
			
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
	    
	    public void actionPerformed(ActionEvent e){
	    	if(e.getSource().equals(exit)){
	    		System.exit(0);
	    	}
	    }
}
