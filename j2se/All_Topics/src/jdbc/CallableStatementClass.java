package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class CallableStatementClass {

	static int n1=10,n2=20;
	public static void main(String[] args) throws Exception{
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","dgovindan","dhana");
		String query="update t1 set id=id+1 where id=?";
		
		String s="insert into t1 values("+"'dhana'"+"2)";
		CallableStatement pst=conn.prepareCall("{?=call fun1("+n1+",?)}");
		
		pst.setInt(2, 12);
		pst.registerOutParameter(1,java.sql.Types.INTEGER);
		pst.registerOutParameter(2,java.sql.Types.INTEGER); 
		pst.execute();
	
		System.out.println(pst.getInt(1 ));
		
		pst.close();
		

		
		
		
		/*CallableStatement pst=conn.prepareCall("call proc1(10,?)");
		pst.setInt(1, 12);
		pst.registerOutParameter(1,java.sql.Types.INTEGER);
		pst.execute();
		
		System.out.println(pst.getInt(1));
		pst.close();
		*/
		
		
		
		
		
		
		/*Statement st=conn.createStatement();	
		ResultSet rs=null;
		
		for(int i=1;i<=5;i++)
		{
		pst.setInt(1,1*i);
		pst.executeUpdate();
		rs=st.executeQuery("select * from t1");
		
		
		}
		while(rs.next())
			System.out.println(rs.getString(1));
		rs.close();
		pst.close();
		conn.close();
	}*/
		
	}

}
