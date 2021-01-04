import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("SIGN UP");
		lblRegistration.setForeground(Color.RED);
		lblRegistration.setFont(new Font("Algerian", Font.BOLD, 18));
		lblRegistration.setBounds(182, 11, 211, 22);
		contentPane.add(lblRegistration);
		
		JLabel lblName = new JLabel("Username");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(30, 80, 100, 17);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(174, 80, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(29, 131, 88, 14);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 130, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EMAIL=textField_2.getText().toString();
				String Username=textField.getText().toString();				
				String Password=textField_1.getText().toString();
				String PHONENO=textField_3.getText().toString();
				String COUNTRY=textField_4.getText().toString();
				String STATE=textField_5.getText().toString();
				
				try
		        { 
					
					Connection con=null;
		        int i=0;
		            Class.forName("com.mysql.jdbc.Driver");
		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","");
		            PreparedStatement ps=con.prepareStatement("insert into info values(?,?,?,?,?,?)");
		            ps.setString(1, EMAIL);
		            ps.setString(2, Username);
		            ps.setString(3, Password);
		            ps.setString(4, PHONENO);
		            ps.setString(5,COUNTRY);
		            ps.setString(6,STATE);
		            i=ps.executeUpdate();
		            if(i>0)
		            {
		            	JOptionPane.showMessageDialog(null , "successfully registered");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null , "plz enter all information");
		            }
		        }
		        catch(Exception e)
		        {
		            System.out.println(e);
		        }
				PassengerInformation pi=new PassengerInformation();
				pi.setVisible(true);
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmit.setBounds(213, 253, 116, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(30, 45, 82, 24);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 44, 88, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setForeground(Color.BLACK);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNo.setBounds(30, 161, 87, 17);
		contentPane.add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(174, 161, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setForeground(Color.BLACK);
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCountry.setBounds(30, 189, 76, 14);
		contentPane.add(lblCountry);
		
		textField_4 = new JTextField();
		textField_4.setBounds(174, 192, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnExit = new JButton("LOGIN");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login lg = new login();
				lg.setVisible(true);
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(381, 256, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText(null);
				textField.setText(null);
				textField_1.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				
				
			}
		});
		btnReset.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnReset.setBounds(41, 256, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblState.setForeground(Color.BLACK);
		lblState.setBounds(30, 231, 75, 14);
		contentPane.add(lblState);
		
		textField_5 = new JTextField();
		textField_5.setBounds(174, 223, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
