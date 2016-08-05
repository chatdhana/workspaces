package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementUpdate {

	
	public static void main(String[] args)throws Exception
	{
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String query="select * from t1";
		statement.executeUpdate("update t1 set id=1 where id=?");
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
