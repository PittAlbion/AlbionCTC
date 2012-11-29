package TrainController;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LogPanel extends JPanel{

	private JTextArea textArea;
	
    LogPanel(TrainController p_controller){
        super();
        this.setLayout(new GridLayout(1,1));
        
        textArea = new JTextArea();
        this.add(textArea);
    }
    
    void WriteMessage(String p_message){
		textArea.append(p_message);
    }
}