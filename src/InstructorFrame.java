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

public class InstructorFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		// left buttons
		JButton personalInfoButton = new JButton("Personal Information");
		personalInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// personalInfoPanel.setVisible(true);
				// educationalInfoPanel.setVisible(false);
				// clubsPanel.setVisible(false);
			}
		});
		personalInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		personalInfoButton.setBounds(10, 142, 250, 52);
		contentPane.add(personalInfoButton);
		
		JButton studentsInfoButton = new JButton("Students Information");
		studentsInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// personalInfoPanel.setVisible(false);
				// educationalInfoPanel.setVisible(true);
				// clubsPanel.setVisible(false);
			}
		});
		studentsInfoButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studentsInfoButton.setBounds(10, 205, 250, 52);
		contentPane.add(studentsInfoButton);
	}
}