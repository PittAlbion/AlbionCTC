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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import TrackController.TrackController;
import TrainModel.TrainModel;

@SuppressWarnings("serial")
public class TrainStatPanel extends JPanel implements ActionListener{
	
	private JButton editButton;
	private JButton removeButton;
	private LogPanel log;
	private TrackController trackController;
	TrainModel train;
	
	// panels to be created display train info and allow editing
	public TrainStatPanel(TrainModel trainM,LogPanel logPanel, TrackController controller){
		super();
		log = logPanel;
		train = trainM;
		trackController = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,300));
		this.setBorder(new TitledBorder("Train " + train.trainID));
		this.add(new JLabel("Current Location: " + train.trackLine + train.blockID));
		this.add(new JLabel("Current Speed: " + train.currSpeed));
		this.add(new  JLabel("Passengers: " + (int)train.passengerTotal));
		this.add(new JLabel("Current Authority: " + train.currAuthority));
		String status = (train.doorsClosed) ? "Closed" : "Open";
		this.add(new JLabel("Door Status: " + status));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setMaximumSize(new Dimension(150,50));
		buttonPanel.setLayout(new GridLayout(2,1));
		editButton = new JButton("Edit");
		editButton.addActionListener(this);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		buttonPanel.add(editButton);
		buttonPanel.add(removeButton);
		
		//add in other properties before buttons
		
		this.add(buttonPanel);
		this.setMaximumSize(this.getPreferredSize());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		//call edit method and pass suggestion to track controller
		if(event.getSource().equals(editButton)){
			new TrainEditDialog(train,trackController);
			log.UpdateLog("Editing Train " + train.trainID);
		}
		else if(event.getSource().equals(removeButton)){
			log.UpdateLog("Routing Train " + train.trainID+"back to station");
		}
		
	}

}
