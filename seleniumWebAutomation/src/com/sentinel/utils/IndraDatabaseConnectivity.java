package com.sentinel.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IndraDatabaseConnectivity {
	public static Connection connections = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static boolean connectionStatusFlag = false;
	public static Connection con = null;
		private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String PUBLIC_DNS = "13.229.128.214";
	private static final Integer PORT = 3306;
	private static final String DATABASE = "pmn";
	private static final String REMOTE_DATABASE_USERNAME = "root";
	private static final String DATABASE_USER_PASSWORD = "root";
	
	public static boolean openConnection() {
		if (connectionStatusFlag == false) {
			try {
				Class.forName(dbClassName);
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				connectionStatusFlag = false;
				return connectionStatusFlag;
			}

			System.out.println("MySQL JDBC Driver Registered!");
			Connection connection = null;

			try {
				connection = DriverManager.getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE,
						REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
			} catch (SQLException e) {
				System.out.println("Connection Failed!:\n" + e.getMessage());
			}

			if (connection != null) {
				connectionStatusFlag = true;
				System.out.println("SUCCESS!!!! You made it, take control     your database now!");
			} else {
				System.out.println("FAILURE! Failed to make connection!");
			}

			} 
		
		return connectionStatusFlag;
	}

	public static ArrayList<String> executeQuery(String query) {
		ArrayList<String> result = null;
		try {
			openConnection();

			result = new ArrayList<String>();
			// step4 execute query
			rs = stmt.executeQuery(query);
			int sizers = rs.getMetaData().getColumnCount();
			if (sizers != 0) {
				while (rs.next()) {
					for (int i = 0; i < sizers; i++) {
						result.add(rs.getString(i + 1));
					}
				}
			}
			con.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void closeConnection() {
		// step5 close the connection object
		try {
			connections.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
