//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import TrackController.TrackController;
import TrackModel.trackBlock;
import TrainModel.TrainModel;

@SuppressWarnings("serial")
public class TrainPanel extends JPanel {
	
	private LogPanel log;
	private TrackController trackController;
	
	//setup panel for holding train info panels
	TrainPanel(LogPanel logPanel,TrackController controller){
		super();
		this.setLayout(new GridLayout(1,1));
		JPanel panel = new JPanel();
		trackController = controller;
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		log = logPanel;
		
		this.add(new JScrollPane(panel));
	}
	
	public void AddTrain(TrainModel train){
		this.add(new TrainStatPanel(train,log,trackController));
		
	}

}
