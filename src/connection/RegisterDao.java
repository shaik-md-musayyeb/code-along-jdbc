package connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	public void addUser(RegisterPojo rpj) throws ClassNotFoundException, SQLException {
		String firstname = rpj.getFirstName();
		String lastname = rpj.getLastName();
		String username = rpj.getUserName();
		String password = rpj.getPassword();
		String email = rpj.getEmail();
		ConnectionManager cm = new ConnectionManager();
		String sql = "insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL) values (?,?,?,?,?)";
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		// inserting values using setString() method
		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, username);
		st.setString(4, password);
		st.setString(5, email);
		st.executeUpdate();
		cm.getConnection().close();
	}
}
