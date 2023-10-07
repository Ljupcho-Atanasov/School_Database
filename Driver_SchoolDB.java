        import java.util.ArrayList;
        import java.util.Scanner;
		import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver_SchoolDB {
	static Scanner s = new Scanner (System.in);
	public static void main (String [] args) {
		
		PrintWriter writer = null;
		FileOutputStream fileOut = null;
		String line = null;
		String classType = null;
		String param1 = null;
		String param2 = null;
		String param3 = null;
		String param4 = null;
//		Person p = null;
//		ArrayList <Person> pArr = new ArrayList <Person>();
		Faculty f = null;
		ArrayList <Faculty> fArr = new ArrayList <Faculty>();
		GeneralStaff g = null;
		ArrayList <GeneralStaff> gArr = new ArrayList <GeneralStaff>();
		Course c = null;
		ArrayList <Course> cArr = new ArrayList <Course>();
		Student st = null;
		ArrayList <Student> sArr = new ArrayList <Student>();
		Scanner scnr = null;

		try {
			FileInputStream file = new FileInputStream("SchoolDB_Initial.txt");
			
			scnr = new Scanner(file);
			while (scnr.hasNext()) {
				classType = null;
				param1 = null;
				param2 = null;
				param3 = null;
				param4 = null;
				
				line = scnr.nextLine();
				System.out.println(line);
				
				if (line.equals("")) {
					continue;
				}
				
				classType = line.split(":")[0].strip();
				
				try {
		//			System.out.println(classType);
					String[] params = line.split(":")[1].split(",");
		//			System.out.println(Arrays.toString(params));
					
					
					param1 = params[0].strip();
					param2 = params[1].strip();
					param3 = params[2].strip();
					param4 = params[3].strip();
				} catch (Exception e) {}
				
				
				if (classType.equals("Faculty")) {
					if (param1 == null && param2 == null && param3 == null && param4 == null) f = new Faculty();
					if (param1 != null && param2 == null && param3 == null && param4 == null) f = new Faculty(Boolean.parseBoolean(param1));
					if (param1 != null && param2 != null && param3 == null && param4 == null) f = new Faculty(param1, Boolean.parseBoolean(param2));
					if (param1 != null && param2 != null && param3 != null && param4 != null) 
					f = new Faculty(param1, Integer.parseInt(param2), param3, Boolean.parseBoolean(param4));
			        
					fArr.add(f);
				}
				if (classType.equals("GeneralStaff")) {
					if (param1 == null && param2 == null && param3 == null && param4 == null) g = new GeneralStaff();
					if (param1 != null && param2 == null && param3 == null && param4 == null) g = new GeneralStaff(param1);
					if (param1 != null && param2 != null && param3 == null && param4 == null) g = new GeneralStaff(param1, param2);
					if (param1 != null && param2 != null && param3 != null && param4 != null) 
					g = new GeneralStaff(param1, Integer.parseInt(param2), param3, param4);
					gArr.add(g);
				}
				if (classType.equals("Course")) {
					
					if (param2 == null)                             //(param2.equals(""))
						c = new Course(Boolean.parseBoolean(param1), 0, param3, Integer.parseInt(param4));
					else if (param4 == null && param2!=null) 
						c = new Course(Boolean.parseBoolean(param1), Integer.parseInt(param2), param3, 0);
					else if( (param2 == null)  && (param4 == null))
						c = new Course(Boolean.parseBoolean(param1), 0, param3, 0);
					else c = new Course(Boolean.parseBoolean(param1), Integer.parseInt(param2), param3, Integer.parseInt(param4));
				 
					cArr.add(c);
				}
				if (classType.equals("Student")) {
					if (param1 == null && param2 == null && param3 == null && param4 == null) st = new Student();
					if (param1 != null && param2 == null && param3 == null && param4 == null) st = new Student(Boolean.parseBoolean(param1));
					if (param1 != null && param2 != null && param3 == null && param4 == null) st = new Student(param1, Boolean.parseBoolean(param2));
					if (param1 != null && param2 != null && param3 != null && param4 != null) 
					st = new Student(param1, Integer.parseInt(param2), param3, Boolean.parseBoolean(param4));
					
					sArr.add(st);
				    }
				
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		int choice = 0;
	//	printDatabase(cArr, gArr,  fArr, sArr);
		while(true) {
		System.out.println("ENTER YOUR OPTION (enter -1 to EXIT)");
		displayMenu();
		System.out.println("ENTER YOUR OPTION (enter -1 to EXIT)");
		choice = s.nextInt();
		s.nextLine();
		
		while (choice < -1 || choice > 17) {
			System.out.println("Incorect input. Enter from 0 to 17.");
			choice = s.nextInt();
			s.nextLine();
		}
		if (choice == -1) {
			System.out.println("Exiting interface. Bye!");
			break;
		}
		if (choice == 1) createCourse(cArr);
		if (choice == 2) createFaculty(fArr);
		if (choice == 3) createGeneralStaff(gArr);
		if (choice == 4) createStudent(sArr);
		if (choice == 5) addNewCourseToFacultyMember (fArr, cArr);
		if (choice == 6) addNewCourseToStudentMember (sArr, cArr);
		if (choice == 7) addNewCoursesToFacultyMember (fArr, cArr);
		if (choice == 8) addNewCoursesToStudentMember (sArr, cArr);
		if (choice == 9) getCoursefromFacultyObjAtIndex (fArr);
	    if (choice == 10) getCourseFromStudentObjAtIndex(sArr);
		if (choice == 11) inqiry (fArr, cArr);
		if (choice == 12) mostAndLeastCoursesTaughtBy(fArr);
		if (choice == 13) minimumOfAllCourses (cArr);
		if (choice == 14) maximumOfAllCourses (cArr);
		if (choice == 15) studentsWithMostAndLeastCredits (sArr);
		if (choice == 16) printDatabase(cArr, gArr, fArr, sArr); 
		}
		while (true) {
		try {
		fileOut = new FileOutputStream("SchoolDB_Updated.txt");
		writer = new PrintWriter(fileOut);
		break;
		} catch (IOException exp) {
			System.out.println("Can not open file.");
		}
		}
		
		for (int i = 0; i < fArr.size(); ++i) {
			writer.println("Faculty: " + fArr.get(i).getName() + "," + fArr.get(i).getBirthYear() + "," + fArr.get(i).getDeptName() + "," + fArr.get(i).isTenured());
				
		}
		
		for (int i = 0; i < sArr.size(); ++i) {
			writer.println("Student :" + sArr.get(i).getName() + "," + sArr.get(i).getBirthYear() + "," + sArr.get(i).getMajor() + "," + sArr.get(i).isGraduate());
		
		}
		
		for ( int i = 0; i < gArr.size(); ++i) {
			writer.println(gArr.get(i).getName() + "," + gArr.get(i).getBirthYear() + "," + gArr.get(i).getDeptName() + "," + gArr.get(i).getDuty());
		}
		
		for (int i = 0; i < cArr.size(); ++i) {
			writer.println("Course: " + cArr.get(i).isGraduateCourse() + "," + cArr.get(i).getCourseNum() + "," + cArr.get(i).getCourseName() + "," + cArr.get(i).getNumCredits());
		}
		try {
		writer.close();
		fileOut.close();
		
		} catch (IOException exept) {
			System.out.println("Can't close the file.");
		}
		
	}
	
//16. Display all the Objects using toString on the console	
	public static void printDatabase(ArrayList<Course> cArr, 
			                         ArrayList<GeneralStaff> gArr, 
			                         ArrayList<Faculty> fArr,
			                         ArrayList<Student> sArr) 
	{
		System.out.println("**************************************************************");
		System.out.println("SCHOOL DATABASE INFO:");
		System.out.println();
		System.out.println("************************************************");
		System.out.println("COURSES:");
		
		for (int i = 0; i < cArr.size(); ++i) {
			System.out.println(cArr.get(i).toString());
		}
		
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("PERSONS:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("EMPLOYEES:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("GENERAL STAFF:");
		
		for (int i = 0; i < gArr.size(); ++i) {
			System.out.println(gArr.get(i).toString());
		}
		
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("FACULTY:");
		
		for (int i = 0; i < fArr.size(); ++i) {
			System.out.println(fArr.get(i).toString());
		}
		
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("STUDENTS:");
		
		for (int i = 0; i < sArr.size(); ++i) {
			System.out.println(sArr.get(i).toString());
		}
		
		System.out.println("************************************************");
		System.out.println("**************************************************************");
		System.out.println();
		
	}
	
	public static void displayMenu() {
		System.out.println("=====================================================================================");
		System.out.println("== 1.  Create a new Course  =========================================================");
		System.out.println("=====================================================================================");
		System.out.println("== 2.  Crate a naw Faculty  =========================================================");
		System.out.println("=====================================================================================");
		System.out.println("== 3.  Crate a new General Staff  ===================================================");
		System.out.println("=====================================================================================");
		System.out.println("== 4.  Crate a new Student  =========================================================");
		System.out.println("=====================================================================================");
		System.out.println("== 5.  Add a new Course to a Faculty object  ========================================");
		System.out.println("=====================================================================================");
		System.out.println("== 6.  Add a new Course to a Student object  ========================================");
		System.out.println("=====================================================================================");
		System.out.println("== 7.  Add an array of Courses to a Faculty object  =================================");
		System.out.println("=====================================================================================");
		System.out.println("== 8.  Add an array of Courses to a Student object  =================================");
		System.out.println("=====================================================================================");
		System.out.println("== 9. Get the Course at index (valid and invalid indexes) from a Faculty object  ====");
		System.out.println("=====================================================================================");
		System.out.println("== 10. Get the Course at index (valid and invalid indexes) from a Student object  ===");
		System.out.println("=====================================================================================");
		System.out.println("== 11. Allow the user to select a Faculty object and a Course object from menus  ====");
		System.out.println("==     and query the Faculty object for the Course to determine whether  ============");
		System.out.println("==     the Faculty object teaches it or not.  =======================================");
		System.out.println("=====================================================================================");
		System.out.println("== 12. Determine which Faculty object teaches the most and the least courses.  ======");
		System.out.println("=====================================================================================");
		System.out.println("== 13. Determine which Course is the minimum of all Course objects in the catalog.  =");
		System.out.println("=====================================================================================");
		System.out.println("== 14. Determine which Course is the maximum of all Course objects in the catalog.  =");
		System.out.println("=====================================================================================");
		System.out.println("== 15. Determine which Student has the most and least credits.  =====================");
		System.out.println("=====================================================================================");
		System.out.println("== 16. Display all the Objects using toString on the console  =======================");
		System.out.println("==     (this includes existing plus recently added)  ================================");
		System.out.println("=====================================================================================");

	}
	
	public static Course createCourse(ArrayList<Course> cArr) {    											//1.
		
		System.out.println("Is the course graduate?");
		boolean g = s.nextBoolean();
		s.nextLine();
		System.out.println("Enter course number.");
		int cn = s.nextInt();
		s.nextLine();
		System.out.println("Enter course department.");
		String department = s.nextLine();
		System.out.println("How many credits is this course?");
		int numCr = s.nextInt();
		s.nextLine();
		Course c = new Course (g, cn, department, numCr);
		cArr.add(c);
		return c;
		
	}
	
    public static Faculty createFaculty(ArrayList<Faculty> fArr) {   											//2.
		
		System.out.println("What is the name of the Faculty memeber?");
		String g = s.nextLine();
		System.out.println("Enter the birth year of the Faculty memeber.");
		int cn = s.nextInt();
		s.nextLine();
		System.out.println("Enter course department name.");
		String department = s.nextLine();;
		System.out.println("Is this Faculty member tenured?");
		boolean numCr = s.nextBoolean();
		s.nextLine();
		Faculty c = new Faculty (g, cn, department, numCr);
		fArr.add(c);
		return c;
		
	}
    
    
    public static GeneralStaff createGeneralStaff(ArrayList<GeneralStaff> gArr) {									//3.
		
    	System.out.println("What is the name of the staff memeber?");
		String g = s.nextLine();
		System.out.println("Enter the birth year of the Faculty memeber.");
		int cn = s.nextInt();
		s.nextLine();
		System.out.println("Enter course department name.");
		String department = s.nextLine();
		System.out.println("Is this Faculty member's duty?");
		String duty = s.nextLine();
		GeneralStaff c = new GeneralStaff (g, cn, department, duty);
		gArr.add(c);
		return c;
  		
  	}
    
    public static Student createStudent(ArrayList<Student> sArr) {												//4.
		
    	System.out.println("What is the name of the Student?");
		String g = s.nextLine();
		System.out.println("Enter the birth year of the Student.");
		int cn = s.nextInt();
		s.nextLine();
		System.out.println("Enter course student's major.");
		String major = s.nextLine();
		System.out.println("Is this Student graduate?");
		boolean graduate = s.nextBoolean();
		s.nextLine();
		Student c = new Student (g, cn, major, graduate);
		sArr.add(c);
		return c;
    }
    
    public static void addNewCourseToFacultyMember ( ArrayList<Faculty> fArr, ArrayList<Course> cArr) {  						//5.
    	System.out.println("Our faculty members:");
    	for (int i = 0; i < fArr.size(); ++i) System.out.println("" + (i+1) + "   " + fArr.get(i).getName());
    	System.out.println("Enter the number of the faculty member to add a course to.");
    	int name = s.nextInt();
    	s.nextLine();
    	while(name < 1 || name > fArr.size()) {
    		System.out.println("Enter the number between 1 and " + fArr.size());
    		name = s.nextInt();
        	s.nextLine();
    	}
    		
    	    Faculty f = fArr.get(--name);
   
    	Course c = createCourse(cArr);
    	f.addCourseTaught(c);
    	System.out.println(c.getCourseName() +" added to faculty member " + f.getName());
    }
    
    public static void addNewCourseToStudentMember ( ArrayList<Student> sArr, ArrayList<Course> cArr) { 						//6.
    	System.out.println("This is our student list:");
    	for (int i = 0; i < sArr.size(); ++i) System.out.println("" + (i+1) + "   " + sArr.get(i).getName());
    	System.out.println("Enter the number of the student to add a course to.");
    	int name = s.nextInt();
    	s.nextLine();
    	while(name < 1 || name > sArr.size()) {
    		System.out.println("Enter the number between 1 and " + sArr.size());
    		name = s.nextInt();
        	s.nextLine();
    	}
    	Student st = sArr.get(--name);
	
    	Course c = createCourse(cArr);
    	st.addCourseTaken(c);
    	System.out.println(c.getCourseName() +" added to student " + st.getName());
    }
    
    public static void addNewCoursesToFacultyMember (ArrayList<Faculty> fArr, ArrayList<Course> cArr) {				//7.
    	System.out.println("Our faculty members:");
    	for (int i = 0; i < fArr.size(); ++i) System.out.println("" + (i+1) + "   " + fArr.get(i).getName());
    	System.out.println("Enter the number of the faculty member to add a course to.");
    	int name = s.nextInt();
    	s.nextLine();
    	while(name < 1 || name > fArr.size()) {
    		System.out.println("Enter the number between 1 and " + fArr.size());
    		name = s.nextInt();
        	s.nextLine();
    	}
    		
    	    Faculty f = fArr.get(--name);
    	
    	System.out.println("How many courses would You want to add to faculty member " + f.getName() + "?");
    	int num = s.nextInt();
    	System.out.println("Create " + num + "courses:");
    	for (int i = 0; i < num; ++i) {
    		System.out.println("Create course number " + (i+1)  + ":");
    		Course c = createCourse(cArr);
        	f.addCourseTaught(c);
    	}
    }
    
  public static void addNewCoursesToStudentMember ( ArrayList<Student> sArr, ArrayList<Course> cArr) {		   				 //8.
	  System.out.println("This is our student list:");
  	for (int i = 0; i < sArr.size(); ++i) System.out.println("" + (i+1) + "   " + sArr.get(i).getName());
  	System.out.println("Enter the number of the student to add a course to.");
  	int name = s.nextInt();
  	s.nextLine();
  	while(name < 1 || name > sArr.size()) {
  		System.out.println("Enter the number between 1 and " + sArr.size());
  		name = s.nextInt();
      	s.nextLine();
  	}
  	Student st = sArr.get(--name);
    	
    	System.out.println("How many courses would You want to add to faculty member " + st.getName() + "?");
    	int num = s.nextInt();
    	s.nextLine();
    	System.out.println("Create " + num + "courses:");
    	for (int i = 0; i < num; ++i) {
    		System.out.println("Create course number " + (i+1)  + ":");
    		Course c = createCourse(cArr);
    		st.addCourseTaken(c);
    	}
    }
  
  //9. Get the Course at index (valid and invalid indexes) from a Faculty object
  public static Course getCoursefromFacultyObjAtIndex ( ArrayList<Faculty> fArr) {						//9.
	  
	  System.out.println("Our faculty members:");
  	for (int i = 0; i < fArr.size(); ++i) System.out.println("" + (i+1) + "   " + fArr.get(i).getName());
  	System.out.println("Enter the number of the faculty member to add a course to.");
  	int name = s.nextInt();
  	s.nextLine();
  	while(name < 1 || name > fArr.size()) {
  		System.out.println("Enter the number between 1 and " + fArr.size());
  		name = s.nextInt();
      	s.nextLine();
  	}
  		
  	    Faculty f = fArr.get(--name);
  	
  	System.out.println("Enter the index of course.");
  	int index = s.nextInt();
  	s.nextLine();
  	
	  while (f.getCourseTaught(index - 1) == null) {
		  System.out.println("Invalid inex input. Try inputing a valid index:");
		  index = s.nextInt();
		  s.nextLine();
	  }
	  System.out.println();
	  System.out.println("The course at index " + index + " is: " + f.getCourseTaught(index - 1).toString());
	  
	  System.out.println();
	  return f.getCourseTaught(index - 1);
  }
  
  //10. Get the Course at index (valid and invalid indexes) from a Student object
  public static Course getCourseFromStudentObjAtIndex ( ArrayList<Student> sArr) {		   				//10.
	  
	  System.out.println("This is our student list:");
	  	for (int i = 0; i < sArr.size(); ++i) System.out.println("" + (i+1) + "   " + sArr.get(i).getName());
	  	System.out.println("Enter the number of the student to add a course to.");
	  	int name = s.nextInt();
	  	s.nextLine();
	  	while(name < 1 || name > sArr.size()) {
	  		System.out.println("Enter the number between 1 and " + sArr.size());
	  		name = s.nextInt();
	      	s.nextLine();
	  	}
	  	Student st = sArr.get(--name);
	  	
	  	System.out.println("Enter the index of course.");
	  	int index = s.nextInt();
	  	s.nextLine();
	  	while (st.getCourseTaken(index - 1) == null) {
			  System.out.println("Invalid inex input. Try inputing a valid index:");
			  index = s.nextInt();
			  s.nextLine();
		  }
		  System.out.println();
		  System.out.println("The course at index " + index + " is: " + st.getCourseTaken(index - 1).toString());
		  
		  System.out.println();
		  return st.getCourseTaken(index - 1);
  }
  
//11. Allow the user to select a Faculty object and a Course object from menus  
//			     and query the Faculty object for the Course to determine whether  
//			    the Faculty object teaches it or not.
  public static void inqiry (ArrayList<Faculty> fArr, ArrayList<Course> cArr) {			//11.
	  Faculty f = null;
	  Course c = null;
	  System.out.println("This is the list of our Faculty members:");
	  for (int i = 0; i < fArr.size(); ++i) {
		  System.out.println("" + (i+1) + "   " + fArr.get(i).getName());
		  }
	  System.out.println("And this is a list of availeble courses:");
	  for (int i = 0; i < cArr.size(); ++i) {
		  System.out.println("" + (i+1) + "   " + cArr.get(i).getCourseName());
		  }
	  
	  
	  System.out.println("Enter the valid number of the faculty member for inqury.");
	  	int name = s.nextInt();
	  	s.nextLine();
	  	while(name < 1 || name > fArr.size()) {
	  		System.out.println("Enter the number between 1 and " + fArr.size());
	  		name = s.nextInt();
	      	s.nextLine();
	  	}
	  	f = fArr.get(--name);
	  	
	  
	  	System.out.println("Enter the number of the course to check if " + f.getName() + " teaches it.");
	  	int course = s.nextInt();
	  	s.nextLine();
	  	while(course < 1 || course > cArr.size()) {
	  		System.out.println("Enter the number between 1 and " + cArr.size());
	  		course = s.nextInt();
	      	s.nextLine();
	  	}
	  	c = cArr.get(--course);
	  
  
	  boolean teaches = false;
//	  try {
	  for (int i = 0; i < f.getAllCoursesTaughtAsString().split(", ").length; ++i) {
		  if (c.getCourseName().equals(f.getCourseTaught(i).getCourseName())) teaches = true;
	  }
	  if (teaches) System.out.println("\nThe faculty member " + f.getName() + " teaches " + c.getCourseName() + ".\n");
	  else System.out.println("\nThe faculty member " + f.getName() + " does NOT teach " + c.getCourseName() + ".\n");
//	  } catch(Exception e) {}
  }
  
  
//  12. Determine which Faculty object teaches the most and the least courses.
	  public static void mostAndLeastCoursesTaughtBy(ArrayList<Faculty> fArr) {
		  int[] count = new int[fArr.size()];
		  for (int i = 0; i < count.length; ++i) count[i] = 0;
		  for (int i = 0; i < fArr.size(); ++i) 
			  count[i] = fArr.get(i).getAllCoursesTaughtAsString().split(", ").length;
	  int max = count[0];
	  int maxIndex = 0;
	  for (int i = 1; i < count.length; ++i ) 
		  if (max < count[i]) {
			  max = count[i];
			  maxIndex = i;
		  }
	  System.out.println("Most courses taught by faculty member :" + fArr.get(maxIndex).getName());
	  System.out.println( fArr.get(maxIndex).getName() + " teaches " + max + " courses.");
	  
	  int min = count[0];
	  int minIndex = 0;
	  for (int i = 1; i < count.length; ++i ) 
		  if (min > count[i]) {
			  min = count[i];
			  minIndex = i;
		  }
	  System.out.println("Least courses taught by faculty member :" + fArr.get(minIndex).getName());
	  System.out.println( fArr.get(minIndex).getName() + " teaches " + min + "courses.");
	  }
	  
//13. Determine which Course is the minimum of all Course objects in the catalog.
	  public static Course minimumOfAllCourses (ArrayList<Course> cArr) {
		  Course c = cArr.get(0);
		  for (int i = 0; i < cArr.size(); ++i) {
			  if(c.compareTo(cArr.get(i)) > 0) c = cArr.get(i);
		  }
		  System.out.println("\n\n" + "Minimum of all courses is " + c.getCourseName() + " from " + c.getCourseDept() +"\n\n");
		  return c;
	  }
	  
//14. Determine which Course is the maximum of all Course objects in the catalog.
	  public static Course maximumOfAllCourses (ArrayList<Course> cArr) {
		  Course c = cArr.get(0);
		  for (int i = 0; i < cArr.size(); ++i) {
			  if(c.compareTo(cArr.get(i)) < 0) c = cArr.get(i);
		  }
		  System.out.println("\n\n" + "Maximum of all courses is " + c.getCourseName() + " from " + c.getCourseDept() +"\n\n");
		  return c;
	  }
	  
//15. Determine which Student has the most and least credits.
	  public static void studentsWithMostAndLeastCredits (ArrayList<Student> sArr) {
		  int[] numCredits = new int[sArr.size()];
		  int mostIndex = 0;
		  int leastIndex = 0;
		  for (int i = 0; i < numCredits.length; ++i) numCredits[i] = 0;
		  Course[] cr;
		  
//		  try {
		  for (int i = 0; i < sArr.size(); ++i) {
			  System.out.println(sArr.get(i).getName());
			  for( int j = 0; j < sArr.get(i).getNumCoursesTaken(); ++j) {
				  cr = sArr.get(i).getCoursesTaken();
				  if(cr[j] != null) 
				  numCredits[i] += cr[j].getNumCredits();
				  else {
					  numCredits[i] = 0;
				  }
			  }
		  }//getNumCredits()
//		  } catch(Exception e) {}
		  
		  int mostCredits = numCredits[0];
		  int leastCredits = numCredits[0];
		  for (int i = 0; i < numCredits.length; ++i) {
			  if (mostCredits < numCredits[i] ) {
				  mostCredits = numCredits[i];
				  mostIndex = i;
			  }
			  if (leastCredits > numCredits[i] ) {
				  leastCredits = numCredits[i];  
				  leastIndex = i;
			  }
		  }
		  System.out.println("\n\n Student with most credits is: " + sArr.get(mostIndex).getName() + " with " + mostCredits + " credits.\n\n");
		  System.out.println(" Student with least credits is: " + sArr.get(leastIndex).getName() + " with " + leastCredits + " credits.\n\n");
	  }
	
	}
