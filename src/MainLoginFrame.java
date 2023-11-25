import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainLoginFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	boolean isStudentLoginSuccessful = false;
	boolean isAdminLoginSuccessful = false;
	boolean isLibraryLoginSuccessful = false;
	boolean isInstuctorLoginSuccessful = false;
	String studentLoggedIn;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginFrame frame = new MainLoginFrame();
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainLoginFrame() {
		setTitle("University Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel mainHeader = new JLabel("University Management System");
		mainHeader.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeader.setFont(new Font("Tahoma", Font.BOLD, 40));
		mainHeader.setBounds(146, 28, 644, 63);
		contentPane.add(mainHeader);


		String[] roles = {"Admin","Student","Instructor","Library Staff"};
		JComboBox rolesCombobox = new JComboBox(roles);
		rolesCombobox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rolesCombobox.setBounds(339, 264, 249, 36);
		rolesCombobox.addActionListener(this);
		contentPane.add(rolesCombobox);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		usernameLabel.setBounds(257, 157, 137, 36);
		contentPane.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		passwordLabel.setBounds(257, 204, 137, 36);
		contentPane.add(passwordLabel);

		usernameField = new JTextField();
		usernameField.setBounds(420, 159, 239, 34);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(420, 204, 239, 34);
		contentPane.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		loginButton.setBounds(399, 323, 137, 36);
		loginButton.addActionListener(loginButtonListener);
		
		contentPane.add(loginButton);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		JComboBox cb = (JComboBox)e.getSource();
		String roleSelected = (String)cb.getSelectedItem();

		String usernameInput = usernameField.getText();
		String passwordInput = String.valueOf(passwordField.getPassword());

		if(roleSelected.equals("Student")){

			ArrayList<String> students = FileStuff.readStudentsTxt();
			
			for(int i=0;i<students.size();i++){
				String student = FileStuff.readStudentsTxt().get(i);
				if(student.split("-")[5].equals(usernameInput) && student.split("-")[6].equals(passwordInput)){
					isStudentLoginSuccessful = true;
					studentLoggedIn = student;
					break;
				}
				else{
					isStudentLoginSuccessful = false;
				}
			}

		}

		if(roleSelected.equals("Instructor")){
			
		}

		if(roleSelected.equals("Library Staff")){
		
		}
		
		if(roleSelected.equals("Admin")){

		}
		
	}
	
	ActionListener loginButtonListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(isStudentLoginSuccessful){
				new StudentFrame(studentLoggedIn).setVisible(true);
				dispose();
				return;
			}
			if(isAdminLoginSuccessful){
				return;
			}
			if(isInstuctorLoginSuccessful){
				return;
			}
			if(isLibraryLoginSuccessful){
				return;
			}
			else{
				JOptionPane.showMessageDialog(contentPane,"No user with given credentials!","Bad Request!",JOptionPane.ERROR_MESSAGE);
			}
		}
	};




}