package TrainController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements ActionListener{

    static JButton faster, slower, stop, call;
    TrainController controller;
    
    ButtonPanel(TrainController p_controller){
        super();
        this.setLayout(new GridLayout(1,4));
        this.setPreferredSize(new Dimension(400, 100));
        
        controller = p_controller;
        faster = new JButton("<html>Increase<br />Speed</html>");
        faster.addActionListener(this);
        slower = new JButton("<html>Decrease<br />Speed</html>");
        slower.addActionListener(this);
        stop = new JButton("<html>Emergency<br />Stop</html>");
        stop.addActionListener(this);
        call = new JButton("<html>Call CTC<br />Office</html>");
        call.addActionListener(this);
        
        this.add(faster);
        this.add(slower);
        this.add(stop);
        this.add(call);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(faster)){
            controller.IncreaseSpeed(controller.currentTrain);
        }
        else if (e.getSource().equals(slower)){
            controller.DecreaseSpeed(controller.currentTrain);
        }
        else if (e.getSource().equals(stop)){
            controller.EmergencyStop(controller.currentTrain);
        }
        else if (e.getSource().equals(call)){
            //call call?
        }
        else{
        }
    }
}