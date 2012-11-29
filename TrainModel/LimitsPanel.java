package TrainModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class LimitsPanel extends JPanel {

	private JLabel authority, speedLimit, accLimit, decLimit;
	public LimitsPanel(TrainModel theModel){
		super();
		this.setLayout(new GridLayout(4,1));
		this.setPreferredSize(new Dimension(100,100));
		//this.setMaximumSize(this.getPreferredSize());
		
		authority = new JLabel("Authority: " + theModel.currAuthority);
		speedLimit = new JLabel("Speed Limit: " +theModel.speedLimit);
		accLimit = new JLabel("Acceleration Limit: " + theModel.accLimit);
		decLimit = new JLabel("deceleration Limit: " + theModel.decLimit);
		
		
		this.add(authority);
		this.add(speedLimit);
		this.add(accLimit);
		this.add(decLimit);
	
		
	}
	
}
