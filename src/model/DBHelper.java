package model;

import java.sql.*;

public class DBHelper {

	static private java.sql.Connection connect = null;
	static private java.sql.Statement statement = null;
	static private java.sql.PreparedStatement preparedStatement = null;
	static private ResultSet resultSet = null;

	public DBHelper() {
		connect = ConfigSQL.getConnection();
	}

	/////////////// Set & Get///////////
	static public java.sql.Connection getConnect() {
		return connect;
	}
	// -----------------------------------------------------//
	static public void setConnect(java.sql.Connection connect) {
		DBHelper.connect = connect;
	}
	// -----------------------------------------------------//
	static public java.sql.PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
	// -----------------------------------------------------//
	static public void setPreparedStatement(java.sql.PreparedStatement preparedStatement) {
		DBHelper.preparedStatement = preparedStatement;
	}
	// -----------------------------------------------------//
	static public ResultSet getResultSet() {
		return resultSet;
	}
	// -----------------------------------------------------//

	static public void setResultSet(ResultSet resultSet) {
		DBHelper.resultSet = resultSet;
	}
	// -----------------------------------------------------//
	public static java.sql.Statement getStatement() {
		return statement;
	}
	// -----------------------------------------------------//
	public static void setStatement(java.sql.Statement statement) {
		DBHelper.statement = statement;
	}
	// -----------------------------------------------------//
}
