// AWT Imports
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Font;

// Swing Imports
import javax.swing.*;

public class Login
{

	private JFrame frame;

	// This is the Main entry point of the program, the first method called when the program is run.
	// Or better it is the class that is called first
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			try
			{
				Login window = new Login();
				window.frame.setVisible(true);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	private JLabel lblNewLabel_1;
	private JLabel lblpic1;

	public Login()
	{
		initialize();
	}


	// Initialize the contents of the frame.
	private void initialize()
	{
		// Initialize the frame
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Initialize the Copyright label
		lblNewLabel_1 = new JLabel("BookShop Automation Software by Kells");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel_1.setBounds(256, 20, 400, 44);
		frame.getContentPane().add(lblNewLabel_1);

		// Initialize the Login Button
		JButton btnContinue = new JButton("Continue to Admin Login");
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image img6 = new ImageIcon(this.getClass().getResource("/admin_icon_1.png")).getImage();
		btnContinue.setIcon(new ImageIcon(img6));
		btnContinue.addActionListener(e ->
		{
			frame.dispose();
			LoginFrame loginFrame = new LoginFrame();
			loginFrame.setVisible(true);
		});
		btnContinue.setBounds(320, 410, 276, 44);
		frame.getContentPane().add(btnContinue);

		// Label for the picture
		lblpic1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/book_icon2.png")).getImage();
		lblpic1.setIcon(new ImageIcon(img2));
		lblpic1.setBounds(248, 74, 408, 211);
		frame.getContentPane().add(lblpic1);

		// Copyright Label
		JLabel lblNewLabel = new JLabel("developed by \u00A9Kells");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(716, 481, 178, 27);
		frame.getContentPane().add(lblNewLabel);
	}
}
