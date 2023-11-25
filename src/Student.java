import java.util.ArrayList;

public class Student extends Person {
    // variables    
    private int student_id;
    private int studentNumber; 
    private String studentPassword;

    private String faculty;
    private String department;
    private int gradeLevel; // sınıfı
    private double annual_fee;
    private ArrayList<String> coursesRegistered = new ArrayList<String>();
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    private ArrayList<String> clubsRegistered = new ArrayList<String>();

    // constructors
    public Student(String name,String address){
        super(name,address);
        coursesRegistered = new ArrayList<String>();
        grades = new ArrayList<Integer>();
    }

    // getters and setters
    public int getStudentId(){return this.student_id;}
    public int getStudentNumber(){return this.studentNumber;}
    public String getStudentPassword(){return this.studentPassword;}
    public void setStudentPassword(String student_password){this.studentPassword = student_password;}
    
    public double getAnnualFee(){return this.annual_fee;}
    public void setAnnualFee(double annual_fee){this.annual_fee = annual_fee;}
    public int getNumOfCourses(){return coursesRegistered.size();}
    
    public String getFaculty(){return this.faculty;}
    public void setFaculty(String faculty){this.faculty = faculty;} // fakülte değişimi?
    public String getDepartment(){return this.department;}
    public void setDepartment(String department){this.department = department;} // bölüm değişimi?
    public int getGradeLevel(){return this.gradeLevel;}
    public void setGradeLevel(int gradeLevel){this.gradeLevel = gradeLevel;}
    
    public ArrayList<String> getCourses(){return coursesRegistered;}
    public ArrayList<Integer> getGrades(){return grades;}
    public ArrayList<String> getClubsRegistered(){return clubsRegistered;}

    // other methods
    public void addCourseGrade(String course,int grade){
        coursesRegistered.add(course);
        grades.add(grade);
    }

    public void printGrades(){
        for(int i=0;i<coursesRegistered.size();i++){
            System.out.println(coursesRegistered.get(i)+": "+grades.get(i));
        }
    }

    public double getAverageGrade(){
        int sum=0;
        for(int grade:grades){
            sum += grade;
        }
        return (double)sum/grades.size();
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
        return "Student: "+getName()+"("+getAddress()+")";
    }

}
