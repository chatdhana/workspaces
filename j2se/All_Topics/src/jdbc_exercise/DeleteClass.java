package jdbc_exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteClass {

	
	public static void main(String[] args)throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		//Connection conn=DriverManager.getConnection("jdbc:odbc:dhana","dgovindan","dhana");
		Statement statement=conn.createStatement();
		String query="select last_name from employees where upper(job)='ST_CLERK'";
		statement.executeUpdate("delete from employees where upper(job)='ST_CLERK'");
		ResultSet rs=statement.executeQuery(query);
		
		
		while(rs.next())
		{
		
		System.out.println(rs.getString("last_name"));
		}
		rs.close();
		statement.close();
		conn.close();
		
	}
	}


