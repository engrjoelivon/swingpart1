package advanced;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


public class ControllerFrame extends JFrame {
	private FormPanel formpanel;
	private Display display;
	
	public ControllerFrame ()
	{
		super("Advanced");
	formpanel=new FormPanel();
	display=new Display();
	
	setTitle("Frame Icon Example");
	
    
	
	setLayout(new BorderLayout());
	add(formpanel,BorderLayout.EAST);
	add(display,BorderLayout.WEST);
	
	
	Dimension dim=getPreferredSize();
	dim.width=600;
	dim.height=500;
	formpanel.formEventlistener(new EventListener() //pass in anonymous class interface for the defined interface
	
	{
		
		public void eventOccured(FormEvent e) //Override the eventOccured method, call appropriate getters methods to pass parameters to display panel
		
		{
			Integer inte=new Integer(e.getId());
		display.displayText(e.getName()+"\n ");
		display.displayText(e.getOccupation()+ "\n ");
		display.displayText(inte.toString()+"\n ");
		display.displayText(e.getComboselection()+ "\n");
		display.displayText(e.getRadioButtonSelection()+ "\n");
			
		}
	});
	
	
	
	
	setMinimumSize(dim);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
public static void main(String [] args)
{
	new ControllerFrame();
}
	

}
