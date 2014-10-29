package basic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class Toolbar extends JPanel {
	protected JButton jbutton1;
	protected JButton jbutton2;
public Toolbar(){
setLayout(new FlowLayout(FlowLayout.LEFT));
jbutton1 =new JButton("login");
jbutton2=new JButton("logout");
add(jbutton1);
add(jbutton2);
jbutton1.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("You have clickec login");
		
	}
})	;
jbutton2.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("you have clicked log out");
		
	}
});
	
	
}
	/**
	 * @param args
	 */
	
}
