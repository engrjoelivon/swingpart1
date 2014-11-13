package advanced;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import advancedmodals.Person;


public class PersonTablemodal extends AbstractTableModel {
	private List<Person> db;
	private String[] colNames = {"ID",  "Age Category", "Name","Employment ", "Gender"};
	public PersonTablemodal(){}
	
	@Override
	public String getColumnName(int column) {
		
		return colNames[column];
	}

	public void setDb(List<Person> db)
	{
		this.db=db;
		
	}

	@Override
	public int getRowCount() {
		
		return db.size();
	}

	@Override
	public int getColumnCount() {
		
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Person person=db.get(rowIndex);
		switch(columnIndex)
		{
		case 0:{return person.getId();}
		case 1:{return person.getAge();}
		case 2:{return person.getName();}
		case 3:{return person.getEmployment();}
		case 4:{return person.getGender();}
		
		}
		return null;
		}
	

}
