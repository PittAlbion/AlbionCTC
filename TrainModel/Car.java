package TrainModel;

public class Car {
		public int carID;
		public double nPassengers, nCrew;
	
	
	Car(){
	carID=-1;	
	nPassengers=nCrew=0;
	}
	
	public void SetID(int IDP){
		carID=IDP;	
	}
	
	public void PassengerChange(double changeP){
		nPassengers+=changeP;
		
	}
	
	public double GetPassengers(){
		return nPassengers;		
	}
	
	public double GetCrew(){
		return nCrew;		
	}
	
	public int GetID(){
		return carID;
	}
	
}
