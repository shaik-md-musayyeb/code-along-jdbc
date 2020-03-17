package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

	public boolean validate(LoginPojo lpj) throws ClassNotFoundException, SQLException {
		String username = lpj.getUsername();
		String password = lpj.getPassword();
		ConnectionManager cm = new ConnectionManager();
		Statement st = cm.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from USERDETAILS");
		while(rs.next()) {
			if(username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD"))) {
				cm.getConnection().close();
				return true;
			}
//			else {
////				cm.getConnection().close();
//				return false;
//			}
		}
		return false;
		
	}

}
