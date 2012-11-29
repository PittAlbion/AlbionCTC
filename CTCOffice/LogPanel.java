//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;

@SuppressWarnings("serial")
// panel for the log file to be written to
public class LogPanel extends JPanel{

	private static JEditorPane textPane;
	// constructor
	LogPanel(){
		super();
		this.setLayout(new BorderLayout());
		JLabel labelText = new JLabel("System Log:");
		this.add(labelText, BorderLayout.PAGE_START);
		textPane = new JEditorPane();
		textPane.setEditable(false);
		textPane.setPreferredSize(new Dimension(100,250));
		textPane.setContentType("text");
		
		this.add(textPane,BorderLayout.CENTER);

	}
	
	//add new messages to the system log
	public void UpdateLog(String logMessage){
		SimpleAttributeSet format = new SimpleAttributeSet();
		Document doc = textPane.getDocument();
		try {
			doc.insertString(doc.getLength(), "\n" + logMessage, format);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	//Save the log to a file
	public void Save(){
		try {
			// setup file name for writing long
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "text");
			
			fileChooser.setFileFilter(filter);
			
			int valid = fileChooser.showSaveDialog(this.getParent());			
			
			File logFile = fileChooser.getSelectedFile();
			if(valid == JFileChooser.APPROVE_OPTION){
				FileWriter fileWriter = new FileWriter(logFile);
				fileWriter.write(textPane.getText());
				fileWriter.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
