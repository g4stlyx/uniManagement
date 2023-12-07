import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminFrame() {
		setTitle("University Management System - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel welcomeLabel = new JLabel("Hello boss, welcome home.");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		welcomeLabel.setBounds(290, 11, 488, 51);
		contentPane.add(welcomeLabel);				
		
		JButton addStudentButton = new JButton("Add Student");
		addStudentButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addStudentButton.setBounds(32, 106, 200, 35);
		contentPane.add(addStudentButton);
		
		JButton editStudentsPersonalInfoButton = new JButton("Edit Students' Personal Information");
		editStudentsPersonalInfoButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		editStudentsPersonalInfoButton.setBounds(32, 152, 431, 40);
		contentPane.add(editStudentsPersonalInfoButton);
		
		JButton editStudentsEducationalInfoButton = new JButton("Edit Students' Educational Information");
		editStudentsEducationalInfoButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		editStudentsEducationalInfoButton.setBounds(32, 203, 463, 40);
		contentPane.add(editStudentsEducationalInfoButton);
		
		JButton editInstuctorsPersonalInfoButton = new JButton("Edit Instructors' Personal Information");
		editInstuctorsPersonalInfoButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		editInstuctorsPersonalInfoButton.setBounds(541, 152, 468, 40);
		contentPane.add(editInstuctorsPersonalInfoButton);
		
		JButton addInstructor = new JButton("Add Instructor");
		addInstructor.setFont(new Font("Tahoma", Font.BOLD, 22));
		addInstructor.setBounds(543, 106, 200, 35);
		contentPane.add(addInstructor);
		
		JButton editInstructorsEducationalInfoButton = new JButton("Edit Instructors' Educational Information");
		editInstructorsEducationalInfoButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		editInstructorsEducationalInfoButton.setBounds(541, 203, 505, 40);
		contentPane.add(editInstructorsEducationalInfoButton);
	}
}