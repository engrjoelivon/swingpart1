package classwork1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.Border;


public class Entry extends JPanel implements ActionListener{
	private TextField textfield;
	private JLabel textLabel;
	private JButton enterButton;
	private ControllerInterface cI;
	public Entry()
	{
		Dimension dim=getPreferredSize();
		dim.height=200;
		dim.width=300;
		this.setPreferredSize(dim);
		Border border=BorderFactory.createEmptyBorder(5, 5, 5, 5);
	   Border innBorder=BorderFactory.createTitledBorder("ENTRY");
		
		setBorder(BorderFactory.createCompoundBorder(border, innBorder));
     textfield=new TextField(10);
     textLabel=new JLabel("Year Of Birth");
     enterButton =new JButton("Submit");
     enterButton.addActionListener(this);
     setLayout(new FlowLayout(FlowLayout.LEFT));
      setBackground(Color.ORANGE) ;
     add(textLabel);
     add(textfield);
     add(enterButton);
	}
	public void setTextField(ControllerInterface cI)
	{
		this.cI=cI;
		
	}
	public void actionPerformed(ActionEvent e) {
		Integer inte=new Integer(textfield.getText());
		int a=inte.intValue();
		
		
		cI.textSent("You are "	+(2014-a)+" years old ");
	}

	

}
