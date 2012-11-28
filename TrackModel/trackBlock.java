package TrackModel;

public class trackBlock {
	
	//all componenets of a track block that are provided in the excel sheet
    String track_line;
	String train_section;
	int block_number;
	double block_length;
	double block_grade;
	int speed_limit;
	String infrastructure;
	double elevation;
	double cumulative_elevation;
/*
public trackBlock(String a, String b, int c, int d, double e, int f, String g, double h, double i){
	
	this.track_line = a;
	this.train_section = b;
	this.block_number = c;
	this.block_length = d;
	this.block_grade = e;
	this.speed_limit = f;
	this.infrastructure = g;
	this.elevation = h;
	this.cumulative_elevation= i; 
}
*/
public trackBlock(String[] properties){
	
	track_line = properties[0];
	train_section = properties[1];
	block_number = Integer.parseInt(properties[2]);
	block_length = Double.parseDouble(properties[3]);
	block_grade = Double.parseDouble(properties[4]);
	speed_limit = Integer.parseInt(properties[5]);
	infrastructure = properties[6];
	elevation = Double.parseDouble(properties[7]);
	cumulative_elevation = Double.parseDouble(properties[8]);
}
/*
public void edit_track_line(String temptrackline){
	
	track_line = temptrackline;
	
}
*/

}