package TrainModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.*;
import javax.swing.JButton;

import javax.swing.*;


public class TrainGUI extends JFrame implements ActionListener{
	
	private TrainModel theModel;
	private double tempDouble;
	private String tempString;
	private JPanel mainPane, buttonPane, topPane;
	private Container mainContainer;
	private JButton setPointButton, openButton, closeButton, stopButton, exitButton, moveButton;
	private JButton simBrakeFail, simEngineFail, simSignalFail, simEBrake;
	private JTextField setPointText;
	
	private AttributesPanel attPanel;
	private MiscPanel miscPanel;
	private FailPanel failPanel;
	private OtherPanel otherPanel;
	private CommandsPanel commPanel;
	private LimitsPanel limPanel;
	
	
	TrainGUI(TrainModel theModelP) throws IOException{
		super("Albion Train Model Gui v1.0");
		theModel=theModelP;
		theModel.crewTotal=2;
		theModel.MassUpdate();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		topPane = new JPanel();
		topPane.setLayout(new GridLayout(1,3));
		buttonPane = new JPanel();
		
		
		mainContainer = this.getContentPane();
		mainPane = new JPanel();
		mainContainer.add(mainPane);
		mainPane.setLayout(new BorderLayout());
		
		attPanel = new AttributesPanel(theModel);
		miscPanel = new MiscPanel(theModel);
		failPanel = new FailPanel(theModel);
		otherPanel= new OtherPanel(theModel);
		commPanel = new CommandsPanel(theModel);
		limPanel = new LimitsPanel(theModel);
		
		attPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		miscPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		failPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		otherPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		commPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		limPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		topPane.add(limPanel);
		topPane.add(commPanel);
		topPane.add(miscPanel);
		
		
		
		buttonPane.setLayout(new GridLayout(2,0));
		
		simBrakeFail = new JButton("Sim Brake Failure");
		simBrakeFail.addActionListener(this);
		
		simEngineFail = new JButton("Sim Engine Failure");
		simEngineFail.addActionListener(this);
		
		simSignalFail = new JButton("Sim Signal Failure");
		simSignalFail.addActionListener(this);
		
		simEBrake = new JButton("Throw Emergency Brake");
		simEBrake.addActionListener(this);
		
		setPointText = new JTextField(5);
		
		setPointButton = new JButton("Set Point Speed (input to right)");
		setPointButton.addActionListener(this);
		
		closeButton = new JButton("Close Doors");
		closeButton.addActionListener(this);
		
		openButton = new JButton("Open Doors");
		openButton.addActionListener(this);
		
		stopButton = new JButton("Simulate Passengers");
		stopButton.addActionListener(this);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		
		moveButton = new JButton("Move");
		moveButton.addActionListener(this);
		
		buttonPane.add(stopButton);
		buttonPane.add(moveButton);
		buttonPane.add(setPointButton);
		buttonPane.add(setPointText);
		buttonPane.add(openButton);
		buttonPane.add(closeButton);
		
		buttonPane.add(simBrakeFail);
		buttonPane.add(simSignalFail);
		buttonPane.add(simEngineFail);
		buttonPane.add(simEBrake);
		buttonPane.add(exitButton);
		
		mainPane.add(buttonPane,BorderLayout.SOUTH);
		mainPane.add(topPane,BorderLayout.NORTH);
		mainPane.add(failPanel,BorderLayout.CENTER);
		mainPane.add(otherPanel,BorderLayout.EAST);
		mainPane.add(attPanel,BorderLayout.WEST);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		
				if(event.getSource().equals(openButton)){
				theModel.openDoors();
				miscPanel.update(theModel);
				}
				else if(event.getSource().equals(closeButton)){
					theModel.closeDoors();
					miscPanel.update(theModel);
				}
				else if(event.getSource().equals(stopButton)){
					theModel.SimulateStop();
					attPanel.update(theModel);
				}
				else if(event.getSource().equals(exitButton)){
					System.exit(0);
				}
				else if(event.getSource().equals(moveButton)){
					theModel.move();
					attPanel.update(theModel);
				}
				else if(event.getSource().equals(setPointButton)){
					tempString=setPointText.getText();
					tempDouble = Double.parseDouble(tempString);
					theModel.SetPointSpeed(tempDouble);
					attPanel.update(theModel);
				}
				else if(event.getSource().equals(simBrakeFail)){
					theModel.detector.brakesWorking=false;
					theModel.FailCheck();
					failPanel.update(theModel);
					attPanel.update(theModel);
					
				}
				else if(event.getSource().equals(simEngineFail)){
					theModel.detector.engineWorking=false;
					theModel.FailCheck();
					failPanel.update(theModel);
					attPanel.update(theModel);
					
				}
				else if(event.getSource().equals(simSignalFail)){
					theModel.detector.signalsWorking=false;
					theModel.FailCheck();
					failPanel.update(theModel);
					attPanel.update(theModel);
					
				}
				else if(event.getSource().equals(simEBrake)){
					theModel.detector.eBrakeThrown=true;
					theModel.FailCheck();
					failPanel.update(theModel);
					attPanel.update(theModel);
					
				}
		
		
		
	}
	
	
}
