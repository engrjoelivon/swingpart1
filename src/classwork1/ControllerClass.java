package classwork1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.apple.eawt.Application;

public class ControllerClass extends JFrame {
	private Entry entry;
	private Screen screen;
	
 public ControllerClass()
 {
	 super("Age Calculator");
	 entry=new Entry();
	 screen=new Screen();
	 entry.setTextField(new ControllerInterface() {
		
		public void textSent(String text) {
	      screen.setText(text);
			
			
		}
	});
	 Dimension dim=getPreferredSize();
	 dim.height=400;
	 dim.width=500;
	 setLayout(new BorderLayout());
	 add(entry, BorderLayout.NORTH);
	 add(screen,BorderLayout.SOUTH);
	 Application.getApplication().setDockIconImage(new ImageIcon("/Users/macbook/Documents/icons/unnamed.png").getImage());
	 setVisible(true);
	 //setSize(600,500);
	 setMinimumSize(dim);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 
 }

	
	public static void main(String[] args) {
		new ControllerClass();

	}

}
