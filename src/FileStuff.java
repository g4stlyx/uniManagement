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

    public static ArrayList<String> readStudentsTxt(){
        try { 
            // TODO: pathname'i parametre olarak al, bir func tüm dosyaları okusun
            File studentsTxt = new File("db/_students.txt");
            Scanner scanner = new Scanner(studentsTxt);
            ArrayList<String> dataTotal = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                dataTotal.add("\n"+data);
            }

            scanner.close();
            return dataTotal;
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a; 
        }
    }

    public static ArrayList<String> editStudentsTxt(int userId,String newPhone,String newEmail,String newAddress){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("db/_students.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 1;

            ArrayList<String> studentData = readStudentsTxt();
            
            String studentDataToEdit = studentData.get(userId-1);
            
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

            String newStudentData = id+"-"+name+"-"+newAddress+"-"+newPhone+"-"+newEmail+"-"+number+"-"+pwd+"-"+faculty+"-"+department+"-"+gradeLevel+"-"+annualPayment+"-"+courses+"-"+grades+"-"+clubs;

            while((line= reader.readLine()) != null){
                if(currentLine == userId ){
                    content.append(newStudentData).append("\n");
                }
                else if(currentLine == (userId-1)){
                    content.append(line);
                }
                else{
                    content.append(line).append("\n");
                }
                currentLine++;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("db/_students.txt"));
            writer.write(content.toString());

            System.out.println(studentData);
            System.out.println(studentDataToEdit);
            System.out.println(newStudentData);

            reader.close();
            writer.close();
            return studentData;
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            ArrayList<String> a = new ArrayList<String>();
            a.add(ex.getMessage());
            return a; 
        }
    }


}