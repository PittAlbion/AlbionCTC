//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;
//import java.sql.Timestamp;
import javax.swing.*;

public class CommandPanel {

	public static JButton activate, deactivate, switcher;
	//private static Timestamp time;
	
		public static JPanel CreateCommandPanel(){
			
			JPanel pane = new JPanel();
			pane.setLayout(new GridLayout(3,1));
			
			activate = new JButton("Activate Crossing");
			deactivate = new JButton("Deactivate Crossing");
			switcher = new JButton("Activate Switch");
			
			activate.setPreferredSize(new Dimension(100,35));
			deactivate.setPreferredSize(new Dimension(100, 35));
			switcher.setPreferredSize(new Dimension(100,35));
			
			pane.add(activate);
			pane.add(deactivate);
			pane.add(switcher);
			
			//time = new Timestamp(System.currentTimeMillis());
			
			pane.setSize(200, 400);
			return pane;
			
		}
		
		public void deactivateButton(JButton button){
			button.setEnabled(false);
		}
}
