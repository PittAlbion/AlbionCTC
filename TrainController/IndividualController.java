package TrainController;

import TrainModel.*;

public class IndividualController {
	
	private static char trackLine;
	private static int trainID;
	private static TrainModel train;
	
	public IndividualController(char p_trackLine, int p_trainID, TrainModel p_train){
		trackLine = p_trackLine;
		trainID = p_trainID;
		train = p_train;
	}
	
	public int RunTrain(double p_distance){
		double traveled=0.0;
		int passed=0;
		
		while(traveled < p_distance){
			train.keepMoving();
		}
		return passed;
	}

}
