package com.nbsteam11.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*******
 * <p>
 * Title: establishCon Class.
 * </p>
 * 
 * <p>
 * Description: A Java class which specifies the IP address of the admin for
 * connection of database.
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

public class establishCon {

	public static Connection estcon() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbs?useSSL=false", "root", "374269");
		return conn;
	}
}
