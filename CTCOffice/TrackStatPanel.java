//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import TrackController.TrackController;

@SuppressWarnings("serial")
public class TrackStatPanel extends JPanel implements ActionListener{
	int blockNumber;
	String route;
	JButton maintenanceButton;
	private JButton editButton;
	private LogPanel log;
	private TrackController trackController;
	
	//class to represent the Track Info panel
	TrackStatPanel(String routeName,
			       int block, 
			       LogPanel logPanel,
			       TrackController controller){
		super();
		blockNumber = block;
		route = routeName;
		log = logPanel;
		trackController = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,300));
		this.setMaximumSize(this.getPreferredSize());
		this.setBorder(new TitledBorder(routeName +" " + blockNumber));
		
		maintenanceButton = new JButton("Maintenance");
		maintenanceButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setMaximumSize(new Dimension(150,50));
		buttonPanel.setLayout(new GridLayout(2,1));
		editButton = new JButton("Edit");
		editButton.addActionListener(this);
		
		buttonPanel.add(editButton);
		buttonPanel.add(maintenanceButton);
		
		this.add(buttonPanel);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//put block on maintenance and send suggestion to Track Controller
		if(event.getSource().equals(maintenanceButton)){
			log.UpdateLog("Maintenance on block: "+route+" "+blockNumber);
			Object[] suggestion = new Object[4];
			suggestion[0] = "Track";
			suggestion[1] = route.charAt(0)+blockNumber;
			suggestion[2] = "maintenance";
			suggestion[3] = true;
			
			trackController.GetSuggestion(suggestion);
		}
		else if(event.getSource().equals(editButton)){
			log.UpdateLog("Editing "+route+" "+blockNumber);
		}
		
	}

}
