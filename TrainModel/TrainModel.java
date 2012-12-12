//Albion Train Control System Train Model Module
//Shane Lester, STL24@pitt.edu, maddacheeb5@gmail.com
//Initial construction 11/27/2012

//bug- speed going below 0, added a check
//bug- power going over accepted level for engine- added checks

package TrainModel;

import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.math.*;

@SuppressWarnings("serial")

public class TrainModel implements Runnable {
	public int trainID;
	
	public Car[] cars;
	public int nCars,blockID;
	
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
		theModel.currPower=theModel.maxPower;
		theModel.SetLimits(19,.5,-1.2);
		
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
		DT=.5;
		blockID=-1;
		
		speedLimit=19.44444;  //70km/hr to m/s
		for(int i=0;i<nCars;i++){
			cars[i]= new Car();
			cars[i].SetID(i);
		}
		MassUpdate();
		
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
	
	public double SetPointSpeed(double set){
		double uk,ek,ekl,toPower,totalMoved;
		uk=ek=ekl=toPower=totalMoved=0;
		if(set<=speedLimit){
			

			while(currSpeed<set){
				
				if(toPower<maxPower){
				ek=set-currSpeed;
				uk+=DT/2*(ek+ekl);
				ekl=ek;
				toPower=(1000*ek)+(1000*uk);
				if(toPower<maxPower)GivePower(toPower);
				else GivePower(120000);
				//System.out.println(toPower);
				}
				
				totalMoved+= move();	
			}
			
			while(currSpeed>set){
				
				ek=currSpeed-set;
				uk+=DT/2*(ek+ekl);
				ekl=ek;
				toPower=-((1000*ek)+(1000*uk));
				GivePower(toPower);
				
				//System.out.println(toPower);
				
				totalMoved+=move();	
			
		}

			if(currSpeed<0) currSpeed=0;
		}
		return totalMoved;
	}
	
	// moves it by one timestep
	// also must take into account our authority.
	public double move(){
		double force, metersMoved,angle;
		force=0;
		
	
		//1-get power  (already have this)
		//2- divide power by current velocity to get force
		if(currSpeed!=0.0) force=currPower/currSpeed;
		else force= 240000;  //give it an initial force, so it doesn't divide by 0, this would be the force at .5 m/s at 120 KW (full engine power)
			
		if(currGrade != 0.0){
			// need to have currgrade be an angle, not a %
			angle=Math.atan(currGrade/100.0);
			force+= massTotal*9.8*  Math.sin((Math.PI/180)*angle);
		}
		//3- divide force by current mass to get acc
		currAcc=force/massTotal;
		
		if(currAcc>accLimit)currAcc=accLimit;
		if(currAcc<decLimit)currAcc=decLimit;
		if(currSpeed>speedLimit)currSpeed=speedLimit;
		// integrate down to new position with DT
		
		currSpeed+=currAcc*DT;
		
		
		metersMoved = currSpeed*DT;
		//System.out.println("Meters moved:"+metersMoved);
		//this might want to be elsewhere
		currTime+=DT;
		
		return metersMoved;
		
		
	}
	
	// moves with no change to acceleration
	public double keepMoving(){
		double force, metersMoved,angle,accFromGrade;
		force=accFromGrade=0;
		
		// integrate down to new position with DT
		
		if(currGrade != 0.0){
			// need to have currgrade be an angle, not a %
			angle=Math.atan(currGrade/100.0);
			force+= massTotal*9.8*  Math.sin((Math.PI/180)*angle);
		}
		
		accFromGrade+=force/massTotal;
		currSpeed+=accFromGrade*DT;
		
		if(currSpeed>speedLimit)currSpeed=speedLimit;
		
		metersMoved = currSpeed*DT;
		//System.out.println("Meters moved:"+metersMoved);
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
	public void FailCheck(){
		if(!detector.CheckBrakes())  HandleBrakeFailure();
		if(!detector.CheckEngine())  HandleEngineFailure();
		if(!detector.CheckSignals()) HandleSignalFailure();
		if(detector.eBrakeThrown()) HandleEBrake();
	}
	
	public void HandleBrakeFailure(){
		SetPointSpeed(0.0);
	}
	
	public void HandleEngineFailure(){
		SetPointSpeed(0.0);
	}
	
	public void HandleSignalFailure(){
		SetPointSpeed(0.0);
	}
	
	public void HandleEBrake(){
		SetLimits(speedLimit,accLimit,-2.73);
		SetPointSpeed(0.0);
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
	
	massTotal=37103.86*nCars;
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
