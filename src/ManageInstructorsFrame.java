import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ManageInstructorsFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField[] textFields;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JLabel salaryLabel;
	private JTextField salaryField;
	private JTextField passwordField;
	private JLabel coursesLabel;
	private JTextField coursesField;
	private JLabel noteDivide1;

	private JTable instructorsTable;
	DefaultTableModel instructorsTableModel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton updateButton;

	private int idCounter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageInstructorsFrame frame = new ManageInstructorsFrame();
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManageInstructorsFrame(){
		setTitle("University Management System - Admin - Manage Instructors");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		idLabel.setBounds(12, 35, 32, 16);
		contentPane.add(idLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nameLabel.setBounds(12, 63, 56, 16);
		contentPane.add(nameLabel);
		
		textFields = new JTextField[9];

		idField  = textFields[0] = new JTextField();
		idField.setBounds(83, 34, 100, 20);
		contentPane.add(idField);
		idField.setColumns(15);
		idField.setEditable(false);
		
		nameField = textFields[1] = new JTextField();
		nameField.setColumns(15);
		nameField.setBounds(83, 62, 200, 20);
		contentPane.add(nameField);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		addressLabel.setBounds(12, 91, 69, 16);
		contentPane.add(addressLabel);
		
		addressField = textFields[2] = new JTextField();;
		addressField.setColumns(15);
		addressField.setBounds(83, 90, 300, 20);
		contentPane.add(addressField);
		
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		phoneLabel.setBounds(190, 35, 69, 16);
		contentPane.add(phoneLabel);
		 
		phoneField = textFields[3] = new JTextField();;
		phoneField.setColumns(15);
		phoneField.setBounds(263, 34, 200, 20);
		contentPane.add(phoneField);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emailLabel.setBounds(290, 63, 69, 16);
		contentPane.add(emailLabel);
		
		emailField = textFields[4] = new JTextField();;
		emailField.setColumns(15);
		emailField.setBounds(363, 62, 200, 20);
		contentPane.add(emailField);
				
		coursesLabel = new JLabel("Courses*:");
		coursesLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		coursesLabel.setBounds(385, 92, 87, 16);
		contentPane.add(coursesLabel);
		
		coursesField = textFields[5] = new JTextField();;
		coursesField.setColumns(15);
		coursesField.setBounds(470, 92, 400, 20);
		contentPane.add(coursesField);
		
		salaryLabel = new JLabel("Salary:");
		salaryLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		salaryLabel.setBounds(760, 35, 69, 16);
		contentPane.add(salaryLabel);
		
		salaryField = textFields[6] = new JTextField();;
		salaryField.setColumns(15);
		salaryField.setBounds(835, 35, 100, 20);
		contentPane.add(salaryField);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		usernameLabel.setBounds(465, 35, 87, 16);
		contentPane.add(usernameLabel);
				
		JTextField usernameField = textFields[7] = new JTextField();;
		usernameField.setColumns(15);
		usernameField.setBounds(555, 35, 200, 20);
		contentPane.add(usernameField);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		passwordLabel.setBounds(565, 63, 87, 16);
		contentPane.add(passwordLabel);
				
		passwordField = textFields[8] = new JTextField();;
		passwordField.setColumns(15);
		passwordField.setBounds(655, 63, 200, 20);
		contentPane.add(passwordField);
		
		noteDivide1 = new JLabel("*you must divide each course by '_'");
		noteDivide1.setBounds(22, 122, 243, 16);
		contentPane.add(noteDivide1);
		
		// table
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 150, 938, 250);
        getContentPane().add(scrollPane);
        instructorsTable = new JTable();

        // enter the content of the chosen row to the fields
        instructorsTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e){
				int selectedRow = instructorsTable.getSelectedRow();
				for(int i=0;i<textFields.length;i++){
					textFields[i].setText(instructorsTableModel.getValueAt(selectedRow, i).toString());
				}
        	}
        });

        instructorsTableModel = new DefaultTableModel();
        String[] columns = {"ID","Name","Address","Phone","Email","Courses","Salary","Username","Password"};
        instructorsTable.setModel(instructorsTableModel);
        instructorsTable.setRowHeight(25);
        instructorsTableModel.setColumnIdentifiers(columns);
        scrollPane.setViewportView(instructorsTable);
        
        instructorsTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        instructorsTable.getColumnModel().getColumn(1).setPreferredWidth(35);
        instructorsTable.getColumnModel().getColumn(2).setPreferredWidth(55);
		instructorsTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        instructorsTable.getColumnModel().getColumn(4).setPreferredWidth(55);
        instructorsTable.getColumnModel().getColumn(5).setPreferredWidth(105);
        instructorsTable.getColumnModel().getColumn(6).setPreferredWidth(35);
        instructorsTable.getColumnModel().getColumn(7).setPreferredWidth(45);
        instructorsTable.getColumnModel().getColumn(7).setPreferredWidth(45);

		// get default values from txt
        ArrayList<String> instructors= FileStuff.readTxt("db/_instructors.txt");
		Object[] row = new  Object[9];
       	for(int i=0;i<instructors.size();i++){
    	  	String instructor = instructors.get(i);
			for(int j=0;j<row.length;j++){
				row[j] = instructor.split("-")[j];
			}
			instructorsTableModel.addRow(row);
       }
       
       // find maxId among instructors and assign idCounter to the maxId+1
	   int maxIdIndex;
	   idCounter = Integer.parseInt(instructors.get(0).split("-")[0].trim());
	   for(maxIdIndex=1;maxIdIndex<instructors.size();maxIdIndex++){
			if(Integer.parseInt(instructors.get(maxIdIndex).split("-")[0].trim()) > idCounter){
				idCounter = Integer.parseInt(instructors.get(maxIdIndex).split("-")[0].trim()) +1;
			}
	   }

	   // add button
	   addButton = new JButton("Add");
       addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String userData = "";
				Boolean isUserNameUnique = true;
				for(int i=0;i<instructors.size();i++){
						String userN = instructors.get(i).split("-")[7].trim();
						if(textFields[7].getText().trim().equals(userN)){
							isUserNameUnique = false;
						}
				}

				if(textFields[1].getText().equals("") || textFields[2].getText().equals("") || textFields[3].getText().equals("") || textFields[6].getText().equals("") || textFields[7].getText().equals("") ){
    				JOptionPane.showMessageDialog(null,"Please Fill All Fields");
        		}
        		else{
    				if(isUserNameUnique){
						idCounter++;
						for(int i=0;i<textFields.length;i++){
							row[i] = textFields[i].getText();
							row[0] = idCounter;

							userData = userData + row[i];
							if(i!=textFields.length-1){
								userData = userData + "-";
							}
						}
						instructorsTableModel.addRow(row);
						FileStuff.addUser(userData, "db/_instructors.txt");

						ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(row[5].toString().split("_")));
						Instructor tempUser = new Instructor(Integer.parseInt(row[0].toString().trim()),row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),coursesArrayList,row[6].toString(),row[7].toString(),row[8].toString());
						tempUser.add();

						clear();
						JOptionPane.showMessageDialog(null,"Instructor Added Successfully");
					}
					else{
						JOptionPane.showMessageDialog(null,"Username must be unique!");
					}
        		}
        	}
        });
        addButton.setBounds(20, 410, 89, 23);
        getContentPane().add(addButton);

		// update button
 	   	updateButton = new JButton("Update");
 	   	updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String userData = "";
				int selectedRow = instructorsTable.getSelectedRow();
				if(selectedRow>=0){ // 0'dan küçük = editlenecek satır seçilmemiş
					for(int i=0;i<textFields.length;i++){
						instructorsTableModel.setValueAt(textFields[i].getText(), selectedRow, i);
						userData = userData + textFields[i].getText();
						if(i!=textFields.length-1){
							userData = userData + "-";
						}
					}
					JOptionPane.showMessageDialog(null,"Updated Successfully");
					int idInt = Integer.parseInt(textFields[0].getText().trim());
					FileStuff.updateUser(userData, idInt, "db/_instructors.txt");

					ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(row[5].toString().split("_")));					
					Instructor.edit(idInt,row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),coursesArrayList,row[6].toString(),row[7].toString(),row[8].toString());

					clear();
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select a Row First");
				}
			}
		});
 	   	updateButton.setBounds(125, 410, 89, 23);
        getContentPane().add(updateButton);        

        // delete button
		deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRow = instructorsTable.getSelectedRow();
        		if(selectedRow>=0){
					instructorsTableModel.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null,"Row Deleted Successfully");
					int id = Integer.parseInt(idField.getText().trim());

					FileStuff.deleteUser(id ,"db/_instructors.txt");
					Instructor emptyInstructorToAvoidStaticMethods = new Instructor();
					emptyInstructorToAvoidStaticMethods.delete(id);

					clear();
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Please Select a Row to Remove");
        		}
        			
        	}
        });
        deleteButton.setBounds(230, 410, 89, 23);
        getContentPane().add(deleteButton);

    }

	public void clear(){
		for(JTextField tf:textFields){
			tf.setText("");
		}
	}



}