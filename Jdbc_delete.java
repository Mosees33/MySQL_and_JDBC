package internshala.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//used to create the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mgmt","root","$20AZ3530Mos");
			
			Statement smt = con.createStatement();
			
			//bufferedReader for create the user input.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				
				System.out.println("Enter deletion emp id");
				int eno = Integer.parseInt(br.readLine());
				
				int count = smt.executeUpdate("Delete from employee where eno = "+eno);
				
				if(count > 0) {
					System.out.println(count + " record deleted");
				}
					else {
						System.out.println("No record found");
					}
				
				System.out.println("Do u want to continue");
				String ch = br.readLine();
				if(ch.equalsIgnoreCase("no"))
					break;
			}
														
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
