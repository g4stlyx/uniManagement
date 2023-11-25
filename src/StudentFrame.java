import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class StudentFrame extends JFrame {

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
	private JTextField facultyField;
	private JTextField departmentField;
	private JTextField gradeLevelField;
	private JTextField annualFeeField;

	//! dont forget to uncomment all panels after you done editing, eg. you dont have the educational panel rn

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame("a");
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame(String student) {
		
		setTitle("University Management System - Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("Welcome back, "+ student.split("-")[1]);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		welcomeLabel.setBounds(31, 11, 927, 63);
		contentPane.add(welcomeLabel);

		// educational info
		JPanel educationalInfoPanel = new JPanel();
		educationalInfoPanel.setBackground(new Color(128, 128, 128));
		educationalInfoPanel.setBounds(270, 84, 794, 306);
		educationalInfoPanel.setLayout(null);
		educationalInfoPanel.setVisible(false);
		contentPane.add(educationalInfoPanel);
		
		JLabel facultyLabel = new JLabel("Faculty: ");
		facultyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		facultyLabel.setBounds(11, 48, 85, 25);
		educationalInfoPanel.add(facultyLabel);
		
		facultyField = new JTextField();
		facultyField.setBounds(159, 47, 138, 35);
		educationalInfoPanel.add(facultyField);
		facultyField.setColumns(10);
		facultyField.setText(student.split("-")[7]);
		facultyField.setEditable(false);
		
		JLabel departmentLabel = new JLabel("Department:");
		departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		departmentLabel.setBounds(11, 101, 138, 25);
		educationalInfoPanel.add(departmentLabel);
		
		departmentField = new JTextField();
		departmentField.setColumns(10);
		departmentField.setBounds(159, 100, 138, 35);
		departmentField.setText(student.split("-")[8]);
		departmentField.setEditable(false);
		educationalInfoPanel.add(departmentField);
		
		
		JLabel gradeLevelLabel = new JLabel("Grade Level:");
		gradeLevelLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeLevelLabel.setBounds(11, 181, 138, 25);
		educationalInfoPanel.add(gradeLevelLabel);
		
		gradeLevelField = new JTextField();
		gradeLevelField.setColumns(10);
		gradeLevelField.setBounds(159, 180, 138, 35);
		gradeLevelField.setText(student.split("-")[9]);
		gradeLevelField.setEditable(false);
		educationalInfoPanel.add(gradeLevelField);
		
		JLabel annualFeeLabel = new JLabel("Annual Fee:");
		annualFeeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		annualFeeLabel.setBounds(11, 234, 138, 25);
		educationalInfoPanel.add(annualFeeLabel);
		
		annualFeeField = new JTextField();
		annualFeeField.setColumns(10);
		annualFeeField.setBounds(159, 233, 138, 35);
		annualFeeField.setText(student.split("-")[10]);
		annualFeeField.setEditable(false);
		educationalInfoPanel.add(annualFeeField);
		
		JLabel coursesLabel = new JLabel("Courses");
		coursesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coursesLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		coursesLabel.setBounds(432, 11, 92, 25);
		educationalInfoPanel.add(coursesLabel);
		
		JLabel gradesLevel = new JLabel("Grades");
		gradesLevel.setHorizontalAlignment(SwingConstants.CENTER);
		gradesLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradesLevel.setBounds(666, 11, 85, 25);
		educationalInfoPanel.add(gradesLevel);
		
		JPanel gradesArea = new JPanel();
		gradesArea.setBounds(666, 48, 92, 221);
		educationalInfoPanel.add(gradesArea);

		JPanel coursesArea = new JPanel();
		coursesArea.setBounds(330, 48, 306, 221);
		educationalInfoPanel.add(coursesArea);
		

		String[] coursesArray = student.split("-")[11].split("_");
		String[] gradesArray = student.split("-")[12].split("_");

		for(int i=0;i<coursesArray.length;i++){
			JLabel[] coursesLabels = new JLabel[coursesArray.length];
			coursesLabels[i] = new JLabel("<html>"+coursesArray[i]+"<br></html>");
			coursesLabels[i].setBorder(BorderFactory.createEmptyBorder(0,30,0,30)); // for the linespacing
			coursesLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			coursesLabels[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			coursesArea.add(coursesLabels[i]);

			coursesArea.revalidate();
			coursesArea.repaint();
		}

		for(int i=0;i<gradesArray.length;i++){
			JLabel[] gradesLabels = new JLabel[gradesArray.length];
			gradesLabels[i] = new JLabel(gradesArray[i]);
			gradesLabels[i].setBorder(BorderFactory.createEmptyBorder(0,30,0,30)); // for the linespacing
			gradesLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			gradesLabels[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			gradesArea.add(gradesLabels[i]);

			gradesArea.revalidate();
			gradesArea.repaint();
		}
		

		
		// **********************************
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
		idField.setText(student.split("-")[0]);
		idField.setEditable(false);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		idLabel.setBounds(10, 78, 108, 29);
		personalInfoPanel.add(idLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(128, 118, 142, 29);
		personalInfoPanel.add(nameField);
		nameField.setText(student.split("-")[1]);
		nameField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(128, 158, 142, 29);
		personalInfoPanel.add(phoneField);
		phoneField.setText(student.split("-")[3]);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(388, 78, 396, 29);
		personalInfoPanel.add(addressField);
		addressField.setText(student.split("-")[2]);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		nameLabel.setBounds(10, 118, 108, 29);
		personalInfoPanel.add(nameLabel);
		
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		phoneLabel.setBounds(10, 158, 108, 29);
		personalInfoPanel.add(phoneLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		addressLabel.setBounds(280, 78, 108, 29);
		personalInfoPanel.add(addressLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		emailLabel.setBounds(10, 199, 108, 29);
		personalInfoPanel.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(128, 199, 142, 29);
		personalInfoPanel.add(emailField);
		emailField.setText(student.split("-")[4]);
		
		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		numberLabel.setBounds(10, 240, 120, 29);
		personalInfoPanel.add(numberLabel);
		
		JTextField numberField = new JTextField();
		numberField.setColumns(10);
		numberField.setBounds(128, 240, 142, 29);
		personalInfoPanel.add(numberField);
		numberField.setText(student.split("-")[5]);
		numberField.setEditable(false);
		
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
		usernameField.setText(student.split("-")[5]);
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
		
		// save
		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		saveButton.setBounds(670, 199, 114, 70);
		personalInfoPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// save everything and write to the students.txt
				// then set name,phone,email,address
				String passwordInput1 = String.valueOf(passwordField1.getPassword());
				String passwordInput2 = String.valueOf(passwordField2.getPassword());
				if(passwordInput1.equals(student.split("-")[6]) && passwordInput2.equals(student.split("-")[6])){
					// write to the students.txt
					// warning
					int idInt = Integer.parseInt(idField.getText().trim()); // trim çünkü idField.getText()=" 5"
					FileStuff.editTxt(idInt,phoneField.getText(),emailField.getText(),addressField.getText(),"db/_students.txt");
					passwordInput1 = "";
					passwordInput2 = "";
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"Incorrect Password!","Bad Request!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel attendanceInfoPanel = new JPanel();
		attendanceInfoPanel.setBackground(new Color(128, 128, 128));
		attendanceInfoPanel.setBounds(270, 84, 794, 306);
		attendanceInfoPanel.setLayout(null);
		attendanceInfoPanel.setVisible(false);
		contentPane.add(attendanceInfoPanel);

		JPanel clubsPanel = new JPanel();
		clubsPanel.setBackground(new Color(128, 128, 128));
		clubsPanel.setBounds(270, 84, 794, 306);
		clubsPanel.setLayout(null);
		clubsPanel.setVisible(false);
		contentPane.add(clubsPanel);
		
		// left buttons
		JButton personalInfoButton = new JButton("Personal Information");
		personalInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				personalInfoPanel.setVisible(true);
				educationalInfoPanel.setVisible(false);
				attendanceInfoPanel.setVisible(false);
				clubsPanel.setVisible(false);
			}
		});
		personalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		personalInfoButton.setBounds(10, 85, 250, 53);
		contentPane.add(personalInfoButton);
		
		JButton educationalInfoButton = new JButton("Educational Information");
		educationalInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				educationalInfoPanel.setVisible(true);
				attendanceInfoPanel.setVisible(false);
				clubsPanel.setVisible(false);
			}
		});
		educationalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		educationalInfoButton.setBounds(10, 171, 250, 52);
		contentPane.add(educationalInfoButton);
		
		JButton attendanceInfoButton = new JButton("Attendance Information");
		attendanceInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				educationalInfoPanel.setVisible(false);
				attendanceInfoPanel.setVisible(true);
				clubsPanel.setVisible(false);
			}
		});
		attendanceInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		attendanceInfoButton.setBounds(10, 254, 250, 52);
		contentPane.add(attendanceInfoButton);
		
		JButton clubsButton = new JButton("Clubs Registered");
		clubsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				educationalInfoPanel.setVisible(false);
				attendanceInfoPanel.setVisible(false);
				clubsPanel.setVisible(true);
			}
		});
		clubsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clubsButton.setBounds(10, 338, 250, 52);
		contentPane.add(clubsButton);
				
	}
}
