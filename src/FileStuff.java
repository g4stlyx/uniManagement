import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class FileStuff {
    FileStuff(){}

    public static Admin readAdmin(){
        Admin admin = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("db/admin.ser")));
            admin = (Admin) in.readObject();
        } 
        catch (EOFException e){
        }
        catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return admin;
    }

    public static HashMap<Integer,Person> readTxt(String pathname) {
        HashMap<Integer,Person> users = new HashMap<>();
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(pathname)));
            users = (HashMap) in.readObject();
        } 
        catch (EOFException e){ // end of the file reached here
        } 
        catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return users;
    }
    
    public static HashMap<Integer,Person> editStudentsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        HashMap<Integer,Person> data = readTxt("db/_students.ser");
        Student chosenStudent;
        for (Person person : data.values()) {
            Student student = (Student)person;
            if (student.getStudentId() == userId){
                chosenStudent = student;
                chosenStudent.setPhoneNumber(newPhone);
                chosenStudent.setEmail(newEmail);
                chosenStudent.setAddress(newAddress);
                data.remove(student.getStudentId());
                data.put(chosenStudent.getStudentId(), chosenStudent);
                break;
            }
        }
        writeTxt(data, "db/_instructors.ser");
        return data;
    }

    public static void writeTxt(HashMap<Integer,Person> data,String pathname) {
        try {
            FileOutputStream fileOut = new FileOutputStream(pathname);
            BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);
            ObjectOutputStream out = new ObjectOutputStream(bufferedOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void writeTxt(Admin admin,String pathname){ // for the admin only
        try {
            FileOutputStream fileOut = new FileOutputStream(pathname);
            BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut);
            ObjectOutputStream out = new ObjectOutputStream(bufferedOut);
            out.writeObject(admin);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static HashMap<Integer,Person> editInstructorsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        HashMap<Integer,Person> instructorData = readTxt("db/_instructors.ser");
        Instructor chosenInstructor;
        for (Person person : instructorData.values()) {
            Instructor instructor = (Instructor)person;
            if (instructor.getId() == userId){
                chosenInstructor = instructor;
                chosenInstructor.setPhoneNumber(newPhone);
                chosenInstructor.setEmail(newEmail);
                chosenInstructor.setAddress(newAddress);
                instructorData.remove(instructor.getId());
                instructorData.put(chosenInstructor.getId(),chosenInstructor);
                break;
            }
        }
        writeTxt(instructorData, "db/_instructors.ser");

        return instructorData;
    }

    public static HashMap<Integer,Person> editStudentGrades(int userId,ArrayList<String> newGrades){
        HashMap<Integer,Person> studentData = readTxt("db/_students.ser");
        for (Person person : studentData.values()) {
            Student student = (Student)person;
            if (student.getStudentId() == userId) {
                Student chosenStudent = student;
                chosenStudent.setGrades(newGrades);
                studentData.remove(student.getStudentId());
                studentData.put(chosenStudent.getStudentId(),chosenStudent);
                break;
            }
        }
        return studentData;
    }

    public static void addUser(Person person,String pathname){
        try{
            ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathname)));
            if(pathname.equals("db/_instructors.ser")){
                HashMap<Integer,Instructor> instructors = Instructor.getAllInstructors();
                for(Instructor instructor : instructors.values()){
                    instructor.add();
                }
                ((Instructor)person).add();
                writer.writeObject(Instructor.getAllInstructors());
            }
            else if(pathname.equals("db/_students.ser")){
                HashMap<Integer,Student> students = Student.getAllStudents();
                for(Student student : students.values()){
                    student.add();
                }
                ((Student)person).add();
                writer.writeObject(Student.getAllStudents());
            }
            writer.close();
            writer.flush();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void deleteUser(int userId,String pathname){
        try{
            ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathname)));
            if(pathname.equals("db/_instructors.ser")){
                HashMap<Integer,Instructor> instructors = Instructor.getAllInstructors();
                for(Instructor instructor : instructors.values()){
                    instructor.add();
                }
                instructors.remove(userId);
                writer.writeObject(Instructor.getAllInstructors());
            }
            else if(pathname.equals("db/_students.ser")){
                HashMap<Integer,Student> students = Student.getAllStudents();
                for(Student student : students.values()){
                    student.add();
                }
                students.remove(userId);
                writer.writeObject(Student.getAllStudents());
            }
            writer.close();
            writer.flush();  
        } 
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}