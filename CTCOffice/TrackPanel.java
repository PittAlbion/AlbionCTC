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

@SuppressWarnings("serial")
public class TrackPanel extends JPanel{
	//panel for holding track info panels
	private LogPanel log;
	private TrackController controller;
	/**<NEWLINE>
	 * Creates a TrackWatcher Panel for the provided
	 * blocks in the ArrayList, with the provided TrackController,
	 * Updating to the provided logPanel, The Panel will have the
	 * provided name.
	 * @param name
	 * @param logPanel
	 * @param blocks
	 * @param trackController
	 */
	TrackPanel(String name,
			   LogPanel logPanel,
			   ArrayList<trackBlock> blocks,
			   TrackController trackController){
		super();
		this.setLayout(new GridLayout(1,1));
		
		log = logPanel;
		controller = trackController;
		Update(blocks);
	}
	
	/**<NEWLINE>
	 * Updates the panel to display the blocks listed in the ArrayList
	 * @param blocks
	 * @return 
	 */
	public void Update(ArrayList<trackBlock> blocks){
		this.removeAll();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		for(trackBlock block : blocks){
			panel.add(new TrackStatPanel(block,log,controller));			
		}
		
		this.add(new JScrollPane(panel));
		
	}
}
