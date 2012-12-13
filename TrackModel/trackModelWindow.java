package TrackModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		JButton btnDownloadGreenTrack = new JButton("Upload Green Track");
		btnDownloadGreenTrack.setBounds(10, 11, 163, 23);
		btnDownloadGreenTrack.addActionListener(new ActionListener() {
	    	 
	        public void actionPerformed(ActionEvent e)
	        {
	            //Execute when button is pressed
	            System.out.println("You clicked the green button");
	            txtrGreenTrackDownloaded.setVisible(true);
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
		JButton btnDownloadRedTrack = new JButton("Upload Red Track");
		btnDownloadRedTrack.setBounds(10, 45, 163, 23);
		btnDownloadRedTrack.addActionListener(new ActionListener() {
			  
	          public void actionPerformed(ActionEvent e)
	          {
	              //Execute when button is pressed
	              //System.out.println("You clicked the red button");
	             txtrRedTrackDownloaded.setVisible(true);
	              try {
	  				trackModel.buildGreenList("reddata.txt");
	  				
	  				
	  			} catch (IOException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			}
	          }
	      });   
		contentPane.add(btnDownloadRedTrack);
		
		
		
		
		//create combo box for train color
		//JComboBox comboBox = new JComboBox();
		//comboBox.setBounds(21, 121, 28, 20);
		//contentPane.add(comboBox);
		
		//create combo box for track block
		//JComboBox comboBox_1 = new JComboBox();
		//comboBox_1.setBounds(68, 121, 28, 20);
		//contentPane.add(comboBox_1);
		
		//create table to display properties
		
		
		table = new JTable();
		table.setBounds(238, 110, 168, 141);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(20, 163, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Turn On/Off Heater");
		btnNewButton.setBounds(10, 228, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Broken Rail");
		btnNewButton_1.setBounds(10, 194, 136, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrEnterBlockNumber = new JTextArea();
		txtrEnterBlockNumber.setText("Enter Block Number");
		txtrEnterBlockNumber.setBackground(Color.gray);
		txtrEnterBlockNumber.setBounds(20, 130, 163, 22);
		contentPane.add(txtrEnterBlockNumber);
		
	}
}
