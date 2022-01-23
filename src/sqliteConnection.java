// SQL Imports
import java.sql.*;

// Swing Imports: Not sure if this is absolutely necessary
import javax.swing.*;

public class sqliteConnection
{
	Connection connection = null;

	// Static Function: Connect to the database, and return the connection
	// Uses SQLite JDBC drivers and the url to connect to the database
	// the url is the path to the database file can be Moved to a Server
	// EXCEPTION: If the database file does not exist
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Database/BAS_admin.db");
			//			Dead Code
			// 			Debug Code To Be Removed
			//			JOptionPane.showMessageDialog(null, "Connection Successful");
			//			End of Debug Code
			return connection;
		}

		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null, exc);
			return null;
		}
	}
}
