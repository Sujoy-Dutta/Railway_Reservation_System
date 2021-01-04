import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;
import java.sql.Time;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class PassengerInformation extends JFrame {

	private JPanel contentPane;
	private JTextField tf15;
	private JTextField tf22;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf;
	private JTextField tf10;
	private JTextField tf11;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf2;
	private JTextField tf8;
	private JTextField tf9;
	private JTextField tf13;
	private JTextField tf14;
	private JTextField tf12;
     static int count=1000;
     private JTextField textField;
     private JTextField tf16;
     private JTextField textField_2;
     private JTextField tf17;
     private JTextField tf18;
     private JTextField tf19;
     private JTextField tf20;
     static String name;
     static String price1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerInformation frame = new PassengerInformation();
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
	public PassengerInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 472);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setForeground(new Color(0, 0, 0));
		
		tf15 = new JTextField();
		tf15.setColumns(10);
		
		JLabel lblAge = new JLabel("Age\r\n");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setForeground(new Color(0, 0, 0));
		
		tf22 = new JTextField();
		tf22.setColumns(10);
		
		JRadioButton rb6 = new JRadioButton("ADULT\r\n");
		rb6.setFont(new Font("Algerian", Font.BOLD, 14));
		
		JRadioButton rb7 = new JRadioButton("CHILD");
		rb7.setFont(new Font("Algerian", Font.BOLD, 15));
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SOURCE", "Howrah", "Kolkata"}));
		cb1.setBounds(43, 11, 74, 20);
		contentPane.add(cb1);
		
		JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"DESTINATION", "Delhi", "Patna"}));
		contentPane.add(cb2);
		
		JRadioButton rb2 = new JRadioButton("SLEEPER");
		rb2.setFont(new Font("Algerian", Font.BOLD, 14));
		JRadioButton rb1 = new JRadioButton("AC");
		rb1.setFont(new Font("Algerian", Font.BOLD, 14));
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblTax = new JLabel("TAX");
		lblTax.setFont(new Font("Algerian", Font.BOLD, 14));
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Algerian", Font.BOLD, 14));
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.setForeground(new Color(255, 69, 0));
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double tax = 2.0;
				double fare = 1500;
				double fare2 = 200;
				double totalTax, eco = 3.85, fclass = 5.60;
				
				if((rb2.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Poorva Express");
					
				}
				else if((rb2.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare/2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare/2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Poorva Express");
					
				}
				else if((rb1.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare*1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare*1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Poorva Express");
					
				}
				else if((rb1.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare/1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare/1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Poorva Express");
					
				}
				if((rb2.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Jan Shatabdi");
					
				}
				else if((rb2.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2/2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2/2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Jan Shatabdi");
					
				}
				else if((rb1.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2*1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2*1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Jan Shatabdi");
					
				}
				else if((rb1.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Howrah") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2/1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2/1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Jan Shatabdi");
					
				}
				if((rb2.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("ANVT Express");
					
				}
				else if((rb2.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare/2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare/2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("ANVT Express");
					
				}
				else if((rb1.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare*1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare*1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("ANVT Express");
					
				}
				else if((rb1.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Delhi"))
				{
					totalTax = (tax * fare)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare/1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare/1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("ANVT Express");
					
				}
				if((rb2.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Patna-Kolkata Express");
					
				}
				else if((rb2.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2/2);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2/2 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("SL");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Patna-Kolkata Express");
					
				}
				else if((rb1.isSelected()) && (rb7.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2*1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2*1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("One");
					tf6.setText("Nil");
					tf11.setText("Patna-Kolkata Express");
					
				}
				else if((rb1.isSelected()) && (rb6.isSelected()) && cb1.getSelectedItem().equals("Kolkata") && cb2.getSelectedItem().equals("Patna"))
				{
					totalTax = (tax * fare2)/100;
					String tTax = String.format("Rs. %.2f", totalTax);
					tf1.setText(tTax);
					String Subtotal = String.format("Rs. %.2f", fare2/1.5);
					tf2.setText(Subtotal);
					String Total = String.format("Rs. %.2f",fare2/1.5 + totalTax);
					tf3.setText(Total);
					tf13.setText(Total);
					// ==============net side==================//
					tf4.setText("AC");
					tf5.setText("One Way");
					tf7.setText("Nil");
					tf6.setText("One");
					tf11.setText("Patna-Kolkata Express");
					
				}
			}
		});
		
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//time//
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				

				
				
				//date//
				SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-YYYY");
				tf10.setText(Tdate.format(timer.getTime()));
				
				//tf8.setText("Howrah *");
				tf8.setText((String)cb1.getSelectedItem()+ " *");
				tf9.setText((String)cb2.getSelectedItem()+ " *");
				
				//random no. generator//
				int num1;
				String q1 ="";
				num1 = 1325 + (int) (Math.random()*4238);
				q1 += num1 + 1325;
				tf.setText(q1);
				
				int num2;
							String q2="";
								num1=1325+(int)(Math.random()*4238);
						q1 +=num1+1325;
							tf12.setText(q1);
				
				//=================================//
				
				tf14.setText("Any");
				

			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null);
				rb2.setSelected(false);
				rb1.setSelected(false);
				
				
				
				rb7.setSelected(false);
				rb6.setSelected(false);
				cb1.setSelectedItem("Source");
				cb2.setSelectedItem("Destination");
				tf4.setText(null);
				tf5.setText(null);
				tf7.setText(null);
				tf6.setText(null);
				tf8.setText(null);
				tf14.setText(null);
				tf9.setText(null);
				tf11.setText(null);
				tf.setText(null);
				tf13.setText(null);
				tf12.setText(null);
				tf10.setText(null);
				

				
				
				
			}
		});
		
		JLabel lblAdult = new JLabel("ADULT");
		lblAdult.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		
		JLabel lblChild = new JLabel("CHILD");
		lblChild.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		
		
		
		JLabel lblTrainNo = new JLabel("TRAIN NO");
		lblTrainNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf = new JTextField();
		tf.setColumns(10);
		
		JLabel lblDepartureTime = new JLabel("DATE");
		lblDepartureTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf10 = new JTextField();
		tf10.setColumns(10);
		
		JLabel lblTrainName = new JLabel("TRAIN NAME");
		lblTrainName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf11 = new JTextField();
		tf11.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		
		
		
		
		JLabel lblSleeper = new JLabel("CLASS");
		lblSleeper.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		
		JLabel lblTicket = new JLabel("TICKET");
		lblTicket.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setFont(new Font("Algerian", Font.BOLD, 14));
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		
		JLabel lblFrom_1 = new JLabel("FROM");
		lblFrom_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf8 = new JTextField();
		tf8.setColumns(10);
		
		JLabel lblTo_1 = new JLabel("TO");
		lblTo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf9 = new JTextField();
		tf9.setColumns(10);
		
		JLabel lblPrice_1 = new JLabel("PRICE");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf13 = new JTextField();
		tf13.setColumns(10);
		
		JLabel lblRoute = new JLabel("ROUTE");
		lblRoute.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf14 = new JTextField();
		tf14.setColumns(10);
		
		JLabel lblTicketNo = new JLabel("TICKET NO");
		lblTicketNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tf12 = new JTextField();
		tf12.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JList list = new JList();
		
		JSeparator separator_2 = new JSeparator();
		
		JSeparator separator_3 = new JSeparator();
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel lblTrainAndPassenger = new JLabel("TRAIN AND PASSENGER DETAILS");
		lblTrainAndPassenger.setForeground(new Color(255, 140, 0));
		lblTrainAndPassenger.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JSeparator separator_5 = new JSeparator();
		
		JSeparator separator_6 = new JSeparator();
		


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addContainerGap()
															.addComponent(rb6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(23)
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addContainerGap()
															.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(lblTax, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																	.addComponent(cb1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(lblSubtotal)
																	.addComponent(rb2))))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addContainerGap()
															.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																	.addGap(2)
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																			.addComponent(rb1)
																			.addComponent(rb7, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
																			.addComponent(tf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(tf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(tf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)
																				.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
																		.addComponent(tf15, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
																.addComponent(tf22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addGap(14)
															.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblFrom_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
																.addComponent(lblTo_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblTrainName)
																.addComponent(lblDepartureTime)
																.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(18)
															.addComponent(cb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
															.addComponent(lblTicketNo)
															.addGap(10))))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addContainerGap()
													.addComponent(separator, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
												.addGap(77)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(btnTotal)
											.addGap(40)))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addGap(124)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(145))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(tf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(tf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblSleeper)
											.addGap(69)
											.addComponent(lblTicket)))
									.addGap(44))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(5))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAdult, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(lblChild, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(101))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tf7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(51))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(tf8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTrainNo, Alignment.TRAILING)
										.addComponent(lblRoute, Alignment.TRAILING)
										.addComponent(lblPrice_1, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(tf, 0, 0, Short.MAX_VALUE))
										.addComponent(tf14, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(tf13, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTrainAndPassenger, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
							.addGap(88)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTrainAndPassenger, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAdult)
										.addComponent(lblChild))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(tf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(13)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSleeper)
										.addComponent(lblTicket))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(tf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFrom_1)
										.addComponent(tf13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrice_1)
										.addComponent(tf8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTo_1)
										.addComponent(tf14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRoute)
										.addComponent(tf9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(tf12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTicketNo)
												.addComponent(lblTrainNo)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDepartureTime)
										.addComponent(tf10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(tf15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(22)
									.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(rb7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(rb6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(rb1)
										.addComponent(rb2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTax, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(tf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSubtotal)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTrainName)
											.addComponent(tf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(tf11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(2)
										.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnTotal)
										.addComponent(btnReset)))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE))
							.addGap(21))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
							.addContainerGap())))
		);
		panel.setLayout(null);
		
		JLabel lblName_1 = new JLabel("NAME");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName_1.setBounds(24, 60, 60, 17);
		panel.add(lblName_1);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname=String.valueOf(textField.getText().toString());
				String from=String.valueOf(tf16.getText().toString());
				String to=String.valueOf(tf17.getText().toString());
				String train_name=String.valueOf(tf18.getText().toString());
				String train_class=String.valueOf(tf19.getText().toString());
				String price=String.valueOf(tf20.getText().toString());
				  try
	               { 
					  int i=0;
					  int c=1;

					   Class.forName("com.mysql.jdbc.Driver");
			            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","");


	                    PreparedStatement ps = con.prepareStatement("insert into confirm values(?,?,?,?,?,?)");

	                    ps.setString(1, cname);

	                    ps.setString(2, from);

	                    ps.setString(3, to);
	   												
	                    ps.setString(4, train_name);

	                    ps.setString(5, train_class);

	                   ps.setString(6,price);

	                    i = ps.executeUpdate();

	                    c++;

	                    if (i > 0)	
	                    {
	                    
                        
name=cname;
price1=price;
	                        JOptionPane.showMessageDialog(btnBook, "Booking Successful, Your seat no. is : "+count );
	                        
	                        payment ob=new payment(cname,price);
	                        ob.setVisible(true);
	                        dispose();
	                        
	                       

	                        count--;
	                    }

	                }
	          catch (Exception ex)
	                {

	                    //System.out.println(ex);
	        	  ex.printStackTrace();

	                }

	            }
		});
		
		btnBook.setBounds(104, 357, 92, 23);
		panel.add(btnBook);
		
		textField = new JTextField();
		textField.setBounds(104, 60, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FROM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 104, 60, 14);
		panel.add(lblNewLabel);
		
		tf16 = new JTextField();
		tf16.setBounds(104, 103, 86, 20);
		panel.add(tf16);
		tf16.setColumns(10);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTo.setBounds(24, 146, 46, 14);
		panel.add(lblTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 81, -58, -1);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		tf17 = new JTextField();
		tf17.setBounds(104, 145, 86, 20);
		panel.add(tf17);
		tf17.setColumns(10);
		
		JLabel lblTrainName_1 = new JLabel("TRAIN NAME\r\n");
		lblTrainName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrainName_1.setBounds(10, 193, 108, 14);
		panel.add(lblTrainName_1);
		
		tf18 = new JTextField();
		tf18.setBounds(104, 192, 86, 20);
		panel.add(tf18);
		tf18.setColumns(10);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass.setBounds(21, 242, 74, 14);
		panel.add(lblClass);
		
		tf19 = new JTextField();
		tf19.setBounds(104, 241, 86, 20);
		panel.add(tf19);
		tf19.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(24, 296, 46, 14);
		panel.add(lblPrice);
		
		tf20 = new JTextField();
		tf20.setBounds(104, 295, 86, 20);
		panel.add(tf20);
		tf20.setColumns(10);
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.setForeground(new Color(25, 25, 112));
		btnProceed.setBounds(10, 358, 84, 23);
		panel.add(btnProceed);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(tf15.getText().toString());
				tf16.setText(tf8.getText().toString());
				tf17.setText(tf9.getText().toString());
				tf18.setText(tf11.getText().toString());
				tf19.setText(tf4.getText().toString());
				tf20.setText(tf13.getText().toString());
				
				
				String name=String.valueOf(textField.getText().toString());
				String from=String.valueOf(tf16.getText().toString());
				String to=String.valueOf(tf17.getText().toString());
				String train_name=String.valueOf(tf18.getText().toString());
				String train_class=String.valueOf(tf19.getText().toString());
				String price=String.valueOf(tf20.getText().toString());
				
			}
		});
	
			
		
		
						
				
				
					btnProceed.setFont(new Font("Arial", Font.BOLD, 10));
				
				JLabel lblConfirmDetails = new JLabel("CONFIRM DETAILS");
				lblConfirmDetails.setForeground(new Color(85, 107, 47));
				lblConfirmDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblConfirmDetails.setBounds(24, 22, 190, 14);
				panel.add(lblConfirmDetails);
		
		contentPane.setLayout(gl_contentPane);
	}
}
