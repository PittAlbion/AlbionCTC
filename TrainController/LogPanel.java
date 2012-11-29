package TrainController;

import java.awt.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class LogPanel extends JPanel{

	private ArrayList<JTextArea> logList;
	private TrainController controller;
	private JTextArea currentArea;
	
    LogPanel(TrainController p_controller){
        super();
        this.setLayout(new GridLayout(1,1));
        this.controller = p_controller;
        
        logList = new ArrayList<JTextArea>();
        currentArea = new JTextArea();
        this.add(currentArea);
    }
    
    void CreateLog(){
		logList.add(new JTextArea());
    }
    
    void UpdateLog(){
    	this.removeAll();
    	this.add(currentArea = logList.get(controller.currentTrain));
		this.revalidate();
    }
    
    void WriteMessage(String p_message){
		currentArea.append(p_message);
    }
}