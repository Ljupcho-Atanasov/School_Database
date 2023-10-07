
public class Person implements Comparable <Person>{			

	private String name;
	private int birthYear;
//------------CONSTRUCTORS-----------------------------------------------------------
	public Person() {
		name = "";
		birthYear = 0;
	}
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;		
	}
//------------@Override--------------------------------------------------------------	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person o = (Person) obj;
			if (this.name.equals(o.getName()) && this.birthYear == o.getBirthYear()) 
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Person: Name: %30s | Birth Year: %4d", this.name, this.birthYear);
	}
	
	@Override
	public int compareTo(Person p) {
		if(this.birthYear > p.getBirthYear()) return 1;
		else if (this.birthYear == p.getBirthYear()) return 0;
		else return -1;

	}
	
	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	
}
