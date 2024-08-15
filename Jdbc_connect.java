package internshala.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_connect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mgmt","root","$20AZ3530Mos");
			
			Statement smt = con.createStatement();
			
			smt.executeUpdate("create table employee(eno int, ename varchar(25), esalary int)");
			
			System.out.println("Table created succesfully");
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
