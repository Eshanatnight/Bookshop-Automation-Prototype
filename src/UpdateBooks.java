import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class UpdateBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBooks frame = new UpdateBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textFieldBookName;
	private JTextField textFieldBookID;
	private JTextField textFieldAuthor;
	private JTextField textFieldPrice;
	private JTextField textFieldQty;
	private JTextField textFieldBookIDrmv;
	private JTextField textFieldQtyrmv;
	private JTextField textFieldBookIDadd;
	private JTextField textFieldQtyadd;

	/**
	 * Create the frame.
	 */
	public UpdateBooks() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		btnBack.setBounds(25, 487, 85, 21);
		contentPane.add(btnBack);
		
		JButton btnLoadBooks = new JButton("Load Books Data");
		btnLoadBooks.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from BookInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnLoadBooks.setBounds(337, 265, 160, 31);
		contentPane.add(btnLoadBooks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 306, 843, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAddBook = new JButton("Add New Book");
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String query="insert into BookInfo (BookID,BookName,Author,Price,Quantity) values (?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldBookID.getText());
					pst.setString(2, textFieldBookName.getText());
					pst.setString(3, textFieldAuthor.getText());
					pst.setString(4, textFieldPrice.getText());
					pst.setString(5, textFieldQty.getText());

					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnAddBook.setBounds(56, 249, 150, 31);
		contentPane.add(btnAddBook);
		
		JLabel lblBookID = new JLabel("Book ID : ");
		lblBookID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookID.setBounds(36, 77, 85, 17);
		contentPane.add(lblBookID);
		
		textFieldBookName = new JTextField();
		textFieldBookName.setBounds(132, 108, 111, 21);
		contentPane.add(textFieldBookName);
		textFieldBookName.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setBounds(36, 110, 109, 13);
		contentPane.add(lblBookName);
		
		textFieldBookID = new JTextField();
		textFieldBookID.setColumns(10);
		textFieldBookID.setBounds(132, 77, 111, 21);
		contentPane.add(textFieldBookID);
		
		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthor.setBounds(36, 144, 85, 17);
		contentPane.add(lblAuthor);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setBounds(132, 139, 111, 21);
		contentPane.add(textFieldAuthor);
		textFieldAuthor.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(36, 170, 74, 25);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(132, 174, 73, 21);
		contentPane.add(textFieldPrice);
		
		JLabel lblQty = new JLabel("Quantity : ");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQty.setBounds(36, 205, 85, 17);
		contentPane.add(lblQty);
		
		textFieldQty = new JTextField();
		textFieldQty.setColumns(10);
		textFieldQty.setBounds(132, 205, 45, 21);
		contentPane.add(textFieldQty);
		
		JLabel lblBookIDrmv = new JLabel("Book ID : ");
		lblBookIDrmv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookIDrmv.setBounds(619, 195, 85, 17);
		contentPane.add(lblBookIDrmv);
		
		textFieldBookIDrmv = new JTextField();
		textFieldBookIDrmv.setColumns(10);
		textFieldBookIDrmv.setBounds(750, 195, 111, 21);
		contentPane.add(textFieldBookIDrmv);
		
		JButton btnNewButton = new JButton("Remove Book");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="update BookInfo set quantity = (quantity - ?) where bookid=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(2, textFieldBookIDrmv.getText());
					pst.setString(1, textFieldQtyrmv.getText());

					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					
					pst.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(648, 249, 170, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblQty_1 = new JLabel("Quantity : ");
		lblQty_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQty_1.setBounds(619, 222, 85, 17);
		contentPane.add(lblQty_1);
		
		textFieldQtyrmv = new JTextField();
		textFieldQtyrmv.setColumns(10);
		textFieldQtyrmv.setBounds(750, 226, 45, 21);
		contentPane.add(textFieldQtyrmv);
		
		JLabel lblNewLabel_1 = new JLabel("BookShop Automation Software by Swaraj");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel_1.setBounds(246, 0, 391, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/book_icon3.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(337, 70, 216, 195);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("developed by \u00A9Swaraj");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(701, 484, 178, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblBookIDadd = new JLabel("Book ID : ");
		lblBookIDadd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookIDadd.setBounds(619, 77, 85, 17);
		contentPane.add(lblBookIDadd);
		
		textFieldBookIDadd = new JTextField();
		textFieldBookIDadd.setColumns(10);
		textFieldBookIDadd.setBounds(750, 77, 111, 21);
		contentPane.add(textFieldBookIDadd);
		
		JLabel lblQtyadd = new JLabel("Quantity : ");
		lblQtyadd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQtyadd.setBounds(619, 104, 85, 17);
		contentPane.add(lblQtyadd);
		
		textFieldQtyadd = new JTextField();
		textFieldQtyadd.setColumns(10);
		textFieldQtyadd.setBounds(750, 108, 45, 21);
		contentPane.add(textFieldQtyadd);
		
		JButton btnNewButton_1 = new JButton("Add Existing Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="update BookInfo set quantity = (quantity + ?) where bookid=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(2, textFieldBookIDadd.getText());
					pst.setString(1, textFieldQtyadd.getText());

					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Added");
					
					pst.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(648, 139, 170, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Update Books");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(379, 44, 160, 31);
		contentPane.add(lblNewLabel_3);
	}
}
