//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;
import java.awt.FlowLayout;

import javax.swing.*;

import TrackController.TrackController;

@SuppressWarnings("serial")
public class TrainPanel extends JPanel {
	
	private LogPanel log;
	//setup panel for holding train info panels
	TrainPanel(LogPanel logPanel,TrackController controller){
		super();
		log = logPanel;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new TrainStatPanel("Train 1",log, controller));
	}

}
