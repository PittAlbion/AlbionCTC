//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;
//import java.sql.Timestamp;
import javax.swing.*;

@SuppressWarnings("serial")
public class CommandPanel extends JPanel{

	public static JButton activate, deactivate, switcher;
	//private static Timestamp time;
	
		CommandPanel(){
			super();
			
			this.setLayout(new BorderLayout());
			
			activate = new JButton("Activate Crossing");
			deactivate = new JButton("Deactivate Crossing");
			switcher = new JButton("Activate Switch");
			
			activate.setSize(new Dimension(50,35));
			deactivate.setPreferredSize(new Dimension(50, 35));
			switcher.setPreferredSize(new Dimension(50,35));
			
			JPanel buttonPanel = new JPanel();
			//buttonPanel.setMaximumSize(new Dimension(100,100));
			buttonPanel.setLayout(new GridLayout(3,1));
			buttonPanel.add(activate);
			buttonPanel.add(deactivate);
			buttonPanel.add(switcher);
			
			this.add(buttonPanel, BorderLayout.CENTER);
			//time = new Timestamp(System.currentTimeMillis());
			
			//this.setSize(200, 400);
			
		}
		
		public void deactivateButton(JButton button){
			button.setEnabled(false);
		}
}
