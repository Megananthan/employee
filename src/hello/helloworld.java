package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class helloworld {

	private static void insert(Connection con) throws SQLException {
		int id = 1;
		Statement st = con.createStatement();
		String a;
		for (int i = 0; i < 3; i++) {
			a = "insert into employee values (" + (id + i) + ",'name" + (i + 1) + "'," + (31 + i) + ");";
			st.executeUpdate(a);
		}
		st.close();
	}

	private static void select(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee.employee;");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
		stmt.close();
	}

	private static void delete(Connection con) throws SQLException {

		Statement st = con.createStatement();
		st.executeUpdate("delete from employee;");
		st.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "increff", "$4t153*qn");
		
		delete(con);
		System.out.println("deleted");
		insert(con);
		select(con);
		System.out.println("inserted");
		
		
		
		con.close();
	}

}
