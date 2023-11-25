import java.util.ArrayList;

public class Teacher extends Person {
    
    // variables
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>(); // prof, öğrenci danışmanı, kütüphane görevlisi etc.
    private int salary;

    private String staffUsername;
    private String staffPassword;

    // constructors
    Teacher(String name,String address){
        super(name,address);
        courses = new ArrayList<String>();
    }

    // getters and setters
    public int getNumOfCourses(){return courses.size();}
    public ArrayList<String> getCourses(){return courses;}
    public ArrayList<String> getTitles(){return titles;}

    public int getSalary(){return this.salary;}
    public void setSalary(int salary){this.salary = salary;}

    public String getStaffUsername(){return this.staffUsername;}
    public void setStaffUsername(String staff_username){this.staffUsername = staff_username;}
    public String getStaffPassword(){return this.staffPassword;}
    public void setStaffPassword(String staff_password){this.staffPassword = staff_password;}

    // other methods
    public boolean addCourse(String course){
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).equals(course)){
                System.out.println("The course you want to add is already exist!");
                return false;
            }
        }
        courses.add(course);
        System.out.println("Courses after addition: "+courses);
        return true;
    }

    public boolean removeCourse(String course){
        int j=0;
        if(courses.size()==0){
            System.out.println("The course you want to remove does not exist!");
            return false;
        }
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).equals(course)){ // silinmesi istenen kurs listede yoksa j'yi arttır
                j++;
            }
        }
        if(j<1){ // silinmesi istenen kurs yoksa çıktı verip false dön
            System.out.println("The course you want to remove does not exist!");
            return false;
        }
        // silinmesi istenen kurs var:
        courses.remove(course);
        System.out.println("Courses after deletion: "+courses);
        return true;
    }

    public ArrayList<String> printCourses(){
        return courses;
    }

    @Override
    public String toString(){
        return "Teacher: "+getName()+"("+getAddress()+")";
    }

    public boolean staffLogin(String staff_username, String staff_password){
        if(staff_password == this.staffUsername && staff_password == this.staffPassword){
            System.out.println("Staff login successful");
            return true;
        }
        else{
            System.out.println("Staff login failed");
            return false;
        }
    }

}
