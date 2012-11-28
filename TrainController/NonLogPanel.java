package TrainController;

import java.awt.*;
import javax.swing.*;

public class NonLogPanel{

    private static JPanel infoPanel, buttonPanel;
    
    public static JPanel CreateNonLogPanel(){
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2,1));
        
        infoPanel = InfoPanel.CreateInfoPanel();
        buttonPanel = ButtonPanel.CreateButtonPanel();
        
        pane.add(infoPanel);
        pane.add(buttonPanel);
        
        return pane;
    }
}