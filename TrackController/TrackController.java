//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import TrackModel.*;
import TrainController.*;
import TrainModel.*;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable {
	
		public static ArrayList<trackBlock> greenList = new ArrayList<trackBlock>();
		public static ArrayList<trackBlock> redList = new ArrayList<trackBlock>();
		public static ArrayList<TrainModel> trainList = new ArrayList<TrainModel>();
		public static ArrayList<TrackController> controlList = new ArrayList<TrackController>();
		public static trackModel tm = new trackModel();
		public static TrainController tc;
		public static TrackController tr;
		static GUI myGUI;
		
		public int id = 0;
		public int type;
		private int count = 0;
		public double speedLimit;
		public double trackTemp;
		public double thermostatTemp;
		public boolean direction;
		public boolean heater;
		public boolean occupied;
		public int state;
		
		public static void main(String [] args) throws InterruptedException, IOException{
			
			
			myGUI = new GUI(); 
			tr = new TrackController();
			//myGUI.setState(0);
		//	myGUI.setOccupancy(false);
	//		myGUI.setTrackTemp(25);
//			myGUI.setThermostat(15);
			//myGUI.setDirection(true);
			//myGUI.setSpeedLimit(55);
			//myGUI.setHeater(false);
			//trainList = tc.GetTrainList();
			
			//System.out.println(greenList.size());
			//myGUI.statisticPanel.changeGeneralData(1, 1, greenList.get(0).block_number);
				
		}
		
		public TrackController() throws IOException
		{
			TrackController t;
			greenList = new ArrayList<trackBlock>(trackModel.buildGreenList("help"));
			redList = new ArrayList<trackBlock>(trackModel.buildRedList("help"));
			
			for (int i = 0; i < greenList.size(); i++){
				if (greenList.get(i).infrastructure.contains("SWITCH")){
					t = new TrackController(count, 0);
					controlList.add(t);
					myGUI.addToList("Green Line Switch " + Integer.toString(controlList.get(count).id));
					count++;
				}
				else if (greenList.get(i).infrastructure.equals("RAILWAY CROSSING")){
					t = new TrackController(count, 1);
					controlList.add(t);
					myGUI.addToList("Green Line Crossing " + Integer.toString(controlList.get(count).id));
					count++;
				}
			}
			
			for (int i = 0; i < redList.size(); i++){
				if (redList.get(i).infrastructure.contains("SWITCH")){
					t = new TrackController(count, 0);
					controlList.add(t);
					myGUI.addToList("Red Line Switch " + Integer.toString(controlList.get(count).id));
					count++;
				}
				else if (redList.get(i).infrastructure.equals("RAILWAY CROSSING")){
					t = new TrackController(count, 1);
					controlList.add(t);
					myGUI.addToList("Red Line Crossing " + Integer.toString(controlList.get(count).id));
					count++;
				}
			}
			
			//tc = new TrainController();
			tm = new trackModel();
			
			//Debug purposes
			//System.out.println("Green Track List Length: " + greenList.size());
			//System.out.println("Red Track List Length: " + redList.size());
			
		}
		
		public TrackController(int id, int type){
			
			this.id = id;
			this.type = type;
			this.state = 0;
			this.occupied = true;
			this.heater = true;
			this.direction = true;
			this.trackTemp = 55;
			this.thermostatTemp = 15;
			this.speedLimit = 55;
			
		}
		
		public void run(){
			while(true){
				
			}
		}
		
		public void GetSuggestion(Object [] s){

	        int i;
			String [] parsedString = new String[2];
	        String suggestionDest = s[0].toString();
	        String selector = s[1].toString();
			
			parsedString = selector.split(" ");
			String line = parsedString[0];
			int block = Integer.parseInt(parsedString[1]);
			
	        for (i=2; i<(s.length - 1); i++){
	            if (suggestionDest.equals("Train")){ //Train Controller Suggestion
	                TrainController.SendCommand(block, s[i].toString(), Double.parseDouble(s[i+1].toString()));   // PassSuggestion. Some code to send the suggestion to the Train Controller
	            }else if (suggestionDest.equals("Track")){ //Track Controller Suggestion
	                useSuggestion(line, block, s[i].toString(), s[i+1].toString());
	            }
	            else    // Invalid Suggestion Destination, do nothing.
	                return;
	        }
			
	    }

		
		
	    private void useSuggestion(String lineSelect, int trackSelect, String type, String value){
		
	    		trackBlock t = null;
	    		boolean safe = true;
	    		
	    		if (lineSelect.equals("Green")){
	    			t = greenList.get(trackSelect);
	    		}
	    		else if (lineSelect.equals("Red")){
	    			t = redList.get(trackSelect);
	    		}
	    		else { ; }
	    		
	            if (type.equals("Authority")){
	                //safe = checkStatus(); //Do something safe involving the authority suggestion
	                if(safe){ //change Authority
	                	//
	                }
	            }
	            else if(type.equals("Speed")){
	                //safe = checkStatus(); //Do something safe involving the speed suggestion
	                if (safe){ //change speed
	                	t.speed_limit = Integer.parseInt(value);
	                }
	            }
	            else{;}//Invalid suggestion
					
	    }
	    

		public boolean activateCrossing(String lineSelect, int trackSelect){
	    	boolean near = tc.IsNearCrossing(0);
	    	trackBlock t;
	    	if (lineSelect.equals("Green")){
	    		if (near){
	    		
	    			t = greenList.get(trackSelect);
	    			if (t.infrastructure.equals("CROSSING")){
	    				
						//trackModel.trackCrossingList.get(0).active = true;
						//trackModel.trackCrossingList.get(0).lights = true;
	    				//t.activateCrossing();
	    				
	    			}
	    		}
	    		return true;
	    	}
	    	else if (lineSelect.equals("Red")){
	    		if (near){
	    		
    			t = greenList.get(trackSelect);
    			if (t.infrastructure.equals("CROSSING")){
    				
    				//t.activateCrossing();
    				
    			}
    		}
    			return true;
	    	}
	    	else{
	    		System.out.println("Invalid Track Line");
	    		return false;
	    	}
	    }
	    
	    @SuppressWarnings("unused")
		private boolean deactivateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is activated:
	    	//Check to make sure all trains are out of the area and that
	    	//it is safe to deactivate the crossing
	    	//Deactivate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    @SuppressWarnings("unused")
		private boolean switchTrackSegment(String lineSelect, int trackSegment, int position){
	    	//Determine if the switch can safely be activated
	    	//Based on the arguments given, switch the track segment into the appropriate position.
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean trainDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for trains
	    	//currently present on the system. If the circuit is broken (i.e. a train is present)
	    	//the function shall return true, otherwise false.
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean brokenRailDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for rails that
	    	//are currently broken. If the circuit is non functional, the function shall return true,
	    	//otherwise false;
	    	return false;
	    }
	    
	    @SuppressWarnings("unused")
		private boolean checkStatus(){
	    	
	    	return false;
	    }
	    
	    public void addTrain(char p_trackLine, int p_trainID, int p_cars ){
	    	
	    	//tc.CreateNewTrain(p_trackLine, p_trainID, p_cars);
	    	
	    }
	    
	    public ArrayList<TrainModel> getTrainList(){
	    	
	    	return trainList;
	    	
	    }
}
