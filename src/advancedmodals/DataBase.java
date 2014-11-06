package advancedmodals;
/*This class is defined to hold informations about persons acting more as a database*/
import java.util.ArrayList;
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
	
	
return people;	
}
}
