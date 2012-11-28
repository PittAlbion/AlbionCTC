//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class TrackPanel extends JPanel{
	//panel for holding track info panels
	private LogPanel log;
	private String route;
	TrackPanel(String name, LogPanel logPanel){
		super();
		route = name;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		log = logPanel;
		
		this.add(new TrackStatPanel(route,0,log));
	}

}
