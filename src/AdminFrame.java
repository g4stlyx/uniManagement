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
		welcomeLabel.setBounds(283, 30, 488, 51);
		contentPane.add(welcomeLabel);				
		
		JButton addStudentButton = new JButton("Manage Students");
		addStudentButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageStudentsFrame().setVisible(true);
			}
		});
		addStudentButton.setBounds(369, 125, 285, 51);
		contentPane.add(addStudentButton);
		
		JButton addInstructorButton = new JButton("Manage Instructors");
		addInstructorButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		addInstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageInstructorsFrame().setVisible(true);
			}
		});
		addInstructorButton.setBounds(369, 214, 285, 51);
		contentPane.add(addInstructorButton);

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