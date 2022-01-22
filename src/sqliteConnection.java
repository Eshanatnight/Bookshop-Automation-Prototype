import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection connection = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:Database/BAS_admin.db");
//			JOptionPane.showMessageDialog(null, "Connection Successful");
			return connection;
		}catch(Exception exc) {
			JOptionPane.showMessageDialog(null, exc);
			return null;
		}
	}
}
