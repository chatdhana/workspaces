package jdbc_exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddBatchClass {

	
	public static void main(String[] args) throws Exception{
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		Connection conn=DriverManager.getConnection("jdbc:odbc:dhana","dgovindan","dhana");
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String query="select * from departments";
		ResultSet rs=statement.executeQuery(query);
		
		rs.last();
		while(rs.previous())
		{
		
		System.out.println(rs.getString(1));
		}
		rs.close();
		statement.close();
		conn.close();
		
	}

}
