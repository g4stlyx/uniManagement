import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Student extends Person implements Managable{

    private static HashMap<Integer, Student> students = new HashMap<>(); 

    private int student_id; // id in person?
    private String studentNumber; // int? 
    private String studentPassword; // password in person?
    private String faculty;
    private String department;
    private String gradeLevel; // int?
    private String annual_fee; //int/double?
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<String> grades = new ArrayList<String>(); // Integer?
    private ArrayList<String> clubs = new ArrayList<String>();
    private ArrayList<String> clubDescriptions = new ArrayList<String>();

    public Student(){}

    public Student(int id,String name,String address,String phoneNumber,String email,String studentNumber,String pwd, String faculty, String department, String gradeLevel, String annual_fee,ArrayList<String> courses, ArrayList<String> grades, ArrayList<String> clubs, ArrayList<String> clubDescriptions){
        super(name,address,phoneNumber,email);
        this.student_id = id;
        this.studentNumber = studentNumber;
        this.studentPassword = pwd;
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

    public int getStudentId(){return this.student_id;}
    public void setStudentId(int id){this.student_id = id;}
    public String getStudentNumber(){return this.studentNumber;}
    public void setStudentNumber(String studentNumber){this.studentNumber = studentNumber;}
    public String getStudentPassword(){return this.studentPassword;}
    public void setStudentPassword(String student_password){this.studentPassword = student_password;}
    
    public String getAnnualFee(){return this.annual_fee;}
    public void setAnnualFee(String annual_fee){this.annual_fee = annual_fee;}
    public int getNumOfCourses(){return courses.size();}
    
    public String getFaculty(){return this.faculty;}
    public void setFaculty(String faculty){this.faculty = faculty;} // fakülte değişimi?
    public String getDepartment(){return this.department;}
    public void setDepartment(String department){this.department = department;} // bölüm değişimi?
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


    public void addCourseGrade(String course,String grade){
        courses.add(course);
        grades.add(grade);
    }
    public void printGrades(){
        for(int i=0;i<courses.size();i++){
            System.out.println(courses.get(i)+": "+grades.get(i));
        }
    }
    public boolean studentLogin(int student_id, String student_password){
        if(student_id == this.student_id && student_password == this.studentPassword){
            System.out.println("Student login successful");
            return true;
        }
        else{
            System.out.println("Student login failed");
            return false;
        }
    }
    @Override
    public String toString(){
        return "Student: "+getName()+", "+getFaculty()+", "+getDepartment()+", "+getCourses();
    }

    @Override
    public void add(){
        students.put(this.getStudentId(), this);
    }

    public static void edit(int id, String name,String address,String phoneNumber,String email,String pwd, String faculty, String department, String gradeLevel, String annual_fee,ArrayList<String> courses, ArrayList<String> grades, ArrayList<String> clubs, ArrayList<String> clubDescriptions) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setAddress(address);
            student.setPhoneNumber(phoneNumber);
            student.setEmail(email);
            student.setStudentPassword(pwd);
            student.setFaculty(faculty);
            student.setDepartment(department);
            student.setGradeLevel(gradeLevel);
            student.setAnnualFee(annual_fee);
            student.setCourses(courses);
            student.setGrades(grades);
            student.setClubs(clubs);
            student.setClubDescriptions(clubDescriptions);
        } 
        else{
            System.out.println("No User Found With the id " + id);
        }
    }

    @Override
    public void delete(int id) {
        Student student = students.get(id);
        if(student != null){
            students.put(id, null);
            System.out.println(students);
        } 
        else{
            System.out.println("No User Found With the id " + id);
        }
    }

    @Override
    public void addExistingUsersToTheMaps(){
        ArrayList<String> studentsList = FileStuff.readTxt("db/_students.txt");

        for(int i=0;i<studentsList.size();i++){
            String[] studentValues = studentsList.get(i).split("-");
            ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(studentValues[11].toString().split("_")));
            ArrayList<String> gradesArrayList = new ArrayList<>(Arrays.asList(studentValues[12].toString().split("_ | ,"))); 
            ArrayList<String> clubsArrayList = new ArrayList<String>(Arrays.asList(studentValues[13].toString().split("_"))); 
            ArrayList<String> clubDescriptionsArrayList = new ArrayList<String>(Arrays.asList(studentValues[14].toString().split("_")));  
            Student tempStudent = new Student(Integer.parseInt(studentValues[0].toString().trim()),studentValues[1].toString(),studentValues[2].toString(),studentValues[3].toString(),studentValues[4].toString(),studentValues[5].toString(),studentValues[6].toString(),studentValues[7].toString(),studentValues[8].toString(),studentValues[9].toString(),studentValues[10].toString(),coursesArrayList,gradesArrayList,clubsArrayList,clubDescriptionsArrayList);
            tempStudent.add();
        }
    }



}