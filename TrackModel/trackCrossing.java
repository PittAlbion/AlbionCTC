package TrackModel;
import java.util.*;
import java.io.*;

public class trackCrossing {

	public boolean active;
	public boolean lights;
	public int block_number;
	public String train_line;
	
	public trackCrossing(boolean isActive, boolean light, int block_num, String train_color){
		
		active = isActive;
		lights = light;
		block_number = block_num;
		train_line = train_color;
		
		
	}

}
