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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(139, 0, 139));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(107, 94, 124, 17);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(260, 94, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(128, 0, 128));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(105, 166, 105, 17);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 166, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.RED);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						String user=textField.getText().toString();
						String password=textField_1.getText().toString();
			               try{ 
			            	   int i=0;
				            Class.forName("com.mysql.jdbc.Driver");
				            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","");
							//String sql="SELECT * FROM user_login WHERE username=? and password=?";
				             PreparedStatement ps=con.prepareStatement("select * from user_login where username=? and password=?");
				            ps.setString(1, user);
				            ps.setString(2,password);
				           ResultSet rs=ps.executeQuery();
				             if(rs.next()){
				        		 JOptionPane.showMessageDialog(null , "successfully login");
				        		 PassengerInformation pi = new PassengerInformation();
				 				pi.setVisible(true);
				             }
				             else{
				            	 JOptionPane.showMessageDialog(null, "username and password invalid or  register first ");
				             }
			               }
				        catch(Exception e1)
				        {
				            System.out.println(e1);
				        }
			               
			               
					}
			});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(210, 244, 115, 23);
		contentPane.add(btnLogin);
		
		JLabel lblRailwayReservationSystem = new JLabel("RAILWAY RESERVATION SYSTEM");
		lblRailwayReservationSystem.setBackground(new Color(255, 69, 0));
		lblRailwayReservationSystem.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblRailwayReservationSystem.setForeground(new Color(139, 0, 0));
		lblRailwayReservationSystem.setBounds(113, 11, 346, 36);
		contentPane.add(lblRailwayReservationSystem);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(126, 49, 291, 9);
		contentPane.add(separator);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration RE=new Registration();
				RE.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(358, 245, 124, 23);
		contentPane.add(btnRegister);
	}
}
