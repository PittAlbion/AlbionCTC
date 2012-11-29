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
	public double DT;
	public double currGrade, currAuthority, currSpeed, currAcc, currPower;
	
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
		
		maxPass=222;
		trainID=trainIDP;
		nCars=carsP;
		lengthOfCar=32.2;
		lengthTotal= lengthOfCar*nCars;
		width=2.65;
		height=3.42;
		
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


	
	public void SetPointSpeed(double set){
		// takes input that sets certain speed I suppose
		currSpeed=set;
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
	
    // potentially unnecessary
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
