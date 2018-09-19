package com.sentinel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection1 {
	// The JDBC Connector Class.
	private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String PUBLIC_DNS = "13.229.128.214";
	private static final Integer PORT = 3306;
	private static final String DATABASE = "pmn";
	private static final String REMOTE_DATABASE_USERNAME = "root";
	private static final String DATABASE_USER_PASSWORD = "root";
	private static Connection connection = null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			// openConnection();
			System.out.println(executeQuery("SELECT email FROM `tblcontact` where firstname='Nishabh'"));
		} catch (Exception e) {
			System.out.println("error Response " + e.getMessage());
			// e.printStackTrace();
		}
	}

	public static void openConnection() throws Exception {
		// System.out.println("----MySQL JDBC Connection Testing -------");
		//
		try {
			Class.forName(dbClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		//
		// System.out.println("MySQL JDBC Driver Registered!");
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE,
					REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed!:\n" + e.getMessage());
		}
		if (connection != null) {
			System.out.println("SUCCESS!!!! You made it, take control your database now!");
		} else {
			System.out.println("FAILURE! Failed to make connection!");
		}
	}

	public static ArrayList<String> executeQuery(String query) {

		ArrayList<String> result = null;
		ResultSet rs = null;
		Statement statement = null;
		try {
			openConnection();
			result = new ArrayList<String>();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			int sizers = rs.getMetaData().getColumnCount();
			if (sizers != 0) {
				while (rs.next()) {
					for (int i = 0; i < sizers; i++) {
						result.add(rs.getString(i + 1));
					}
				}
			}
			connection.setAutoCommit(true);
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
