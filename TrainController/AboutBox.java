package TrainController;

import java.awt.event.*;
import javax.swing.*;

public class AboutBox extends JDialog{

    JLabel name = new JLabel("Albion Train Controller");
    JLabel version = new JLabel("Version 1.0.0");
    JLabel me = new JLabel("Author: James Vento");
    
    public AboutBox(JFrame frame){
        super(frame, "About", true);
        
        Box box = Box.createVerticalBox();
        box.add(Box.createGlue());
        name.setAlignmentX(CENTER_ALIGNMENT);
        version.setAlignmentX(CENTER_ALIGNMENT);
        me.setAlignmentX(CENTER_ALIGNMENT);
        box.add(name);
        box.add(version);
        box.add(me);
        box.add(Box.createGlue());
        getContentPane().add(box, "Center");
        
        JPanel pane = new JPanel();
        JButton close = new JButton("Close");
        pane.add(close);
        getContentPane().add(pane, "South");
        
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
            }
        });
    }
}