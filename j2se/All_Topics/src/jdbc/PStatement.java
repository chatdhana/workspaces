package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PStatement {

	
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		String query="update t1 set id=id+1 where id=?";
		PreparedStatement pst=conn.prepareStatement(query);		
		Statement st=conn.createStatement();	
		ResultSet rs=null;
		for(int i=1;i<=5;i++)
		{
		pst.setInt(1,1*i);
		
		//ResultSet rs=pst.executeQuery();
		
		pst.addBatch();
		}
		pst.executeBatch();
		//pst.executeUpdate();
		rs=st.executeQuery("select * from t1");
		
		while(rs.next())
			System.out.println(rs.getString(1));
		rs.close();
		pst.close();
		conn.close();

	}

}
