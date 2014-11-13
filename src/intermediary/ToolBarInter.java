package intermediary;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



public class ToolBarInter extends JPanel  implements ActionListener {
	JButton jbutton3;
	JButton jbutton4;
	private Textpanelinter textpanelinter;
	
	public ToolBarInter()
	{
		super();
		setBorder(BorderFactory.createEtchedBorder());
		jbutton3 =new JButton("inout");
		jbutton4=new JButton("output");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(jbutton3);
		add(jbutton4);
		jbutton3.addActionListener(this);
		jbutton4.addActionListener(this);
		
	}

	/**
	 * @param args
	 */
public void setTextPanel(Textpanelinter textpanelinter)//interface to link communication between this panel and the controller panel
{
	this.textpanelinter=textpanelinter;

}




	

public void actionPerformed(ActionEvent e) {
	JButton clicked=(JButton)e.getSource();//the get source method returns an object because we know it can only return one of JBbutton objects we then cast it to JButon
	if(clicked==jbutton3)
	{  textpanelinter.appendtext("You just clicked ion input \n") ;                              }
	else
		textpanelinter.appendtext("You just clicked ion output \n");
		
		
	}
}