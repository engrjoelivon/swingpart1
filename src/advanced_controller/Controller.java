package advanced_controller;

import advanced.FormEvent;
import advancedmodals.AgeCategory;
import advancedmodals.DataBase;
import advancedmodals.EmploymentCat;
import advancedmodals.Gender;
import advancedmodals.Person;

public class Controller {
		
	public Controller(){}
	public void addPerson(FormEvent eV)
	{
		DataBase db=new DataBase();
		String name=eV.getName();
		String Occupation=eV.getOccupation();
		String comboSelection=eV.getComboselection();//serving as employment
		String radioButtonsel=eV.getRadioButtonSelection();//serving as gender
		int id =eV.getId();//serving as ageCategory
		//converting int from ageCat to enumeration for the person class//
		 AgeCategory ageCat;
		 
		 switch(id)
		 {
		 case 0:{ageCat=AgeCategory.CHILD;break;}
		 case 1:{ ageCat=AgeCategory.YOUTH;      break;}
		 case 2:{ ageCat=AgeCategory.ADULT;      break;}
		 case 3:{ ageCat=AgeCategory.SENIOR;      break;}
		 default:{ageCat=null;         break;}
		 }
		 
		//converting string from comboSelection to employmentenumeration for the person class//
		  EmploymentCat employmentCat;
		 if(comboSelection=="Engineer")
		 { employmentCat = EmploymentCat.ENGINEER; }
		 else if(comboSelection=="Designer")
		 {
			 employmentCat = EmploymentCat.DESIGNER; 
		 }
		 else if(comboSelection=="Programmer")
		 {
			 employmentCat = EmploymentCat.PROGRAMMER; 
		 }
		 else if(comboSelection=="Economist")
		 {
			 employmentCat = EmploymentCat.ECONOMIST; 
		 }
		 else
		 { employmentCat=EmploymentCat.OTHER;     System.err.println(comboSelection);}
		//converting string from radioButtongender to genderenumeration for the person class//
		 Gender gender;
		 
		 if(radioButtonsel=="MALE")
		 { gender=Gender.MALE;       }
		 else
		 {gender=Gender.FEMALE;}
		 
		Person person=new Person(ageCat, name, employmentCat, true, gender);
		db.addPerson(person);
				
		
		
		
		
	}
	

}
