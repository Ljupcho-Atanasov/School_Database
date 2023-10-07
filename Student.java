
public class Student extends Person implements Comparable <Person> {

	private static int numStudents = 0;
	private int studentID;         
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
//----------------------CONSTRUCTORS-------------------------------------------------------
	public Student( ) {		
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = false;
		this.major = "undeclared";
		this.studentID = ++numStudents;
	}
	
	public Student(boolean isGraduate) {
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = "undeclared";
		this.studentID = ++numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID = ++numStudents;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID = ++numStudents;
	}
	
//------------------GETTERS AND SETTERS-------------------------------------------------------
	public boolean isGraduate() {
		return this.isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return this.numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Course[] getCoursesTaken() {
		return this.coursesTaken;
	}
	
//-------------------LOCAL METHODS-------------------------------------------------------------
	public void addCourseTaken(Course course) {	
		if (numCoursesTaken < 50) {
		coursesTaken[numCoursesTaken] = course;
		
		++numCoursesTaken;
	}
	}
	
	public void addCoursesTaken(Course [] course) 		
	{		
		
		int j = course.length;
		if ((numCoursesTaken + course.length) < coursesTaken.length) 
			{
				for (int i = numCoursesTaken; i < (numCoursesTaken + course.length); ++i) 
				{
					coursesTaken[i] = course[course.length - j];
					--j;
				}
			}
	}
	
	public Course getCourseTaken(int index) {			
		if (index < 0 || index >= coursesTaken.length) return null;
		else {
			return coursesTaken[index];
		}
	}
	
	public String getCourseTakenAsString(int index) {	
		if (index < 0 || index >= coursesTaken.length) return "";
		else 
		{
			return coursesTaken[index].getCourseDept() + "-" + coursesTaken[index].getCourseNum();
		}
		
	}
	
	public String getAllCoursesTakenAsString() {		
		String s = "";									
		for (int i = 0; i < numCoursesTaken; ++i){     
				if (i == numCoursesTaken - 1) s += getCourseTakenAsString(i);
				else s += getCourseTakenAsString(i) + ", ";
			}
		return s;
	}
		
//-----------------------@Override-------------------------------------------------------------------------------------
	
	@Override
	public boolean equals(Object obj) {					
		if (obj instanceof Student) {
			Student s = (Student) obj;
			    if    (this.numCoursesTaken == s.getNumCoursesTaken() 
					&& this.isGraduate == s.isGraduate()
					&& this.getAllCoursesTakenAsString().equals(s.getAllCoursesTakenAsString())
					&& this.major.equals(s.getMajor())
					&& this.studentID == s.getStudentID()
					&& super.equals(s))
			    	return true;
		}
		return false;
	}
	
	@Override
	public String toString() {  
		String grad = "";
		if (this.isGraduate) grad = "Graduate"; else grad = "Undergraduate";
		return String.format( super.toString() + " Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s"
				                                           ,studentID,        major,       grad,  numCoursesTaken,              this.getAllCoursesTakenAsString());
	}
	
	@Override
	public int compareTo(Person p) {					
		Student p1 = (Student) p;
		if (this.getNumCredits(this.coursesTaken, this.numCoursesTaken) > p1.getNumCredits(p1.getCoursesTaken(), p1.getNumCoursesTaken()))
			return 1;
		else if (this.getNumCredits(this.coursesTaken, this.numCoursesTaken) == p1.getNumCredits(p1.getCoursesTaken(), p1.getNumCoursesTaken()))
			return 0;
		else return -1;
	}

	public int getNumCredits(Course [] c, int numCoursesTaken) {
		int sum = 0;
		for (int i = 0; i < numCoursesTaken; ++i) {
			sum += c[i].getNumCredits();
		}
		return sum;
	}
}
