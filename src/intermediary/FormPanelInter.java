package intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
/*A simple gui panel is defined,the panels contains two textfield inputs,it accepts parameter from a user an sends this paramter to 
 * a controller class,through an interface.It implements the actionListener interface,and invokes a button that listens for action
 * performed to this gui panel.
 * The actionperformed method is invoked when the button is clicked,it takes the interface that must have been initialized and
 * uses it to invoke its method,thereby passing in the text to be sent.
 * 
 * */
public class FormPanelInter extends JPanel implements ActionListener {
	private JLabel namejlabel;
	private JLabel occupationLabel;
	private TextField nameField;
	private TextField occupation;
	private JButton okbutton;
	private TextControllerInterface textControllerInterface;
	public FormPanelInter()
	{   namejlabel =new JLabel("Name");
	    occupationLabel= new JLabel("Occupation");
	    nameField =new TextField( 10);
	    occupation=new TextField(10);
	    
	    okbutton=new JButton("Enter");
	    okbutton.addActionListener(this);
	    
		
 
		Border border=BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border innBorder=BorderFactory.createTitledBorder("Form");
		
		setBorder(BorderFactory.createCompoundBorder(border, innBorder));
		//Dimension dim=getPreferredSize();
		Dimension dim=new Dimension();
		 dim.width=300;
		 this.setPreferredSize(dim);
		 setBackground(new Color(180,100,200));
		 setLayout(new GridBagLayout());
		 GridBagConstraints gc=new GridBagConstraints();
		 gc.fill=GridBagConstraints.NONE;
		 
		 //////first row//////////////////////////////
		 gc.gridx=0;
		 gc.gridy=0;
		 gc.weightx=1;
		 gc.weighty=0.1;
		 gc.anchor=GridBagConstraints.LINE_START;
		 add(namejlabel, gc);
		 
		
		 gc.gridx=1;
		 gc.gridy=0;
		 gc.anchor=GridBagConstraints.LINE_END;
		add(nameField,gc);
		
		
		 ///////second row//////////////////////////////
		gc.weightx=1;
		 gc.weighty=0.1;
	    gc.gridx=0;
		 gc.gridy=1;
		 gc.anchor=GridBagConstraints.LINE_START;
		add(occupationLabel, gc);
		
		gc.gridx=1;
		 gc.gridy=1;
		 gc.anchor=GridBagConstraints.LINE_END;
		add(occupation, gc);
		
		 //////Third row//////////////////////////////
		gc.weightx=1;
		 gc.weighty=2.0;
		gc.gridx=1;
		 gc.gridy=2;
		 gc.anchor=GridBagConstraints.LINE_START;
		add(okbutton, gc);
	
		
		
	}
public void stringListener(TextControllerInterface textCon)//To initialize the TextControllerInterface interface 

{
	this.textControllerInterface=textCon;
	
	
}
public void actionPerformed(ActionEvent e) {
	if(textControllerInterface != null)//ensure textControllerInterface has been initialized by the controller 
	{ textControllerInterface.textEmitted(nameField.getText() +" " +occupation.getText() +"\n");                           

	
	
	}
	
}

}
