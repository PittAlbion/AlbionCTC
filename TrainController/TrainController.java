package TrainController;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import TrainModel.*;

@SuppressWarnings({ "serial", "unchecked", "rawtypes", "unused" })

public class TrainController extends JFrame implements Runnable, ActionListener{

    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem exit, doc, about;
	private JDialog f;
    private Container container;
    private static JPanel mainPane;
    private static LogPanel logPanel;
    private static NonLogPanel nonLogPanel;
    private JDialog dialog;
    static ArrayList<TrainModel> trainList;
    private static int trainCount = 0;
    static String[] trainIDArray;
    int currentTrain;
    
    
    public static void main(String[] args) throws InterruptedException{
        new TrainController();
        
        Thread.sleep(5000);
        CreateNewTrain('G', 1, 3);
        Thread.sleep(2000);
        CreateNewTrain('G', 4, 3);
    }
    
	public TrainController(){
        super("Albion Train Controller v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        
        trainIDArray = new String[100];
        trainIDArray[0]="None";
        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        fileMenu.add(exit);
        
        doc = new JMenuItem("Documentation");
        doc.addActionListener(this);
        about = new JMenuItem("About");
        about.addActionListener(this);
        helpMenu.add(doc);
        helpMenu.add(about);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        
        container = this.getContentPane();
        mainPane = new JPanel();
        container.add(mainPane);
        mainPane.setLayout(new GridLayout(1,2));
        logPanel = new LogPanel(this);
        nonLogPanel = new NonLogPanel(this, logPanel);
        mainPane.add(nonLogPanel);
        mainPane.add(logPanel);
        
        pack();
        setVisible(true);
        
        trainList = new ArrayList();
    }
    
    public static void CreateNewTrain(char p_trackLine, int p_trainID, int p_cars){
        trainList.add(new TrainModel(p_trackLine, p_trainID, p_cars));
        trainIDArray[trainCount] = ""+trainList.get(trainCount).trainID;
        nonLogPanel.trainPanel.UpdateTrainBox();
        logPanel.WriteMessage("Train Created: " + p_trackLine + p_trainID + "\n");
        trainCount++;
    }
    
    private static TrainModel FindTrain(int p_trainID){
        for (int i = 0; i < trainList.size(); i++){
            if (trainList.get(i).trainID == p_trainID){
                return trainList.get(i);
            }
        }
        return null;
    }
    
    int FindTrainIndex(int p_trainID){
		for (int i=0; i <= trainList.size(); i++){
			if (trainIDArray[i].equals(""+p_trainID)){
				return i;
				//System.out.println(""+i);
			}
		}
		return 0;
    }
    
    public static void SendCommand(int p_trainID, String p_type, double p_value){
        TrainModel train = FindTrain(p_trainID);
        if (train != null){
            if (p_type.equals("Speed")){
                train.SetPointSpeed(p_value);
            }else if (p_type.equals("Authority")){
                train.SetAuthority(p_value);
            }
        }
        logPanel.WriteMessage(p_type + " suggestion recieved.\n");
    }
    
    public ArrayList<TrainModel> GetTrainList(){
		return trainList;
    }
    
    void IncreaseSpeed(int p_trainID){
        //if (this.CheckSpeedLimit(int _speed = (this._trainInfo.GetTrainSpeed()+.1)){
        //    this._trainInfo.SetTrainSpeed(this._speed);
        //}*/
    }
    
    void DecreaseSpeed(int p_trainID){
        /*if ((int speed = this._trainInfo.GetTrainSpeed()) != 0.0){
            this._trainInfo.SetTrainSpeed(this._speed-.1);
        }*/
    }
    
    void EmergencyStop(int p_trainID){
        FindTrain(p_trainID).SetPointSpeed(0.0);
    }
    
    public boolean IsNearCrossing(int p_trainID){
    	Random number = new Random();
        int hack = number.nextInt(2);
        if (hack == 1)
            return true;
        
        return false;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(exit)){
            System.exit(0);
        }
        else if (e.getSource().equals(doc)){
            //doc shit
        }
        else if (e.getSource().equals(about)){
            dialog = new AboutBox(new JFrame());
            dialog.setVisible(true);
        }
    }
    
    public void run(){
    }
}