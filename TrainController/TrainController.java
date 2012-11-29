package TrainController;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
@SuppressWarnings({ "serial", "unchecked", "rawtypes", "unused" })

public class TrainController extends JFrame implements Runnable, ActionListener{

    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem exit, doc, about;
	private JDialog f;
    private Container container;
    private static JPanel mainPane;
    private LogPanel logPanel;
    private static NonLogPanel nonLogPanel;
    private JDialog dialog;
    static ArrayList<Train> trainList;
    private static int trainCount = 0;
    static String[] trainIDArray;
    int currentTrain;
    
    public static void main(String[] args) throws InterruptedException{
        new TrainController();
        
        Thread.sleep(5000);
        CreateNewTrain('g', 1, 3, 10.0, 50.0, 50.0);
        Thread.sleep(2000);
        CreateNewTrain('g', 4, 3, 10.0, 50.0, 50.0);
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
        logPanel = new LogPanel();
        nonLogPanel = new NonLogPanel(this);
        mainPane.add(nonLogPanel);
        mainPane.add(logPanel);
        
        pack();
        setVisible(true);
        
        trainList = new ArrayList();
    }
    
    public static void CreateNewTrain(char p_trackLine, int p_trainID, int p_cars, double p_length, double p_height, double p_width){
        trainList.add(new Train(p_trackLine, p_trainID, p_cars, p_length, p_height, p_width));
        trainIDArray[trainCount] = ""+trainList.get(trainCount).GetID();
        nonLogPanel.trainPanel.UpdateTrainBox();
        nonLogPanel.infoPanel.UpdateTrainInfo();
        trainCount++;
    }
    
    private static Train FindTrain(int p_trainID){
        for (int i = 0; i < trainList.size(); i++){
            if (trainList.get(i).GetID() == p_trainID){
                return trainList.get(i);
            }
        }
        return null;
    }
    
    public static void SendCommand(int p_trainID, String p_type, double p_value){
        Train train = FindTrain(p_trainID);
        if (train != null){
            if (p_type.equals("Speed")){
                train.SetSpeed(p_value);
            }else if (p_type.equals("Authority")){
                train.SetAuthority(p_value);
            }
        }
    }
    
    void IncreaseSpeed(int p_trainID){
        /*if (this.CheckSpeedLimit(int _speed = (this._trainInfo.GetTrainSpeed()+.1)){
            this._trainInfo.SetTrainSpeed(this._speed);
        }*/
    }
    
    void DecreaseSpeed(int p_trainID){
        /*if ((int speed = this._trainInfo.GetTrainSpeed()) != 0.0){
            this._trainInfo.SetTrainSpeed(this._speed-.1);
        }*/
    }
    
    void EmergencyStop(int p_trainID){
        FindTrain(p_trainID).Stop();
    }
    
    public boolean IsNearCrossing(int p_trainID){
        return FindTrain(p_trainID).NearCrossing();
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