package advanced;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;

public class FormPanel extends JPanel implements ActionListener {
	private TextField name;
	private TextField occupation;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JButton jButton;
	private JList ageList;
	private FormEvent formevent;
	private String username;
	private String occupationName;
	private EventListener eventListener;
	private AgeCategory ageCat;
	
	
	public FormPanel ()
	{
		name =new TextField(10);
		occupation=new TextField(10);
		jButton=new JButton("register");
		jButton.addActionListener(this);
		
///////////jlist///////////////		
		ageList=new JList();
		DefaultListModel ageModal=new DefaultListModel();
		ageModal.addElement(new AgeCategory(0, "under 18"));
		ageModal.addElement(new AgeCategory(1, "between 18 and 30"));
		ageModal.addElement(new AgeCategory(2, "between 30 and 40"));
		ageModal.addElement(new AgeCategory(3, "between 40 and 60"));
		ageList.setModel(ageModal);
		ageList.setPreferredSize(new Dimension(112, 80));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		

//////////jlabel////////////////////////////
		occupationLabel=new JLabel("Occupation");
		Dimension diml=getPreferredSize();
		diml.width=20;
		diml.height=20;
		ImageIcon image=new ImageIcon("/Users/macbook/Documents/icons/nameicon.png");
		nameLabel=new JLabel(image);
		
		
		
		
		Dimension dim=getPreferredSize();
		dim.width=300;
		setPreferredSize(dim);
		setBackground(Color.BLUE);
		Border innerbBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		Border outer=BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createCompoundBorder(outer, innerbBorder));
		GridBagLayout gBL=new GridBagLayout();
		setLayout(gBL);
		GridBagConstraints gBC=new GridBagConstraints();
		gBC.fill=GridBagConstraints.NONE;
		
/////////////////row1///////////////////////////		
		gBC.gridx=0;
		gBC.gridy=0;
		gBC.weightx=1;
		gBC.weighty=0.05;
		gBC.anchor=GridBagConstraints.FIRST_LINE_START;//defines how the components are positioned.
		add(nameLabel,gBC);
		
		
		gBC.gridx=1;
		gBC.gridy=0;
		add(name,gBC);
		
		
/////////////////row2///////////////////////////		
gBC.weightx=1;
gBC.weighty=0.05;
gBC.gridx=0;
gBC.gridy=1;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;
add(occupationLabel,gBC);


gBC.gridx=1;
gBC.gridy=1;
add(occupation,gBC);		
		
/////////////////row3///////////////////////////
gBC.weightx=1;
gBC.weighty=0.2;
gBC.gridx=1;
gBC.gridy=2;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;
add(ageList,gBC);



/////////////////row4///////////////////////////
gBC.weightx=1;
gBC.weighty=2.5;
gBC.gridx=1;
gBC.gridy=2;
gBC.anchor=GridBagConstraints.LAST_LINE_START;
add(jButton,gBC);

	}

	/**
	 * 
	 */
	
	public void actionPerformed(ActionEvent e) {
		
	 username=name.getText();
	 occupationName=occupation.getText();
	 ageCat=(AgeCategory)ageList.getSelectedValue();
	 //System.out.println(ageCat);
	//formevent =new FormEvent(this, username,occupationName);
	formevent=new FormEvent(this, username, occupationName, ageCat.id);
	
	if(eventListener!= null)
	{  eventListener.eventOccured(formevent);                      }
		
		
	}
public void formEventlistener(EventListener eventListener)//accepts an eventlistener and initializes the field variable.
{   this.eventListener=eventListener; 
	
}
 ///////////////// inner class///////////////////////
private class AgeCategory
{
	private int id;
	private String name;
 public AgeCategory(int id,String name)
 {
	this.setId(id);
	this.setName(name);
	 
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 public String toString()
 {
	return name; 
	 
 }
}

}
