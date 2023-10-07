
public class GeneralStaff extends Employee {
	
	private String duty;
	
//----------------------CONSTRUCTORS--------------------------------------------
	
	public GeneralStaff()	{
		super();
		this.duty = "";
	}
	
	public GeneralStaff(String duty) {
		super();
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
//------------------------GETTER-------------------------------------------------
	public String getDuty() {
		return this.duty;
	}
//----------------------@Override------------------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GeneralStaff) {
			GeneralStaff gs = (GeneralStaff) obj;
			if (super.equals(gs) && this.duty.equals(gs.getDuty())) return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return String.format(super.toString() + " GeneralStaff: Duty: %10s", duty );
	}
	
	

}
