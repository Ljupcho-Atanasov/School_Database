
public class Faculty extends Employee implements Comparable <Person>{

	private Course[] coursesTaught;
	private int numCoursesTaught;		
	private boolean isTenured;
	
//-------------CONSTRUCTORS---------------------------------------------------
	
	public Faculty() {
		super();
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}
	
	public Faculty(boolean isTenured)	{
		super();
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		this.isTenured = isTenured;
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		this.coursesTaught = new Course[100];
		this.isTenured = isTenured;
		this.numCoursesTaught = 0;
	}
	
//----------------GETTERS AND SETTERS-----------------------------------------------
	
	public boolean isTenured() {
		return this.isTenured;
	}
	
	public int getNumCoursesTaught() {
		return this.numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
//------------------LOCAL METHODS--------------------------------------------------
	
	public void addCourseTaught(Course course) {
		if (numCoursesTaught < 100) {
		coursesTaught[numCoursesTaught] = course;
		++numCoursesTaught;
		}
	}
	
	
	
	public void addCoursesTaught(Course [] course) {	
		int j = course.length;
		if ((numCoursesTaught + course.length) < coursesTaught.length) 
		{
			for (int i = numCoursesTaught; i < (numCoursesTaught + course.length); ++i) 
			{
			coursesTaught[i] = course[course.length - j];
			--j;
			}
		}
	}
	
	
	
	public Course getCourseTaught(int index) {			
		//String s = "\"null\"";
		if (index < 0 || index >= coursesTaught.length) return null;
		return coursesTaught[index];
	}
	
	
	
	public String getCourseTaughtAsString(int index) {	
		if (index < 0 || index >= coursesTaught.length) return "";
		return coursesTaught[index].getCourseDept() + "-" + coursesTaught[index].getCourseNum();
	}
	
	
	
	public String getAllCoursesTaughtAsString() {		
		String s = "";									
		for (int i = 0; i < numCoursesTaught; ++i){     
				if (i == numCoursesTaught - 1) s += getCourseTaughtAsString(i);
				else s += getCourseTaughtAsString(i) + ", ";
			}
		return s;
	}
	
//---------------@Override---------------------------------------------------------------------------------------	
	@Override
	public boolean equals(Object obj) {	
		if (obj instanceof Faculty) {
			Faculty o = (Faculty) obj;
			if (this.getAllCoursesTaughtAsString().equals(o.getAllCoursesTaughtAsString())
					&& this.isTenured == o.isTenured 
					&& this.numCoursesTaught == o.numCoursesTaught
					&& super.equals(o)) 		
				return true;
		}
		return false;
	}
	@Override
	public String toString() {				
		String s = "";
		if (this.isTenured) s = "Is Tenured"; else s = "Not Tenured";
		
		return String.format( super.toString() + 
				" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s"  
				    ,s ,this.numCoursesTaught, this.getAllCoursesTaughtAsString());			
	}
	
	
	@Override
	public int compareTo(Person p) {	
		if (!p.getClass().equals(null)) {
		int n = 0;
		Faculty p1 = (Faculty) p;
		
			if (this.getNumCoursesTaught() > p1.getNumCoursesTaught() ) n = 1;
			else if (this.getNumCoursesTaught() == p1.getNumCoursesTaught() ) n = 0;
			else n = -1;
		return n;
		} else return 1;
	}
}
