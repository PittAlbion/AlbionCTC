package TrainController;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NonLogPanel extends JPanel{

    //private static JPanel infoPanel, buttonPanel;
	private InfoPanel infoPanel;
	private static ButtonPanel buttonPanel;
	TrainPanel trainPanel;
    
    NonLogPanel(TrainController p_controller, LogPanel p_logPanel){
        super();
        this.setLayout(new BorderLayout());
        
        infoPanel = new InfoPanel(p_controller);
        trainPanel = new TrainPanel(p_controller, infoPanel, p_logPanel);
        buttonPanel = new ButtonPanel(p_controller, infoPanel);
        
        this.add(trainPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    void ManualUpdate(){
    	infoPanel.UpdateTrainInfo();
    }
}