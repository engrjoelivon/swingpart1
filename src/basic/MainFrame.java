package basic;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 6751427954659386896L;
	private static TextPanel textPanel;
	private static Toolbar  toolBar;
	private JButton jbutton;
public   MainFrame(){
	super("hello world");
    setLayout(new BorderLayout());
    toolBar=new Toolbar();
    textPanel=new TextPanel();
    jbutton=new JButton("click me");
    
    jbutton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			textPanel.addText("hello \n");
			
		}
	});
    add(textPanel, BorderLayout.CENTER);
    add(toolBar, BorderLayout.NORTH);
    add(jbutton,BorderLayout.SOUTH);
	this.setSize(300, 300);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 
	}

public static void main(String arg[])
{
	new MainFrame();
	 
}	
	

}
