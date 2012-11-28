package TrainController;

import java.awt.*;
import javax.swing.*;

public class ButtonPanel{

    public static JButton faster, slower, stop, call;
    
    public static JPanel CreateButtonPanel(){
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1,4));
        
        faster = new JButton("Increase Speed");
        slower = new JButton("Decrease Speed");
        stop = new JButton("Emergency Stop");
        call = new JButton("Call CTC Office");
        
        pane.add(faster);
        pane.add(slower);
        pane.add(stop);
        pane.add(call);
        
        return pane;
    }
}