package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		RegisterPojo rpj = new RegisterPojo();
		RegisterDao rdao = new RegisterDao();
		LoginPojo lpj = new LoginPojo();
		LoginDao ldao = new LoginDao();
		Luck luck = new Luck();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 - Register");
		System.out.println("2 - Login");
		System.out.println("Your Option");
		int x = Integer.parseInt(br.readLine());
		switch(x) {
		case 1:
			System.out.println("Enter Firstname");
			String firstname = br.readLine();
			System.out.println("Enter Lastname");
			String lastname = br.readLine();
			System.out.println("Enter Username");
			String username = br.readLine();
			System.out.println("Enter Password");
			String password = br.readLine();
			System.out.println("Enter Email");
			String email = br.readLine();
			rpj.setFirstName(firstname);
			rpj.setLastName(lastname);
			rpj.setUserName(username);
			rpj.setPassword(password);
			rpj.setEmail(email);
			rdao.addUser(rpj);
			break;
		case 2:
			System.out.println("Enter Username");
			String usernameLogin = br.readLine();
			System.out.println("Enter Password");
			String passwordLogin = br.readLine();
			lpj.setUsername(usernameLogin);
			lpj.setPassword(passwordLogin);
			if(ldao.validate(lpj)==true) {
				luck.display();
			}
			else {
				System.out.println("Incorrect Username / Password");
			}
		}
		

	}

}
