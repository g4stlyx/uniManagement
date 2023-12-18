import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Instructor extends Person implements Managable {
    
    private static HashMap<Integer, Instructor> instructors = new HashMap<>(); 

    private int id;
    private ArrayList<String> courses = new ArrayList<String>();
    private String salary;
    private String username;
    private String password;

    Instructor(){}

    Instructor(int id,String name,String address,String phoneNumber,String email,ArrayList<String> courses,String salary, String username, String password){
        super(name,address,phoneNumber,email);
        this.id = id;
        this.courses = courses;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public static HashMap<Integer,Instructor> getAllInstructors(){return instructors;}

    public int getId(){return this.id;}
    public void setId(int id){this.id=id;}
    public int getNumOfCourses(){return courses.size();}
    public ArrayList<String> getCourses(){return courses;}
    public void setCourses(ArrayList<String> courses){this.courses=courses;}
    public String getSalary(){return this.salary;}
    public void setSalary(String salary){this.salary = salary;}
    public String getUsername(){return this.username;}
    public void setUsername(String staff_username){this.username = staff_username;}
    public String getPassword(){return this.password;}
    public void setPassword(String staff_password){this.password = staff_password;}

    @Override
    public String toString(){
        return "Instructor: "+getUsername()+", "+getEmail();
    }

    public boolean staffLogin(String staff_username, String staff_password){
        if(staff_password == this.username && staff_password == this.password){
            System.out.println("Instructor login successful");
            return true;
        }
        else{
            System.out.println("Instructor login failed");
            return false;
        }
    }

    @Override
    public void add(){
        instructors.put(this.getId(), this);
    }

    @Override
    public void delete(int id) {
        Instructor instructor = instructors.get(id);
        if(instructor != null){
            instructors.put(id, null);
        } 
        else{
            System.out.println("No User Found With the id " + id);
        }
    }

    @Override
    public void addExistingUsersToTheMaps(){
        ArrayList<String> instructorsList = FileStuff.readTxt("db/_instructors.txt");

        for(int i=0;i<instructorsList.size();i++){
            String[] values = instructorsList.get(i).split("-");
            ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(values[5].toString().split("_")));
            Instructor tempUser = new Instructor(Integer.parseInt(values[0].toString().trim()),values[1].toString(),values[2].toString(),values[3].toString(),values[4].toString(),coursesArrayList,values[6].toString(),values[7].toString(),values[8].toString());
            tempUser.add();
        }
    }

    public static void edit(int id,String name,String address,String phoneNumber,String email,ArrayList<String> courses,String salary, String username, String password) {
        Instructor instructor = instructors.get(id);
        if (instructor != null) {
            instructor.setName(name);
            instructor.setAddress(address);
            instructor.setPhoneNumber(phoneNumber);
            instructor.setEmail(email);
            instructor.setUsername(username);
            instructor.setPassword(password);
            instructor.setSalary(salary);
            instructor.setCourses(courses);
        } 
        else{
            System.out.println("No User Found With the id " + id);
        }
    }

}