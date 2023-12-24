import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class InstructorFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField addressField;
	private JTextField emailField;
	private JTextField usernameField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JList coursesList;
	private JTextField[] gradesTextFields;
	Student selectedStudent;
	private String[] selectedStudentCoursesArray;
	private String[] selectedStudentGradesArray;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorFrame frame = new InstructorFrame(new Instructor());
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InstructorFrame(Instructor instructor) {
		setTitle("University Management System - Instructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("Welcome back, "+ instructor.getName());
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		welcomeLabel.setBounds(232, 10, 570, 63);
		contentPane.add(welcomeLabel);
		
		// ********
		// personalInfo
		JPanel personalInfoPanel = new JPanel();
		personalInfoPanel.setBounds(270, 84, 794, 306);
		personalInfoPanel.setBackground(new Color(128, 128, 128));
		personalInfoPanel.setLayout(null);
		personalInfoPanel.setVisible(false);
		contentPane.add(personalInfoPanel);
		
		JLabel personalInfoHeader = new JLabel("Personal Information");
		personalInfoHeader.setHorizontalAlignment(SwingConstants.CENTER);
		personalInfoHeader.setFont(new Font("Tahoma", Font.PLAIN, 24));
		personalInfoHeader.setBounds(220, 11, 321, 36);
		personalInfoPanel.add(personalInfoHeader);
		
		idField = new JTextField();
		idField.setBounds(128, 78, 142, 29);
		personalInfoPanel.add(idField);
		idField.setColumns(10);
		idField.setText(""+instructor.getId());
		idField.setEditable(false);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		idLabel.setBounds(10, 78, 108, 29);
		personalInfoPanel.add(idLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(128, 133, 142, 29);
		personalInfoPanel.add(nameField);
		nameField.setText(instructor.getName());
		nameField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(128, 185, 142, 29);
		personalInfoPanel.add(phoneField);
		phoneField.setText(instructor.getPhoneNumber());
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(388, 78, 396, 29);
		personalInfoPanel.add(addressField);
		addressField.setText(instructor.getAddress());
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		nameLabel.setBounds(10, 133, 108, 29);
		personalInfoPanel.add(nameLabel);
		
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		phoneLabel.setBounds(10, 185, 108, 29);
		personalInfoPanel.add(phoneLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		addressLabel.setBounds(280, 78, 108, 29);
		personalInfoPanel.add(addressLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		emailLabel.setBounds(10, 240, 108, 29);
		personalInfoPanel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(128, 240, 142, 29);
		personalInfoPanel.add(emailField);
		emailField.setText(instructor.getEmail());
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		usernameLabel.setBounds(280, 158, 120, 29);
		personalInfoPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		passwordLabel.setBounds(280, 199, 120, 29);
		personalInfoPanel.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(496, 158, 142, 29);
		personalInfoPanel.add(usernameField);
		usernameField.setText(instructor.getUsername());
		usernameField.setEditable(false);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(496, 199, 142, 29);
		personalInfoPanel.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(496, 240, 142, 29);
		personalInfoPanel.add(passwordField2);
		
		JLabel passwordLabel2 = new JLabel("Password Again:");
		passwordLabel2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		passwordLabel2.setBounds(280, 240, 185, 29);
		personalInfoPanel.add(passwordLabel2);

		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		saveButton.setBounds(670, 199, 114, 70);
		personalInfoPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordInput1 = String.valueOf(passwordField1.getPassword());
				String passwordInput2 = String.valueOf(passwordField2.getPassword());
				if(passwordInput1.equals(instructor.getPassword()) && passwordInput2.equals(instructor.getPassword())){
					int idInt = Integer.parseInt(idField.getText().trim());
					FileStuff.editInstructors(idInt,phoneField.getText(),emailField.getText(),addressField.getText());
					passwordField1.setText("");
					passwordField2.setText("");
					Instructor.edit(idInt,instructor.getName(),addressField.getText(),phoneField.getText(),emailField.getText(),instructor.getCourses(),instructor.getSalary(),instructor.getUsername(),instructor.getPassword());

					JOptionPane.showMessageDialog(contentPane,"Instructor Edited Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"Incorrect Password!","Bad Request!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// ********
		// studentsInfo
		JPanel studentsPanel = new JPanel();
		studentsPanel.setBounds(270, 84, 794, 306);
		studentsPanel.setBackground(new Color(128, 128, 128));
		studentsPanel.setLayout(null);
		studentsPanel.setVisible(false);
		contentPane.add(studentsPanel);
	
		JList studentsList = new JList(FileStuff.read("db/students.ser").values().toArray());
		studentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentsList.setBounds(10, 11, 153, 240);
		studentsPanel.add(studentsList);

		JPanel gradesArea = new JPanel();
		gradesArea.setBounds(582, 11, 190, 240);
		studentsPanel.add(gradesArea);

		coursesList = new JList();
		coursesList.setBounds(173, 11, 399, 240);
		coursesList.setFont(new Font("Tahoma", Font.BOLD, 15));
		DefaultListModel coursesListModel = new DefaultListModel();
		coursesList.setModel(coursesListModel);
		studentsPanel.add(coursesList);
		
		JButton selectStudentButton = new JButton("Select Student");
		selectStudentButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		selectStudentButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				coursesListModel.clear();
				gradesArea.removeAll();

				selectedStudent = (Student)studentsList.getSelectedValue();
				
				// ArrayList<String> to Object[], then to String[]
				selectedStudentCoursesArray = selectedStudent.getCourses().toArray(new String[selectedStudent.getCourses().toArray().length]); // Returns an array of courses
				selectedStudentGradesArray = selectedStudent.getGrades().toArray(new String[selectedStudent.getGrades().toArray().length]); // Returns an array of grades

				List<String> gradesList = new ArrayList<>();
				for (String grade : selectedStudentGradesArray) {
					String[] temp = grade.split(",");
					for (String gradePair : temp) {
						String[] grades = gradePair.split("_");
						Collections.addAll(gradesList, grades);
					}
				}

				coursesList.setListData(selectedStudentCoursesArray);
				studentsPanel.add(coursesList);

				gradesTextFields = new JTextField[gradesList.size()];
				for (int i = 0; i < gradesList.size(); i++) {
					gradesTextFields[i] = new JTextField(gradesList.get(i));
					gradesTextFields[i].setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
					gradesTextFields[i].setHorizontalAlignment(SwingConstants.CENTER);
					gradesTextFields[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					gradesArea.add(gradesTextFields[i]);
				}

				revalidate();
				repaint();
			}
		});

		selectStudentButton.setBounds(10, 262, 153, 33);
		studentsPanel.add(selectStudentButton);
		
		JButton editStudentButton = new JButton("Edit Student");
		editStudentButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		editStudentButton.setBounds(585, 262, 153, 33);
		editStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> grades = new ArrayList<>();
				for (int i=0; i<gradesTextFields.length; i++) {
					grades.add(gradesTextFields[i].getText());
				}

				Student.edit(selectedStudent.getId(),selectedStudent.getName(),selectedStudent.getAddress(),selectedStudent.getPhoneNumber(),selectedStudent.getEmail(),selectedStudent.getPassword(),selectedStudent.getFaculty(),selectedStudent.getDepartment(),selectedStudent.getAnnualFee(),selectedStudent.getAnnualFee(),selectedStudent.getCourses(),grades,selectedStudent.getClubs(),selectedStudent.getClubDescriptions());
				FileStuff.editStudentGrades(selectedStudent.getId(),grades);
		 		JOptionPane.showMessageDialog(contentPane,"Student's Grades Edited Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		studentsPanel.add(editStudentButton);

		// left buttons
		JButton personalInfoButton = new JButton("Personal Information");
		personalInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				personalInfoPanel.setVisible(true);
				studentsPanel.setVisible(false);
			}
		});
		personalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		personalInfoButton.setBounds(10, 142, 250, 52);
		contentPane.add(personalInfoButton);
		
		
		JButton studentsInfoButton = new JButton("Students Information");
		studentsInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				studentsPanel.setVisible(true);
			}
		});
		studentsInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studentsInfoButton.setBounds(10, 205, 250, 52);
		contentPane.add(studentsInfoButton);
		
		JButton goBack = new JButton("Go Back");
		goBack.setBounds(23, 30, 100, 37);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLoginFrame().setVisible(true);
				dispose();
			}
		});
		contentPane.add(goBack);
	}
}