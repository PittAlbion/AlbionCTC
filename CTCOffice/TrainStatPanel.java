package CTCOffice;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class TrainStatPanel extends JPanel implements ActionListener{
	
	private JButton editButton;
	private String title;
	
	public TrainStatPanel(String name){
		super();
		title = name;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150,300));
		this.setMaximumSize(this.getPreferredSize());
		this.setBorder(new TitledBorder(title));
		
		
		editButton = new JButton("Edit");
		editButton.addActionListener(this);
		this.add(editButton);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource().equals(editButton)){
			System.out.println(title);
		}
		
	}

}
