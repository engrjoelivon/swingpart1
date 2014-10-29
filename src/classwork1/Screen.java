package classwork1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Screen extends JPanel {
	private TextArea tA;
 public Screen(){
	 Dimension dim=new Dimension();
	 dim.height=180;
	 this.setPreferredSize(dim);
	 setBackground(Color.cyan);
	tA=new TextArea();
	
	setLayout(new BorderLayout());
	add(tA, BorderLayout.CENTER);
	
	 
 }

public void setText(String text)
{
	
	tA.setText(text);
}	

}
