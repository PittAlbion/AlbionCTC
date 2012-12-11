//Albion Train Control System Train Model Module
//Shane Lester, STL24@pitt.edu, maddacheeb5@gmail.com
//Initial construction 11/27/2012

package TrainModel;

import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.math.*;

@SuppressWarnings("serial")

public class TrainModel implements Runnable {
	public int trainID;
	
	public Car[] cars;
	public int nCars;
	
	public FailureDetector detector;
	
	public Random randomGen;
	public char trackLine;
	public double maxPass;
	public double kgPerPerson,kgPerSquareMeter;
	public double passengerTotal, crewTotal;
	public boolean doorsClosed, lightsOn;
	public double temperature, massTotal, lengthTotal,lengthOfCar,width,height, trackGrade;
	public double speedLimit, accLimit, decLimit;
	public double DT,currTime;
	public double currGrade, currAuthority, currSpeed, currAcc, currPower;
	public double maxPower, brakePower;
	
	//transponder input, track circuit input, routeinfo system,  
	
	public static void main(String[] args) throws IOException{

		TrainModel theModel = new TrainModel('r',1, 1);
		//System.out.println("");
		
//System.nanoTime()
		new TrainGUI(theModel);


	}


	public TrainModel(char trackLineP ,int trainIDP, int carsP){
		
		InitialVars();
		
		randomGen = new Random(System.nanoTime());
		detector = new FailureDetector();
		cars = new Car[carsP];
		trackLine=trackLineP;
		
		//serviceBrake=1.2 m/s^2
		//emergencyBrake=2.73 m/s^2
		maxPower=120000; //120 KW
		brakePower=6*81000;  // spec said 6*81 Kn
		maxPass=222;
		trainID=trainIDP;
		nCars=carsP;
		lengthOfCar=32.2;
		lengthTotal= lengthOfCar*nCars;
		width=2.65;
		height=3.42;
		currTime=0;
		
		speedLimit=19.44444;  //70km/hr to m/s
		for(int i=0;i<nCars;i++){
			cars[i]= new Car();
			cars[i].SetID(i);
		}
		
	}
	
	public void SetLimits(double speedLimP, double accLimP, double decLimP){
		speedLimit=speedLimP;
		accLimit=accLimP;
		decLimit=decLimP;	
	}
	
	// not sure if I should just set it, or increment power.  
	//Probably just set power, increment speed acc dec etc.
	public void GivePower(double powerP){
		currPower=powerP;		
	}
	
	public void SetAuthority(double authP){
		currAuthority=authP;
	}

	//f for incline is m*g*sin(theta)
	
	public void SetPointSpeed(double set){
		
			if(currPower<maxPower){
				// use equation on slides
				//keep going up until its at the one we want.
				// maybe a while loop, and using the move method below
				// to increment the speed up until its at the right place.
				
				
			}
		
	}
	
	// moves it by one timestep
	// also must take into account our authority.
	public double move(){
		double Force, metersMoved;
		
		//1-get power  (already have this)
		//2- divide power by current velocity to get force
		Force=currPower/currSpeed;
		
		if(currGrade!=0.0){
			// need to have currgrade be an angle, not a %
			Force+= massTotal*9.8*  Math.sin((Math.PI/180)*currGrade);
			
		}
		//3- divide force by current mass to get acc
		currAcc=Force/massTotal;
		
		// integrate down to new position with DT
		currSpeed=currAcc*DT;
		
		metersMoved = currSpeed*DT;
		
		//this might want to be elsewhere
		currTime+=DT;
		
		return metersMoved;
		
		
	}
	
	// he claims we can also give the train negative power, so that seems to be more of what this is.
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
	
    // potentially unnecessary. unused by me at the moment
	public void UpdatePassengerData(){
		if(nCars==0)System.out.println("Must have a car before you try to update the train's data from cars");
	
		passengerTotal=crewTotal=0;
		for(int i=0;i<nCars;i++){
			passengerTotal+= cars[i].GetPassengers();
			crewTotal+= cars[i].GetCrew();
			
		}
	}
	
	public void SimulateStop(){
		//random number generator to decide how many get off / on each car
		//without going over max, then calculate new mass and such.
		
		System.out.println("Total before: " + passengerTotal);
		// passengers getting off
		if(passengerTotal!=0.0){
		passengerTotal-= Math.ceil(Math.abs(randomGen.nextInt())%passengerTotal);
		}
		System.out.println("Total after dec: " + passengerTotal);
		
		
		//passengers getting on
		passengerTotal+= Math.ceil(Math.abs(randomGen.nextInt())%(maxPass-passengerTotal));
		System.out.println("Total after: " + passengerTotal);
		MassUpdate();
		
	}
	
	public void MassUpdate(){
	//UpdatePassengerData();
	
	massTotal=37103.86;
	// also should add the total mass of the train
	massTotal+= ((passengerTotal+crewTotal)*kgPerPerson);
		
	}
	
	public void InitialVars(){
	// explicitly initializing as 0;
	lightsOn=true;
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
