// AWT Imports
import java.awt.BorderLayout;
import java.awt.EventQueue;

// Swing Imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SearchBooks extends JFrame
{
	private JPanel contentPane;

	// Main Function for the search books
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			try
			{
				SearchBooks frame = new SearchBooks();
				frame.setVisible(true);
			}

			catch (Exception e)
			{
				e.printStackTrace();
			}
		});
	}

	//	Create the frame. -> Constructor
	public SearchBooks()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}
