package TrainModel;

public class FailureDetector {
	public boolean engineWorking, brakesWorking, signalsWorking;
	public boolean eBrakeThrown;
	
	
	FailureDetector(){
		engineWorking=brakesWorking=signalsWorking=true;
		eBrakeThrown=false;
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
	
	public boolean eBrakeThrown(){
		return eBrakeThrown;
		
	}
	
}
