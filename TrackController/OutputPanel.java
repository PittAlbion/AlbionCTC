//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel{

		OutputPanel(){
			
			super();
			this.setLayout(new BorderLayout());
			//this.setPreferredSize(new Dimension(300,300));
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			JButton a = new JButton("NO WAY!");
			JButton b = new JButton("NO WAY!");
			JButton c = new JButton("I THINK YOU NEED A NEW ONE!");
			
			p.add(a);
			p.add(b);
			p.add(c);
			
			this.add(p);
			
		}
		
}