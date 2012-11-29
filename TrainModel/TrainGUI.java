package TrainModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;



public class TrainGUI extends JFrame implements ActionListener{
	
	private JPanel mainPane;
	private Container mainContainer;
	
	private AttributesPanel attPanel;
	private MiscPanel miscPanel;
	private FailPanel failPanel;
	private OtherPanel otherPanel;
	private CommandsPanel commPanel;
	private LimitsPanel limPanel;
	
	
	TrainGUI(TrainModel theModel) throws IOException{
		super("Albion Train Model Gui v1.0");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		mainContainer = this.getContentPane();
		mainPane = new JPanel();
		mainContainer.add(mainPane);
		mainPane.setLayout(new GridLayout());
		
		attPanel = new AttributesPanel();
		miscPanel = new MiscPanel();
		failPanel = new FailPanel();
		otherPanel= new OtherPanel();
		commPanel = new CommandsPanel();
		limPanel = new LimitsPanel();
		
		setVisible(true);
		
	}
	

	public void actionPerformed(ActionEvent event){
		
		
		
		
	}
	
	
}
