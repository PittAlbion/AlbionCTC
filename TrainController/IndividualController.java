package TrainController;

import TrainModel.*;

public class IndividualController {
	
	private static char trackLine;
	private static int trainID;
	private static TrainModel train;
	private TrainController controller;
	private boolean suggestionReceived = false, powerReceived = false, emergencyStopping = false;
	private double pendingSuggestion, pendingPower, speedGoal;
	private double traveled=0.0;
	private int index;
	
	public IndividualController(TrainController p_controller, char p_trackLine, int p_trainID, TrainModel p_train, int p_index){
		trackLine = p_trackLine;
		trainID = p_trainID;
		train = p_train;
		controller = p_controller;
		index = p_index;
	}
	
	public int RunTrain(double p_distance){
		double testTravel = 0.0;
		double traveled2 = 0.0;
		int passed = 0;
		
		while (traveled2 < p_distance){
			testTravel += train.keepMovingNoDT();
			if (testTravel < p_distance){
				traveled2 += train.keepMoving();
				passed++;
			}
		}
		return passed;
	}
	
	public void SendSpeed(double p_speed){
		suggestionReceived = true;
		if (p_speed <= train.speedLimit){
			pendingSuggestion = speedGoal = p_speed;
		}
		else{
			pendingSuggestion = speedGoal = train.speedLimit;
		}
		if (emergencyStopping){
			emergencyStopping = false;
		}
	}
	
	public void SendPower(double p_power){
		powerReceived = true;
		pendingPower = p_power;
		if (emergencyStopping){
			emergencyStopping = false;
		}
	}
	
	public void StopPower(){
		pendingPower = 0;
		powerReceived = false;
		train.currPower = 0.0;
	}
	
	public void EmergencyStop(){
		emergencyStopping = true;
	}
	
	public double GetDistance(){
		return traveled;
	}
	
	public int FindTime(double p_distance){
		double traveled2 = 0.0;
		int passed = 0;
		
		while (traveled2 < p_distance){
			traveled2+=train.keepMovingNoDT();
			if (traveled2 < p_distance){
				passed++;
			}
		}
		return passed;
	}
	
	public void MoveTrain() throws InterruptedException{
		while (true){
			if (emergencyStopping){
				train.HandleEBrake();
			}
			else if (suggestionReceived){
				double initialTime = train.currTime;
				train.GivePower(train.maxPower);
				traveled += train.move();
				controller.timeArray[index] += train.currTime - initialTime;
				if (train.currSpeed == speedGoal){
					suggestionReceived = false;
				}
			}
			else if (powerReceived){
				double initialTime = train.currTime;
				train.GivePower(pendingPower);
				traveled += train.move();
				controller.timeArray[index] += train.currTime - initialTime;
			}
			else{
				traveled += train.keepMoving();
				controller.timeArray[index] += 0.5;
			}
			double maxTime=0;
			for (int i = 0; i < controller.trainCount; i++){
				if (maxTime < controller.timeArray[i]){
					maxTime = controller.timeArray[i];
				}
			}
			if (controller.timeArray[index] < maxTime){
				while (controller.timeArray[index] < maxTime){
					traveled += train.keepMoving();
					controller.timeArray[index] += 0.5;
				}
			}
			Thread.sleep(250);
			controller.nonLogPanel.infoPanel.UpdateTrainInfo();
		}
	}

}
