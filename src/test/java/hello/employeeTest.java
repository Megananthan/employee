package hello;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class employeeTest {
	
	

	@Test
	public void sayHello() throws ClassNotFoundException, IOException, SQLException {
		System.out.println("Hello");
		EmployeeJDBCApi he=new EmployeeJDBCApi();
		he.delete();
		he.insert();
		ResultSet rs=he.select();
		int i=0;
		System.out.println("b4");
//		
//		while (rs.next()) {
//			System.out.println(i);
//			i++;
//		}
//		System.out.println(i);
//		assertEquals(3,i);
	}
	
}
