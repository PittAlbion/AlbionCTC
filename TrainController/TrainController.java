package TrainController;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
@SuppressWarnings("serial")

public class TrainController extends JFrame implements Runnable, ActionListener{

    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem exit, doc, about;
    private JDialog f;
    private Container container;
    private static JPanel mainPane;
    private JPanel logPanel, nonLogPanel;
    private JDialog dialog;
    //private TrainModel trainModel;
    
    public static void main(String[] args) throws InterruptedException{
        new TrainController();
    }
    
    TrainController(){
        super("Albion Train Controller v1.0");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
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
        logPanel = LogPanel.CreateLogPanel();
        nonLogPanel = NonLogPanel.CreateNonLogPanel();
        mainPane.add(nonLogPanel);
        mainPane.add(logPanel);
        
        pack();
        setVisible(true);
        
        //trainModel = new TrainModel();
    }
    
    public static void SendCommand(char trackLine, int trainNumber, String type, double value){
        //check to see if trackLine and trainNumber matches info from associated train model
        if (type.equals("Speed")){
            ChangeSpeed(value);
        }else if (type.equals("Authority")){
            ChangeAuthority(value);
        }else
            return;
        //Shouldn't the value be a double instead of an int?
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
    
    private static boolean ChangeSpeed(double p_newSpeed){
        //This will call a method in the TrainModel that will change the speed
        return false;
    }
    
    public boolean EmergencyStop(){
        return this.ChangeSpeed(0.0);
    }
    
    private static boolean ChangeAuthority(double p_authority){
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