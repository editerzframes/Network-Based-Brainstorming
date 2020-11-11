package com.nbsteam11.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/*******
 * <p>
 * Title: AdminTopics Class.
 * </p>
 * 
 * <p>
 * Description: A service class which connects to database and handles the
 * requests.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Service
public class AdminTopics {

	private static Connection conn = null;

	public static void removeTopic(String index) throws SQLException, ClassNotFoundException {

		conn = establishCon.estcon();

		String insert = "UPDATE admin_topic SET status = 'approve' where topic_ID = '" + index + "';";

		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
	}

	public static void disTopic(String index) throws SQLException, ClassNotFoundException {
		conn = establishCon.estcon();

		String insert = "UPDATE admin_topic SET status = 'disapprove' where topic_ID = '" + index + "';";

		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
	}

	public static void startTop(String index) throws SQLException, ClassNotFoundException {

		conn = establishCon.estcon();

		String insert = "UPDATE admin_topic SET start = 'start' where topic_ID = '" + index + "';";

		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
	}

}
