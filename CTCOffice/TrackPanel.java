package CTCOffice;

import java.awt.FlowLayout;

import javax.swing.*;

public class TrackPanel {
	
	public static JPanel CreateTrackPanel(String route){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		return pane;
	}

}
