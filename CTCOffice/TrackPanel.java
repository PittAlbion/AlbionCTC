//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.*;

import TrackController.TrackController;
import TrackModel.trackBlock;

@SuppressWarnings("serial")
public class TrackPanel extends JPanel{
	//panel for holding track info panels
	private LogPanel log;
	TrackPanel(String name,
			   LogPanel logPanel,
			   ArrayList<trackBlock> blocks,
			   TrackController controller){
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		log = logPanel;
		
		for(trackBlock block : blocks){
			this.add(new TrackStatPanel(block,log,controller));			
		}
	}

}
