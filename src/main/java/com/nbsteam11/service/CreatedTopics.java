package com.nbsteam11.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/*******
 * <p>
 * Title: CreatedTopics Class.
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
public class CreatedTopics {

	private static Connection conn = null;
	static ArrayList<String> topics = new ArrayList<String>();// creating new generic arraylist
	static ArrayList<String> topic_description = new ArrayList<String>();// creating new generic arraylist

	public void createTopic(String client, String topic, String description)
			throws ClassNotFoundException, SQLException {
		conn = establishCon.estcon();
		Statement stmt = conn.createStatement();

		String insert = "INSERT INTO topic_info (topic_name, topic_description, client_no) VALUES ('" + topic + "', '"
				+ description + "', '" + client + "');";
		stmt.executeUpdate(insert);

		topics.add(topic);
		topic_description.add(description);
	}

	public static int getArraySize() throws ClassNotFoundException, SQLException {
		conn = establishCon.estcon();
		int i = 0;

		String ret = "Select * from topic_info;";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(ret);

		while (rs.next()) {
			i++;
		}

		return i;
	}

	public static String getItem(int index) throws ClassNotFoundException, SQLException {

		conn = establishCon.estcon();

		String topic_name = null;

		String ret = "Select * from topic_info WHERE topic_ID = '" + index + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(ret);

		while (rs.next()) {
			topic_name = rs.getString("topic_name");
		}

		return topic_name;
	}

	public static String getDescription(int index) throws SQLException, ClassNotFoundException {
		conn = establishCon.estcon();

		String topic_des = null;

		String ret = "Select * from topic_info WHERE topic_ID = '" + index + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(ret);

		while (rs.next()) {
			topic_des = rs.getString("topic_description");
		}

		return topic_des;
	}

	public void updateTopic(int index, String topic, String description) throws ClassNotFoundException, SQLException {
		conn = establishCon.estcon();

		String insert = "UPDATE topic_info SET topic_name = '" + topic + "', topic_description='" + description
				+ "' where topic_ID = '" + index + "';";
		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);

	}

	public static void removeTopic(String index) throws SQLException, ClassNotFoundException {
//		int index1 = Integer.parseInt(index);

		conn = establishCon.estcon();

		String insert = "DELETE FROM topic_info where topic_ID = '" + index + "';";
		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
	}

	public static void submitOnServer(String index) throws SQLException, ClassNotFoundException {
//		int index1 = Integer.parseInt(index);

		conn = establishCon.estcon();

		String topic_name = null;
		String topic_des = null;
		String id = null;

		String ret = "Select * from topic_info where topic_ID = '" + index + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(ret);

		while (rs.next()) {
			topic_name = rs.getString("topic_name");
			topic_des = rs.getString("topic_description");
			id = rs.getString("client_no");

		}

		String insert = "INSERT INTO admin_topic (topic_name, topic_description, client_no, status, start) VALUES ('"
				+ topic_name + "', '" + topic_des + "', '" + id + "', 'pending', 'stop');";
		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
	}
}
