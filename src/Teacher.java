import java.util.ArrayList;

public class Teacher extends Person {
    
    // variables
    private ArrayList<String> courses = new ArrayList<String>();
    private int salary;

    private String username;
    private String password;

    // constructors
    Teacher(String name,String address,String phoneNumber,String email){
        super(name,address,phoneNumber,email);
    }

    // getters and setters
    public int getNumOfCourses(){return courses.size();}
    public ArrayList<String> getCourses(){return courses;}

    public int getSalary(){return this.salary;}
    public void setSalary(int salary){this.salary = salary;}

    public String getUsername(){return this.username;}
    public void setUsername(String staff_username){this.username = staff_username;}
    public String getPassword(){return this.password;}
    public void setPassword(String staff_password){this.password = staff_password;}

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
        if(staff_password == this.username && staff_password == this.password){
            System.out.println("Staff login successful");
            return true;
        }
        else{
            System.out.println("Staff login failed");
            return false;
        }
    }

}
