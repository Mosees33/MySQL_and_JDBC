package internshala.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_modifydata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//for load the class into java Application (or) jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mgmt","root","$20AZ3530Mos");
			
			//to execute the SQL queries
			Statement smt = con.createStatement();
			
			//user input 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("give the employee number for updation :");
			int num = Integer.parseInt(br.readLine());
			
			System.out.println("give the salary :");
			int sal = Integer.parseInt(br.readLine());
			
			int count = smt.executeUpdate("update employee set esalary="+sal+ "where eno="+num);
			
			if(count > 0)
				System.out.println(count + "record updated");
			
			else 
				System.out.println("Not found");
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
