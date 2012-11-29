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
import javax.swing.JLabel;
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
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(6,1));
		
		JLabel section = new JLabel("Length: "+block.block_length);
		section.setAlignmentX(LEFT_ALIGNMENT);
		labelPanel.add(section);
		JLabel grade = new JLabel("Grade: "+ block.block_grade + "%");
		grade.setAlignmentX(LEFT_ALIGNMENT);
		labelPanel.add(grade);
		JLabel speed = new JLabel("Speed Limit: " + block.speed_limit + "km/h");
		speed.setAlignmentX(LEFT_ALIGNMENT);
		labelPanel.add(speed);
		if(!block.infrastructure.equalsIgnoreCase("")){
			JLabel infrastructure = new JLabel("Type: " + block.infrastructure);
			infrastructure.setAlignmentX(LEFT_ALIGNMENT);
			labelPanel.add(infrastructure);
		}
		JLabel elevation = new JLabel("Elevation: " + block.elevation + " m");
		elevation.setAlignmentX(LEFT_ALIGNMENT);
		labelPanel.add(elevation);
		JLabel cumElevation = new JLabel("Cum. Elev.: " + block.cumulative_elevation + " m");
		cumElevation.setAlignmentX(LEFT_ALIGNMENT);
		labelPanel.add(cumElevation);
		
		
		this.add(labelPanel);
		
		maintenanceButton = new JButton("Maintenance");
		if(block.maintenance){
			maintenanceButton.setText("Clear Maintenance");
		}
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
			suggestion[3] = !block.maintenance;
			
			trackController.GetSuggestion(suggestion);
		}
		else if(event.getSource().equals(editButton)){
			log.UpdateLog("Editing "+block.track_line+" "+block.block_number);
		}
		
	}

}
