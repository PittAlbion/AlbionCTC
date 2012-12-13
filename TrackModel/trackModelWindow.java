package TrackModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class trackModelWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextArea txtrGreenTrackDownloaded, txtrRedTrackDownloaded;
	private JTextField textField;
	private JLabel lblEnterBlockNumber;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowBuild frame = new windowBuild();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String text;
	int tempBlockNumber;
	
	public trackModelWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
;
		
		
		
		//create green download message
		txtrGreenTrackDownloaded = new JTextArea();
		txtrGreenTrackDownloaded.setText("Green Track Uploaded");
		txtrGreenTrackDownloaded.setBounds(183, 10, 188, 24);
		contentPane.add(txtrGreenTrackDownloaded);
		txtrGreenTrackDownloaded.setBackground(Color.green);
		txtrGreenTrackDownloaded.setVisible(false);
		
		//create download greentrack button
		final JButton btnDownloadGreenTrack = new JButton("Upload Green Track");
		btnDownloadGreenTrack.setBounds(10, 11, 163, 23);
		btnDownloadGreenTrack.addActionListener(new ActionListener() {
	    	 
	        public void actionPerformed(ActionEvent e)
	        {
	            //Execute when button is pressed
	            //System.out.println("You clicked the green button");
	            txtrGreenTrackDownloaded.setVisible(true);
	            btnDownloadGreenTrack.setEnabled(false);
	            try {
					trackModel.buildGreenList("greendata.txt");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	    });   
		contentPane.add(btnDownloadGreenTrack);
		//create red download message
		txtrRedTrackDownloaded = new JTextArea();
		txtrRedTrackDownloaded.setText("Red Track Uploaded");
		txtrRedTrackDownloaded.setBounds(183, 44, 188, 23);
		txtrRedTrackDownloaded.setBackground(Color.red);
		contentPane.add(txtrRedTrackDownloaded);
		txtrRedTrackDownloaded.setVisible(false);
		
		//create download red track button
		final JButton btnDownloadRedTrack = new JButton("Upload Red Track");
		btnDownloadRedTrack.setBounds(10, 45, 163, 23);
		btnDownloadRedTrack.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	             txtrRedTrackDownloaded.setVisible(true);
	             btnDownloadRedTrack.setEnabled(false);
	              try {
	  				trackModel.buildRedList("reddata.txt");
	  				
	  				
	  			} catch (IOException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			}
	          }
	      });   
		contentPane.add(btnDownloadRedTrack);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(20, 137, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e)
			{
	        text = textField.getText();
	        tempBlockNumber = Integer.parseInt(text);
	        //System.out.println(text);
	     
	    }
		});
		JButton btnNewButton = new JButton("Toggle Heater");
		btnNewButton.setBounds(10, 228, 136, 23);
		btnNewButton.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	        	  //System.out.println("Heater Button");
	        	  text = textField.getText();
	  	          tempBlockNumber = Integer.parseInt(text);
	        	  trackModel.edit_GreenHeater(tempBlockNumber);
	  				
	            
	          }
	      }); 
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Toggle Broken Rail");
		btnNewButton_1.setBounds(10, 194, 136, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	             //txtrRedTrackDownloaded.setVisible(true);
	        	  text = textField.getText();
	  	          tempBlockNumber = Integer.parseInt(text);
	        	  trackModel.update_greenBrokenRail(tempBlockNumber);
	             
	          }
	      }); 
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrEnterBlockNumber = new JTextArea();
		txtrEnterBlockNumber.setText("Enter Block Number");
		txtrEnterBlockNumber.setBounds(10, 110, 163, 22);
		contentPane.add(txtrEnterBlockNumber);
		
		//red updates
		JButton btnUpdateBrokenRail = new JButton("Toggle Broken Rail");
		btnUpdateBrokenRail.setBounds(183, 194, 136, 23);
		btnUpdateBrokenRail.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	        	  //System.out.println("Heater Button");
	        	  text = textField.getText();
	  	          tempBlockNumber = Integer.parseInt(text);
	        	  trackModel.update_redBrokenRail(tempBlockNumber);
	  			
	            
	         
	      }
		 }); 
		contentPane.add(btnUpdateBrokenRail);
		 
	//green update heater	
		JButton btnNewButton_2 = new JButton("Toggle Heater");
		btnNewButton_2.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	        	  //System.out.println("Heater Button");
	        	  text = textField.getText();
	  	          tempBlockNumber = Integer.parseInt(text);
	        	  trackModel.edit_redHeater(tempBlockNumber);
	  			
	             
	      }
		 }); 
		btnNewButton_2.setBounds(183, 228, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Green");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(42, 162, 63, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblRed = new JLabel("Red");
		lblRed.setBackground(Color.RED);
		lblRed.setBounds(222, 169, 46, 14);
		contentPane.add(lblRed);
		
	}
}
