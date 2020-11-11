package com.nbsteam11.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/*******
 * <p>
 * Title: LoginService Class.
 * </p>
 * 
 * <p>
 * Description: A service class which connects to database and handles the
 * requests for login.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Service
public class LoginService {

	private static Connection conn = null;

	public int validateUser(String userid, String password) {
		try {
			conn = establishCon.estcon();

			String ret = "Select * from login_ac;";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ret);

			while (rs.next()) {
				String name = rs.getString("login_Name");
				String pass = rs.getString("login_password");
				String role = rs.getString("role");
				if (userid.equals(name) && password.equals(pass) && role.equals("client")) {
					return 1;
				} else if (userid.equals(name) && password.equals(pass) && role.equals("admin")) {
					return 2;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 3;
	}

}
