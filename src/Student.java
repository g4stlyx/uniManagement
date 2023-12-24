import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person implements Managable{

    private static HashMap<Integer, Student> students = new HashMap<>(); 

    private static final long serialVersionUID = 1L;
    private String studentNumber;
    private String faculty;
    private String department;
    private String gradeLevel;
    private String annual_fee;
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<String> grades = new ArrayList<String>();
    private ArrayList<String> clubs = new ArrayList<String>();
    private ArrayList<String> clubDescriptions = new ArrayList<String>();

    public Student(){}

    public Student(int id,String name,String address,String phoneNumber,String email,String studentNumber,String pwd, String faculty, String department, String gradeLevel, String annual_fee,ArrayList<String> courses, ArrayList<String> grades, ArrayList<String> clubs, ArrayList<String> clubDescriptions){
        super(id,name,address,phoneNumber,email,studentNumber,pwd);
        this.studentNumber = studentNumber;
        this.faculty = faculty;
        this.department = department;
        this.gradeLevel = gradeLevel;
        this.annual_fee = annual_fee;
        this.courses = courses;
        this.grades = grades;
        this.clubs = clubs;
        this.clubDescriptions = clubDescriptions;
    }

    public static HashMap<Integer,Student> getAllStudents(){return students;}

    public String getStudentNumber(){return this.studentNumber;}
    public void setStudentNumber(String studentNumber){this.studentNumber = studentNumber;}
    
    public String getAnnualFee(){return this.annual_fee;}
    public void setAnnualFee(String annual_fee){this.annual_fee = annual_fee;}
    public int getNumOfCourses(){return courses.size();}
    
    public String getFaculty(){return this.faculty;}
    public void setFaculty(String faculty){this.faculty = faculty;}
    public String getDepartment(){return this.department;}
    public void setDepartment(String department){this.department = department;}
    public String getGradeLevel(){return this.gradeLevel;}
    public void setGradeLevel(String gradeLevel){this.gradeLevel = gradeLevel;}
    
    public ArrayList<String> getCourses(){return courses;}
    public void setCourses(ArrayList<String> courses){this.courses=courses;}
    public ArrayList<String> getGrades(){return grades;}
    public void setGrades(ArrayList<String> grades){this.grades=grades;}
    public ArrayList<String> getClubs(){return clubs;}
    public void setClubs(ArrayList<String> clubs){this.clubs=clubs;}
    public ArrayList<String> getClubDescriptions(){return clubDescriptions;}
    public void setClubDescriptions(ArrayList<String> clubDescriptions){this.clubDescriptions=clubDescriptions;}

    @Override
    public String toString(){
        return "Student: "+getName()+", "+getFaculty()+", "+getDepartment()+", "+getCourses() +", "+ getGrades();
    }

    @Override
    public void add(){
        students.put(this.getId(), this);
    }

    public static void edit(int id, String name,String address,String phoneNumber,String email,String pwd, String faculty, String department, String gradeLevel, String annual_fee,ArrayList<String> courses, ArrayList<String> grades, ArrayList<String> clubs, ArrayList<String> clubDescriptions) {
        HashMap<Integer,Person> data = FileStuff.read("db/students.ser");
        Person person = data.get(id);
        Student student = (Student)person;
        if (student != null){
            Student chosenStudent = student;
            chosenStudent.setName(name);
            chosenStudent.setAddress(address);
            chosenStudent.setPhoneNumber(phoneNumber);
            chosenStudent.setEmail(email);
            chosenStudent.setPassword(pwd);
            chosenStudent.setFaculty(faculty);
            chosenStudent.setDepartment(department);
            chosenStudent.setGradeLevel(gradeLevel);
            chosenStudent.setAnnualFee(annual_fee);
            chosenStudent.setCourses(courses);
            chosenStudent.setGrades(grades);
            chosenStudent.setClubs(clubs);
            chosenStudent.setClubDescriptions(clubDescriptions);
            data.remove(student.getId());
            data.put(chosenStudent.getId(),chosenStudent);
        }
        FileStuff.write(data, "db/students.ser");
    }

    @Override
    public void delete(int id) {
        Student student = students.get(id);
        if(student != null){
            students.put(id, null);
            System.out.println(students);
        } 
    }

    @Override
    public void addExistingUsersToTheMaps(){
        HashMap<Integer,Person> students = FileStuff.read("db/students.ser");
        for(Person person:students.values()){
            Student student = (Student)person;
            student.add();
        }
    }
}