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

public class CommandsPanel extends JPanel {

	private JLabel lastComm;
	
	public CommandsPanel(TrainModel theModel){
		super();
		this.setLayout(new GridLayout(0,1));
		this.setPreferredSize(new Dimension(100,100));
		//this.setMaximumSize(this.getPreferredSize());
		
		lastComm = new JLabel("Last Command will go here");
		
		this.add(lastComm);
	}
	
}
