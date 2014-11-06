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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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
	private JComboBox employTypes;
	private JCheckBox citizenCheck;
	private TextField taxcheckField;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private ButtonGroup  buttonGroup;
	
	
	public FormPanel ()
	{
///////////   text fields and buttons///////////////////////////////
		name =new TextField(10);
		occupation=new TextField(10);
		taxcheckField =new TextField(10);
		citizenCheck=new JCheckBox();
		taxcheckField.setEnabled(false);
		jButton=new JButton("register");
		jButton.addActionListener(this);
		citizenCheck.addActionListener(this);
		
//////////radioButton////////////
  maleButton=new JRadioButton();
  femaleButton=new JRadioButton();
  buttonGroup=new ButtonGroup();
  buttonGroup.add(femaleButton);
  buttonGroup.add(maleButton);
  maleButton.setSelected(true);
  maleButton.setActionCommand("MALE"); //this is used to set an identifier for the button and can be retrived when form is submitted	
  femaleButton.setActionCommand("FEMALE")	;
		
		
		
		
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
		
		
//////////jcomboBox///////////////////////
		employTypes=new JComboBox();
		DefaultComboBoxModel dCBM=new DefaultComboBoxModel();
		dCBM.addElement("Engineer");
		dCBM.addElement("Programmer");
		dCBM.addElement("Economist");
		dCBM.addElement("Designer");
		employTypes.setModel(dCBM);
		
		
		
		Dimension dim=getPreferredSize();
		dim.width=300;
		setPreferredSize(dim);
		setBackground(Color.BLUE);
		//Border innerbBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		Border innerBorder=BorderFactory.createTitledBorder("Person Form");
		
		Border outer=BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createCompoundBorder(outer, innerBorder));
		layoutHandler();

	}
                         ////////////defined the layoout///////////////////////
	public void layoutHandler()
	{
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



/////////////////row4 Jcombo///////////////////////////
gBC.weightx=1;
gBC.weighty=0.2;
gBC.gridx=1;
gBC.gridy=3;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;


add( employTypes,gBC);


gBC.gridx=0;
gBC.gridy=3;

add( new JLabel("JCombo"),gBC);

///////////////////row 5 jcheckbox/////////////////////////
gBC.weightx=1;
gBC.weighty=0.2;
gBC.gridx=1;
gBC.gridy=4;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;


add(citizenCheck ,gBC);


gBC.gridx=0;
gBC.gridy=4;

add( new JLabel("JCheckBox"),gBC);


/////////////////row 6///////////////////////
gBC.weightx=1;
gBC.weighty=0.2;
gBC.gridx=1;
gBC.gridy=5;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;


add( taxcheckField,gBC);


gBC.gridx=0;
gBC.gridy=5;

add( new JLabel("TaxNumber"),gBC);



/////////////////row 7   JradioButton///////////////////////
gBC.weightx=1;
gBC.weighty=0.03;
gBC.gridx=1;
gBC.gridy=6;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;
add( maleButton,gBC);


gBC.gridx=0;
gBC.gridy=6;

add( new JLabel("Radio Buttons"),gBC);


/////////////////row 8   ///////////////////////
gBC.weightx=1;
gBC.weighty=0.2;
gBC.gridx=1;
gBC.gridy=7;
gBC.anchor=GridBagConstraints.FIRST_LINE_START;


add( femaleButton,gBC);



/////////////////row9///////////////////////////
gBC.weightx=1;
gBC.weighty=2.5;
gBC.gridx=1;
gBC.gridy=8;
gBC.anchor=GridBagConstraints.LAST_LINE_START;
add(jButton,gBC);
		
		
	}
	
	//////////////////////ACTION PERFORMED IMPLEMENTATION////////////////////
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jButton)
		{
		
	 username=name.getText();
	 occupationName=occupation.getText();
	 ageCat=(AgeCategory)ageList.getSelectedValue();
	 String jcomboSelection=(String)employTypes.getSelectedItem();
	 //formevent =new FormEvent(this, username,occupationName);
	 //formevent=new FormEvent(this, username, occupationName, ageCat.id);
	formevent=new FormEvent(this, username, occupationName, ageCat.id,buttonGroup.getSelection().getActionCommand(),jcomboSelection);
	
	if(eventListener!= null)
	{  eventListener.eventOccured(formevent); }                     }
		else
			{
			
			taxcheckField.setEnabled(citizenCheck.isEnabled());
			}
		
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
