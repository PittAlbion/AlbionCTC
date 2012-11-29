//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SelectPanel extends JPanel {

		SelectPanel(){
			super();
			//this.setLayout(new BorderLayout());
			//this.setPreferredSize(new Dimension(300,300));
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			JButton a = new JButton("This");
			JButton b = new JButton("isn't");
			JButton c = new JButton("Done");
			JButton d = new JButton("Yet");
			
			p.add(a);
			p.add(b);
			p.add(c);
			p.add(d);
			
			this.add(p);
			
		}
		
}