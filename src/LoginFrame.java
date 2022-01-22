import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnUpdateBooks;
	private JLabel lblLogin;
	private JLabel lblLogin_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;


	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserName.setBounds(473, 112, 109, 27);
		contentPane.add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(581, 118, 96, 19);
		contentPane.add(textFieldUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(473, 175, 120, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(581, 176, 96, 19);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Login as Admin");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from AdminInfo where UserID=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUserName.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count+=1;
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Successfully Logged in!");
						setVisible(false);
						AdminInfo adminInfo = new AdminInfo();
						adminInfo.setVisible(true);
					}else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate Record Found");
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Login Details, Try Again");
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 14));
		Image img3 = new ImageIcon(this.getClass().getResource("/ok_bas.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img3));
		btnLogin.setBounds(473, 278, 210, 44);
		contentPane.add(btnLogin);
		
		btnUpdateBooks = new JButton("Update Books");
		Image img4 = new ImageIcon(this.getClass().getResource("/update_icon_1.png")).getImage();
		btnUpdateBooks.setIcon(new ImageIcon(img4));
		btnUpdateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from AdminInfo where UserID=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUserName.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count+=1;
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Successfully Logged in!");
						setVisible(false);
						UpdateBooks updateBooks = new UpdateBooks();
						updateBooks.setVisible(true);
//						AdminInfo adminInfo = new AdminInfo();
//						adminInfo.setVisible(true);
					}else if(count>1) {
						JOptionPane.showMessageDialog(null, "Duplicate Record Found");
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Login Details, Try Again");
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		btnUpdateBooks.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUpdateBooks.setBounds(209, 278, 203, 44);
		contentPane.add(btnUpdateBooks);
		
		lblLogin = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Login_bas.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img2));
		lblLogin.setBounds(224, 93, 76, 142);
		contentPane.add(lblLogin);
		
		lblLogin_1 = new JLabel("");
		lblLogin_1.setBounds(55, 77, 76, 142);
		contentPane.add(lblLogin_1);
		
		lblNewLabel = new JLabel("developed by \u00A9Kells");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(716, 481, 178, 27);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BookShop Automation Software by Kells");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel_1.setBounds(254, 10, 423, 44);
		contentPane.add(lblNewLabel_1);
	}
}
