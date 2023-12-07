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

    public static ArrayList<String> readTxt(String pathname) {
        try {
            File txtFile = new File(pathname);
            Scanner scanner = new Scanner(txtFile);
            ArrayList<String> dataTotal = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();                
                dataTotal.add("\n" + data); //! burası ilk baştaki boşluğun sebebi olabilir
            }
            scanner.close();
            return dataTotal;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a;
        }
    }

    public static ArrayList<String> editStudentsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_students.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 1;

            ArrayList<String> studentData = readTxt("db/_students.txt");
            String studentDataToEdit = studentData.get(userId - 1);

            String id = studentDataToEdit.split("-")[0];
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

            String newStudentData = id + "-" + name + "-" + newAddress + "-" + newPhone + "-" + newEmail + "-" + number
                    + "-" + pwd + "-" + faculty + "-" + department + "-" + gradeLevel + "-" + annualPayment + "-"
                    + courses + "-" + grades + "-" + clubs + "-" + clubsDescriptions;

            // TODO: error handling for the first line doesnt work here, while editing it creates an empty line at the top
            while((line = reader.readLine()) != null){
                // if(currentLine == userId && userId == 1 ){
                //     content.append(newStudentData); // to avoid white spaces in first line in the text file
                // }
                if(currentLine == userId){
                    content.append(newStudentData).append("\n");
                }
                else if(currentLine == (userId-1)){
                    content.append(line); // to avoid white spaces in txt file
                }
                else{
                    content.append(line).append("\n");
                }
                currentLine++;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_students.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return studentData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a;
        }
    }

    public static ArrayList<String> editInstructorsTxt(int userId, String newPhone, String newEmail, String newAddress) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_instructors.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 1;

            ArrayList<String> instructorData = readTxt("db/_instructors.txt");
            String instructorDataToEdit = instructorData.get(userId - 1);

            String id = instructorDataToEdit.split("-")[0];
            String name = instructorDataToEdit.split("-")[1];            
            String courses = instructorDataToEdit.split("-")[5];
            String salary = instructorDataToEdit.split("-")[6];
            String username = instructorDataToEdit.split("-")[7];
            String pwd = instructorDataToEdit.split("-")[8];

            String newInstructorData = id + "-" + name + "-" + newAddress + "-" + newPhone + "-" + newEmail + "-"
                    + courses + "-" + salary + "-" + username + "-" + pwd ;

            // TODO: error handling for the first line doesnt work here, while editing it creates an empty line at the top
            while((line = reader.readLine()) != null){
                // if(currentLine == userId && userId == 1 ){
                //     content.append(newStudentData); // to avoid white spaces in first line in the text file
                // }
                if(currentLine == userId){
                    content.append(newInstructorData).append("\n");
                }
                else if(currentLine == (userId-1)){
                    content.append(line); // to avoid white spaces in txt file
                }
                else{
                    content.append(line).append("\n");
                }
                currentLine++;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_instructors.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return instructorData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a;
        }
    }

    public static ArrayList<String> editStudentGrades(int userId,String newGrades){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_students.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 1;

            ArrayList<String> studentData = readTxt("db/_students.txt");
            String studentDataToEdit = studentData.get(userId -1);

            String id = studentDataToEdit.split("-")[0];
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

            String newStudentData = id + "-" + name + "-" + address + "-" + phone + "-" + email + "-" + number
                    + "-" + pwd + "-" + faculty + "-" + department + "-" + gradeLevel + "-" + annualPayment + "-"
                    + courses + "-" + newGrades + "-" + clubs + "-" + clubsDescriptions;


            while((line = reader.readLine()) != null){
                if(currentLine == userId){
                    content.append(newStudentData).append("\n");
                }
                else if(currentLine == (userId-1)){
                    content.append(line); // to avoid white spaces in txt file
                }
                else{
                    content.append(line).append("\n");
                }
                currentLine++;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_students.txt"));
            writer.write(content.toString());

            reader.close();
            writer.close();
            return studentData;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a;
        }
    }


}