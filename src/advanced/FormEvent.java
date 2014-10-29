package advanced;

import java.util.EventObject;


public class FormEvent extends EventObject //EventObject constructor accepts an object called source for that we must declare a constrcutor and pass in a source
{
private String name;
private String Occupation;
private int id;
private String comboselection;
private String radioButtonSelection;

	
	public FormEvent(Object source ) {
		super(source);
		// TODO Auto-generated constructor stub
	}
 public FormEvent (Object source,String name,String occupation)
 {
	super(source);
	this.setName(name);
	this.setOccupation(occupation);
	 
 }
 
 public FormEvent (Object source,String name,String occupation,int id)
 {
	super(source);
	this.setName(name);
	this.setOccupation(occupation);
	this.setId(id);
	 
 }
 public FormEvent (Object source,String name,String occupation,int id,String radioButtonSelection,String JcomboSelection)
 {
	super(source);
	this.setName(name);
	this.setOccupation(occupation);
	this.setId(id);
	this.comboselection=JcomboSelection;
	this.radioButtonSelection=radioButtonSelection;
	 
 }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getOccupation() {
	return Occupation;
}
public void setOccupation(String occupation) {
	Occupation = occupation;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getComboselection() {
	return comboselection;
}
public void setComboselection(String comboselection) {
	this.comboselection = comboselection;
}
public String getRadioButtonSelection() {
	return radioButtonSelection;
}
public void setRadioButtonSelection(String radioButtonSelection) {
	this.radioButtonSelection = radioButtonSelection;
}
	
	

}
