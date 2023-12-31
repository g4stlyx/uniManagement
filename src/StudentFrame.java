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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame(new Student());
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame(Student student) {
		setTitle("University Management System v2.1 - Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("Welcome back, "+ student.getName());
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
		facultyField.setText(student.getFaculty());
		facultyField.setEditable(false);
		
		JLabel departmentLabel = new JLabel("Department:");
		departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		departmentLabel.setBounds(11, 101, 138, 25);
		educationalInfoPanel.add(departmentLabel);
		
		departmentField = new JTextField();
		departmentField.setColumns(10);
		departmentField.setBounds(159, 100, 138, 35);
		departmentField.setText(student.getDepartment());
		departmentField.setEditable(false);
		educationalInfoPanel.add(departmentField);
		
		JLabel gradeLevelLabel = new JLabel("Grade Level:");
		gradeLevelLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeLevelLabel.setBounds(11, 181, 138, 25);
		educationalInfoPanel.add(gradeLevelLabel);
		
		gradeLevelField = new JTextField();
		gradeLevelField.setColumns(10);
		gradeLevelField.setBounds(159, 180, 138, 35);
		gradeLevelField.setText(student.getGradeLevel());
		gradeLevelField.setEditable(false);
		educationalInfoPanel.add(gradeLevelField);
		
		JLabel annualFeeLabel = new JLabel("Annual Fee:");
		annualFeeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		annualFeeLabel.setBounds(11, 234, 138, 25);
		educationalInfoPanel.add(annualFeeLabel);
		
		annualFeeField = new JTextField();
		annualFeeField.setColumns(10);
		annualFeeField.setBounds(159, 233, 138, 35);
		annualFeeField.setText(student.getAnnualFee());
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
		gradesLevel.setBounds(670, 11, 85, 25);
		educationalInfoPanel.add(gradesLevel);
		
		JPanel gradesArea = new JPanel();
		gradesArea.setBounds(670, 48, 100, 221);
		educationalInfoPanel.add(gradesArea);

		JPanel coursesArea = new JPanel();
		coursesArea.setBounds(330, 48, 306, 221);
		educationalInfoPanel.add(coursesArea);
		
		Object[] coursesArray = student.getCourses().toArray();
		Object[] gradesArray = student.getGrades().toArray();

		for(int i=0;i<coursesArray.length;i++){
			JLabel[] coursesLabels = new JLabel[coursesArray.length];
			coursesLabels[i] = new JLabel("<html>"+coursesArray[i]+"<br></html>");
			coursesLabels[i].setBorder(BorderFactory.createEmptyBorder(0,150,0,150)); // for the linespacing
			coursesLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			coursesLabels[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			coursesArea.add(coursesLabels[i]);

			coursesArea.revalidate();
			coursesArea.repaint();
		}

		for(int i=0;i<gradesArray.length;i++){
			JLabel[] gradesLabels = new JLabel[gradesArray.length];
			gradesLabels[i] = new JLabel(gradesArray[i].toString());
			gradesLabels[i].setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
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
		idField.setText(""+student.getId());
		idField.setEditable(false);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		idLabel.setBounds(10, 78, 108, 29);
		personalInfoPanel.add(idLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(128, 118, 142, 29);
		personalInfoPanel.add(nameField);
		nameField.setText(student.getName());
		nameField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(128, 158, 142, 29);
		personalInfoPanel.add(phoneField);
		phoneField.setText(student.getPhoneNumber());
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(388, 78, 396, 29);
		personalInfoPanel.add(addressField);
		addressField.setText(student.getAddress());
		
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
		emailField.setText(student.getEmail());
		
		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		numberLabel.setBounds(10, 240, 120, 29);
		personalInfoPanel.add(numberLabel);
		
		JTextField numberField = new JTextField();
		numberField.setColumns(10);
		numberField.setBounds(128, 240, 142, 29);
		personalInfoPanel.add(numberField);
		numberField.setText(student.getStudentNumber());
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
		usernameField.setText(student.getStudentNumber());
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
				String passwordInput1 = String.valueOf(passwordField1.getPassword());
				String passwordInput2 = String.valueOf(passwordField2.getPassword());
				if(passwordInput1.equals(student.getPassword().trim()) && passwordInput2.equals(student.getPassword().trim())){
					int idInt = Integer.parseInt(idField.getText().trim());
					
					Student.edit(idInt,student.getName(),student.getAddress(),student.getPhoneNumber(),student.getEmail(),student.getPassword(),student.getFaculty(),student.getDepartment(),student.getGradeLevel(),student.getAnnualFee(),student.getCourses(),student.getGrades(),student.getClubs(),student.getClubDescriptions());

					FileStuff.editStudents(idInt,phoneField.getText(),emailField.getText(),addressField.getText());
					passwordField1.setText("");
					passwordField2.setText("");
					JOptionPane.showMessageDialog(contentPane,"Student Edited Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"Incorrect Password!","Bad Request!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// ********************
		// clubs
		JPanel clubsPanel = new JPanel();
		clubsPanel.setBackground(new Color(128, 128, 128));
		clubsPanel.setBounds(270, 84, 794, 306);
		clubsPanel.setLayout(null);
		clubsPanel.setVisible(false);
		contentPane.add(clubsPanel);
		
		JPanel clubsPanel2 = new JPanel();
		clubsPanel2.setBackground(new Color(128, 128, 128));
		clubsPanel2.setBounds(0, 0, 794, 306);
		clubsPanel.add(clubsPanel2);
		
		Object[] clubsArray = student.getClubs().toArray();
		Object[] clubsDescriptionsArray = student.getClubDescriptions().toArray();
		
		for(int i=0;i<clubsArray.length;i++){
			JLabel[] clubsLabels = new JLabel[clubsArray.length];
			clubsLabels[i] = new JLabel(clubsArray[i].toString());
			clubsLabels[i].setBorder(BorderFactory.createEmptyBorder(0,200,0,200));
			clubsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			clubsLabels[i].setFont(new Font("Tahoma", Font.BOLD, 18));
						
			JLabel[] clubsDescriptionsLabels = new JLabel[clubsArray.length];
			clubsDescriptionsLabels[i] = new JLabel("-"+clubsDescriptionsArray[i]);
			clubsDescriptionsLabels[i].setBorder(BorderFactory.createEmptyBorder(0,200,0,200));
			clubsDescriptionsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			clubsDescriptionsLabels[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			
			clubsPanel2.add(clubsLabels[i]);
			clubsPanel2.add(clubsDescriptionsLabels[i]);
	
			clubsPanel.revalidate();
			clubsPanel.repaint();
			
			revalidate();
			repaint();
		}
		
		// left buttons
		JButton personalInfoButton = new JButton("Personal Information");
		personalInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				personalInfoPanel.setVisible(true);
				educationalInfoPanel.setVisible(false);
				clubsPanel.setVisible(false);
			}
		});
		personalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		personalInfoButton.setBounds(10, 142, 250, 52);
		contentPane.add(personalInfoButton);
		
		JButton educationalInfoButton = new JButton("Educational Information");
		educationalInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				educationalInfoPanel.setVisible(true);
				clubsPanel.setVisible(false);
			}
		});

		educationalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		educationalInfoButton.setBounds(10, 205, 250, 52);
		contentPane.add(educationalInfoButton);
		
		JButton clubsButton = new JButton("Clubs Registered");
		clubsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				educationalInfoPanel.setVisible(false);
				clubsPanel.setVisible(true);
			}
		});
		clubsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clubsButton.setBounds(10, 268, 250, 52);
		contentPane.add(clubsButton);
				
		JButton goBack = new JButton("Go Back");
		goBack.setBounds(23, 30, 100, 37);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainLoginFrame().setVisible(true);
				dispose();
			}
		});
		contentPane.add(goBack);
		
		setResizable(false);
	}
}
