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
	private double tempDouble,tempDoubleB,totalMove;
	private String tempString;
	private JPanel mainPane, buttonPane, topPane, centerPane;
	private Container mainContainer;
	private JButton setPointButton, powerMoveButton, toggleDoorsButton, stopButton, exitButton, moveButton;
	private JButton simBrakeFail, simEngineFail, simSignalFail, simEBrake;
	private JTextField setPointText, powerText;
	private LogPanel logPanel;
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
		totalMove=0;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		topPane = new JPanel();
		topPane.setLayout(new GridLayout(1,3));
		
		centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(1,2));
		
		buttonPane = new JPanel();
		
		
		mainContainer = this.getContentPane();
		mainPane = new JPanel();
		mainContainer.add(mainPane);
		mainPane.setLayout(new BorderLayout());
		
		logPanel = new LogPanel(theModel);
		attPanel = new AttributesPanel(theModel);
		miscPanel = new MiscPanel(theModel);
		failPanel = new FailPanel(theModel);
		otherPanel= new OtherPanel(theModel);
		commPanel = new CommandsPanel(theModel);
		limPanel = new LimitsPanel(theModel);
		
		logPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		attPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		miscPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		failPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		otherPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		commPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		limPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		topPane.add(limPanel);
		topPane.add(commPanel);
		topPane.add(miscPanel);
		
		centerPane.add(failPanel);
		centerPane.add(logPanel);
		
		buttonPane.setLayout(new GridLayout(2,0));
		
		powerMoveButton = new JButton("Give Power (kW)");
		powerMoveButton.addActionListener(this);
		
		simBrakeFail = new JButton("Sim Brake Failure");
		simBrakeFail.addActionListener(this);
		
		simEngineFail = new JButton("Sim Engine Failure");
		simEngineFail.addActionListener(this);
		
		simSignalFail = new JButton("Sim Signal Failure");
		simSignalFail.addActionListener(this);
		
		simEBrake = new JButton("Throw Emergency Brake");
		simEBrake.addActionListener(this);
		
		setPointText = new JTextField(5);
		powerText = new JTextField(5);
		
		setPointButton = new JButton("Set Point Speed (input to right)");
		setPointButton.addActionListener(this);
		
		toggleDoorsButton = new JButton("Toggle doors");
		toggleDoorsButton.addActionListener(this);
		
		
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
		buttonPane.add(powerMoveButton);
		buttonPane.add(powerText);
		buttonPane.add(toggleDoorsButton);
		
		buttonPane.add(simBrakeFail);
		buttonPane.add(simSignalFail);
		buttonPane.add(simEngineFail);
		buttonPane.add(simEBrake);
		buttonPane.add(exitButton);
		
		mainPane.add(buttonPane,BorderLayout.SOUTH);
		mainPane.add(topPane,BorderLayout.NORTH);
		mainPane.add(centerPane,BorderLayout.CENTER);
	//	mainPane.add(otherPanel,BorderLayout.EAST);
		mainPane.add(attPanel,BorderLayout.WEST);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		
				if(event.getSource().equals(toggleDoorsButton)){
				if(theModel.doorsClosed) theModel.openDoors();
				else theModel.closeDoors();
				
				miscPanel.update(theModel);
				}
				else if(event.getSource().equals(stopButton)){
					theModel.SimulateStop();
					attPanel.update(theModel);
				}
				else if(event.getSource().equals(exitButton)){
					System.exit(0);
				}
				else if(event.getSource().equals(powerMoveButton)){
					tempString = powerText.getText();
					tempDouble = 1000*(Double.parseDouble(tempString));
					
					tempDoubleB = theModel.currTime;
					
					if(tempDouble<=theModel.maxPower){
					
					theModel.GivePower(tempDouble);
					tempDouble = theModel.move();
					totalMove += tempDouble;
					tempString = Double.toString(tempDouble);
					logPanel.WriteMessage("In "+(theModel.currTime-tempDoubleB)+ " seconds, train moved total of "+ tempString+" meters\n");
					
					attPanel.update(theModel);
					commPanel.update(totalMove);
					}
					
				}
				else if(event.getSource().equals(moveButton)){
					tempDoubleB = theModel.currTime;
					
					tempDouble = theModel.keepMoving();
					totalMove +=tempDouble;
					tempString = Double.toString(tempDouble);
					
					logPanel.WriteMessage("In "+(theModel.currTime-tempDoubleB)+ " seconds, train moved total of "+ tempString+" meters\n");
					
					attPanel.update(theModel);
					commPanel.update(totalMove);
				}
				else if(event.getSource().equals(setPointButton)){
					tempString=setPointText.getText();
					
					tempDoubleB = theModel.currTime;
					tempDouble = Double.parseDouble(tempString);
					tempDouble=theModel.SetPointSpeed(tempDouble);
					totalMove+=tempDouble;
					tempString = Double.toString(tempDouble);

					logPanel.WriteMessage("In "+(theModel.currTime-tempDoubleB)+ " seconds, train moved total of "+ tempString+" meters\n");
					attPanel.update(theModel);
					commPanel.update(totalMove);
				}
				else if(event.getSource().equals(simBrakeFail)){
					theModel.detector.brakesWorking=false;
					tempDoubleB = theModel.currTime;
					
					theModel.SetLimits(theModel.speedLimit,theModel.accLimit,-2.73);
					tempDouble=theModel.SetPointSpeed(0.0);
					totalMove+=tempDouble;
					
					logPanel.WriteMessage("It took "+(theModel.currTime-tempDoubleB)+" seconds and "+ tempDouble+ "meters  to stop\n");
					failPanel.update(theModel);
					attPanel.update(theModel);
					commPanel.update(totalMove);
					
				}
				else if(event.getSource().equals(simEngineFail)){
					theModel.detector.engineWorking=false;
					tempDoubleB = theModel.currTime;
					
					tempDouble=theModel.SetPointSpeed(0.0);
					totalMove+=tempDouble;
					
					logPanel.WriteMessage("It took "+(theModel.currTime-tempDoubleB)+" seconds and "+ tempDouble+ "meters  to stop\n");
					failPanel.update(theModel);
					attPanel.update(theModel);
					commPanel.update(totalMove);
					
				}
				else if(event.getSource().equals(simSignalFail)){
					theModel.detector.signalsWorking=false;
					tempDoubleB = theModel.currTime;
					
					tempDouble=theModel.SetPointSpeed(0.0);
					totalMove+=tempDouble;
					
					logPanel.WriteMessage("It took "+(theModel.currTime-tempDoubleB)+" seconds and "+ tempDouble+ "meters  to stop\n");
					failPanel.update(theModel);
					attPanel.update(theModel);
					commPanel.update(totalMove);
					
				}
				else if(event.getSource().equals(simEBrake)){
					theModel.detector.eBrakeThrown=true;
					tempDoubleB = theModel.currTime;
					
					theModel.SetLimits(theModel.speedLimit,theModel.accLimit,-2.73);
					tempDouble=theModel.SetPointSpeed(0.0);
					totalMove+=tempDouble;
					
					logPanel.WriteMessage("It took "+(theModel.currTime-tempDoubleB)+" seconds and "+ tempDouble+ "meters  to stop with the emergency brake\n");
					failPanel.update(theModel);
					attPanel.update(theModel);
					commPanel.update(totalMove);
				}
		
		
		
	}
	
	
}
