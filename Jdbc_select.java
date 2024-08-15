package internshala.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//for load the class into java Application (or) jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mgmt","root","$20AZ3530Mos");
			
			//to execute the SQL queries
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("select * from employee");
			while(rs.next()) {
				int eid = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				System.out.print(eid+" ");
				System.out.print(name+" ");
				System.out.print(salary);
				System.out.println();
				
			}
				
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
