package TrainController;

import java.awt.*;
import javax.swing.*;
import TrainModel.*;

@SuppressWarnings({ "serial", "static-access" })
public class InfoPanel extends JPanel{

	private JLabel speedLimit, currentSpeed, currentAuthority, distanceTraveled, doorStatus, lightStatus, currentPower;//nextStop, 
	private TrainController controller;
	TrainModel currentModel;
	
    InfoPanel(TrainController p_controller){
    	super();
    	this.setLayout(new GridLayout(7, 1));
    	this.setPreferredSize(new Dimension(400, 450));
    	this.controller = p_controller;
    	
    	currentPower = new JLabel("Current Power: No train selected");
    	speedLimit = new JLabel("Speed Limit: No train selected");
    	currentSpeed = new JLabel("Train Speed: No train selected");
    	currentAuthority = new JLabel("Authority: No train selected");
    	distanceTraveled = new JLabel("Distance Traveled: No train selected");
    	doorStatus = new JLabel("Doors Closed: No train selected");
    	lightStatus = new JLabel("Lights On: No train selected");// + currentModel.lightOn);
    	//nextStop = new JLabel("Next Stop: No train selected"); //fix
        
    	this.add(speedLimit);
    	this.add(currentSpeed);
    	this.add(currentPower);
    	this.add(currentAuthority);
    	this.add(distanceTraveled);
    	this.add(doorStatus);
    	this.add(lightStatus);
    	//this.add(nextStop);
    }
    
    void UpdateTrainInfo(){
    	if (controller.currentTrain != -1){
    		currentModel = controller.FindTrain(controller.currentTrain);
    	
    		speedLimit.setText("Speed Limit: " + currentModel.speedLimit);
    		currentSpeed.setText("Train Speed: " + currentModel.currSpeed);
    		currentPower.setText("Current Power: " + currentModel.currPower);
    		currentAuthority.setText("Authority: " + currentModel.currAuthority);
    		distanceTraveled.setText("Distance Traveled: " + controller.FindController(controller.currentTrain).GetDistance()); //fix
    		doorStatus.setText("Doors Closed: " + currentModel.doorsClosed);
    		lightStatus.setText("Lights On: " + currentModel.lightsOn);
    		//nextStop.setText("Next Stop: Nowhere"); //fix
    	}
    }
}