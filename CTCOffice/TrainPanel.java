//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;
import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class TrainPanel extends JPanel {
	
	//setup panel for holding train info panels
	TrainPanel(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new TrainStatPanel("Train 1"));
	}

}
