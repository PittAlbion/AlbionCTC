package TrainController;

import TrainModel.*;

public class IndividualController {
	
	private static char trackLine;
	private static int trainID;
	private static TrainModel train;
	private TrainController controller;
	private boolean suggestionReceived = false;
	private double pendingSuggestion;
	private double traveled;
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
		pendingSuggestion = p_speed;
	}
	
	public int FindTime(double p_distance){
		double traveled = 0.0;
		int passed = 0;
		
		while (traveled < p_distance){
			traveled+=train.keepMovingNoDT();
			if (traveled < p_distance){
				passed++;
			}
		}
		return passed;
	}
	
	public void MoveTrain(){
		while (true){
			if (suggestionReceived){
				double initialTime = train.currTime;
				traveled += train.SetPointSpeed(pendingSuggestion);
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
		}
	}

}
