//~ CTC Office
//~ Ben Long
//~ 11/27/2012
//~ Albion
package CTCOffice;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

@SuppressWarnings("serial")
// panel for the log file to be written to
public class LogPanel extends JPanel{

	private static JTextPane textPane;
	private static Timestamp time;
	// constructor
	LogPanel(){
		super();
		this.setLayout(new BorderLayout());
		JLabel labelText = new JLabel("System Log:");
		this.add(labelText, BorderLayout.PAGE_START);
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setPreferredSize(new Dimension(100,150));
		textPane.setContentType("text/html");
		
		this.add(textPane,BorderLayout.CENTER);
		time = new Timestamp(System.currentTimeMillis());

	}
	
	//add new messages to the system log
	public static void UpdateLog(String logMessage){
		SimpleAttributeSet format = new SimpleAttributeSet();
		StyledDocument doc = textPane.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), "\n" + logMessage, format);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Save the log to a file
	@SuppressWarnings("deprecation")
	public static void Save(){
		try {
			// setup file name for writing long
			StringBuilder fileName = new StringBuilder("../Logs/log:");
			fileName.append("["+time.getYear() + 1900+"]");
			fileName.append("["+time.getMonth()+"]");
			fileName.append("["+time.getDate()+"]");
			fileName.append("["+time.getHours()+".");
			fileName.append(time.getMinutes()+".");
			fileName.append(time.getSeconds()+"]");
			fileName.append(".html");
			File logFile = new File(fileName.toString());
			logFile.createNewFile();
			FileWriter file = new FileWriter(logFile);
			HTMLDocument doc = (HTMLDocument)textPane.getDocument();
			HTMLWriter writer = new HTMLWriter(file,doc);
			
			writer.write();			
			time = new Timestamp(System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
