import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment(PassengerInformation.name,PassengerInformation.price1);
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
	public payment(String name,String price) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Card Holder Name");
		lblName.setForeground(new Color(139, 0, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 193, 141, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(161, 192, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(PassengerInformation.name);
		JLabel lblPrice = new JLabel("Amount to be Charged to card :");
		lblPrice.setForeground(new Color(139, 0, 0));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 218, 231, 31);
		contentPane.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 225, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(PassengerInformation.price1);
		JButton btnPay = new JButton("PAY");
		btnPay.setForeground(new Color(199, 21, 133));
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "payment Sucessful" );
				 login lo=new login();
				 lo.setVisible(true);
			}
		});
		btnPay.setBounds(341, 242, 89, 23);
		contentPane.add(btnPay);
		
		JLabel lblCardType = new JLabel("CARD TYPE");
		lblCardType.setForeground(new Color(25, 25, 112));
		lblCardType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCardType.setBounds(24, 57, 86, 14);
		contentPane.add(lblCardType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "DEBIT", "CREDIT"}));
		comboBox.setBounds(24, 83, 62, 20);
		contentPane.add(comboBox);
		
		JLabel lblPaymentDetails = new JLabel("PAYMENT DETAILS");
		lblPaymentDetails.setForeground(new Color(0, 128, 128));
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentDetails.setBounds(24, 11, 165, 31);
		contentPane.add(lblPaymentDetails);
		
		JLabel lblExpiary = new JLabel("Expiry Date-");
		lblExpiary.setForeground(new Color(25, 25, 112));
		lblExpiary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExpiary.setBounds(24, 123, 96, 14);
		contentPane.add(lblExpiary);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"}));
		comboBox_1.setBounds(24, 148, 62, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Year", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox_2.setBounds(96, 148, 72, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setForeground(new Color(139, 0, 0));
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCardNumber.setBounds(259, 193, 123, 14);
		contentPane.add(lblCardNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(369, 187, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(59, 44, 165, 2);
		contentPane.add(separator);
	}
}
