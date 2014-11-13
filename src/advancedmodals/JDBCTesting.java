package advancedmodals;

public class JDBCTesting {
public static void main(String [] args)
{
	DataBase db=new DataBase();
	try {
		System.out.println("Connected to database");
		db.connect();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

}
