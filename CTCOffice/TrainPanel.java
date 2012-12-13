//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import TrackController.TrackController;
import TrackModel.trackBlock;
import TrainModel.TrainModel;

@SuppressWarnings("serial")
public class TrainPanel extends JPanel {
	
	private LogPanel log;
	private TrackController trackController;

	/**<NEWLINE>
	 * Creates a Panel to display the trains in the system
	 * @param logPanel
	 * @param controller
	 */
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
	
	/**<NEWLINE>
	 * Updates the Panel to display the trains provided in the ArrayList
	 * @param trains
	 */
	public void Update(ArrayList<TrainModel> trains){
		this.removeAll();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		for(TrainModel train : trains){
			AddTrain(train);
		}
		
		this.add(new JScrollPane(panel));
		
		
		
	}

}
