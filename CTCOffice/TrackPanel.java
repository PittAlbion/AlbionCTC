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
	String route;
	TrackPanel(String name){
		super();
		route = name;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(new TrackStatPanel(route,0));
	}

}
