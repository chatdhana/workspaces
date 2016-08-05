package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMapper {

	public static void main(String[] args) {
		try {
			Temp2[] temp2Arr = (Temp2[]) new TableMapper().tableClassMapper(
					Temp2.class.getName(), "select * from temp2");

			Temp3[] temp3Arr = (Temp3[]) new TableMapper().tableClassMapper(
					Temp3.class.getName(), "select * from temp3");

			// To display the records.
			System.out.println("Number of Records:" + temp2Arr.length);
			for (int i = 0; i < temp2Arr.length; i++) {
				System.out
						.println("A:" + temp2Arr[i].a + " B:" + temp2Arr[i].b);

			}

			System.out.println("Number of Records:" + temp3Arr.length);
			for (int i = 0; i < temp3Arr.length; i++) {
				System.out.println("Name:" + temp3Arr[i].name_ + " DOB:"
						+ temp3Arr[i].dob);

			}

			// Temp2 tempArr = ((Temp1[]) new TableMapper().tableClassMapper(
			// Temp2.class.getName(), "select * from temp2"))[0];
			//			
			// System.out.println("A:" + tempArr.a + " B:"
			// + tempArr.b);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object tableClassMapper(String className, String query)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException {
		int arrSize = 10;

		// DB operation-Starts
		ResultSet rs = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.128.27.164:1523:atlasdb", "atlas",
				"welcome");
		PreparedStatement pst = conn.prepareStatement(query,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = pst.executeQuery(query);
		rs.last();
		arrSize = rs.getRow();
		rs.beforeFirst();
		// DB operation-Ends

		Class cls = Class.forName(className);
		Object objArr = Array.newInstance(cls, arrSize);
		Field[] fields = cls.getDeclaredFields();
		for (int rowCount = 0; rs.next(); rowCount++) {
			Object obj = cls.newInstance();
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getType().toString().equals(
						"class java.lang.String")) {
					fields[i].set(obj, rs.getString(fields[i].getName()));
				} else if (fields[i].getType().toString().equals(
						"class java.util.Date")) {
					fields[i].set(obj, rs.getDate(fields[i].getName()));
				} else {
					fields[i].set(obj, rs.getObject(fields[i].getName()));
				}

			}
			Array.set(objArr, rowCount, obj);
		}
		return objArr;

	}
}
