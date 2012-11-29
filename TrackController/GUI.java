package TrackController;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener{
	
	private JMenuBar menuBar;
	private JMenu fileMenu, helpMenu;
	private JMenuItem exit, runPLC, doc, about;
	private JDialog f;
	private static JPanel mainPane;
	private Container mainContainer;
	CommandPanel commandPanel;
	OutputPanel outputPanel;
	SelectPanel selectPanel;
	StatisticPanel statisticPanel;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	GUI(){

			super("Albion Track Controller v1.0");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setResizable(false);
			this.setMaximumSize(new Dimension(800,800));
			this.setPreferredSize(new Dimension(800,800));
			setExtendedState(Frame.NORMAL);
			
			
			menuBar = new JMenuBar();
			fileMenu = new JMenu("File");
			helpMenu = new JMenu("Help");
			
			runPLC = new JMenuItem("Run PLC...");
			runPLC.addActionListener(this);
			fileMenu.add(runPLC);
			
			exit = new JMenuItem("Exit");
			exit.addActionListener(this);
			fileMenu.add(exit);
			
			doc = new JMenuItem("Documentation");
			doc.addActionListener(this);
			helpMenu.add(doc);
			
			about = new JMenuItem("About");
			about.addActionListener(this);
			helpMenu.add(about);
			
			menuBar.add(fileMenu);
			menuBar.add(helpMenu);
			this.setJMenuBar(menuBar);
			
			mainContainer = this.getContentPane();
			mainPane = new JPanel();
			mainContainer.add(mainPane);
			mainPane.setLayout(new GridBagLayout());
			GridBagConstraints c= new GridBagConstraints();
			
			commandPanel = new CommandPanel();
			selectPanel = new SelectPanel();
			outputPanel = new OutputPanel();
			statisticPanel = new StatisticPanel();
			
			//statisticPanel.setSize(new Dimension(200, 200));
			//CommandPanel.activate.setEnabled(false);
			//mainPane.add(selectPanel);
			//mainPane.add(commandPanel);
			//mainPane.add(outputPanel);
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 400;
			c.weighty = 300;
			c.gridwidth = 1;
			c.gridheight = 1;
			
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			
			//selectPanel.setPreferredSize(new Dimension(300,300));
			mainPane.add(selectPanel, c);
			
			c.gridx = 1;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_END;
			mainPane.add(commandPanel, c);
			
			c.weightx = 200;
			c.weighty = 400;
			
			c.gridx = 0;
			c.gridy = 1;
			c.anchor = GridBagConstraints.LAST_LINE_START;
			mainPane.add(outputPanel,c);
			
			c.weighty = 200;
			c.gridx = 1;
			c.gridy = 1;
			//c.anchor = GridBagConstraints.LAST_LINE_END;
			mainPane.add(statisticPanel,c);
			
			pack();
			
			setVisible(true);
	}

	 public void actionPerformed(ActionEvent e){
	    	if(e.getSource().equals(exit)){
	    		System.exit(0);
	    	}
	    	else if (e.getSource().equals(doc)){
	    		//do some crap with documentation
	    	}
	    	else if (e.getSource().equals(about)){
	    		
	    		f = new AboutBox(new JFrame());
	    		f.setVisible(true);
	    	}
	    	else if (e.getSource().equals(runPLC)){
	    		final JFileChooser fc = new JFileChooser();
	    		fc.setMultiSelectionEnabled(false);
	    		fc.setAcceptAllFileFilterUsed(false);
	    		
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("PLC Files", "plc");
	    		fc.setFileFilter(filter);
	    		
	    		int returnVal = fc.showOpenDialog(GUI.this);
	    		
	    		if (returnVal == JFileChooser.APPROVE_OPTION){
	    			File file = fc.getSelectedFile();
	    			
	    			try {
						PLCImport.ParsePLCFile(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	    		}
	    	}
	    	else{
	    		
	    	}
	    }
}