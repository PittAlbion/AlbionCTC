//Albion Train Control System Train Model Module
//Shane Lester, STL24@pitt.edu, maddacheeb5@gmail.com
//Initial construction 11/27/2012

package trainModel;

public class TrainModel implements Runnable {
	private int trainID;
	
	private Car[] cars;
	private int nCars;
	
	private FailureDetector detector;
	
	private double kgPerPerson,kgPerSquareMeter;
	private double passengerTotal, crewTotal;
	private boolean doorsClosed;
	private double temperature, massTotal, lengthTotal,lengthOfCar,width,height, trackGrade;
	private double speedLimit, accLimit, decLimit;
	private double DT;
	private double currGrade, currAuthority, currSpeed, currAcc, currPower;
	
	//transponder input, track circuit input, routeinfo system,  
	
	public static void main(String[] args) {
		//this will be done by track controller, 
		//potentially add some kind of tag telling which train controller is controlling it?
		TrainModel theModel = new TrainModel(1, 3, 30, 10, 12);
		//here should set the connection and get all the inputs that are needed
		
	}

	
	TrainModel(int trainIDP, int carsP, double lengthCar,double heightP, double widthP){
		InitialVars();
			
		detector = new FailureDetector();
		cars = new Car[carsP];
		
		trainID=trainIDP;
		nCars=carsP;
		lengthOfCar=lengthCar;
		lengthTotal= lengthOfCar*nCars;
		width=widthP;
		height=heightP;
		
		for(int i=0;i<nCars;i++){
			cars[i]= new Car();
			cars[i].SetID(i);
		}
		
	}
	
	public void setLimits(double speedLimP, double accLimP, double decLimP){
		speedLimit=speedLimP;
		accLimit=accLimP;
		decLimit=decLimP;	
	}
	
	// not sure if I should just set it, or increment power.  
	//Probably just set power, increment speed acc dec etc.
	public void givePower(double powerP){
		currPower=powerP;		
	}
	
	public void setAuthority(double authP){
		currAuthority=authP;
	}


	
	public void SetPointSpeed(){
		// takes input that sets certain speed I suppose
		
	}
	
	public void BrakeCommand(){
		//puts on da brakes within the dec limit
		
	}
	
	public void openDoors(){
		doorsClosed=false;
	}
	
	public void closeDoors(){
		doorsClosed=true;		
	}

	public void tempControl(double tempP){
		temperature=tempP;		
	}
	
	//check them, if any come back false call the handle method
	public void failCheck(){
		if(!detector.CheckBrakes())  HandleBrakeFailure();
		if(!detector.CheckEngine())  HandleEngineFailure();
		if(!detector.CheckSignals()) HandleSignalFailure();
	}
	
	public void HandleBrakeFailure(){
		
	}
	
	public void HandleEngineFailure(){
		
	}
	
	public void HandleSignalFailure(){
		
	}
	
	public void UpdatePassengerData(){
		if(nCars==0)System.out.println("Must have a car before you try to update the train's data from cars");
	
		passengerTotal=crewTotal=0;
		for(int i=0;i<nCars;i++){
			passengerTotal+= cars[i].GetPassengers();
			crewTotal+= cars[i].GetCrew();
		}
	}
	
	public void SimulateStop(){
		//random number gen to decide how many get off / on each car
		//without going over max, then calc new mass and such.
		
		
	}
	
	public void MassUpdate(){
	UpdatePassengerData();
	
	massTotal=0;
	// also should add the total mass of the train
	massTotal= ((passengerTotal+crewTotal)*kgPerPerson);
		
		
	}
	
	public void InitialVars(){
		// explicitly initializing as 0;
	kgPerSquareMeter=1000; //kilograms per square meter of length/width
	kgPerPerson=200; //kilograms per person on the train
	nCars=0;
	passengerTotal=temperature=massTotal=lengthTotal=width=height=trackGrade=
	speedLimit=accLimit=decLimit=currGrade=currAuthority=currSpeed=currAcc
	=currPower=trainID=0;
	doorsClosed=true;
	}
	
	// Because otherwise implementing runnable gets mad
	public void run(){
	}
	
	
}
