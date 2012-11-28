//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class SelectPanel extends JPanel {

		SelectPanel(){
			super();
			this.setLayout(new BorderLayout());
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			JButton a = new JButton("HEY!");
			JButton b = new JButton("HEY!");
			JButton c = new JButton("YOU! YOU!");
			JButton d = new JButton("I DON'T LIKE YOUR GIRLFRIEND!");
			
			p.add(a);
			p.add(b);
			p.add(c);
			p.add(d);
			
			this.add(p);
			
		}
		
}