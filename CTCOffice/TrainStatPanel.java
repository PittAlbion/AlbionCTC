//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import TrackController.TrackController;

@SuppressWarnings("serial")
public class TrainStatPanel extends JPanel implements ActionListener{
	
	private JButton editButton;
	private JButton removeButton;
	private String title;
	private LogPanel log;
	private TrackController trackController;
	
	// panels to be created display train info and allow editing
	public TrainStatPanel(String name,LogPanel logPanel, TrackController controller){
		super();
		title = name;
		log = logPanel;
		trackController = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,300));
		this.setMaximumSize(this.getPreferredSize());
		this.setBorder(new TitledBorder(title));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setMaximumSize(new Dimension(150,50));
		buttonPanel.setLayout(new GridLayout(2,1));
		editButton = new JButton("Edit");
		editButton.addActionListener(this);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		buttonPanel.add(editButton);
		buttonPanel.add(removeButton);
		
		//add in other properties before buttons
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		//call edit method and pass suggestion to track controller
		if(event.getSource().equals(editButton)){
			log.UpdateLog("Editing "+title);
		}
		else if(event.getSource().equals(removeButton)){
			log.UpdateLog("Routing "+title+"back to station");
		}
		
	}

}
