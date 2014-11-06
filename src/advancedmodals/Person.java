package advancedmodals;

public class Person {
	private static int count=0;
	private  int id;//will be used as key in database
	private AgeCategory age;
	private String name;
	private EmploymentCat employment;
	
	private Gender gender;
	
	private boolean usCitizen;
	
	public Person(AgeCategory age,String name,EmploymentCat employment,boolean usCitizen,Gender gender)
	{
		this.setAge(age);
		this.setName(name);
		this.setUsCitizen(usCitizen);
		this.setEmployment(employment);
		this.gender=gender;
		this.id=count;
		count++;
		
		
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	public EmploymentCat getEmployment() {
		return employment;
	}
	public void setEmployment(EmploymentCat employment) {
		this.employment = employment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AgeCategory getAge() {
		return age;
	}
	public void setAge(AgeCategory age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
