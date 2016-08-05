package JDBCPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionClass {

	

	





	public static void main(String args[])throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:ORACL","scott", "tiger");

		con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		Statement st=con.createStatement();
		Statement st1=con.createStatement();
						
		boolean flag=st.execute("select * from departments");
		if(flag==true)
		{
			ResultSet rs=st.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			rs.close();
		}
		else
		{
			System.out.println("the select statement did not return any resultset");
		}
		
		boolean flag1=st1.execute("delete from employees");
		if(flag1==true)
		{
			System.out.println("the dml statement did not return any resultset");
		}
		else
		{
			int count=st.getUpdateCount();
			if(count>0)
				System.out.println("the dml statement has modified "+count +" rows");
			else
				System.out.println("the dml statement did not return any number ");
		}
		st.close();
		con.close();	
	}
}


