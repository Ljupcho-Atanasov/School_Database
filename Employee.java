
public class Employee extends Person implements Comparable <Person> {
	
	private String deptName;
	private static int numEmployees = 0;
	private int employeeID;     // needs to be generated   !!!
	
	
//-----------@Override methods----------------------------------------------------------	
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Employee) {
				Employee o = (Employee) obj;
				if (this.deptName.equals(o.getDeptName()) && this.employeeID == o.getEmployeeID() 
						&& super.equals(o))
						return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return String.format( super.toString() + " Employee: Department: %20s | Employee Number: %3d", this.deptName, this.employeeID);
					
		}
		
		@Override
		public int compareTo (Person p) {
			Employee p1 = (Employee) p;
			if (this.employeeID > p1.getEmployeeID()) return 1;
			else if (this.employeeID == p1.getEmployeeID()) return 0;
			else return -1;
		}
		
		
//----------CONSTRUCTORS---------------------------------------------------------------	
	public Employee()	{
		
		super();
		this.deptName = "";
		this.employeeID = ++numEmployees;		
	}
	
	public Employee(String deptName) {  
		
		this();
		this.deptName = deptName;
		//this.employeeID = ++numEmployees;
	}
	
	public Employee(String name, int birthYear, String deptName) {
	
		super(name, birthYear);
		this.deptName = deptName;
		this.employeeID = ++numEmployees; 
	}
	
	
	
//-----------GETTERS AND SETTERS-------------------------------------------------------
	
	public static int getNumEmployees() {
		return numEmployees;
	}

	public String getDeptName() {
		return this.deptName;
	}
	
	public int getEmployeeID() {
		return this.employeeID;    
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
