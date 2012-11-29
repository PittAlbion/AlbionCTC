//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;
//import java.sql.Timestamp;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CommandPanel extends JPanel{

	public static JButton activate, deactivate, switcher;
	//private static Timestamp time;
	
		CommandPanel(){
			super();
			
			this.setLayout(new GridBagLayout());
			this.setPreferredSize(new Dimension(200, 400));
			JPanel p = new JPanel();
			p.setLayout(new GridBagLayout());
			GridBagConstraints c= new GridBagConstraints();
			c.weightx = 100;
			c.weighty = 100;
			c.gridheight = 2;
			//this.setPreferredSize(new Dimension(200,300));
			//p.setPreferredSize(new Dimension(100,300));
			
			c.insets = new Insets(25, 25, 25, 25);
			activate = new JButton("Activate Crossing");
			c.gridx = 0;
			c.gridy = 0;
			p.add(activate, c);
			
			//c.insets = new Insets(5, 5, 5, 5);
			deactivate = new JButton("Deactivate Crossing");
			c.gridx = 0;
			c.gridy = 2;
			p.add(deactivate, c);
			
			switcher = new JButton("Activate Switch");
			c.gridx = 0;
			c.gridy = 4;
			p.add(switcher, c);
			p.setBorder(BorderFactory.createLineBorder(Color.black));
			
			c.weightx = 200;
			c.weighty = 400;
			c.insets = new Insets(0,0,0,0);
			//c.fill = GridBagConstraints.BOTH;
			this.add(p, c);
			//time = new Timestamp(System.currentTimeMillis());
			
			this.setSize(200, 400);
			
		}
		
		public void deactivateButton(JButton button){
			button.setEnabled(false);
		}
}
