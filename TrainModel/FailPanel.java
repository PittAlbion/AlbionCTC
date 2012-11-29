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

public class FailPanel extends JPanel {

	private JLabel engineStat, brakesStat, signalsStat, eBrakeStat;
	
	public FailPanel(TrainModel theModel){
		
		super();
		this.setLayout(new GridLayout(4,1));
		this.setPreferredSize(new Dimension(100,100));
		
		engineStat= new JLabel();
		brakesStat = new JLabel();
		eBrakeStat = new JLabel();
		signalsStat = new JLabel();
		
		if(theModel.detector.engineWorking) engineStat.setText("Engine Working");
		else engineStat.setText("Engine Broken!");
		
		if(theModel.detector.brakesWorking) brakesStat.setText("Brakes Working");
		else brakesStat.setText("Brakes Broken!");
		
		if(theModel.detector.signalsWorking) signalsStat.setText("Signals Working");
		else signalsStat.setText("Signals Broken!");

		if(theModel.detector.eBreakThrown) eBrakeStat.setText("Emergency Brake has ben thrown!");
		else eBrakeStat.setText("Emergency brake idle.");
		
		this.add(engineStat);
		this.add(brakesStat);
		this.add(signalsStat);
		this.add(eBrakeStat);
		
	}
	
}
