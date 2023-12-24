import java.util.ArrayList;
import java.util.HashMap;

public class Instructor extends Person implements Managable {
    
    private static HashMap<Integer, Instructor> instructors = new HashMap<>(); 
    private static final long serialVersionUID = 1L;
    private ArrayList<String> courses = new ArrayList<String>();
    private String salary;

    Instructor(){}

    Instructor(int id,String name,String address,String phoneNumber,String email,ArrayList<String> courses,String salary, String username, String password){
        super(id,name,address,phoneNumber,email,username,password);
        this.courses = courses;
        this.salary = salary;
    }

    public static HashMap<Integer,Instructor> getAllInstructors(){return instructors;}

    public int getNumOfCourses(){return courses.size();}
    public ArrayList<String> getCourses(){return courses;}
    public void setCourses(ArrayList<String> courses){this.courses=courses;}
    public String getSalary(){return this.salary;}
    public void setSalary(String salary){this.salary = salary;}

    @Override
    public String toString(){
        return "Instructor: "+getUsername()+", "+getEmail();
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
    }

    @Override
    public void addExistingUsersToTheMaps(){
        HashMap<Integer,Person> instructors = FileStuff.read("db/instructors.ser");
        for(Person person:instructors.values()){
            Instructor instructor = (Instructor)person;
            instructor.add();
        }
    }

    public static void edit(int id,String name,String address,String phoneNumber,String email,ArrayList<String> courses,String salary, String username, String password) {
        HashMap<Integer,Person> data = FileStuff.read("db/instructors.ser");
        Person person = data.get(id);
        Instructor instructor = (Instructor)person;
        if (instructor != null) {
            Instructor chosenInstructor = instructor;
            chosenInstructor.setName(name);
            chosenInstructor.setAddress(address);
            chosenInstructor.setPhoneNumber(phoneNumber);
            chosenInstructor.setEmail(email);
            chosenInstructor.setUsername(username);
            chosenInstructor.setPassword(password);
            chosenInstructor.setSalary(salary);
            chosenInstructor.setCourses(courses);
            data.remove(instructor.getId());
            data.put(chosenInstructor.getId(), chosenInstructor);
        }
        FileStuff.write(data, "db/instructors.ser");
    }

}