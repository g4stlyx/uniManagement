import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStuff {
    FileStuff(){}
    // TODO: dosya okuyup yazarken String değil Object(Student,Instructor) kullan

    public static ArrayList<String> readTxt(String pathname) {
        try {
            File txtFile = new File(pathname);
            Scanner scanner = new Scanner(txtFile);
            ArrayList<String> dataTotal = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();                
                dataTotal.add("\n" + data);
            }
            scanner.close();
            return dataTotal;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<String>();
        }
    }

    public static ArrayList<String> editStudentsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_students.txt"));
            StringBuilder content = new StringBuilder();
            String line;

            ArrayList<String> studentData = readTxt("db/_students.txt");
            String studentDataToEdit = "";
            for (String student : studentData) {
                if (Integer.parseInt(student.split("-")[0].trim()) == userId) {
                    studentDataToEdit = student;
                    break;
                }
            }
            
            String name = studentDataToEdit.split("-")[1];
            String number = studentDataToEdit.split("-")[5];
            String pwd = studentDataToEdit.split("-")[6];
            String faculty = studentDataToEdit.split("-")[7];
            String department = studentDataToEdit.split("-")[8];
            String gradeLevel = studentDataToEdit.split("-")[9];
            String annualPayment = studentDataToEdit.split("-")[10];
            String courses = studentDataToEdit.split("-")[11];
            String grades = studentDataToEdit.split("-")[12];
            String clubs = studentDataToEdit.split("-")[13];
            String clubsDescriptions = studentDataToEdit.split("-")[14];

            String newStudentData = userId + "-" + name + "-" + newAddress + "-" + newPhone + "-" + newEmail + "-" + number
                    + "-" + pwd + "-" + faculty + "-" + department + "-" + gradeLevel + "-" + annualPayment + "-"
                    + courses + "-" + grades + "-" + clubs + "-" + clubsDescriptions;

            while((line = reader.readLine()) != null){
                String currentId=line.split("-")[0].trim();
                if(Integer.parseInt(currentId) == userId){
                    content.append(newStudentData);
                }
                else {
                    content.append(line); 
                }
                content.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_students.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return studentData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<String>();
        }
    }

    public static ArrayList<String> editInstructorsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_instructors.txt"));
            StringBuilder content = new StringBuilder();
            String line;

            ArrayList<String> instructorData = readTxt("db/_instructors.txt");
            String instructorDataToEdit = "";
            for (String instructor : instructorData) {
                if (Integer.parseInt(instructor.split("-")[0]) == userId) {
                    instructorDataToEdit = instructor;
                    break;
                }
            }

            String name = instructorDataToEdit.split("-")[1];            
            String courses = instructorDataToEdit.split("-")[5];
            String salary = instructorDataToEdit.split("-")[6];
            String username = instructorDataToEdit.split("-")[7];
            String pwd = instructorDataToEdit.split("-")[8];

            String newInstructorData = userId + "-" + name + "-" + newAddress + "-" + newPhone + "-" + newEmail + "-"
                    + courses + "-" + salary + "-" + username + "-" + pwd ;

            while((line = reader.readLine()) != null){
	            String currentId=line.split("-")[0];
	            if(Integer.parseInt(currentId) == userId){
	                content.append(newInstructorData);
	            }
                else {
	                content.append(line); 
	            }               
               content.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_instructors.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return instructorData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<String>();
        }
    }

    public static ArrayList<String> editStudentGrades(int userId,String newGrades){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_students.txt"));
            StringBuilder content = new StringBuilder();
            String line;

            ArrayList<String> studentData = readTxt("db/_students.txt");
            String studentDataToEdit = "";
            for (String student : studentData) {
                if (Integer.parseInt(student.split("-")[0].trim()) == userId) {
                    studentDataToEdit = student;
                    break;
                }
            }

            String name = studentDataToEdit.split("-")[1];
            String address = studentDataToEdit.split("-")[2];
            String phone = studentDataToEdit.split("-")[3];
            String email = studentDataToEdit.split("-")[4];
            String number = studentDataToEdit.split("-")[5];
            String pwd = studentDataToEdit.split("-")[6];
            String faculty = studentDataToEdit.split("-")[7];
            String department = studentDataToEdit.split("-")[8];
            String gradeLevel = studentDataToEdit.split("-")[9];
            String annualPayment = studentDataToEdit.split("-")[10];
            String courses = studentDataToEdit.split("-")[11];
            String clubs = studentDataToEdit.split("-")[13];
            String clubsDescriptions = studentDataToEdit.split("-")[14];

            String newStudentData = userId + "-" + name + "-" + address + "-" + phone + "-" + email + "-" + number
                    + "-" + pwd + "-" + faculty + "-" + department + "-" + gradeLevel + "-" + annualPayment + "-"
                    + courses + "-" + newGrades + "-" + clubs + "-" + clubsDescriptions;


            while((line = reader.readLine()) != null){
	            String currentId=line.split("-")[0];
	            if(Integer.parseInt(currentId) == userId){
	                content.append(newStudentData);
	            }
                else {
	                content.append(line); 
	            }               
               content.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_students.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return studentData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<String>();
        }
    }

    public static void addUser(String userData,String pathname){
        try{
            FileWriter writer = new FileWriter(pathname, true); // true makes it protect old data
            writer.append(userData);
            if (new File(pathname).length() != 0) {
                writer.append("\n");
            }
            writer.close();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void updateUser(String userData,int userId,String pathname){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathname));
            StringBuilder content = new StringBuilder();
            String line;
            
            while((line = reader.readLine()) != null){
                String currentId=line.split("-")[0];
                if(Integer.parseInt(currentId.trim()) == userId){
                    content.append(userData);
                }
                else {
                    content.append(line); 
                }
                content.append("\n");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));
            writer.write(content.toString());

            reader.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deleteUser(int userId,String pathname){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathname));
            StringBuilder content = new StringBuilder();
            String line;
            
            while((line = reader.readLine()) != null){
                String currentId=line.split("-")[0].trim();
                if(Integer.parseInt(currentId) != userId){
                    content.append(line+"\n");
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));
            writer.write(content.toString());

            reader.close();
            writer.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}