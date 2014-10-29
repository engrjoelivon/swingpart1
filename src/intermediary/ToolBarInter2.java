package intermediary;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBarInter2 extends JPanel implements ActionListener {
	JButton jbutton5;
	JButton jbutton6;
	private TextControllerInterface textcontroller;
	
	
	public ToolBarInter2()
	{
		
		jbutton5 =new JButton("inout5");
		jbutton6=new JButton("output6");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(jbutton5);
		add(jbutton6);
		jbutton5.addActionListener(this);
		jbutton6.addActionListener(this);
		
	}
 
	
	
	
	
	public void stringListener(TextControllerInterface textcontroller )
	{
	 this.textcontroller=textcontroller;	
		
	}

	
	public void actionPerformed(ActionEvent e) {
		JButton button=(JButton)e.getSource();
		if(button==jbutton5)
		{ if(textcontroller != null)//checks to ensure the interface has been 
		{
			
			
			textcontroller.textEmitted("hello input5\n");
		}   }
		else
		{ if(textcontroller != null){
			
			
			textcontroller.textEmitted("hello input6\n");      }
		
	}

}}
