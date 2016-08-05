package exerciseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateSalClass {
static int v_id;
	
	public static void main(String[] args)throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		Statement statement=conn.createStatement();
		consoleinput ci=new consoleinput();
		System.out.println("Enter id");
		new Integer(v_id=ci.readInt()).intValue();
		
		String query="select * from employees where employee_id="+v_id;
		
		
		statement.executeUpdate("update employees set salary=salary+salary*.10 where employee_id="+v_id);
		ResultSet rs=statement.executeQuery(query);
		
		
		while(rs.next())
		{
		
		System.out.println(rs.getString(1)+"   "+rs.getString(8));
		}
		rs.close();
		statement.close();
		conn.close();
		
	}

}
