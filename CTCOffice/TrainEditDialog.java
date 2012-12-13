package CTCOffice;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import TrackController.TrackController;
import TrackModel.trackBlock;
import TrainModel.TrainModel;

public class TrainEditDialog extends JFrame implements ActionListener{
	JButton okButton,cancelButton;
	String label;
	JTextField speed;
	JTextField auth;
	TrackController controller;
	TrainModel train;
	TrainEditDialog(TrainModel trainM, TrackController trackController){
		super("Edit Train Dialog");
		label = "Track";
		setMinimumSize(new Dimension(250,200));
		setPreferredSize(this.getMinimumSize());
		setResizable(false);
		controller = trackController;
		train = trainM;
		JPanel master = new JPanel();
		
		master.setLayout(new BorderLayout());
		master.setBorder(new TitledBorder("Train " + train.trainID));
		
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(2,1));
		JPanel speedPanel = new JPanel();
		speedPanel.setLayout(new GridLayout(1,2));
		JLabel label = new JLabel("Current Speed: ");
		speed = new JTextField(new Integer((int) train.currSpeed).toString());
		speedPanel.add(label);
		speedPanel.add(speed);
		JPanel authPanel = new JPanel();
		authPanel.setLayout(new GridLayout(1,2));
		JLabel authLabel = new JLabel("Current Authority: ");
		auth = new JTextField(new Integer((int)train.currAuthority).toString());
		authPanel.add(authLabel);
		authPanel.add(auth);
		
		
		fieldPanel.add(speedPanel);
		fieldPanel.add(authPanel);
		
		master.add(fieldPanel,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		master.add(buttonPanel,BorderLayout.PAGE_END);
		
		this.add(master);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(okButton)){
				Object[] message = new Object[6];
				message[0] = "Train";
				message[1] = train.trainID;
				message[2] = "speed";
				message[3] = speed.getText();
				message[4] = "authority";
				message[5] = auth.getText();

				
				controller.GetSuggestion(message);
				this.dispose();
		}
		else if(e.getSource().equals(cancelButton)){
			this.dispose();
			
		}
		
	}
}
