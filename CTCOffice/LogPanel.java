package CTCOffice;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogPanel {

	private static JEditorPane textPane;
	public static JPanel CreateLogPanel(){
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		JLabel labelText = new JLabel("System Log:");
		pane.add(labelText, BorderLayout.PAGE_START);
		textPane = new JEditorPane();
		textPane.setEditable(false);
		textPane.setPreferredSize(new Dimension(100,150));
		
		pane.add(textPane,BorderLayout.CENTER);
		
		return pane;
	}

}
