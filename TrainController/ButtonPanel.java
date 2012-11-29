package TrainController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel implements ActionListener{

    static JButton faster, slower, stop, call;
    
    JPanel CreateButtonPanel(){
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1,4));
        
        faster = new JButton("Increase Speed");
        faster.addActionListener(this);
        slower = new JButton("Decrease Speed");
        slower.addActionListener(this);
        stop = new JButton("Emergency Stop");
        stop.addActionListener(this);
        call = new JButton("Call CTC Office");
        call.addActionListener(this);
        
        pane.add(faster);
        pane.add(slower);
        pane.add(stop);
        pane.add(call);
        
        return pane;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(faster)){
            IncreaseSpeed(currentTrain);
        }
        else if (e.getSource().equals(slower)){
            DecreaseSpeed(currentTrain);
        }
        else if (e.getSource().equals(stop)){
            EmergencyStop(currentTrain);
        }
        else if (e.getSource().equals(call)){
            //call call?
        }
        else{
        }
    }
}