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

public class AttributesPanel extends JPanel {

	private JLabel length,width,height,crewCount, passCount, mass, speed, acc;
	
	public AttributesPanel(TrainModel theModel){
		super();
		this.setLayout(new GridLayout(0,1));
		this.setPreferredSize(new Dimension(150,400));
		//this.setMaximumSize(this.getPreferredSize());
		
		length = new JLabel("Length: " + theModel.lengthTotal);
		width = new JLabel("Width: " + theModel.width);
		height = new JLabel("Height: " + theModel.height);
		crewCount = new JLabel("Crew: " + theModel.crewTotal);
		passCount = new JLabel("Passengers: " + theModel.passengerTotal);
		mass = new JLabel("Mass: " + theModel.massTotal);
		speed = new JLabel("Speed: " + theModel.currSpeed);
		acc = new JLabel("Acceleration: " + theModel.currAcc);
		
		this.add(length);
		this.add(width);
		this.add(height);
		this.add(crewCount);
		this.add(passCount);
		this.add(mass);
		this.add(speed);
		this.add(acc);
		
	}
	
	void update(TrainModel theModel){
		crewCount.setText("Crew: " + theModel.crewTotal);
		passCount.setText("Passengers: " + theModel.passengerTotal);
		mass.setText("Mass: " + theModel.massTotal);
		speed.setText("Speed: " + theModel.currSpeed);
		acc.setText("Acceleration: " + theModel.currAcc);
		
	}
	
	
}
