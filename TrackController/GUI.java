package TrackController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable genTable;
	private JTable advTable;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JPanel outputPanel = new JPanel();
	private JTextField occupancy;
	private JTextField direction;
	private JTextField speedLimit;
	private JTextField heater;
	private JTextField trackTemp;
	private JTextField thermostat;
	private JTextField state;
	private JButton activate;
	private JButton deactivate;
	private JButton switcher;
	private JComboBox<String> controllerList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void start(){
		setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		initGUI();
	}
	private void initGUI() {
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("Track Controller");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790, 410);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu fileMenu = new JMenu("File");
		menu.add(fileMenu);
		
		JMenuItem mntmRunPlc = new JMenuItem("Run PLC...");
		fileMenu.add(mntmRunPlc);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(this);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		fileMenu.add(mntmExit);
		
		JMenu helpMenu = new JMenu("Help");
		menu.add(helpMenu);
		
		JMenuItem mntmDocumentation = new JMenuItem("Documentation");
		helpMenu.add(mntmDocumentation);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(this);
		helpMenu.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane statsPanel = new JTabbedPane(JTabbedPane.TOP);
		statsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel commandPanel = new JPanel();
		commandPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(373))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(outputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectionPanel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(commandPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(59))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(commandPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(selectionPanel, GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(statsPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addComponent(outputPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addGap(190))
		);
		outputPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		activate = new JButton("Activate Crossing");
		
		deactivate = new JButton("Deactivate Crossing");
		
		switcher = new JButton("Activate Switch");
		GroupLayout gl_commandPanel = new GroupLayout(commandPanel);
		gl_commandPanel.setHorizontalGroup(
			gl_commandPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_commandPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(activate)
					.addGap(18)
					.addComponent(deactivate)
					.addGap(18)
					.addComponent(switcher)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_commandPanel.setVerticalGroup(
			gl_commandPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_commandPanel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_commandPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(activate)
						.addComponent(deactivate)
						.addComponent(switcher))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		commandPanel.setLayout(gl_commandPanel);
		
		JLabel label_5 = new JLabel("Current Track Controller");
		
		controllerList = new JComboBox<String>();
		controllerList.addActionListener(this);
		GroupLayout gl_selectionPanel = new GroupLayout(selectionPanel);
		gl_selectionPanel.setHorizontalGroup(
			gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_selectionPanel.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(label_5)
					.addGap(38))
				.addGroup(gl_selectionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(controllerList, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_selectionPanel.setVerticalGroup(
			gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_selectionPanel.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(controllerList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		selectionPanel.setLayout(gl_selectionPanel);
		
		occupancy = new JTextField();
		occupancy.setHorizontalAlignment(SwingConstants.CENTER);
		occupancy.setEditable(false);
		occupancy.setColumns(10);
		
		direction = new JTextField();
		direction.setHorizontalAlignment(SwingConstants.CENTER);
		direction.setEditable(false);
		direction.setColumns(10);
		
		speedLimit = new JTextField();
		speedLimit.setHorizontalAlignment(SwingConstants.CENTER);
		speedLimit.setEditable(false);
		speedLimit.setColumns(10);
		
		heater = new JTextField();
		heater.setHorizontalAlignment(SwingConstants.CENTER);
		heater.setEditable(false);
		heater.setColumns(10);
		
		trackTemp = new JTextField();
		trackTemp.setHorizontalAlignment(SwingConstants.CENTER);
		trackTemp.setEditable(false);
		trackTemp.setColumns(10);
		
		thermostat = new JTextField();
		thermostat.setHorizontalAlignment(SwingConstants.CENTER);
		thermostat.setEditable(false);
		thermostat.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		
		JLabel lblOccupied = new JLabel("   Occupied?");
		
		JLabel lblDirection = new JLabel("Direction");
		
		JLabel lblTrackSpeedLimit = new JLabel("Track Speed Limit");
		
		JLabel lblHeaterStatus = new JLabel("Heater Status");
		
		JLabel lblTrackTemperature = new JLabel("     Track Temp");
		
		JLabel lblThermostat = new JLabel("Thermostat");
		
		state = new JTextField();
		state.setHorizontalAlignment(SwingConstants.CENTER);
		state.setEditable(false);
		state.setColumns(10);
		GroupLayout gl_outputPanel = new GroupLayout(outputPanel);
		gl_outputPanel.setHorizontalGroup(
			gl_outputPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_outputPanel.createSequentialGroup()
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblState))
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(occupancy, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblOccupied)))
					.addGap(29)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_outputPanel.createSequentialGroup()
							.addComponent(direction, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, gl_outputPanel.createSequentialGroup()
							.addComponent(lblDirection)
							.addGap(31)))
					.addGap(26))
				.addGroup(gl_outputPanel.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addComponent(lblTrackTemperature)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(lblThermostat)
							.addGap(19))
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addComponent(trackTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(thermostat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_outputPanel.createSequentialGroup()
							.addGroup(gl_outputPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTrackSpeedLimit)
								.addComponent(speedLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addGroup(gl_outputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(heater, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_outputPanel.createSequentialGroup()
									.addComponent(lblHeaterStatus)
									.addGap(11)))))
					.addGap(80))
		);
		gl_outputPanel.setVerticalGroup(
			gl_outputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_outputPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDirection)
						.addComponent(lblState)
						.addComponent(lblOccupied))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(direction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(state, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(occupancy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeaterStatus)
						.addComponent(lblTrackSpeedLimit))
					.addGap(7)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(heater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(speedLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrackTemperature)
						.addComponent(lblThermostat))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(thermostat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(trackTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		outputPanel.setLayout(gl_outputPanel);
		
		JScrollPane genTableHolder = new JScrollPane();
		statsPanel.addTab("General", null, genTableHolder, null);
		
		genTable = new JTable();
		genTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		genTable.setEnabled(false);
		genTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Block Size", 0},
				{"Grade", 0},
				{"Elevation", 0},
				{null, null},
				{null, null},
			},
			new String[] {
				"Property", "Value"
			}
		));
		genTableHolder.setViewportView(genTable);
		
		JScrollPane advTableHolder = new JScrollPane();
		statsPanel.addTab("Advanced", null, advTableHolder, null);
		
		advTable = new JTable();
		advTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		advTable.setEnabled(false);
		advTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Type", 0},
				{"Mode", 0},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Property", "Value"
			}
		));
		advTableHolder.setViewportView(advTable);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mntmExit))
			System.exit(0);
		else if (e.getSource().equals(mntmAbout)){
			new AboutDialog();
		}
		else if(e.getSource().equals(controllerList)){
			TrackController t = TrackController.controlList.get(controllerList.getSelectedIndex());
			updateOutputPanel(t);
		}
	}
	
	public void updateOutputPanel(TrackController t){
		if (t.type == 0){
			genTable.setValueAt(t.greenList.get(0).block_length, 0, 1);
			advTable.setValueAt("Switch", 0, 1);
			advTable.setValueAt("Off", 1, 1);
			switcher.setEnabled(true);
			activate.setEnabled(false);
			deactivate.setEnabled(false);
		}
		else if (t.type == 1){
			genTable.setValueAt(t.greenList.get(0).block_length, 0, 1);
			advTable.setValueAt("Crossing", 0, 1);
			advTable.setValueAt("Off", 1, 1);
			switcher.setEnabled(false);
			activate.setEnabled(true);
			deactivate.setEnabled(false);
		}
			
			
		setOccupancy(t.occupied);
		setSpeedLimit(t.speedLimit);
		setHeater(t.heater);
		setState(t.state);
		setDirection(t.direction);
		setTrackTemp(t.trackTemp);
		setThermostat(t.thermostatTemp);
	}
	
	public void setOccupancy(boolean b){
		if (b)
			occupancy.setText("Yes");
		else
			occupancy.setText("No");
	}
	
	public void setSpeedLimit(double x){
		speedLimit.setText(Double.toString(x) + "m/s");
	}
	
	public void setHeater(boolean b){
		if (b)
			heater.setText("On");
		else
			heater.setText("Off");
	}
	
	public void setState(int i){
		if (i == 0)
			state.setText("Normal");
		else if(i == 1)
			state.setText("Switching");
		else
			state.setText("Broken");
	}
	
	public void setDirection(boolean b){
		if (b)
			direction.setText("A-Z");
		else
			direction.setText("Z-A");
	}
	
	public void setTrackTemp(double x){
		trackTemp.setText(Double.toString(x) + "°C");
	}
	
	public void setThermostat(double x){
		thermostat.setText(Double.toString(x) + "°C");
	}
	
	public void addToList(String t){
		controllerList.addItem(t);
	}

}
