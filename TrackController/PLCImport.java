//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

import java.util.*;
import java.io.*;
public class PLCImport {

	private static ArrayList<String> myStrArrayList = new ArrayList<String>();
	
		public static ArrayList<String> ParsePLCFile(File PLCFile) throws IOException{
			
			BufferedReader b = new BufferedReader(new FileReader(PLCFile));
			String line = null;
			while ((line = b.readLine()) != null){
				myStrArrayList.add(line);
				System.out.println(line);
			}
			
			b.close();
			
			return myStrArrayList;
		}
}
