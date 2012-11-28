package trainModel;

public class FailureDetector {
	private boolean engineWorking, brakesWorking, signalsWorking;
	private boolean eBreakThrown;
	
	
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
