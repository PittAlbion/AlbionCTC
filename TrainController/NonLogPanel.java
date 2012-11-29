package TrainController;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NonLogPanel extends JPanel{

    //private static JPanel infoPanel, buttonPanel;
	InfoPanel infoPanel;
	private static ButtonPanel buttonPanel;
	TrainPanel trainPanel;
    
    NonLogPanel(TrainController p_controller){
        super();
        this.setLayout(new BorderLayout());
        
        trainPanel = new TrainPanel(p_controller);
        infoPanel = new InfoPanel(p_controller);
        buttonPanel = new ButtonPanel(p_controller);
        
        this.add(trainPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}