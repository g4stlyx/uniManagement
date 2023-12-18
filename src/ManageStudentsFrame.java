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

public class ManageStudentsFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField[] textFields;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField numberField;
	private JTextField emailField;
	private JTextField facultyField;
	private JTextField passwordField;
	private JLabel departmentLabel;
	private JTextField departmentField;
	private JLabel gradeLevelLabel;
	private JTextField gradeLevelField;
	private JLabel annualFeeLabel;
	private JTextField annualFeeField;
	private JLabel coursesLabel;
	private JTextField coursesField;
	private JLabel gradesLabel;
	private JTextField gradesField;
	private JLabel clubsLabel;
	private JTextField clubsField;
	private JLabel clubsDescriptionsLabels;
	private JTextField clubsDescriptionsField;
	private JLabel noteDivide1;
	private JLabel noteDivide2;
	private JLabel noteDivide3;

	private JTable studentsTable;
	DefaultTableModel studentsTableModel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton updateButton;

	private int idCounter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentsFrame frame = new ManageStudentsFrame();
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManageStudentsFrame(){
		setTitle("University Management System - Admin - Manage Students");
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
		
		textFields = new JTextField[15];

		idField  = textFields[0] = new JTextField();
		idField.setBounds(83, 34, 94, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		idField.setEditable(false);
		
		nameField = textFields[1] = new JTextField();;
		nameField.setColumns(10);
		nameField.setBounds(83, 62, 94, 20);
		contentPane.add(nameField);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		addressLabel.setBounds(12, 91, 69, 16);
		contentPane.add(addressLabel);
		
		addressField = textFields[2] = new JTextField();;
		addressField.setColumns(10);
		addressField.setBounds(83, 90, 94, 20);
		contentPane.add(addressField);
		
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		phoneLabel.setBounds(179, 35, 69, 16);
		contentPane.add(phoneLabel);
		 
		phoneField = textFields[3] = new JTextField();;
		phoneField.setColumns(10);
		phoneField.setBounds(236, 34, 112, 20);
		contentPane.add(phoneField);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		emailLabel.setBounds(179, 63, 56, 16);
		contentPane.add(emailLabel);
		
		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		numberLabel.setBounds(179, 91, 75, 16);
		contentPane.add(numberLabel);
		
		emailField = textFields[4] = new JTextField();;
		emailField.setColumns(10);
		emailField.setBounds(236, 62, 112, 20);
		contentPane.add(emailField);

		numberField = textFields[5] = new JTextField();;
		numberField.setColumns(10);
		numberField.setBounds(254, 90, 94, 20);
		numberField.setEditable(false);
		contentPane.add(numberField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		passwordLabel.setBounds(350, 35, 87, 16);
		contentPane.add(passwordLabel);
		
		JLabel facultyLabel = new JLabel("Faculty:");
		facultyLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		facultyLabel.setBounds(350, 63, 69, 16);
		contentPane.add(facultyLabel);
				
		passwordField = textFields[6] = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(431, 34, 118, 20);
		contentPane.add(passwordField);

		facultyField = textFields[7] = new JTextField();;
		facultyField.setColumns(10);
		facultyField.setBounds(417, 62, 132, 20);
		contentPane.add(facultyField);

		departmentLabel = new JLabel("Department:");
		departmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		departmentLabel.setBounds(350, 91, 103, 16);
		contentPane.add(departmentLabel);
		
		departmentField = textFields[8] = new JTextField();;
		departmentField.setColumns(10);
		departmentField.setBounds(455, 90, 94, 20);
		contentPane.add(departmentField);
		
		gradeLevelLabel = new JLabel("Grade Level:");
		gradeLevelLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		gradeLevelLabel.setBounds(552, 35, 103, 16);
		contentPane.add(gradeLevelLabel);
		
		gradeLevelField = textFields[9] = new JTextField();;
		gradeLevelField.setColumns(10);
		gradeLevelField.setBounds(657, 34, 94, 20);
		contentPane.add(gradeLevelField);
		
		annualFeeLabel = new JLabel("Annual Fee:");
		annualFeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		annualFeeLabel.setBounds(552, 64, 103, 16);
		contentPane.add(annualFeeLabel);
		
		annualFeeField = textFields[10] = new JTextField();;
		annualFeeField.setColumns(10);
		annualFeeField.setBounds(648, 62, 103, 20);
		contentPane.add(annualFeeField);
		
		coursesLabel = new JLabel("Courses*:");
		coursesLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		coursesLabel.setBounds(552, 92, 87, 16);
		contentPane.add(coursesLabel);
		
		coursesField = textFields[11] = new JTextField();;
		coursesField.setColumns(10);
		coursesField.setBounds(633, 90, 118, 20);
		contentPane.add(coursesField);
		
		gradesLabel = new JLabel("Grades**:");
		gradesLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		gradesLabel.setBounds(753, 36, 87, 16);
		contentPane.add(gradesLabel);
		
		gradesField = textFields[12] = new JTextField();;
		gradesField.setColumns(10);
		gradesField.setBounds(832, 34, 139, 20);
		contentPane.add(gradesField);
		
		clubsLabel = new JLabel("Clubs*:");
		clubsLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clubsLabel.setBounds(753, 64, 69, 16);
		contentPane.add(clubsLabel);
		
		clubsField = textFields[13] = new JTextField();;
		clubsField.setColumns(10);
		clubsField.setBounds(814, 62, 157, 20);
		contentPane.add(clubsField);
		
		clubsDescriptionsLabels = new JLabel("Desc***:");
		clubsDescriptionsLabels.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clubsDescriptionsLabels.setBounds(753, 92, 75, 16);
		contentPane.add(clubsDescriptionsLabels);
		
		clubsDescriptionsField = textFields[14] = new JTextField();;
		clubsDescriptionsField.setColumns(10);
		clubsDescriptionsField.setBounds(824, 90, 147, 20);
		contentPane.add(clubsDescriptionsField);
		
		noteDivide1 = new JLabel("*you must divide each course/club by \"_\"");
		noteDivide1.setBounds(22, 122, 243, 16);
		contentPane.add(noteDivide1);
		
		noteDivide2 = new JLabel("**you must divide each grade by \",\" , and course by \"_\"");
		noteDivide2.setBounds(290, 122, 323, 16);
		contentPane.add(noteDivide2);
		
		noteDivide3 = new JLabel("***clubs descriptions, divide them by \"_\"");
		noteDivide3.setBounds(648, 119, 323, 16);
		contentPane.add(noteDivide3);
		
		// table
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 150, 938, 250);
        getContentPane().add(scrollPane);
        studentsTable = new JTable();

        // enter the content of the chosen row to the fields
        studentsTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e){
				int selectedRow = studentsTable.getSelectedRow();
				for(int i=0;i<textFields.length;i++){
					textFields[i].setText(studentsTableModel.getValueAt(selectedRow, i).toString());
				}
        	}
        });

        studentsTableModel = new DefaultTableModel();
        String[] columns = {"ID","Name","Address","Phone","Email","Number","Password","Faculty","Department","Grade Level","Fee","Courses","Grades","Clubs","Club Descriptions"};
        studentsTable.setModel(studentsTableModel);
        studentsTable.setRowHeight(25);
        studentsTableModel.setColumnIdentifiers(columns);
        scrollPane.setViewportView(studentsTable);
        
        studentsTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        studentsTable.getColumnModel().getColumn(9).setPreferredWidth(30);
        studentsTable.getColumnModel().getColumn(10).setPreferredWidth(50);

		// get default values from txt
        ArrayList<String> students= FileStuff.readTxt("db/_students.txt");
		Object[] row = new  Object[15];
       	for(int i=0;i<students.size();i++){
    	  	String student = students.get(i);
			for(int j=0;j<row.length;j++){
				row[j] = student.split("-")[j];
			}
			studentsTableModel.addRow(row);
       }
       
       // find maxId among students and assign idCounter to the maxId+1
	   int maxIdIndex;
	   idCounter = Integer.parseInt(students.get(0).split("-")[0].trim());
	   for(maxIdIndex=1;maxIdIndex<students.size();maxIdIndex++){
			if(Integer.parseInt(students.get(maxIdIndex).split("-")[0].trim()) > idCounter){
				idCounter = Integer.parseInt(students.get(maxIdIndex).split("-")[0].trim()) +1;
			}
	   }

	   // add button
	   addButton = new JButton("Add");
       addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String userData = "";
				if(textFields[1].getText().equals("") || textFields[2].getText().equals("") || textFields[3].getText().equals("") || textFields[6].getText().equals("") || textFields[7].getText().equals("") || textFields[8].getText().equals("") || textFields[9].getText().equals("") || textFields[10].getText().equals("") || textFields[11].getText().equals("") || textFields[12].getText().equals("") || textFields[13].getText().equals("") || textFields[14].getText().equals("") ){
    				JOptionPane.showMessageDialog(null,"Fill All Fields");
        		}
        		else{
    				idCounter++;
					for(int i=0;i<textFields.length;i++){
						row[i] = textFields[i].getText();
						row[0] = idCounter;
						row[5] = "21030300" + idCounter;

						userData = userData + row[i];
						if(i!=textFields.length-1){
							userData = userData + "-";
						}
    				}
    				studentsTableModel.addRow(row);
					FileStuff.addUser(userData, "db/_students.txt");
	
					ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(row[11].toString().split("_")));
					ArrayList<String> gradesArrayList = new ArrayList<>(Arrays.asList(row[12].toString().split("_ | ,")));
					ArrayList<String> clubsArrayList = new ArrayList<String>(Arrays.asList(row[13].toString().split("_")));
					ArrayList<String> clubDescriptionsArrayList = new ArrayList<String>(Arrays.asList(row[14].toString().split("_")));
					Student tempStudent = new Student(Integer.parseInt(row[0].toString().trim()),row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),row[5].toString(),row[6].toString(),row[7].toString(),row[8].toString(),row[9].toString(),row[10].toString(),coursesArrayList,gradesArrayList,clubsArrayList,clubDescriptionsArrayList);
					tempStudent.add();

    				clear();
    				JOptionPane.showMessageDialog(null,"Student Added Successfully");
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
				int selectedRow = studentsTable.getSelectedRow();
				if(selectedRow>=0){ // 0'dan küçük = editlenecek satır seçilmemiş
					for(int i=0;i<textFields.length;i++){
						studentsTableModel.setValueAt(textFields[i].getText(), selectedRow, i);
						userData = userData + textFields[i].getText();
						if(i!=textFields.length-1){
							userData = userData + "-";
						}
					}
					JOptionPane.showMessageDialog(null,"Updated Successfully");
					int idInt = Integer.parseInt(textFields[0].getText().trim());
					FileStuff.updateUser(userData, idInt, "db/_students.txt");

					ArrayList<String> coursesArrayList = new ArrayList<>(Arrays.asList(row[11].toString().split("_")));
					ArrayList<String> gradesArrayList = new ArrayList<>(Arrays.asList(row[12].toString().split("_ | ,")));
					ArrayList<String> clubsArrayList = new ArrayList<String>(Arrays.asList(row[13].toString().split("_")));
					ArrayList<String> clubDescriptionsArrayList = new ArrayList<String>(Arrays.asList(row[14].toString().split("_")));
					Student.edit(idInt,row[1].toString(),row[2].toString(),row[3].toString(),row[4].toString(),row[6].toString(),row[7].toString(),row[8].toString(),row[9].toString(),row[10].toString(),coursesArrayList,gradesArrayList,clubsArrayList,clubDescriptionsArrayList);
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
        		int selectedRow = studentsTable.getSelectedRow();
        		if(selectedRow>=0){
					studentsTableModel.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null,"Row Deleted Successfully");
					
					int id = Integer.parseInt(idField.getText().trim());
					FileStuff.deleteUser(id ,"db/_students.txt");
					
					Student emptyStudentToAvoidStaticMethods = new Student();
					emptyStudentToAvoidStaticMethods.delete(id);

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