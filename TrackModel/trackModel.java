package TrackModel;
import java.util.*;
import java.io.*;

public class trackModel {
	
	public static ArrayList<trackBlock> greenTrack, redTrack;
	public static ArrayList<trackCrossing> trackCrossingList;
	
public static void main(String[] args) throws IOException{

	

//new tmWindow();
	
//Create Array List for Green Track	and Red Track
greenTrack = buildGreenList("greendata.txt");
redTrack = buildRedList("redData.txt");

//Create ArrayList for track Crossings
//edit green crossing
trackBlock greenCblock = greenTrack.get(19);
greenCblock.active = false;
greenCblock.lights = false;
greenCblock.train_line = "green";
 //trackCrossingList = new ArrayList<trackCrossing>();
// trackCrossing firstOne = new trackCrossing(false,false, 47,"red");
 //trackCrossing secondOne = new trackCrossing(false,false,19, "green");
 //edit red crossing
trackBlock redCblock = redTrack.get(47);
redCblock.active = false;
redCblock.lights = false;
greenCblock.train_line = "red";
 //trackCrossingList.add(firstOne);
 //trackCrossingList.add(secondOne);


 
 //Update Switches//////////
 
 trackBlock currentBlock = greenTrack.get(1);
 //Green Switch
 //13
 trackBlock currentBlock1 = greenTrack.get(13);
 currentBlock1.edit_swLeft(12);
 currentBlock1.edit_swRight(1);
 currentBlock1.edit_swCurrent(12);
 //28
 trackBlock currentBlock2 = greenTrack.get(28);
 currentBlock2.edit_swLeft(29);
 currentBlock2.edit_swRight(150);
 currentBlock2.edit_swCurrent(29);
 //57
 trackBlock currentBlock3 = greenTrack.get(57);
 currentBlock3.edit_swLeft(0);
 currentBlock3.edit_swRight(58);
 currentBlock3.edit_swCurrent(0);
 //63
 trackBlock currentBlock4 = greenTrack.get(63);
 currentBlock4.edit_swLeft(62);
 currentBlock4.edit_swRight(0);
 currentBlock4.edit_swCurrent(62);
 //77
 trackBlock currentBlock5 = greenTrack.get(77);
 currentBlock5.edit_swLeft(101);
 currentBlock5.edit_swRight(76);
 currentBlock5.edit_swCurrent(101);
 //85
 trackBlock currentBlock6 = greenTrack.get(85);
 currentBlock6.edit_swLeft(86);
 currentBlock6.edit_swRight(100);
 currentBlock6.edit_swCurrent(86);
 
//Red Switches
 //9
 trackBlock currentBlock7 = redTrack.get(9);
 currentBlock7.edit_swLeft(0);
 currentBlock7.edit_swRight(10);
 currentBlock7.edit_swCurrent(0);
 //16
 trackBlock currentBlock8 = redTrack.get(16);
 currentBlock8.edit_swLeft(1);
 currentBlock8.edit_swRight(15);
 currentBlock8.edit_swCurrent(1);
 //27
 trackBlock currentBlock9 = redTrack.get(27);
 currentBlock9.edit_swLeft(28);
 currentBlock9.edit_swRight(76);
 currentBlock9.edit_swCurrent(28);
 //33
 trackBlock currentBlock10 = redTrack.get(33);
 currentBlock10.edit_swLeft(72);
 currentBlock10.edit_swRight(32);
 currentBlock10.edit_swCurrent(72);
 //38
 trackBlock currentBlock11 = redTrack.get(38);
 currentBlock11.edit_swLeft(37);
 currentBlock11.edit_swRight(71);
 currentBlock11.edit_swCurrent(37);
 //43
 trackBlock currentBlock12 = redTrack.get(43);
 currentBlock12.edit_swLeft(67);
 currentBlock12.edit_swRight(42);
 currentBlock12.edit_swCurrent(67);
 //52
 trackBlock currentBlock13 = redTrack.get(52);
 currentBlock13.edit_swLeft(53);
 currentBlock13.edit_swRight(64);
 currentBlock13.edit_swCurrent(53);
 
 
 //EventQueue.invokeLater(new Runnable() {
		//public void run() {
			try {
				trackModelWindow frame = new trackModelWindow();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
	//});

//CHECK//
//trackBlock printBlock = (trackBlock) greenTrack.get(0);
//trackBlock redprintBlock = (trackBlock) redTrack.get(4);

//System.out.println(printBlock.block_number);
//System.out.println(redprintBlock.block_number);

}

public static ArrayList<trackBlock> buildGreenList(String dataFile) throws IOException{
	
	ArrayList<trackBlock> newGreenTrack = new ArrayList<trackBlock>();
	

//buffered reader used to  green track data text file
BufferedReader in = new BufferedReader(new FileReader("greentrackdata.txt"));

//variable used for reading in next line of the text file
String temp_parse_line;

//For loop to store all of the track block into the array list
for(int i= 0; i<150; i++){

	temp_parse_line = in.readLine();

	String[] temp_results = temp_parse_line.split(",");

	//Create New Block with properties
	trackBlock green_block = new trackBlock(temp_results);

	//add new block to list
	newGreenTrack.add(green_block);

	System.out.println(green_block.block_number);
	}
	
in.close();
    System.out.println("Green Track Uploaded");
	return newGreenTrack;
}


public static ArrayList<trackBlock> buildRedList(String redDataFile) throws IOException{

ArrayList<trackBlock> newRedTrack = new ArrayList<trackBlock>();
	
///////////////////////////////////////////////////
//buffered reader used to  Red track data text file
BufferedReader inRed = new BufferedReader(new FileReader("redtrackdata.txt"));

//variable used for reading in next line of the text file
String red_temp_parse_line;

//For loop to store all of the track block into the array list
for(int j= 0; j<76; j++){

	red_temp_parse_line = inRed.readLine();

	String[] red_temp_results = red_temp_parse_line.split(",");


	//Create New Block with properties
	trackBlock red_block = new trackBlock(red_temp_results);

	//add new block to list
    newRedTrack.add(red_block);

System.out.println(red_block.block_number);
}
	inRed.close();
	System.out.println("Red Track Uploaded");
	return newRedTrack;
	
	
}


}
