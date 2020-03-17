package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","shaik");
		return conn;
		
	}
}
