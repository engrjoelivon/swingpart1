package advancedmodals;
/*This class is defined to hold informations about persons acting more as a database*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;








/*when the constructor loads its creates a arraylist that can hold Person object*/
public class DataBase {
	private ArrayList<Person> people;
public DataBase()
{
	people=new ArrayList<Person>();
}
/*this method add person object to the database*/
public void addPerson(Person p)
{
	
	people.add(p);
}
/*Returns a database of person*/
public List<Person> getPerson(){
	
	
return Collections.unmodifiableList(people);	//made changes,initially i returned just list,now i have passed the list into a collection method to ensure that the list can not be modifed by other classes
}
public void WriteToFile(File file) throws IOException
{
	Person [] arrofpeople=people.toArray(new Person[people.size()]);//convert from an arrayList to an array before serializing
    
	FileOutputStream fos=new FileOutputStream(file);
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	oos.writeObject(arrofpeople);
	//oos.writeObject(people);
	oos.close();

}
public void ReadFromFile(File file) throws IOException
{
   
    
	FileInputStream fis=new FileInputStream(file);
	ObjectInputStream ois=new ObjectInputStream(fis);
	 try {
		 Person[] persons = (Person[])ois.readObject();
		people.clear();
		people.addAll(Arrays.asList(persons));//convert from an array back to an array list.
		 
		 //people=(ArrayList<Person>) ois.readObject();
	
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	ois.close();

}

public void deletePerson(int row) {
	people.remove(row);
	
	
}
public void connect() throws Exception
{  try {
	Class.forName("com.mysql.jdbc.Driver");
	String uCon="jdbc:mysql://:localhost:3306/swingtext";
	Connection con=DriverManager.getConnection(uCon, "", "");
	
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	throw new Exception("class not found");
}                          }
public void disconnect()
{                                    }
}
