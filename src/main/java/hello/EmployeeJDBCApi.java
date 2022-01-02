package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



public class EmployeeJDBCApi {

	
	private final Logger logger=Logger.getLogger(EmployeeJDBCApi.class);
	
	private Connection con;
	
	public EmployeeJDBCApi() throws IOException, ClassNotFoundException, SQLException {
		BasicConfigurator.configure();
		Properties prop= new Properties();
		
		InputStream stream=new FileInputStream("employee.properties");
		prop.load(stream);
		Class.forName(prop.getProperty("jdbc.driver"));
		 con= DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
		
	}


	public void insert() throws SQLException {
		int id = 1;
		Statement st = con.createStatement();
		String a;
		for (int i = 0; i < 3; i++) {
			a = "insert into employee values (" + (id + i) + ",'name" + (i + 1) + "'," + (31 + i) + ");";
			logger.info(a);
			st.executeUpdate(a);
		}
		st.close();
	}

	public ResultSet select() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee.employee;");
//		while (rs.next()) {
//			logger.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
//		}
		stmt.close();
		return rs;
	}

	public void delete() throws SQLException {

		Statement st = con.createStatement();
		st.executeUpdate("delete from employee;");
		st.close();
	}

	

}
