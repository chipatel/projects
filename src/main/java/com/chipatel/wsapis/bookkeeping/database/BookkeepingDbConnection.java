package com.chipatel.wsapis.bookkeeping.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookkeepingDbConnection {

	public static String closeConnection(Connection connection) {
		try {
			connection.close();
			if (!connection.isClosed()) {
				return "No connection closed!!!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Connection closed!!!";
	}

	public static Connection newConneciton() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookkeeping?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC",
					"root", "swamibapa");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
