package exerciseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExperienceClass {

	
	public static void main(String[] args)throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String query="select last_name from employees where (SYSDATE-hire_date)>20";
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
