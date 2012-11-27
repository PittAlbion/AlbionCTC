//~ Track Controller
//~ Calvin Souders
//~ 11/27/2012
//~ Albion

package TrackController;

//import java.awt.FlowLayout;


import javax.swing.*;

@SuppressWarnings("serial")
public class StatisticPanel extends JPanel{

	private static String[] genCols = {"Property", "Data"};
	private static Object[][] genData = {
		{"Train Line", null},
		{"Track Block", null},
		{"Authority", null},
		{"Speed", null},
		{"Grade", null},
		{"Elevation", null}
	};
	
	private static String[] advCols = {"Property", "Data"};
	private static Object[][] advData = {
		{"Train Line", null},
		{"Track Block", null},
		{"Authority", null},
		{"Speed", null},
		{"Grade", null},
		{"Elevation", null}
	};
	
		public static JTabbedPane CreateStatisticPanel(){
			
			JTabbedPane tabPane = new JTabbedPane();
			JTable generalTable, advancedTable;
			
			generalTable = new JTable(genData, genCols);
			advancedTable = new JTable(advData, advCols);
			
			tabPane.addTab("General", new JScrollPane(generalTable));
			tabPane.addTab("Advanced", new JScrollPane(advancedTable));
			
			return tabPane;
			
		}
		
		public static void changeGeneralData(int row, int col, Object value){
			genData[row][col] = value;
		}
		
		public static void changeAdvancedData(int row, int col, Object value){
			advData[row][col] = value;
		}
		
}