package TrainController;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "static-access" })
public class TrainPanel extends JPanel implements ActionListener{
	
		private TrainController controller;
		private JComboBox<String> trainBox;
		
		TrainPanel(TrainController p_controller){
			super();
			this.setLayout(new GridLayout(1,1));
			this.setPreferredSize(new Dimension(400, 50));
			
			this.controller = p_controller;
			this.trainBox = new JComboBox<String>(controller.trainIDArray);
			trainBox.addActionListener(this);
			
			this.add(trainBox);
		}

		void UpdateTrainBox(){
			JComboBox<String> newTrainBox = new JComboBox<String>(controller.trainIDArray);
			newTrainBox.addActionListener(this);
			this.removeAll();
			this.add(newTrainBox);
			this.revalidate();
		}
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
}