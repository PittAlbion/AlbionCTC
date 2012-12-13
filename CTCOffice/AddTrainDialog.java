package CTCOffice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import TrackController.TrackController;

@SuppressWarnings("serial")
public class AddTrainDialog extends JFrame implements ActionListener{

	TrackController controller;
	JRadioButton greenButton,redButton;
	JButton okButton,cancelButton;
	JTextField idField,numCarsField;
	AddTrainDialog(TrackController trackController){
		super();
		setMinimumSize(new Dimension(250,200));
		controller = trackController;
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(2,1));
		radioPanel.setBorder(new TitledBorder("Route"));
		
		greenButton = new JRadioButton("Green");
		redButton = new JRadioButton("Red");
		
		ButtonGroup group = new ButtonGroup();
		group.add(greenButton);
		group.add(redButton);
		radioPanel.add(greenButton);
		radioPanel.add(redButton);
		
		masterPanel.add(radioPanel,BorderLayout.PAGE_START);
		
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(2,2));
		JLabel id = new JLabel("Train ID");
		fieldPanel.add(id);
		idField = new JTextField();
		fieldPanel.add(idField);
		
		JLabel numCars = new JLabel("Number of Cars");
		
		fieldPanel.add(numCars);
		numCarsField = new JTextField();
		fieldPanel.add(numCarsField);
		
		masterPanel.add(fieldPanel,BorderLayout.CENTER);
		
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		masterPanel.add(buttonPanel,BorderLayout.PAGE_END);
		this.add(masterPanel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(okButton)){
			char route = 'G';
			if(redButton.isSelected()){
				route = 'R';
			}
			controller.addTrain(route, Integer.parseInt(idField.getText()), Integer.parseInt(numCarsField.getText()));
			this.dispose();
		}
		else if(event.getSource().equals(cancelButton)){
			this.dispose();
		}
		
		
	}

}
