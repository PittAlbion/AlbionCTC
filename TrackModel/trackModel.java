package TrackModel;
import java.util.*;
import java.io.*;

public class trackModel {
	
	public static ArrayList<trackBlock> greenTrack, redTrack;
	
public static void main(String[] args) throws IOException{

	

//Create Array List for Green Track	and Red Track
greenTrack = buildGreenList("greendata.txt");
redTrack = buildRedList("redData.txt");

//Create ArrayList for track Crossings	
ArrayList<trackCrossing> trackCrossingList = new ArrayList<trackCrossing>();
 trackCrossing firstOne = new trackCrossing(false,false, 47,"red");
 trackCrossing secondOne = new trackCrossing(false,false,19, "green");
 trackCrossingList.add(firstOne);
 trackCrossingList.add(secondOne);



//CHECK//
trackBlock printBlock = (trackBlock) greenTrack.get(0);
trackBlock redprintBlock = (trackBlock) redTrack.get(4);

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

	//System.out.println(green_block.block_number);
	}
	
in.close();
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

//System.out.println(red_block.block_number);
}
	inRed.close();
	return newRedTrack;
	
	
}


}
