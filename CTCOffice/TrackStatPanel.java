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
import TrackModel.trackBlock;

@SuppressWarnings("serial")
public class TrackStatPanel extends JPanel implements ActionListener{
	JButton maintenanceButton;
	private JButton editButton;
	private LogPanel log;
	private TrackController trackController;
	private trackBlock block;
	TrackStatPanel(trackBlock newBlock, 
			       LogPanel logPanel,
			       TrackController controller){
		super();
		log = logPanel;
		trackController = controller;
		block = newBlock;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,300));
		this.setMaximumSize(this.getPreferredSize());
		this.setBorder(new TitledBorder(block.track_line +" " + block.block_number));
		
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
			log.UpdateLog("Maintenance on block: "+block.track_line+" "+block.block_number);
			Object[] suggestion = new Object[4];
			suggestion[0] = "Track";
			suggestion[1] = block.track_line.charAt(0)+block.block_number;
			suggestion[2] = "maintenance";
			suggestion[3] = true;
			
			trackController.GetSuggestion(suggestion);
		}
		else if(event.getSource().equals(editButton)){
			log.UpdateLog("Editing "+block.track_line+" "+block.block_number);
		}
		
	}

}
