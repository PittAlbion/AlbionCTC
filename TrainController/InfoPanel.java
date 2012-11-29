package TrainController;

import java.awt.*;
import javax.swing.*;
import TrainModel.*;

@SuppressWarnings({ "serial", "static-access" })
public class InfoPanel extends JPanel{

	private JLabel speedLimit, currentSpeed, currentAuthority, distanceTraveled, doorStatus, lightStatus, nextStop;
	private TrainController controller;
	private TrainModel currentModel;
	
    InfoPanel(TrainController p_controller){
    	super();
    	this.setLayout(new GridLayout(7, 1));
    	this.setPreferredSize(new Dimension(400, 450));
    	this.controller = p_controller;
    	
    	speedLimit = new JLabel("Speed Limit: No train selected");
    	currentSpeed = new JLabel("Train Speed: No train selected");
    	currentAuthority = new JLabel("Authority: No train selected");
    	distanceTraveled = new JLabel("Distance Traveled: No train selected"); //fix
    	doorStatus = new JLabel("Doors Closed: No train selected");
    	lightStatus = new JLabel("Lights On: No train selected");// + currentModel.lightOn);
    	nextStop = new JLabel("Next Stop: No train selected"); //fix
        
    	this.add(speedLimit);
    	this.add(currentSpeed);
    	this.add(currentAuthority);
    	this.add(distanceTraveled);
    	this.add(doorStatus);
    	this.add(lightStatus);
    	this.add(nextStop);
    }
    
    void UpdateTrainInfo(){
    	currentModel = controller.trainList.get(controller.FindTrainIndex(controller.currentTrain));
    	
		speedLimit.setText("Speed Limit: " + currentModel.speedLimit);
		currentSpeed.setText("Train Speed: " + currentModel.currSpeed);
		currentAuthority.setText("Authority: " + currentModel.currAuthority);
		distanceTraveled.setText("Distance Traveled: 0 mi"); //fix
		doorStatus.setText("Doors Closed: " + currentModel.doorsClosed);
		lightStatus.setText("Lights On: True"); //fix
		nextStop.setText("Next Stop: Nowhere fucker"); //fix
    }
}