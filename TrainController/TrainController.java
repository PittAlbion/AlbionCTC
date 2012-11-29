package TrainController;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
@SuppressWarnings("serial")

public class TrainController extends JFrame implements Runnable, ActionListener{

    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu, trainMenu;
    private JMenuItem exit, doc, about;
    private JDialog f;
    private Container container;
    private static JPanel mainPane;
    private JPanel logPanel, nonLogPanel;
    private JDialog dialog;
    private static ArrayList<Train> trainList;
    private String[] trainIDArray;
    private int trainCount = 0;
    int currentTrain;
    
    /*public static void main(String[] args){
        new TrainController();
    }*/
    
    public TrainController(){
        super("Albion Train Controller v1.0");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        trainMenu = new JMenu("Trains");
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
        menuBar.add(trainMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        
        container = this.getContentPane();
        mainPane = new JPanel();
        container.add(mainPane);
        mainPane.setLayout(new GridLayout(1,2));
        logPanel = LogPanel.CreateLogPanel();
        nonLogPanel = NonLogPanel.CreateNonLogPanel();
        mainPane.add(nonLogPanel);
        mainPane.add(logPanel);
        
        pack();
        setVisible(true);
        
        trainList = new ArrayList();
    }
    
    public void CreateNewTrain(char p_trackLine, int p_trainID, int p_cars, double p_length, double p_height, double p_width){
        trainList.add(new Train(p_trackLine, p_trainID, p_cars, p_length, p_height, p_width));
        trainIDArray[trainCount] = trainList.get(trainCount);
        UpdateTrainMenu(p_trainID)
        trainCount++;
    }
    
    /*private void UpdateTrainMenu(int p_trainID){
		JRadioButtonMenuItem trainButton = new JRadioButtonMenuItem(""+p_trainID);
		trainButton.addActionListener(this);
		trainMenu.add(trainButton);
		trainMenu.repaint();
    }*/
    
    private Train FindTrain(int p_trainID){
        for (int i = 0; i < trainList.size(); i++){
            if (trainList.get(i).getID() == p_trainID){
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
    
    public boolean IncreaseSpeed(){
        /*if (this.CheckSpeedLimit(int _speed = (this._trainInfo.GetTrainSpeed()+.1)){
            this._trainInfo.SetTrainSpeed(this._speed);
            return true;
        }*/
        return false;
    }
    
    public boolean DecreaseSpeed(){
        /*if ((int _speed = this._trainInfo.GetTrainSpeed()) != 0.0){
            this._trainInfo.SetTrainSpeed(this._speed-.1);
            return true;
        }*/
        return false;
    }
    
    public void EmergencyStop(int p_trainID){
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