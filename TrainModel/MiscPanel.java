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

public class MiscPanel extends JPanel {

	private JLabel miscInfo, doorInfo;
	public MiscPanel(TrainModel theModel){
		super();
		this.setLayout(new GridLayout(0,1));
		this.setPreferredSize(new Dimension(100,100));
		//this.setMaximumSize(this.getPreferredSize());
		
		miscInfo = new JLabel("Misc Info will be here");
		doorInfo = new JLabel();
		
		if(theModel.doorsClosed) doorInfo.setText("Doors are Closed.");
		else doorInfo.setText("Doors are Open.");
		
		this.add(doorInfo);
		//this.add(miscInfo);
		
		
	}
	
	public void update(TrainModel theModel){
		if(theModel.doorsClosed) doorInfo.setText("Doors are Closed.");
		else doorInfo.setText("Doors are Open.");
		
	}
	
}
