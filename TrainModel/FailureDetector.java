package TrainModel;

public class FailureDetector {
	public boolean engineWorking, brakesWorking, signalsWorking;
	public boolean eBreakThrown;
	
	
	FailureDetector(){
		engineWorking=brakesWorking=signalsWorking=true;
		eBreakThrown=false;
	}
	
	public boolean CheckEngine(){
		
		return engineWorking;
	}
	
	public boolean CheckBrakes(){
		
		return brakesWorking;
	}
	
	public boolean CheckSignals(){
		
		return signalsWorking;
	}	
	
	
	public void HandleEngineFailure(){
		
		
	}
	
}
