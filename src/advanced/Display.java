package advanced;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JTextArea;


public class Display extends JPanel  {
	private TextArea textArea;
	private JTextArea jArea;
	
	public Display()
	{
	
		textArea =new TextArea("hello");
		textArea.setBackground(Color.GRAY);
		
	Dimension dim=new Dimension();
	dim.width=300;
	dim.height=500;
	
	
	setSize(dim);
	
	setLayout(new BorderLayout());
  add(new JScrollPane(textArea) ,BorderLayout.CENTER);
	}
public void displayText(String arg)
{
	
textArea.append(arg);
}




	

}
