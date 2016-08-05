package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJavaDB {

	static Connection conn = null;

	public static void main(String[] args) {
		conn = BasicJavaDB.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
//			stmt.execute("create table app.test(col1 varchar(20))");
			stmt.execute("insert into app.test values(\'dhana\')");
			ResultSet rs=stmt.executeQuery("select * from test");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Connection getConnection() {

		Connection conn = null;
		try {// derby.jar should be included in a classpath.
			 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager
					.getConnection("jdbc:derby:MySampleDB");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
