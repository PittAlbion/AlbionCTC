//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import CTCOffice.CTCOffice;
import TrackModel.*;
import TrainController.*;
import TrainModel.*;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.border.Border;
/**
 * @author Calvin Souders
 */

@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable {
	
		public static ArrayList<trackBlock> greenList = new ArrayList<trackBlock>();
		public static ArrayList<trackBlock> redList = new ArrayList<trackBlock>();
		public static ArrayList<TrainModel> trainList = new ArrayList<TrainModel>();
		public static ArrayList<TrackController> controlList = new ArrayList<TrackController>();
		public static ArrayList<TrackModel.trackCrossing> crossingList = new ArrayList<TrackModel.trackCrossing>();
		public static trackModel tm = new trackModel();
		public static TrainController tc;
		public static TrackController tr;
		private CTCOffice office;
		static GUI myGUI;
		
		public int id = 0;
		public int type;
		public int line;
		private int count = 0;
		public double speedLimit;
		public double trackTemp;
		public double thermostatTemp;
		public boolean direction;
		public boolean heater;
		public boolean occupied;
		public int state;
		
		/**
		 * This is the main function that will create an instance of the GUI for the user
		 * to use in a standalone mode.
		 * @param args	The list of arguments to import from the command line.
		 * @throws InterruptedException
		 * @throws IOException
		 */
		public static void main(String [] args) throws InterruptedException, IOException{
			
			tr = new TrackController(null);
				
		}
		
		
		/**
		 * Empty constructor for whomever would like to instance the GUI can use to do so.
		 * Loads in the track lists and creates controllers based on that information.
		 * @throws IOException
		 */
		public TrackController(CTCOffice tempOffice) throws IOException
		{
			TrackController t;
			myGUI = new GUI(); 
			greenList = new ArrayList<trackBlock>(trackModel.buildGreenList("help"));
			redList = new ArrayList<trackBlock>(trackModel.buildRedList("help"));
			//crossingList = trackModel.trackCrossingList;
			for (int i = 0; i < greenList.size(); i++){
				if (greenList.get(i).infrastructure.contains("SWITCH")){
					t = new TrackController(count, 0, 0);
					controlList.add(t);
					myGUI.addToList("Green Line Switch " + Integer.toString(controlList.get(count).id));
					count++;
				}
				else if (greenList.get(i).infrastructure.equals("RAILWAY CROSSING")){
					t = new TrackController(count, 1, 0);
					controlList.add(t);
					myGUI.addToList("Green Line Crossing " + Integer.toString(controlList.get(count).id));
					count++;
				}
			}
			
			for (int i = 0; i < redList.size(); i++){
				if (redList.get(i).infrastructure.contains("SWITCH")){
					t = new TrackController(count, 0, 1);
					controlList.add(t);
					myGUI.addToList("Red Line Switch " + Integer.toString(controlList.get(count).id));
					count++;
				}
				else if (redList.get(i).infrastructure.equals("RAILWAY CROSSING")){
					t = new TrackController(count, 1, 1);
					controlList.add(t);
					myGUI.addToList("Red Line Crossing " + Integer.toString(controlList.get(count).id));
					count++;
				}
			}
			
			 //Green Switch
			 //13
			 trackBlock currentBlock1 = greenList.get(13);
			 currentBlock1.edit_swLeft(12);
			 currentBlock1.edit_swRight(1);
			 currentBlock1.edit_swCurrent(12);
			 //28
			 trackBlock currentBlock2 = greenList.get(28);
			 currentBlock2.edit_swLeft(29);
			 currentBlock2.edit_swRight(150);
			 currentBlock2.edit_swCurrent(29);
			 //57
			 trackBlock currentBlock3 = greenList.get(57);
			 currentBlock3.edit_swLeft(0);
			 currentBlock3.edit_swRight(58);
			 currentBlock3.edit_swCurrent(0);
			 //63
			 trackBlock currentBlock4 = greenList.get(63);
			 currentBlock4.edit_swLeft(62);
			 currentBlock4.edit_swRight(0);
			 currentBlock4.edit_swCurrent(62);
			 //77
			 trackBlock currentBlock5 = greenList.get(77);
			 currentBlock5.edit_swLeft(101);
			 currentBlock5.edit_swRight(76);
			 currentBlock5.edit_swCurrent(101);
			 //85
			 trackBlock currentBlock6 = greenList.get(85);
			 currentBlock6.edit_swLeft(86);
			 currentBlock6.edit_swRight(100);
			 currentBlock6.edit_swCurrent(86);
			 
			//Red Switches
			 //9
			 trackBlock currentBlock7 = redList.get(9);
			 currentBlock7.edit_swLeft(0);
			 currentBlock7.edit_swRight(10);
			 currentBlock7.edit_swCurrent(0);
			 //16
			 trackBlock currentBlock8 = redList.get(16);
			 currentBlock8.edit_swLeft(1);
			 currentBlock8.edit_swRight(15);
			 currentBlock8.edit_swCurrent(1);
			 //27
			 trackBlock currentBlock9 = redList.get(27);
			 currentBlock9.edit_swLeft(28);
			 currentBlock9.edit_swRight(76);
			 currentBlock9.edit_swCurrent(28);
			 //33
			 trackBlock currentBlock10 = redList.get(33);
			 currentBlock10.edit_swLeft(72);
			 currentBlock10.edit_swRight(32);
			 currentBlock10.edit_swCurrent(72);
			 //38
			 trackBlock currentBlock11 = redList.get(38);
			 currentBlock11.edit_swLeft(37);
			 currentBlock11.edit_swRight(71);
			 currentBlock11.edit_swCurrent(37);
			 //43
			 trackBlock currentBlock12 = redList.get(43);
			 currentBlock12.edit_swLeft(67);
			 currentBlock12.edit_swRight(42);
			 currentBlock12.edit_swCurrent(67);
			 //52
			 trackBlock currentBlock13 = redList.get(52);
			 currentBlock13.edit_swLeft(53);
			 currentBlock13.edit_swRight(64);
			 currentBlock13.edit_swCurrent(53);
			//myGUI.updateOutputPanel(tr);
			tc = new TrainController();
			tm = new trackModel();
			
			office = tempOffice;
			//Debug purposes
			//System.out.println("Green Track List Length: " + greenList.size());
			//System.out.println("Red Track List Length: " + redList.size());
			
		}
		
		/**
		 * Creates a Track Controller based on the type of infrastructure the component
		 * has.
		 * @param id	ID number of the Track Controller
		 * @param type	Type of Track Controller (Switch/Crossing)
		 * @see TrackController()
		 */
		public TrackController(int id, int type, int line){
			
			this.id = id;
			this.type = type;
			this.line = line;
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
		
		/**
		 * Function call for the CTC Office to send the Track Controller a message
		 * with suggestions. This function takes the message, parses it out and decides, based
		 * on certain arguments, where to send the suggestion.
		 * @param s		The message array encasing the suggestion(s).
		 */
		public void GetSuggestion(Object [] s){

	        int i;
	        String suggestionDest = s[0].toString();
	        String selector = s[1].toString();
			//System.out.println(selector);
			String line = selector.substring(0, 1);
			//System.out.println(line);
			int block = Integer.parseInt(selector.substring(1, selector.length()));
			
	        for (i=2; i<(s.length - 1); i+=2){
	            if (suggestionDest.equals("Train")){ //Train Controller Suggestion
	               boolean ok = TrainController.SendCommand(Integer.parseInt(selector), s[i].toString(), Double.parseDouble(s[i+1].toString()));   // PassSuggestion. Some code to send the suggestion to the Train Controller
	               if (ok)
	            	   office.trainPanel.Update(trainList);
	            }else if (suggestionDest.equals("Track")){ //Track Controller Suggestion
	                useSuggestion(line, block-1, s[i].toString(), s[i+1].toString());
	            }
	            else    // Invalid Suggestion Destination, do nothing.
	                return;
	        }
			
	    }

		/**
		 * A function that takes a Track Controller suggestion from the CTC Office and uses it according
		 * to the specifications.
		 * @param lineSelect	The track line selected (Typically 'G' or 'R')
		 * @param trackSelect	The track block selected (From the track List)
		 * @param type			The type of suggestion (Typically speed or maintenance for a track block
		 * @param value			The value of the suggestion (T/F for maintenance, Some number for speed)
		 * @see GetSuggestion()
		 */
	    private void useSuggestion(String lineSelect, int trackSelect, String type, String value){
		
	    		trackBlock t = null;
	    		boolean safe = true;
	    		//System.out.println(lineSelect);
	    		if (lineSelect.equals("G")){
	    			t = greenList.get(trackSelect);
	    		}
	    		else if (lineSelect.equals("R")){
	    			t = redList.get(trackSelect);
	    		}
	    		else { ; }
	            
	    		if(type.equals("Speed")){
	    			int val = Integer.parseInt(value);
	                //safe = checkStatus(); //Do something safe involving the speed suggestion
	                if (safe){ //change speed
	                	if (val > 0 && val <= t.maxSpeed ){
	                		System.out.println("Valid Speed Suggestion!");
	                		t.speed_limit = val;
	                	}
	                	else
	                		System.out.println("Invalid Speed Suggestion, not changing");
	                	//System.out.println("Made it here");
	                }
	            }
	    		else if (type.equals("maintenance")){
	    			if (safe){
	    				t.maintenance = Boolean.parseBoolean(value);
	    				System.out.println("Block: " + t.block_number + " Val: " + t.maintenance);
	    			}
	    		}
	            else{;}//Invalid suggestion
	    		
	    		if (lineSelect.equals("G")){
	    			if(!office.equals(null))
	    				office.greenTrackPanel.Update(greenList);
	    		}
	    		else if (lineSelect.equals("R")){
	    			if(!office.equals(null))
	    				office.redTrackPanel.Update(redList);
	    		}
	    		
					
	    }
	    
	    /**
	     * Function that will activate a track Crossing based on whether or not a train
	     * is near enough to cause such an event.
	     * @param lineSelect	Track Line ('G' or 'R')
	     * @param trackSelect	Track Block (Selected from the list of tracks, only crossings will actually be considered)
	     * @return	boolean
	     */
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
	    /**
	     * Function that will deactivate a track Crossing based on whether or not a train
	     * is far enough away to cause such an event.
	     * @param lineSelect	Track Line ('G' or 'R')
	     * @param trackSelect	Track Block (Selected from the list of tracks, only crossings will actually be considered)
	     * @return	boolean
	     */
	    @SuppressWarnings("unused")
		private boolean deactivateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is activated:
	    	//Check to make sure all trains are out of the area and that
	    	//it is safe to deactivate the crossing
	    	//Deactivate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
	    }
	    
	    /**
	     * Function that will move a switch to given position based on params and checks
	     * that such an action is safe to perform.
	     * @param lineSelect	Track Line ('G' or 'R')
	     * @param trackSegment	Track Block (Selected from the list of tracks, only switches will be considered)
	     * @param newConnect	Destination for the new switch connection.
	     * @return boolean
	     */
		public boolean switchTrackSegment(){
	    	
	    	return false;
	    }
	    
	    /**
	     * Function that will continuously look for a train in the system based on the status of the
	     * Track Model's circuitry.
	     * @return boolean
	     */
	    @SuppressWarnings("unused")
		private boolean trainDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for trains
	    	//currently present on the system. If the circuit is broken (i.e. a train is present)
	    	//the function shall return true, otherwise false.
	    	return false;
	    }
	    
	    /**
	     * Function that will continuously look for a broken rail flag in the system. Upon Detection,
	     * the proper systems shall be notified of the issue at hand.
	     * @return boolean
	     */
	    @SuppressWarnings("unused")
		private boolean brokenRailDetection(){
	    	//This method will scan the track circuits implemented by the Track Model for rails that
	    	//are currently broken. If the circuit is non functional, the function shall return true,
	    	//otherwise false;
	    	return false;
	    }
	    
	    /**
	     * Function that will check the overall health of the system.
	     * @return boolean
	     */
	    @SuppressWarnings("unused")
		private boolean checkStatus(){
	    	
	    	return false;
	    }
	    
	    /**
	     * Function that sends back, to whomever wants it, an updated version of the green
	     * track block list.
	     * @return ArrayList<trackBlock>
	     */
	    public static ArrayList<trackBlock> updateGreen(){

    		return greenList;

	    }
	    
	    /**
	     * Function that sends back, to whomever wants it, an updated version of the red
	     * track block list.
	     * @return ArrayList<trackBlock>
	     */
	    public static ArrayList<trackBlock> updateRed(){

	    		return redList;

	    }
	    
	    /**
	     * Function that allows the Track Controller itself, or anyone outside of it, to
	     * create a new train for the system.
	     * @param p_trackLine	Track Line the train will be placed on ('G' or 'R')
	     * @param p_trainID		ID Number for the train
	     * @param p_cars		Length of the train
	     */
	    public void addTrain(char p_trackLine, int p_trainID, int p_cars ){
	    	
	    	tc.CreateNewTrain(p_trackLine, p_trainID, p_cars);
	    	getTrainList();
	    	
	    }
	    
	    /**
	     * Function that sends back an up to date list of trains in the system
	     * @return ArrayList<TrainModel>
	     */
	    public void getTrainList(){
	    	
	    	trainList = tc.GetTrainList();
	    	
	    	office.trainPanel.Update(trainList);
	    	
	    }
}
