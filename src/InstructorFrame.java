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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorFrame frame = new InstructorFrame("a");
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InstructorFrame(String instructor) {
		setTitle("University Management System - Instructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("Welcome back, "+ instructor.split("-")[1]);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		welcomeLabel.setBounds(31, 11, 927, 63);
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
		idField.setText(instructor.split("-")[0]);
		idField.setEditable(false);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		idLabel.setBounds(10, 78, 108, 29);
		personalInfoPanel.add(idLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(128, 133, 142, 29);
		personalInfoPanel.add(nameField);
		nameField.setText(instructor.split("-")[1]);
		nameField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(128, 185, 142, 29);
		personalInfoPanel.add(phoneField);
		phoneField.setText(instructor.split("-")[3]);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(388, 78, 396, 29);
		personalInfoPanel.add(addressField);
		addressField.setText(instructor.split("-")[2]);
		
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
		emailField.setText(instructor.split("-")[4]);
		
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
		usernameField.setText(instructor.split("-")[7]);
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
				if(passwordInput1.equals(instructor.split("-")[8]) && passwordInput2.equals(instructor.split("-")[8])){
					int idInt = Integer.parseInt(idField.getText().trim()); // trim çünkü idField.getText()=" 5"
					FileStuff.editInstructorsTxt(idInt,phoneField.getText(),emailField.getText(),addressField.getText());
					passwordField1.setText("");
					passwordField2.setText("");
					JOptionPane.showMessageDialog(contentPane,"Instructor Edited Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"Incorrect Password!","Bad Request!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// left buttons
		JButton personalInfoButton = new JButton("Personal Information");
		personalInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				personalInfoPanel.setVisible(true);
				// educationalInfoPanel.setVisible(false);
			}
		});
		personalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		personalInfoButton.setBounds(10, 142, 250, 52);
		contentPane.add(personalInfoButton);
		
		JButton studentsInfoButton = new JButton("Students Information");
		studentsInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personalInfoPanel.setVisible(false);
				// educationalInfoPanel.setVisible(true);
			}
		});
		studentsInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studentsInfoButton.setBounds(10, 205, 250, 52);
		contentPane.add(studentsInfoButton);
	}
}