package TrainController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements ActionListener{

    static JButton stopPower, stop, call, power;
    static JTextField powerValue;
    TrainController controller;
    InfoPanel infoPanel;
    
    ButtonPanel(TrainController p_controller, InfoPanel p_infoPanel){
        super();
        this.setLayout(new GridLayout(1,5));
        this.setPreferredSize(new Dimension(400, 100));
        
        controller = p_controller;
        infoPanel = p_infoPanel;
        power = new JButton("<html>Give<br />Power</html>");
        power.addActionListener(this);
        powerValue = new JTextField("Power (W)");
        stop = new JButton("<html>Emergency<br />Stop</html>");
        stop.addActionListener(this);
        call = new JButton("<html>Call CTC<br />Office</html>");
        call.addActionListener(this);
        stopPower = new JButton("<html>Stop<br />Power</html>");
        stopPower.addActionListener(this);
        
        this.add(power);
        this.add(powerValue);
        this.add(stopPower);
        this.add(stop);
        this.add(call);
    }
    
    public void actionPerformed(ActionEvent e){
    	if (e.getSource().equals(power)){
    		if (!powerValue.getText().equals("Power (W)")){
    			controller.GivePower(controller.currentTrain, Double.parseDouble(powerValue.getText()));
    			infoPanel.UpdateTrainInfo();
    		}
    	}
        else if (e.getSource().equals(stop)){
            controller.EmergencyStop(controller.currentTrain);
            infoPanel.UpdateTrainInfo();
        }
        else if (e.getSource().equals(call)){
            controller.CallOffice(controller.currentTrain);
        }
        else if (e.getSource().equals(stopPower)){
        	controller.StopPower(controller.currentTrain);
        }
    }
}