package com.chipatel.wsapis.bookkeeping.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chipatel.wsapis.bookkeeping.database.BookkeepingDbConnection;
import com.chipatel.wsapis.bookkeeping.model.Income;

public class IncomeService {

	public static String INSERT_INCOME = "INSERT INTO bookkeeping.Income(name, amount, last_update, is_active) VALUES (\"%s\", %f, NOW(), \"Y\")";

	public static String SELECT_ALL_INCOME = "SELECT id, name, amount FROM bookkeeping.Income";
	public static String SELECT_INCOME = "SELECT id, name, amount FROM bookkeeping.Income WHERE id = %d";

	public boolean addIncome(String name, double amount) throws SQLException {
		Connection conn = BookkeepingDbConnection.newConneciton();
		Statement stmt = conn.createStatement();
		boolean result = stmt.execute(String.format(INSERT_INCOME, name, amount));
		BookkeepingDbConnection.closeConnection(conn);
		return true;
	}

	public ArrayList<Income> getAllIncome() throws SQLException {
		Connection conn = BookkeepingDbConnection.newConneciton();
		ArrayList<Income> incomeList = new ArrayList<Income>();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format(SELECT_ALL_INCOME));

		while (rs.next()) {
			Income income = new Income(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			incomeList.add(income);
		}
		return incomeList;
	}

	public Income getIncome(int id) throws SQLException {
		Connection conn = BookkeepingDbConnection.newConneciton();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format(SELECT_INCOME, id));
		Income ic = null;
		while (rs.next()) {
			ic = new Income(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		}
		BookkeepingDbConnection.closeConnection(conn);
		return ic;
	}

}
