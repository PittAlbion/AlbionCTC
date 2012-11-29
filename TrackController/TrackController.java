//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import TrackModel.*;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
@SuppressWarnings("serial")

public class TrackController extends JFrame implements Runnable {
	
		CommandPanel commandPanel;
		OutputPanel outputPanel;
		SelectPanel selectPanel;
		StatisticPanel statisticPanel;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		public static void main(String [] args) throws InterruptedException, IOException{
			
			new TrackController(new ArrayList<trackBlock>(), new ArrayList<trackBlock>());
			//new GUI();
				
		}
		
		public TrackController(ArrayList<trackBlock> green, ArrayList<trackBlock> red) throws IOException
		{
			
			green = trackModel.buildGreenList("help");
			red = trackModel.buildRedList("help");
			
			//Debug purposes
			//System.out.println("Green Track: Block 0 Elevation: " + green.get(0).elevation);
			//System.out.println("Red Track: Block 35 Block Number: " + red.get(35).block_number);
			
		}
		
		public void run(){
			
		}
		
		public void GetSuggestion(Object [] s){

	        int i;
			String [] parsedString = new String[2];
	        String suggestionDest = s[0].toString();
	        String selector = s[1].toString();
			
			parsedString = selector.split("");
			String line = parsedString[0];
			int block = Integer.parseInt(parsedString[1]);
			
	        for (i=2; i<(s.length); i++){
	            if (suggestionDest.equals("Train")){ //Train Controller Suggestion
	                ;   // PassSuggestion. Some code to send the suggestion to the Train Controller
	            }else if (suggestionDest.equals("Track")){ //Track Controller Suggestion
	                useSuggestion(line, block, s[i].toString(), s[i+1].toString());
	            }
	            else    // Invalid Suggestion Destination, do nothing.
	                return;
	        }
			
	    }

		
		
	    private void useSuggestion(String lineSelect, int trackSelect, String type, String value){
		
	    		boolean safe = false;
	            //Track trackBlock = tracks.get(line, trackSelect);
	            if (type.equals("Authority")){
	                safe = checkStatus(); //Do something safe involving the authority suggestion
	                if(safe){ //change Authority
	                	//trackBlock.setAuthority(value);
	                }
	            }
	            else if(type.equals("Speed")){
	                safe = checkStatus(); //Do something safe involving the speed suggestion
	                if (safe){ //change speed
	                	//trackBlock.setSpeed(value);
	                }
	            }
	            else //Invalid suggestion
	                return; //do nothing
					
	    }
	    
	    
	    @SuppressWarnings("unused")
		private boolean activateCrossing(String lineSelect, int trackSelect){
	    	//If the crossing is inactive:
	    	//Check to make sure it is safe to activate crossing
	    	//Activate Appropriately
	    	//Send back a confirmation or failure signal
	    	return false;
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
		private boolean switchTrackSegment(String lineSelect, int trackSegement, int position){
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
	    
	    private boolean checkStatus(){
	    	
	    	return false;
	    }
}
