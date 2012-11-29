package TrainController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel implements ActionListener{

    public JButton faster, slower, stop, call;
    
    public JPanel CreateButtonPanel(){
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
            //call increasespeed
        }
        else if (e.getSource().equals(slower)){
            //call decreasespeed
        }
        else if (e.getSource().equals(stop)){
            //call emergencystop
        }
        else if (e.getSource().equals(call)){
            //call call?
        }
        else{
        }
    }
}