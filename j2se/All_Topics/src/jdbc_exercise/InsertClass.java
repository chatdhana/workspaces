package jdbc_exercise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertClass {

	static int v_id;
	static String v_name;
	public static void main(String[] args)throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		Statement statement=conn.createStatement();
	
		String query="select * from t1";
		consoleinput ci=new consoleinput();
		System.out.println("Enter id");
		new Integer(v_id=ci.readInt()).intValue();
		System.out.println("Enter name");
		v_name=ci.readString();
		statement.executeUpdate("insert into t1 values("+v_id+",'"+v_name+"')");
		ResultSet rs=statement.executeQuery(query);
		
		
		while(rs.next())
		{
		
		System.out.println(rs.getString("id")+"   "+rs.getString("name"));
		}
		rs.close();
		statement.close();
		conn.close();
		
	}

}
