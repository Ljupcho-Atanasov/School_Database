
public class Course  implements Comparable <Course>{   

	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
//-----------------CONSTRUCTORS----------------------------------------------------------------------------------------------
	public Course (boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
//---------------------@Override----------------------------------------------------------------------------------------------	
	    @Override
	    public int compareTo( Course c ) {
	    	int n = 0;;
	    	
	    	try {
	    	if (this.courseNum > c.getCourseNum()) n = 1;
	    	else if (this.courseNum == c.getCourseNum()) n = 0;
	    	else n = -1;
	    	} catch (Exception e) {}
	    		return n;
	    	}
		
	 
	 
	    @Override
		public boolean equals(Object obj) {
			if (obj instanceof Course) {
				Course o = (Course) obj;
				if(this.isGraduateCourse == o.isGraduateCourse() && this.courseNum == o.getCourseNum() && 
						this.courseDept.equals(o.getCourseDept()) && this.numCredits == o.getNumCredits())
					return true;		
			}
			return false;
		}
		
		@Override
		public String toString() {
			String st = "";
			if (this.isGraduateCourse) st = "Graduate"; else st = "Undergraduate";
			return String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits, st); 
		}
		
//-------------------------GETTRS AND SETTERS---------------------------------------------------------------------------		
	public String getCourseName () {
		if (this.isGraduateCourse) {
			return "G" + this.courseDept + this.courseNum;     
		} else return "U" + this.courseDept + this.courseNum;
	}
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	

}
