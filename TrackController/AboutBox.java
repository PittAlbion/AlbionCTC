package TrackController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class AboutBox extends JDialog {

	JLabel desc = new JLabel("Albion Track Controller");
	JLabel create = new JLabel("Created By: Calvin Souders");
	JLabel version = new JLabel("Version: 1.0.0");
		public AboutBox(JFrame parent) {
			super(parent, "About", true);
			
			Box b = Box.createVerticalBox();
			b.add(Box.createGlue());
			desc.setAlignmentX(CENTER_ALIGNMENT);
			create.setAlignmentX(CENTER_ALIGNMENT);
			version.setAlignmentX(CENTER_ALIGNMENT);
			b.add(desc);
			b.add(create);
			b.add(version);
			b.add(Box.createGlue());
			getContentPane().add(b, "Center");
			
			JPanel p2 = new JPanel();
			JButton ok = new JButton("OK");
			p2.add(ok);
			getContentPane().add(p2, "South");
			
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt){
					setVisible(false);
				}
			});
			
			setSize(250,150);
		}
		
}